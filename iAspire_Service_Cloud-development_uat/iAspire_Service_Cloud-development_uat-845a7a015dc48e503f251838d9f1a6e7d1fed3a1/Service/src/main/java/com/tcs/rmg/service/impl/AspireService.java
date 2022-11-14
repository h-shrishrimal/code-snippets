package com.tcs.rmg.service.impl;

import com.tcs.rmg.data.TotalRequirementDataResponse;
import com.tcs.rmg.data.TotalRequirementDetails;
import com.tcs.rmg.entities.EmpIsuFlag;
import com.tcs.rmg.entities.EmployeeHeadCount;
import com.tcs.rmg.entities.RequirementIAspire;
import com.tcs.rmg.repositories.*;
import me.xdrop.fuzzywuzzy.FuzzySearch;
import me.xdrop.fuzzywuzzy.model.ExtractedResult;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.util.Pair;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.sql.DataSource;
import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class AspireService {

  @Autowired private final DataSource dataSource;

  @Autowired private final RequirementIAspireRepo requirementIAspireRepo;

  @Autowired private final EmployeeHeadCountRepo employeeHeadCountRepo;

  @Autowired private final EmpCertificationRepo empCertificationRepo;

  @Autowired private final EmpMltHcrDataRepo mltHcrDataRepo;

  @Autowired private final EmpIsuFlagRepo empIsuFlagRepo;

  private static final Logger logger = LoggerFactory.getLogger(AspireService.class);

  public AspireService(
    DataSource dataSource,
    RequirementIAspireRepo requirementIAspireRepo,
    EmployeeHeadCountRepo employeeHeadCountRepo,
    EmpCertificationRepo empCertificationRepo, EmpMltHcrDataRepo mltHcrDataRepo, EmpIsuFlagRepo empIsuFlagRepo) {
    this.dataSource = dataSource;
    this.requirementIAspireRepo = requirementIAspireRepo;
    this.employeeHeadCountRepo = employeeHeadCountRepo;
    this.empCertificationRepo = empCertificationRepo;
    this.mltHcrDataRepo = mltHcrDataRepo;
    this.empIsuFlagRepo = empIsuFlagRepo;
  }

  public TotalRequirementDataResponse getTotalDigitalRequirementDetails(
      TotalRequirementDetails totalRequirement, String isu) {



    String limit = " limit "; String offset = " offset ";
    String orderByClause =  "  order by rdi.requirement_id";

    logger.info("In method getTotalDigitalRequirementDetails");
    TotalRequirementDataResponse response = new TotalRequirementDataResponse();
    try {
      Pageable pageRequest =
          PageRequest.of(totalRequirement.getPageNumber(), totalRequirement.getPageSize());


      Optional<EmpIsuFlag> optUnlockOtherIsuFlag = empIsuFlagRepo.findById(totalRequirement.getEmployeeId());
      String unlockOtherIsuFlag = optUnlockOtherIsuFlag.isEmpty() ? "N" : "Y".equalsIgnoreCase(optUnlockOtherIsuFlag.get().getFlag()) ? "Y" : "N";

      if(optUnlockOtherIsuFlag.isPresent())
        unlockOtherIsuFlag = "Y";

      Optional<EmployeeHeadCount> optHeadCountData = employeeHeadCountRepo.findById(totalRequirement.getEmployeeId());
      if(!optHeadCountData.isPresent()) {
        String errMsg = String.format("emp %s not present either in head_count table", totalRequirement.getEmployeeId());
        logger.error(errMsg);
        throw new Exception(errMsg);
      }

      EmployeeHeadCount empHeadCountData = optHeadCountData.get();

      List<Map<String, Object>> requirementData = Collections.EMPTY_LIST;
      Integer countResult = 0;
      Integer totalPages = 0;
      JdbcTemplate jdbcTemplate = new JdbcTemplate(this.dataSource);

      if("N".equals(unlockOtherIsuFlag)  && !"INDIA".equals(empHeadCountData.getEmployeeDeputeCountry())) {
          // run query queryFlagNoAndDeputyCountryNotIndia
          String sql = SELECT_COLUMN_CLAUSE + queryFlagNoAndDeputyCountryNotIndia + orderByClause + limit + totalRequirement.getPageSize() + offset + (totalRequirement.getPageNumber() - 1);
          sql = sql.replaceAll(":empId", totalRequirement.getEmployeeId().toString());
          requirementData = jdbcTemplate.queryForList(sql);
          sql = SELECT_COUNT_CLAUSE + queryFlagNoAndDeputyCountryNotIndia;
          sql = sql.replaceAll(":empId", totalRequirement.getEmployeeId().toString());
          countResult = jdbcTemplate.queryForObject(sql, Integer.class);
          totalPages = (countResult / pageRequest.getPageSize()) + 1;
      }

     if("N".equals(unlockOtherIsuFlag)  && "INDIA".equals(empHeadCountData.getEmployeeDeputeCountry())) {
        // run query queryFlagNoAndDeputyCountryIndia
        String sql = SELECT_COLUMN_CLAUSE + queryFlagNoAndDeputyCountryIndia + orderByClause + limit + totalRequirement.getPageSize() + offset + (totalRequirement.getPageNumber() - 1);
        sql = sql.replaceAll(":empId", totalRequirement.getEmployeeId().toString());
        requirementData = jdbcTemplate.queryForList(sql);
        sql = SELECT_COUNT_CLAUSE + queryFlagNoAndDeputyCountryIndia;
        sql = sql.replaceAll(":empId", totalRequirement.getEmployeeId().toString());
        countResult = jdbcTemplate.queryForObject(sql, Integer.class);
        totalPages = (countResult / pageRequest.getPageSize()) + 1;
     }

      if("Y".equals(unlockOtherIsuFlag)  && !"INDIA".equals(empHeadCountData.getEmployeeDeputeCountry())) {
         // run query queryFlagYesAndDeputyCountryNotIndia
        String sql = SELECT_COLUMN_CLAUSE + queryFlagYesAndDeputyCountryNotIndia + orderByClause + limit + totalRequirement.getPageSize() + offset + (totalRequirement.getPageNumber() - 1);
        sql = sql.replaceAll(":empId", totalRequirement.getEmployeeId().toString());
        requirementData = jdbcTemplate.queryForList(sql);
        sql = SELECT_COUNT_CLAUSE + queryFlagYesAndDeputyCountryNotIndia;
        sql = sql.replaceAll(":empId", totalRequirement.getEmployeeId().toString());
        countResult = jdbcTemplate.queryForObject(sql, Integer.class);
        totalPages = (countResult / pageRequest.getPageSize()) + 1;
      }

      if("Y".equals(unlockOtherIsuFlag) && "INDIA".equals(empHeadCountData.getEmployeeDeputeCountry())) {
          // run query queryFlagYesAndDeputyCountryIndia
        String sql = SELECT_COLUMN_CLAUSE + queryFlagYesAndDeputyCountryIndia + orderByClause + limit + totalRequirement.getPageSize() + offset + (totalRequirement.getPageNumber() - 1);
        sql = sql.replaceAll(":empId", totalRequirement.getEmployeeId().toString());
        requirementData = jdbcTemplate.queryForList(sql);
        sql = SELECT_COUNT_CLAUSE + queryFlagYesAndDeputyCountryIndia;
        sql = sql.replaceAll(":empId", totalRequirement.getEmployeeId().toString());
        countResult = jdbcTemplate.queryForObject(sql, Integer.class);
        totalPages = (countResult / pageRequest.getPageSize()) + 1;
      }

      response.setTotalReqData(requirementData);
      response.setTotalCount(countResult);
      response.setTotalPages(totalPages);

    } catch (Exception e) {
      logger.error("Error in getTotalDigitalRequirementDetails ", e);
    }
    return response;
  }

  public Map<String,? extends Serializable> empDetails(Long empId) {
    Map<String, ? extends Serializable> nonMltCandidate = Map.of("employeeId", empId, "isMLTEligible", false);
    Optional<EmployeeHeadCount> optData = employeeHeadCountRepo.findById(empId.intValue());
    if(!optData.isPresent())
      return nonMltCandidate;
    if(StringUtils.isNotBlank(optData.get().getMltPool()))
      return Map.of("employeeId", empId, "isMLTEligible", true);
    return nonMltCandidate;
  }

  public EmployeeHeadCount geEmployeeDetails(Long employeeId) {
    Optional<EmployeeHeadCount> optHeadCountData = employeeHeadCountRepo.findById(employeeId.intValue());
    if(optHeadCountData.isPresent())
      return optHeadCountData.get();
    return null;
  }

  public Object applyFor(Long employeeId, Long requirementId) {
      JdbcTemplate jdbcTemplate = new JdbcTemplate(this.dataSource);
    String sql = REQUIREMENT_COMPTENCY_QRY.replaceAll(":requirementId",requirementId.toString());
    String requirementCompetency = jdbcTemplate.queryForObject(sql,String.class);

    sql = CERTIFICATE_QUERY.replaceAll(":empId", employeeId.toString());
    String certificationData = jdbcTemplate.queryForObject(sql,String.class);

    sql = COMPTENCY_QUERY.replaceAll(":empId", employeeId.toString());
    String competencyData = jdbcTemplate.queryForObject(sql,String.class);

    certificationData = StringUtils.isNotBlank(certificationData) ? certificationData : "";
    competencyData = StringUtils.isNotBlank(competencyData) ? competencyData : "";

    if(StringUtils.isNotBlank(requirementCompetency)) {
      List<String> listCertificationData = Arrays.asList(StringUtils.split(certificationData,"||"));
      List<String> listCompetencyData = Arrays.asList(StringUtils.split(competencyData,"||"));
      String[] requirements = StringUtils.split(requirementCompetency,"||");

      List<String> allData = new ArrayList<>();
      allData.addAll(listCertificationData);
      allData.addAll(listCompetencyData);

      List<Map<String, ? extends Serializable>> matchedData = Arrays.stream(requirements)
        .map(req -> Pair.of(req,FuzzySearch.extractOne(req, allData)))
        .map(res -> Pair.of(res.getFirst(),Pair.of(res.getSecond().getString(), res.getSecond().getScore())))
        .map(p -> Map.of("requirement", p.getFirst(),"topMatch", p.getSecond().getFirst(), "score", p.getSecond().getSecond()))
        .collect(Collectors.toList());

      return matchedData;
    }

    return Arrays.asList(Map.of("requirement", "","topMatch", "", "score", 100));
  }



  String REQUIREMENT_COMPTENCY_QRY = """
    select rdi.primary_competency_proficiency_details
    from rmg_iaspire.requirement_details_iaspire rdi
    where rdi.requirement_id = :requirementId
    """;

  String CERTIFICATE_QUERY = """
    select string_agg(ec.certification_curriculum_name, ' || ') as certificate_data
    from rmg_iaspire.emp_certification ec
    where ec.employee_number = :empId
    group by ec.employee_number
    """;

  String COMPTENCY_QUERY = """
    select string_agg(emh.competency_name , ' || ') as competency_data
    from rmg_iaspire.emp_mlt_hcr emh
    where emh.employee_number = :empId
    group by emh.employee_number;
    """;

  String SELECT_COLUMN_CLAUSE = """
       select rdi.requirement_id as "requirementId",
              rdi.aging_wrt_rqmt_st_dt as "agingWrtRqmtStDt",
              rdi.bfsi_account_name as "bfsiAccountName",
              rdi.bfsi_sub_segment_name as "bfsiSubSegmentName",
              rdi.bucket_wrt_rqmt_st_dt as "bucketWrtRqmtStDt",
              rdi.du_type as "duType",
              rdi.group_customer_name as "groupCustomerName",
              rdi.horizontal_child_iou as "horizontalChildIou",
              rdi.horizontal_parent_iou as "horizontalParentIou",
              rdi.horizontial_bg_cluster as "horizontialBgCluster",
              rdi.microskill_proficiency_dtls_1 as "microskillProficiencyDtls1",
              rdi.microskill_proficiency_dtls_2 as "microskillProficiencyDtls2",
              rdi.new_segment_iou_name as "newSegmentIouName",
              rdi.onsite_offshore as "onsiteOffshore",
              rdi.parent_du as "parentDu",
              rdi.primary_competency_proficiency_details as "competency",
              rdi.project_number as "projectNumber",
              rdi.realization as "realization",
              rdi.request_id as "requestId",
              rdi.require_status_requirement_start_date as "requireStatusRequirementStartDate",
              rdi.requirement_bg_cluster as "requirementBgCluster",
              rdi.requirement_branch as "branch",
              rdi.requirement_child_iou as "requirementChildIou",
              rdi.requirement_country as "country",
              rdi.requirement_end_date as "requirementEndDate",
              rdi.requirement_geography as "requirementGeography",
              rdi.requirement_parent_iou as "requirementParentIou",
              rdi.requirement_pending_with as "requirementPendingWith",
              rdi.requirement_start_date as "postedOn",
              rdi.requirement_status as "requirementStatus",
              rdi.requirement_type as "requirementType",
              rdi.source_of_staffing as "sourceOfStaffing",
              rdi.sp as "sp",
              rdi.sub_sp as "subSp",
              rdi.total_experience as "experience",
              rdi.type_of_accounts as "typeOfAccounts",
              rdi.won_swon as "wonSwon",
              rdi.project_type as "projectType",
              rdi.requirement_bg__cluster as "requirementBgCluster",
              rdi.horizontal_bg_cluster as "horizontalBgCluster",
              rdi.requirement_role as "role"

      """;

  String SELECT_COUNT_CLAUSE = """
          Select count(*)

      """;

  String queryFlagNoAndDeputyCountryNotIndia = """
      from
      	rmg_iaspire.requirement_details_iaspire rdi, rmg_iaspire.employee_headcount eh
      where
      	  rdi.requirement_parent_iou = eh.employee_parent_iou
      and UPPER(rdi.requirement_status) in ('OPEN')
      and UPPER(eh.employee_depute_country) = UPPER(rdi.requirement_country)
      and eh.employee_id = :empId
      and TO_DATE(rdi.requirement_start_date ,'d mon yy') > (select to_date(to_char(date_trunc('year', current_date - interval '3 month'),'yyyy') || '-' ||case when(select extract('quarter' from date_trunc('quarter', current_date - interval '3 month')::date)) = 1 then '01-01' when (select extract('quarter' from date_trunc('quarter', current_date - interval '3 month')::date )) = 2 then '04-01' when (select extract('quarter' from date_trunc('quarter', current_date - interval '3 month')::date )) = 3 then '07-01' when (select extract('quarter' from date_trunc('quarter', current_date - interval '3 month')::date )) = 4 then '10-01' else '?' end, 'yyyy-mm-dd') as previous_quarter_start_date )
      and TO_DATE(rdi.requirement_end_date ,'d mon yy') < (select to_date(to_char(date_trunc('year', current_date + interval '3 month'),'yyyy') || '-' ||case when(select extract('quarter' from date_trunc('quarter', current_date + interval '3 month')::date)) = 1 then '03-31' when (select extract('quarter' from date_trunc('quarter', current_date + interval '3 month')::date )) = 2 then '06-30' when (select extract('quarter' from date_trunc('quarter', current_date + interval '3 month')::date )) = 3 then '09-30' when (select extract('quarter' from date_trunc('quarter', current_date + interval '3 month')::date )) = 4 then '12-31' else '?' end, 'yyyy-mm-dd') as next_quarter_end_date )

    """;

  String queryFlagNoAndDeputyCountryIndia = """
      from
      	rmg_iaspire.requirement_details_iaspire rdi, rmg_iaspire.employee_headcount eh
      where
      	  rdi.requirement_parent_iou = eh.employee_parent_iou
      and UPPER(rdi.requirement_status) in ('OPEN')
      and eh.employee_id = :empId
      and TO_DATE(rdi.requirement_start_date ,'d mon yy') > (select to_date(to_char(date_trunc('year', current_date - interval '3 month'),'yyyy') || '-' ||case when(select extract('quarter' from date_trunc('quarter', current_date - interval '3 month')::date)) = 1 then '01-01' when (select extract('quarter' from date_trunc('quarter', current_date - interval '3 month')::date )) = 2 then '04-01' when (select extract('quarter' from date_trunc('quarter', current_date - interval '3 month')::date )) = 3 then '07-01' when (select extract('quarter' from date_trunc('quarter', current_date - interval '3 month')::date )) = 4 then '10-01' else '?' end, 'yyyy-mm-dd') as previous_quarter_start_date )
      and TO_DATE(rdi.requirement_end_date ,'d mon yy') < (select to_date(to_char(date_trunc('year', current_date + interval '3 month'),'yyyy') || '-' ||case when(select extract('quarter' from date_trunc('quarter', current_date + interval '3 month')::date)) = 1 then '03-31' when (select extract('quarter' from date_trunc('quarter', current_date + interval '3 month')::date )) = 2 then '06-30' when (select extract('quarter' from date_trunc('quarter', current_date + interval '3 month')::date )) = 3 then '09-30' when (select extract('quarter' from date_trunc('quarter', current_date + interval '3 month')::date )) = 4 then '12-31' else '?' end, 'yyyy-mm-dd') as next_quarter_end_date )

    """;


  String queryFlagYesAndDeputyCountryIndia = """
            from
            	rmg_iaspire.requirement_details_iaspire rdi
            where
                UPPER(rdi.requirement_status) in ('OPEN')
            and TO_DATE(rdi.requirement_start_date ,'d mon yy') > (select to_date(to_char(date_trunc('year', current_date - interval '3 month'),'yyyy') || '-' ||case when(select extract('quarter' from date_trunc('quarter', current_date - interval '3 month')::date)) = 1 then '01-01' when (select extract('quarter' from date_trunc('quarter', current_date - interval '3 month')::date )) = 2 then '04-01' when (select extract('quarter' from date_trunc('quarter', current_date - interval '3 month')::date )) = 3 then '07-01' when (select extract('quarter' from date_trunc('quarter', current_date - interval '3 month')::date )) = 4 then '10-01' else '?' end, 'yyyy-mm-dd') as previous_quarter_start_date )
            and TO_DATE(rdi.requirement_end_date ,'d mon yy') < (select to_date(to_char(date_trunc('year', current_date + interval '3 month'),'yyyy') || '-' ||case when(select extract('quarter' from date_trunc('quarter', current_date + interval '3 month')::date)) = 1 then '03-31' when (select extract('quarter' from date_trunc('quarter', current_date + interval '3 month')::date )) = 2 then '06-30' when (select extract('quarter' from date_trunc('quarter', current_date + interval '3 month')::date )) = 3 then '09-30' when (select extract('quarter' from date_trunc('quarter', current_date + interval '3 month')::date )) = 4 then '12-31' else '?' end, 'yyyy-mm-dd') as next_quarter_end_date )

    """;

  String queryFlagYesAndDeputyCountryNotIndia = """
            from
            	rmg_iaspire.requirement_details_iaspire rdi, rmg_iaspire.employee_headcount eh
            where
            UPPER(rdi.requirement_status) in ('OPEN')
            and eh.employee_id = :empId
            and UPPER(eh.employee_depute_country) = UPPER(rdi.requirement_country)
            and TO_DATE(rdi.requirement_start_date ,'d mon yy') > (select to_date(to_char(date_trunc('year', current_date - interval '3 month'),'yyyy') || '-' ||case when(select extract('quarter' from date_trunc('quarter', current_date - interval '3 month')::date)) = 1 then '01-01' when (select extract('quarter' from date_trunc('quarter', current_date - interval '3 month')::date )) = 2 then '04-01' when (select extract('quarter' from date_trunc('quarter', current_date - interval '3 month')::date )) = 3 then '07-01' when (select extract('quarter' from date_trunc('quarter', current_date - interval '3 month')::date )) = 4 then '10-01' else '?' end, 'yyyy-mm-dd') as previous_quarter_start_date )
            and TO_DATE(rdi.requirement_end_date ,'d mon yy') < (select to_date(to_char(date_trunc('year', current_date + interval '3 month'),'yyyy') || '-' ||case when(select extract('quarter' from date_trunc('quarter', current_date + interval '3 month')::date)) = 1 then '03-31' when (select extract('quarter' from date_trunc('quarter', current_date + interval '3 month')::date )) = 2 then '06-30' when (select extract('quarter' from date_trunc('quarter', current_date + interval '3 month')::date )) = 3 then '09-30' when (select extract('quarter' from date_trunc('quarter', current_date + interval '3 month')::date )) = 4 then '12-31' else '?' end, 'yyyy-mm-dd') as next_quarter_end_date )

      """;


}

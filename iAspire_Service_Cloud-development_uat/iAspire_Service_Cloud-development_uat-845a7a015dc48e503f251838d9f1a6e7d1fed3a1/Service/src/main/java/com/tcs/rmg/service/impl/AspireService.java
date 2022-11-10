package com.tcs.rmg.service.impl;

import com.tcs.rmg.data.TotalRequirementDataResponse;
import com.tcs.rmg.data.TotalRequirementDetails;
import com.tcs.rmg.entities.AspireUserDetails;
import com.tcs.rmg.entities.EmployeeHeadCount;
import com.tcs.rmg.repositories.AspireUserDetailsRepo;
import com.tcs.rmg.repositories.EmployeeHeadCountRepo;
import com.tcs.rmg.repositories.RequirementIAspireRepo;
import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class AspireService {

  @Autowired private final DataSource dataSource;

  @Autowired private final RequirementIAspireRepo requirementIAspireRepo;

  @Autowired private final EmployeeHeadCountRepo employeeHeadCountRepo;

  @Autowired private final AspireUserDetailsRepo aspireUserDetailsRepo;

  private static final Logger logger = LoggerFactory.getLogger(AspireService.class);

  public AspireService(
      DataSource dataSource,
      RequirementIAspireRepo requirementIAspireRepo,
      EmployeeHeadCountRepo employeeHeadCountRepo,
      AspireUserDetailsRepo aspireUserDetailsRepo) {
    this.dataSource = dataSource;
    this.requirementIAspireRepo = requirementIAspireRepo;
    this.employeeHeadCountRepo = employeeHeadCountRepo;
    this.aspireUserDetailsRepo = aspireUserDetailsRepo;
  }

  public TotalRequirementDataResponse getTotalDigitalRequirementDetails(
      TotalRequirementDetails totalRequirement, String isu) {


    String SELECT_COLUMN_CLAUSE = """
           select rdi.total_experience as experience,
           rdi.requirement_id as requirementId, rdi.primary_competency_proficiency_details as competency ,
           rdi.requirement_branch as branch, rdi.requirement_city as city,
           rdi.requirement_country as country, rdi.bfsi_sub_segment_name as businessName,
           rdi.requirement_start_date as postedOn, rdi.onsite_offshore as onsiteOffshore

      """;

    String SELECT_COUNT_CLAUSE = """
          Select count(*)

      """;

    String queryFlagNoAndDeputyCountryNotIndia = """
      from
      	rmg_iaspire.requirement_details_iaspire rdi, rmg_iaspire.emp_user_details eud, rmg_iaspire.employee_headcount eh
      where
      	  rdi.requirement_parent_iou = eud.employee_parent_iou
      and UPPER(rdi.requirement_status) in ('OPEN')
      and eh.employee_id = eud.employee_number
      and UPPER(eh.employee_depute_country) = UPPER(rdi.requirement_country)
      and eud.employee_number = :empId
      and TO_DATE(rdi.requirement_start_date ,'d mon yy') > (select to_date(to_char(date_trunc('year', current_date - interval '3 month'),'yyyy') || '-' ||case when(select extract('quarter' from date_trunc('quarter', current_date - interval '3 month')::date)) = 1 then '01-01' when (select extract('quarter' from date_trunc('quarter', current_date - interval '3 month')::date )) = 2 then '04-01' when (select extract('quarter' from date_trunc('quarter', current_date - interval '3 month')::date )) = 3 then '07-01' when (select extract('quarter' from date_trunc('quarter', current_date - interval '3 month')::date )) = 4 then '10-01' else '?' end, 'yyyy-mm-dd') as previous_quarter_start_date )
      and TO_DATE(rdi.requirement_end_date ,'d mon yy') < (select to_date(to_char(date_trunc('year', current_date + interval '3 month'),'yyyy') || '-' ||case when(select extract('quarter' from date_trunc('quarter', current_date + interval '3 month')::date)) = 1 then '03-31' when (select extract('quarter' from date_trunc('quarter', current_date + interval '3 month')::date )) = 2 then '06-30' when (select extract('quarter' from date_trunc('quarter', current_date + interval '3 month')::date )) = 3 then '09-30' when (select extract('quarter' from date_trunc('quarter', current_date + interval '3 month')::date )) = 4 then '12-31' else '?' end, 'yyyy-mm-dd') as next_quarter_end_date )

    """;

    String queryFlagNoAndDeputyCountryIndia = """
      from
      	rmg_iaspire.requirement_details_iaspire rdi, rmg_iaspire.emp_user_details eud
      where
      	  rdi.requirement_parent_iou = eud.employee_parent_iou
      and UPPER(rdi.requirement_status) in ('OPEN')
      and eud.employee_number = :empId
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

    String limit = " limit "; String offset = " offset ";
    String orderByClause =  "  order by rdi.requirement_id";

    logger.info("In method getTotalDigitalRequirementDetails");
    TotalRequirementDataResponse response = new TotalRequirementDataResponse();
    try {
      Pageable pageRequest =
          PageRequest.of(totalRequirement.getPageNumber(), totalRequirement.getPageSize());

      Optional<AspireUserDetails> optEmpData = aspireUserDetailsRepo.findById(totalRequirement.getEmployeeId());
      Optional<EmployeeHeadCount> optHeadCountData = employeeHeadCountRepo.findById(totalRequirement.getEmployeeId());
      if(!optEmpData.isPresent() || !optHeadCountData.isPresent()) {
        String errMsg = String.format("emp %s not present either in head_count or user_details table", totalRequirement.getEmployeeId());
        logger.error(errMsg);
        throw new Exception(errMsg);
      }

      AspireUserDetails empData = optEmpData.get();
      EmployeeHeadCount empHeadCountData = optHeadCountData.get();

      List<Map<String, Object>> requirementData = Collections.EMPTY_LIST;
      Integer countResult = 0;
      Integer totalPages = 0;
      JdbcTemplate jdbcTemplate = new JdbcTemplate(this.dataSource);

      if(("N".equals(empData.getUnlockOtherIsu()) || StringUtils.isEmpty(empData.getUnlockOtherIsu()) ) && !"INDIA".equals(empHeadCountData.getEmployeeDeputeCountry())) {
          // run query queryFlagNoAndDeputyCountryNotIndia
          String sql = SELECT_COLUMN_CLAUSE + queryFlagNoAndDeputyCountryNotIndia + orderByClause + limit + totalRequirement.getPageSize() + offset + (totalRequirement.getPageNumber() - 1);
          sql = sql.replaceAll(":empId", totalRequirement.getEmployeeId().toString());
          requirementData = jdbcTemplate.queryForList(sql);
          sql = SELECT_COUNT_CLAUSE + queryFlagNoAndDeputyCountryNotIndia;
          sql = sql.replaceAll(":empId", totalRequirement.getEmployeeId().toString());
          countResult = jdbcTemplate.queryForObject(sql, Integer.class);
          totalPages = (countResult / pageRequest.getPageSize()) + 1;
      }

     if(("N".equals(empData.getUnlockOtherIsu()) || StringUtils.isEmpty(empData.getUnlockOtherIsu())) && "INDIA".equals(empHeadCountData.getEmployeeDeputeCountry())) {
        // run query queryFlagNoAndDeputyCountryIndia
        String sql = SELECT_COLUMN_CLAUSE + queryFlagNoAndDeputyCountryIndia + orderByClause + limit + totalRequirement.getPageSize() + offset + (totalRequirement.getPageNumber() - 1);
        sql = sql.replaceAll(":empId", totalRequirement.getEmployeeId().toString());
        requirementData = jdbcTemplate.queryForList(sql);
        sql = SELECT_COUNT_CLAUSE + queryFlagNoAndDeputyCountryIndia;
        sql = sql.replaceAll(":empId", totalRequirement.getEmployeeId().toString());
        countResult = jdbcTemplate.queryForObject(sql, Integer.class);
        totalPages = (countResult / pageRequest.getPageSize()) + 1;
     }

      if("Y".equals(empData.getUnlockOtherIsu())  && !"INDIA".equals(empHeadCountData.getEmployeeDeputeCountry())) {
         // run query queryFlagYesAndDeputyCountryNotIndia
        String sql = SELECT_COLUMN_CLAUSE + queryFlagYesAndDeputyCountryNotIndia + orderByClause + limit + totalRequirement.getPageSize() + offset + (totalRequirement.getPageNumber() - 1);
        sql = sql.replaceAll(":empId", totalRequirement.getEmployeeId().toString());
        requirementData = jdbcTemplate.queryForList(sql);
        sql = SELECT_COUNT_CLAUSE + queryFlagYesAndDeputyCountryNotIndia;
        sql = sql.replaceAll(":empId", totalRequirement.getEmployeeId().toString());
        countResult = jdbcTemplate.queryForObject(sql, Integer.class);
        totalPages = (countResult / pageRequest.getPageSize()) + 1;
      }

      if("Y".equals(empData.getUnlockOtherIsu()) && "INDIA".equals(empHeadCountData.getEmployeeDeputeCountry())) {
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
    Optional<AspireUserDetails> optData = aspireUserDetailsRepo.findById(empId.intValue());
    if(!optData.isPresent())
      return Map.of("employeeId", empId, "isMLTEligible", false);
    return Map.of("employeeId", empId, "isMLTEligible", true);
  }
}

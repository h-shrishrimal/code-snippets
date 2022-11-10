package com.tcs.rmg.service.impl;

import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.querydsl.core.BooleanBuilder;
import com.tcs.rmg.common.AppConstant;
import com.tcs.rmg.common.MailSender;
import com.tcs.rmg.data.AppliedRequirementData;
import com.tcs.rmg.data.ApplyButtonFields;
import com.tcs.rmg.data.ConfirmRelease;
import com.tcs.rmg.data.EmployeeDetails;
import com.tcs.rmg.data.ExcitingOpportunitiesDataResponse;
import com.tcs.rmg.data.GLRequirementData;
import com.tcs.rmg.data.GLWorkList;
import com.tcs.rmg.data.RMGWorklistFYA;
import com.tcs.rmg.data.RequestorRecommendationData;
import com.tcs.rmg.data.RequirementData;
import com.tcs.rmg.data.TotalExcitingOpportunitiesDetails;
import com.tcs.rmg.data.TotalRequirementDataResponse;
import com.tcs.rmg.data.TotalRequirementDetails;
import com.tcs.rmg.domain.AutoApplyRequirement;
//import com.tcs.rmg.domain.EmployeeDetails;
import com.tcs.rmg.domain.QRequirementDetails;
import com.tcs.rmg.domain.RequirementDetails;
import com.tcs.rmg.domain.UserAuditDetails;
//import com.tcs.rmg.domain.RmgDetails;
import com.tcs.rmg.domain.UserMasterEntity;
import com.tcs.rmg.domain.UserRequirementMapping;
import com.tcs.rmg.exception.RmgAppException;
import com.tcs.rmg.repositories.AppliedRequirementsDetailsRepo;
import com.tcs.rmg.repositories.AutoApplyRequirementRepository;
import com.tcs.rmg.repositories.DropDownRepository;
//import com.tcs.rmg.repositories.EmployeeDetailsRepo;
import com.tcs.rmg.repositories.EmployeeTFactorDetailsRepo;
import com.tcs.rmg.repositories.RequestorRecommendationDetailsRepo;
import com.tcs.rmg.repositories.RequirementDetailsRepo;
import com.tcs.rmg.repositories.UserAuditDetailsHelperRepo;
//import com.tcs.rmg.repositories.RmgDetailsHelperRepo;
import com.tcs.rmg.repositories.UserAuthorizationRepository;
import com.tcs.rmg.repositories.UserMasterRepository;
import com.tcs.rmg.repositories.UserRequirementMappingHelperRepo;
import com.tcs.rmg.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private MailSender mailSender;

	/*@Autowired
	RmgDetailsHelperRepo rmgDetailsHelperRepo;*/

	@Autowired
	RequirementDetailsRepo requirementDetailRepo;

	/*@Autowired
	EmployeeDetailsRepo employeeDetailRepo;*/

	@Autowired
	EmployeeTFactorDetailsRepo employeeTFactorDetailRepo;

	@Autowired
	AppliedRequirementsDetailsRepo appliedRequirementsDetailRepo;

	@Autowired
	UserRequirementMappingHelperRepo userRequirementMappingHelperRepo;
	
	@Autowired
	RequestorRecommendationDetailsRepo requestorRecommendationDetailsRepo;
	
	@Autowired
	DropDownRepository dropDownRepo;
	
	@Autowired
	UserAuthorizationRepository userAuthorizationRepo;
	
	@Autowired
	UserMasterRepository userMasterRepo;

    @PersistenceContext
    private EntityManager em;
	
	@Autowired
	AutoApplyRequirementRepository autoApplyRequirementRepository;

	@Autowired
	UserAuditDetailsHelperRepo  userAuditDetailsHelperRepo;

	@Value("${iaspire.employee.gradelist}")
	private String employeeGradeList;

	private static final DateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
	
	@Override
	public List<RequirementData> getTotalRequirementDetails(Integer employeeId,String isu) {
		
		//todo
		List<RequirementDetails> reqDetails = requirementDetailRepo.getTotalRequirementDetails(isu);
		List<UserRequirementMapping> userRequirementMappings = userRequirementMappingHelperRepo.getByUser(employeeId);

		List<RequirementData> dataList = new ArrayList<>();
		Boolean flag = true;
		for (RequirementDetails w : reqDetails) {
			for (UserRequirementMapping userRequirementMapping : userRequirementMappings) {
				//logger.info("1"+userRequirementMapping.getRequirementId());
				//logger.info("2"+w.getRequirementId());
				if (userRequirementMapping.getRequirementId().intValue() == w.getRequirementId().intValue()) {
					//logger.info("inside if");
					flag = false;
					break;
				}
			}
			if (flag) {
				RequirementData requirementData = new RequirementData();
				requirementData.setBranch(w.getRequirementBranch());
				requirementData.setBusinessName(w.getBusiness());
				requirementData.setCity(w.getRequirementCity());
				requirementData.setCompetency(w.getCompetencyProficiencyDetails());
				requirementData.setCountry(w.getRequirementCountry());
				requirementData.setExperience(w.getTotalExperience());
				requirementData.setPostedOn(w.getRequestCreatedOn());
				requirementData.setRequirementId(w.getRequirementId());
				requirementData.setRole(w.getRole());
				requirementData.setGeography(w.getRequirementGeography());
				dataList.add(requirementData);
			}
			flag = true;
		}
		logger.info("Size"+userRequirementMappings.size());
		for (UserRequirementMapping userRequirementMapping : userRequirementMappings) {
			logger.info("reqId"+userRequirementMapping.getRequirementId());
		}
		return dataList;
	}
	
	@Override
	public TotalRequirementDataResponse getTotalDigitalRequirementDetails(TotalRequirementDetails totalRequirement,String isu) {

		logger.info("In method getTotalDigitalRequirementDetails");

		TotalRequirementDataResponse response = new TotalRequirementDataResponse();
		try {
			Pageable pageRequest = PageRequest.of(totalRequirement.getPageNumber(), totalRequirement.getPageSize());
			
			StringBuilder query = new StringBuilder();
			StringBuilder queryCount = new StringBuilder();
			
			if(totalRequirement.getDigitalFlag() != null && totalRequirement.getDigitalFlag().equalsIgnoreCase("Y")){
				/*query.append(" and a.digital_flagging NOT IN ('Not Applicable')");
				queryCount.append(" and a.digital_flagging NOT IN ('Not Applicable')");*/
				//todo
				query.append("select b.Requirement_Id, b.total_experience, b.Request_Created_On, b.Role, b.business, b.Competency_Proficiency_Details, b.Requirement_City, b.Requirement_Branch, b.Requirement_Country, b.requirement_geography, b.onsite_offshore from  global_login.project_details a, rmg_app.requirement_details b where a.project_number = b.project_number and b.requirement_status NOT IN('CLOSED') and a.digital_flagging NOT IN ('Not Applicable')");
				queryCount.append("select count(b.Requirement_Id) from global_login.project_details a, rmg_app.requirement_details b where a.project_number = b.project_number and b.requirement_status NOT IN('CLOSED') and a.digital_flagging NOT IN ('Not Applicable')");
			}else {
				query.append("select Requirement_Id, total_experience, Request_Created_On, Role, business, Competency_Proficiency_Details, Requirement_City, Requirement_Branch, Requirement_Country, requirement_geography, onsite_offshore from  rmg_app.requirement_details b where requirement_status NOT IN('CLOSED')");
				queryCount.append("select count(Requirement_Id) from  rmg_app.requirement_details b where requirement_status NOT IN('CLOSED')");
			}
			if(totalRequirement.getRole() != null) {
				query.append("and role = '"+totalRequirement.getRole()+"'");
				queryCount.append("and role = '"+totalRequirement.getRole()+"'");
			}
			if(totalRequirement.getGeography() != null){
				query.append(" and requirement_geography = '"+totalRequirement.getGeography()+"'");
				queryCount.append(" and requirement_geography = '"+totalRequirement.getGeography()+"'");
			}
			if(totalRequirement.getRequirementId() != null){
				query.append(" and Requirement_Id = '"+totalRequirement.getRequirementId()+"'");
				queryCount.append(" and Requirement_Id = '"+totalRequirement.getRequirementId()+"'");
			}
			if(totalRequirement.getBusiness() != null){
				query.append(" and Business = '"+totalRequirement.getBusiness()+"'");
				queryCount.append(" and Business = '"+totalRequirement.getBusiness()+"'");
			}
			if(totalRequirement.getSkill() != null){
				query.append(" and Competency_Proficiency_Details LIKE '%"+totalRequirement.getSkill()+"%'");
				queryCount.append(" and Competency_Proficiency_Details LIKE '%"+totalRequirement.getSkill()+"%'");
			}
			if(totalRequirement.getLocation() != null){
				query.append(" and (Requirement_City LIKE '%"+totalRequirement.getLocation()+"%' OR Requirement_Country LIKE '%"+totalRequirement.getLocation()+"%' OR Requirement_Branch LIKE '%"+totalRequirement.getLocation()+"%')");
				//queryCount.append(" and Skill LIKE '"+totalRequirement.getLocation()+"'");
			}
			if(totalRequirement.getSkill() != null){
				query.append(" and Competency_Proficiency_Details LIKE '%"+totalRequirement.getSkill()+"%'");
				queryCount.append(" and Competency_Proficiency_Details LIKE '%"+totalRequirement.getSkill()+"%'");
			}
			//changed
			if(isu!=null)
			{
				query.append("and isu = '"+isu+"'");
				queryCount.append("and isu = '"+isu+"'");
			}
			query.append(" and NOT EXISTS (select 1 from  rmg_app.applied_requirement where Requirement_Id = b.Requirement_Id and applicant_employeeid = '"+totalRequirement.getEmployeeId()+"')");
			queryCount.append(" and NOT EXISTS (select 1 from  rmg_app.applied_requirement where Requirement_Id = b.Requirement_Id and applicant_employeeid = '"+totalRequirement.getEmployeeId()+"')");
			//System.out.println("query -> "+query);
			logger.info("query -> "+query);
			logger.info("queryCount -> "+queryCount);
						
			/*if(totalRequirement.getDigitalFlag() != null && totalRequirement.getDigitalFlag().equalsIgnoreCase("Y")){
				query.append(" and a.digital_flagging NOT IN ('Not Applicable')");
				queryCount.append(" and a.digital_flagging NOT IN ('Not Applicable')");
			}*/
			Query q = em.createNativeQuery(query.toString());
			
			Query queryTotal = em.createNativeQuery(queryCount.toString());
			
			int countResult = ((BigInteger)queryTotal.getSingleResult()).intValue();
			int pageNumber = (int) ((countResult / pageRequest.getPageSize()) + 1);
			
			response.setTotalPages(pageNumber);
			response.setTotalCount(countResult);

			q.setFirstResult((totalRequirement.getPageNumber()-1) * totalRequirement.getPageSize());
			q.setMaxResults(totalRequirement.getPageSize());
					
			List<Object> reqDetails = (List<Object>) q.getResultList();
			
			List<UserRequirementMapping> userRequirementMappings = userRequirementMappingHelperRepo.getByUser(totalRequirement.getEmployeeId());
			List<RequirementData> dataList = new ArrayList<>();
			Boolean flag = true;
			
			if(reqDetails != null && !reqDetails.isEmpty()) {
				response.setTotalPages(pageNumber);
				response.setTotalCount(countResult);
				
				Object[] temp;
				Iterator<Object> itr = reqDetails.iterator();
				
				while (itr.hasNext()) {
					temp = (Object[]) itr.next();
					for (UserRequirementMapping userRequirementMapping : userRequirementMappings) {
						if (userRequirementMapping.getRequirementId().intValue() == Integer.parseInt(temp[0].toString())) {
							flag = false;
							break;
						}
					}
					if (flag) {
						RequirementData requirementData = new RequirementData();
						
						requirementData.setRequirementId(Integer.parseInt(temp[0].toString()));
						requirementData.setExperience(temp[1].toString());
						requirementData.setPostedOn(temp[2].toString());
						requirementData.setRole(temp[3].toString());
						requirementData.setBusinessName(temp[4].toString());
						requirementData.setCompetency(temp[5].toString());
						requirementData.setCity(temp[6].toString());
						requirementData.setBranch(temp[7].toString());
						requirementData.setCountry(temp[8].toString());
						requirementData.setGeography(temp[9].toString());
						requirementData.setOnsiteOffshore(temp[10].toString());
						
						dataList.add(requirementData);
					}
					flag = true;		
				}
				response.setTotalReqData(dataList);
			}
			logger.info("Size"+userRequirementMappings.size());
			for (UserRequirementMapping userRequirementMapping : userRequirementMappings) {
				//logger.info("reqId"+userRequirementMapping.getRequirementId());
			}	
		}catch(Exception e) {
			logger.error("Error in getTotalDigitalRequirementDetails ",e);
		}
		return response;
	}

	@Override
	public List<GLRequirementData> getTotalRequirementDetailsForGL(String isu) {

		List<GLRequirementData> dataList = new ArrayList<>();
		List<RequirementDetails> reqDetails = requirementDetailRepo.getTotalRequirementDetails(isu);
		
		for (RequirementDetails w : reqDetails) {
			GLRequirementData requirementData = new GLRequirementData();
			requirementData.setAppliedBy(appliedRequirementsDetailRepo.getCountOfPositions(w.getRequirementId()));
			requirementData.setBranch(w.getRequirementBranch());
			requirementData.setBusinessName(w.getBusiness());
			requirementData.setCity(w.getRequirementCity());
			requirementData.setCompetency(w.getCompetencyProficiencyDetails());
			requirementData.setCountry(w.getRequirementCountry());
			requirementData.setExperience(w.getTotalExperience());
			requirementData.setPostedOn(w.getRequestCreatedOn());
			requirementData.setRequirementId(w.getRequirementId());
			requirementData.setRole(w.getRole());
			dataList.add(requirementData);
		}
		return dataList;
	}

	@Override
	public Integer getTotalRequirementCount(String isu) throws RmgAppException {
		
		try {
			return requirementDetailRepo.getTotalRequirementCount(isu);
		}catch(Exception e) {
			logger.error("Exception in getRoleList - ",e);
			throw new RmgAppException(AppConstant.ERROR_CODE_501, "Exception in getRoleList");
		}
	}
		
	@Override
	public String getEmployeeBusinessUnit(Integer employeeNumber) throws RmgAppException {
		try {
			//return employeeDetailRepo.getEmployeeBusinessUnit(employeeNumber);
			return userMasterRepo.getEmployeeBusinessUnit(Integer.toString(employeeNumber));
		} catch (Exception e) {
			logger.error("Exception in getEmployeeBusinessUnit - ",e); 
			throw new RmgAppException(AppConstant.ERROR_CODE_501, "Unable to get Employee Business Unit -> Data Source not avilable or wrong sql query");
		}
	}

	//todo
	@Override
	public Integer getRequirementCountInEmpBusinessUnit(Integer employeeNumber,String isu) throws RmgAppException {

		//String businessUnit = this.getEmployeeBusinessUnit(employeeNumber);
		try {
			//todo
			return requirementDetailRepo.getRequirementCountInOpenDigitalPosition(isu);
		} catch (Exception e) {
			logger.error("Exception in getRequirementCount in open Digital position - ",e);
			throw new RmgAppException(AppConstant.ERROR_CODE_501, "Unable to get Requirement count In open Digital position -> Data Source not avilable or wrong sql query");
		}
	}

	@Override
	public List<RequirementData> getRequirementListInEmpBusinessUnit(Integer employeeNumber,String isu) throws RmgAppException {

		String businessUnit = this.getEmployeeBusinessUnit(employeeNumber);
		List<Object> reqDetails;
		try {
			reqDetails = requirementDetailRepo.getRequirementListInEmpBusinessUnit(businessUnit,isu);
		} catch (Exception e) {
			logger.error("Exception in getRequirementListInEmpBusinessUnit - ",e);
			throw new RmgAppException(AppConstant.ERROR_CODE_501, "Unable to get Requirement list In Emp Business Unit -> Data Source not avilable or wrong sql query");
		}
		if (reqDetails.isEmpty()) {
			return new ArrayList<>();

		} else {
			Object[] temp;
			Iterator<Object> itr = reqDetails.iterator();
			RequirementData requirementData;
			List<RequirementData> dataList = new ArrayList<>();
			while (itr.hasNext()) {
				temp = (Object[]) itr.next();
				requirementData = new RequirementData(Integer.valueOf(temp[0].toString()), temp[1].toString(),
						temp[2].toString(), temp[3].toString(), temp[4].toString(), temp[5].toString(),
						temp[6].toString(), temp[7].toString(), temp[8].toString(), temp[9].toString(), temp[10].toString());
				dataList.add(requirementData);
			}
			return dataList;
		}
	}

	@Override
	public List<RequirementData> getRecentOpenRequirementList(String isu) throws RmgAppException {
		List<Object> reqDetails;
		try {
			//todo
			reqDetails = requirementDetailRepo.getRecentOpenRequirementList(isu);
			if (reqDetails.isEmpty()) {
				return new ArrayList<>();

			} else {
				Object[] temp;
				Iterator<Object> itr = reqDetails.iterator();
				RequirementData requirementData;
				List<RequirementData> dataList = new ArrayList<>();
				while (itr.hasNext()) {
					temp = (Object[]) itr.next();
					/*
					 * appliedRequirementData = new AppliedRequirementData(Integer.valueOf((temp[0]
					 * == null ? "" : temp[0].toString())), (temp[3] == null ? "" :
					 * temp[3].toString()), (temp[4] == null ? "" : temp[4].toString()), (temp[5] ==
					 * null ? "" : temp[5].toString()), (temp[6] == null ? "" : temp[6].toString()),
					 * (temp[7] == null ? "" : temp[7].toString()), (temp[8] == null ? "" :
					 * temp[8].toString()), (temp[9] == null ? "" : temp[9].toString()),
					 * temp[1].toString(), (temp[2] == null ? "" : temp[2].toString()));
					 */		
					
					requirementData = new RequirementData(Integer.valueOf((temp[0] == null ? "" : temp[0].toString())), (temp[1] == null ? "" : temp[1].toString()),
							(temp[2] == null ? "" : temp[2].toString()), (temp[3] == null ? "" : temp[3].toString()), (temp[4] == null ? "" : temp[4].toString()), (temp[5] == null ? "" : temp[5].toString()),
							(temp[6] == null ? "" : temp[6].toString()), (temp[7] == null ? "" : temp[7].toString()), (temp[8] == null ? "" : temp[8].toString()), (temp[9] == null ? "" : temp[9].toString()), (temp[10] == null ? "" : temp[10].toString()));
					dataList.add(requirementData);
				}
				return dataList;
			}
		} catch (Exception e) {
			logger.error("Exception in getRecentOpenRequirementList - ",e);
			throw new RmgAppException(AppConstant.ERROR_CODE_501, "Unable to get Recent Requirement list -> Data Source not avilable or wrong sql query");
		}
	}

	@Override
	public Integer getRecentOpenRequirementCount(String isu) throws RmgAppException {
		try {
			logger.info("getRecentOpenRequirementCount");
			return requirementDetailRepo.getRecentOpenRequirementCount(isu);
		} catch (Exception e) {
			logger.error("Exception in getRecentOpenRequirementCount - ",e);
			throw new RmgAppException(AppConstant.ERROR_CODE_501, "Unable to get Recent Open requirements count -> Data Source not avilable or wrong sql query");
		}
	}

	@Override
	public Integer getAppliedPositionsCountForUser(Integer employeeNumber) throws RmgAppException {
		try {
			return appliedRequirementsDetailRepo.getAppliedPositionsCountForUser(employeeNumber);
		} catch (Exception e) {
			logger.error("Exception in getAppliedPositionsCountForUser - ",e);
			throw new RmgAppException(AppConstant.ERROR_CODE_501,"Unable to get Applied Position count for User -> Data Source not avilable or wrong sql query");
		}
	}

	@Override
	public List<AppliedRequirementData> getAppliedPositionsListForUser(Integer employeeNumber) throws RmgAppException {
		List<Object> reqDetails;
		try {
			reqDetails = appliedRequirementsDetailRepo.getAppliedPositionsListForUser(employeeNumber);
		} catch (Exception e) {
			logger.error("Exception in getAppliedPositionsListForUser - ",e);
			throw new RmgAppException(AppConstant.ERROR_CODE_501, "Unable to get Applied Position list for User -> Data Source not avilable or wrong sql query");
		}
		if (reqDetails.isEmpty()) {
			return new ArrayList<>();
		} else {
			Object[] temp;
			Iterator<Object> itr = reqDetails.iterator();
			AppliedRequirementData appliedRequirementData;
			List<AppliedRequirementData> dataList = new ArrayList<>();
			while (itr.hasNext()) {
				temp = (Object[]) itr.next();
				appliedRequirementData = new AppliedRequirementData(Integer.valueOf(temp[0].toString()),
						temp[3].toString(), temp[4].toString(), temp[5].toString(), temp[6].toString(),
						temp[7].toString(), temp[8].toString(), temp[9].toString(), temp[1].toString(),
						temp[2].toString());
				dataList.add(appliedRequirementData);
			}
			return dataList;
		}
	}

	// 90 days constraint
	
	@Override
	public List<AppliedRequirementData> getAppliedPositionsListForUserApplied(Integer employeeNumber) throws RmgAppException {
		List<Object> reqDetails;
		try {
			reqDetails = appliedRequirementsDetailRepo.getAppliedPositionsListForUserApplied(employeeNumber);
		} catch (Exception e) {
			logger.error("Exception in getAppliedPositionsListForUserApplied - ",e);
			throw new RmgAppException( AppConstant.ERROR_CODE_501, "Unable to get Applied Position list for User -> Data Source not avilable or wrong sql query");
		}
		if (reqDetails.isEmpty()) {
			return new ArrayList<>();
		} else {
			Object[] temp;
			Iterator<Object> itr = reqDetails.iterator();
			AppliedRequirementData appliedRequirementData;
			List<AppliedRequirementData> dataList = new ArrayList<>();
			while (itr.hasNext()) {
				temp = (Object[]) itr.next();
				appliedRequirementData = new AppliedRequirementData(Integer.valueOf(temp[0].toString()),
						temp[3].toString(), temp[4].toString(), temp[5].toString(), temp[6].toString(),
						temp[7].toString(), temp[8].toString(), temp[9].toString(), temp[1].toString(),
						temp[2].toString());
				dataList.add(appliedRequirementData);
			}
			return dataList;
		}
	}
	
//todo
	@Override
	public List<AppliedRequirementData> getPendingPositionsListForUser(Integer employeeNumber,String isu) throws RmgAppException {

		List<Object> reqDetails;
		try {
			reqDetails = appliedRequirementsDetailRepo.getPendingPositionsListForUser(employeeNumber);
		} catch (Exception e) {
			logger.error("Exception in getPendingPositionsListForUser - ",e);
			throw new RmgAppException(AppConstant.ERROR_CODE_501, "Unable to get Pending Position list for User -> Data Source not avilable or wrong sql query");
		}
		if (reqDetails.isEmpty()) {
			return new ArrayList<>();
		} else {
			Object[] temp;
			Iterator<Object> itr = reqDetails.iterator();
			AppliedRequirementData appliedRequirementData;
			List<AppliedRequirementData> dataList = new ArrayList<>();
			while (itr.hasNext()) {
				temp = (Object[]) itr.next();
				appliedRequirementData = new AppliedRequirementData(Integer.valueOf(temp[0].toString()),
						temp[3].toString(), temp[4].toString(), temp[5].toString(), temp[6].toString(),
						temp[7].toString(), temp[8].toString(), temp[9].toString(), temp[1].toString(),
						temp[2].toString());
				dataList.add(appliedRequirementData);
			}
			return dataList;
		}
	}

	@Override
	public Integer getPendingPositionsCountForUser(Integer employeeNumber) throws RmgAppException {
		try {
			return appliedRequirementsDetailRepo.getPendingPositionsCountForUser(employeeNumber);
		} catch (Exception e) {
			logger.error("Exception in getPendingPositionsCountForUser - ",e);
			throw new RmgAppException(AppConstant.ERROR_CODE_501,"Unable to get Pending Position count for User -> Data Source not avilable or wrong sql query");
		}
	}

	@Override
	public List<String> getCompetencyList(String isu) throws RmgAppException {
		try {
			return requirementDetailRepo.getCompetencyList(isu);
		} catch (Exception e) {
			logger.error("Exception in getCompetencyList - ",e);
			throw new RmgAppException(AppConstant.ERROR_CODE_501,"Unable to get competency list -> Data Source not avilable or wrong sql query");
		}
	}

	@Override
	public List<Integer> getRequestIdList(Integer requestorEmployeeId) throws RmgAppException {

		try {
			return appliedRequirementsDetailRepo.getRequestIdList(requestorEmployeeId);
		} catch (Exception e) {
			logger.error("Exception in getRequestIdList - ",e);
			throw new RmgAppException(AppConstant.ERROR_CODE_501,"Unable to get request id list -> Data Source not avilable or wrong sql query");
		}
	}

	@Override
	public List<String> getRoleList() throws RmgAppException {
		try {
			return requirementDetailRepo.getRoleList();
		} catch (Exception e) {
			logger.error("Exception in getRoleList - ",e);
			throw new RmgAppException(AppConstant.ERROR_CODE_501, "Unable to get role list -> Data Source not avilable or wrong sql query");
		}
	}

	@Override
	public List<String> getGeographyList(String isu) throws RmgAppException {
		try {
			return requirementDetailRepo.getGeographyList(isu);
		} catch (Exception e) {
			logger.error("Exception in getGeographyList - ",e);
			throw new RmgAppException(AppConstant.ERROR_CODE_501, "Unable to get Geography list -> Data Source not avilable or wrong sql query");
		}
	}

	@Override
	public List<String> getCountryList(String isu) throws RmgAppException {
		try {
			return requirementDetailRepo.getCountryList(isu);
		} catch (Exception e) {
			logger.error("Exception in getGeographyList - ",e);
			throw new RmgAppException(AppConstant.ERROR_CODE_501,"Unable to get Country list -> Data Source not avilable or wrong sql query");
		}
	}

	@Override
	public List<String> getBranchList(String isu) throws RmgAppException {
		try {
			return requirementDetailRepo.getBranchList(isu);
		} catch (Exception e) {
			logger.error("Exception in getBranchList - ",e);
			throw new RmgAppException(AppConstant.ERROR_CODE_501, "Unable to get Branch list -> Data Source not avilable or wrong sql query");
		}
	}
	
	
	@Override
	public EmployeeDetails getEmployeeRoleAndGrade(String empNumber) throws RmgAppException {
		EmployeeDetails empDetails = new EmployeeDetails();

		logger.info("List of grade for user:- " + employeeGradeList);
		String[] strList = employeeGradeList.split(",");
		List<String> gradeList = new ArrayList<>();
		gradeList.addAll(Arrays.asList(strList));
		logger.info("Grade for user:- " + gradeList);
		String grade = userMasterRepo.getEmployeeGrade(empNumber);

		empDetails.setRole(getRoleOfEmployee(Integer.valueOf(empNumber)));
		if (gradeList.contains(grade)) {
			empDetails.setShowExcitingOpportunities(true);
		}else {
			empDetails.setShowExcitingOpportunities(false);

		}
		return empDetails;
	}

	@Override
	public String getRoleOfEmployee(Integer employeeNumber) throws RmgAppException {
		try {
			//Integer empNumber = rmgDetailsHelperRepo.getRmgId(employeeNumber);
			String Empno = (employeeNumber == null) ? "": (employeeNumber.toString());
			String empNumber = userAuthorizationRepo.getRmgId(Empno);
				if(null!=empNumber && !empNumber.isEmpty()) {
					logger.info("RM role for user:- "+empNumber); 
					return "RM";
	
				}else {
					String empNumberForExOpp =userAuthorizationRepo.checkExOppRequestor(Empno);
					if(null!=empNumberForExOpp && !empNumberForExOpp.isEmpty()) {
						logger.info(" for EXC-OPP :- RQ role for user:- "+empNumberForExOpp); 
						return "RQ";
					
					}
					else if (null == empNumberForExOpp) {
						Integer requestId = requirementDetailRepo.checkIfRequestorExist(employeeNumber);
						if (requestId != null && requestId.equals(employeeNumber)) {
							logger.info("RQ role for user:- "+empNumberForExOpp); 
							logger.info("RQ");
							return "RQ";
						}
					}
					else {
						String role =  userMasterRepo.getRoleOfEmployee(Empno);
						logger.info(" role for user:- -"+employeeNumber+"----"+role); 
						return role;
					}
				}
			
				
		
								 
	} catch (Exception e) {
			logger.error("Exception in getRoleOfEmployee - ",e);
			throw new RmgAppException(AppConstant.ERROR_CODE_501,"Unable to get role of Employee -> Data Source not avilable or wrong sql query");
		}
		return userMasterRepo.getRoleOfEmployee(employeeNumber.toString());
	}
	@Override
	public List<RequirementData> getRequirementSearchList(String competency, String role, String geography,String isu) {

		QRequirementDetails requirementDetails = QRequirementDetails.requirementDetails;

		BooleanBuilder where = new BooleanBuilder();

		if (competency != null) {
			where.and(requirementDetails.competencyProficiencyDetails.eq(competency));
		} else {
			where.and(requirementDetails.competencyProficiencyDetails.isEmpty());
		}

		if (role != null) {
			where.and(requirementDetails.role.eq(role));
		} else {
			where.and(requirementDetails.role.isEmpty());
		}

		if (geography != null) {
			where.and(requirementDetails.requirementGeography.eq(geography));
		} else {
			where.and(requirementDetails.requirementGeography.isEmpty());

		}
		if (isu != null) {
			where.and(requirementDetails.isu.eq(isu));
		} else {
			where.and(requirementDetails.isu.isEmpty());

		}
		List<RequirementDetails> reqDetails = (List<RequirementDetails>) requirementDetailRepo.getTotalRequirementDetails(isu);

		if (reqDetails.isEmpty()) {
			return new ArrayList<>();

		} else {
			RequirementDetails temp;
			Iterator<RequirementDetails> itr = reqDetails.iterator();
			RequirementData requirementData;
			List<RequirementData> dataList = new ArrayList<>();

			while (itr.hasNext()) {
				temp = itr.next();
				requirementData = new RequirementData(temp.getRequirementId(), temp.getTotalExperience(),
						temp.getRequestCreatedOn(), temp.getRequirementCity(), temp.getRequirementBranch(),
						temp.getRequirementCountry(), temp.getBusiness(), temp.getCompetencyProficiencyDetails(),
						temp.getRole(), temp.getRequirementGeography(), temp.getOnsiteOffshore());
				dataList.add(requirementData);
			}
			return null;
		}
	}

	@Override
	public List<GLRequirementData> getRequirementSearchListForGL(String competency, String role, String geography,
			String country, String branch, String experience, String iou, String requirementStartDate,String isu) {

		QRequirementDetails requirementDetails = QRequirementDetails.requirementDetails;

		BooleanBuilder where = new BooleanBuilder();

		if (competency != null) {
			where.and(requirementDetails.competencyProficiencyDetails.eq(competency));
		} else {
			where.and(requirementDetails.competencyProficiencyDetails.isEmpty());
		}

		if (role != null) {
			where.and(requirementDetails.role.eq(role));
		} else {
			where.and(requirementDetails.role.isEmpty());
		}

		if (geography != null) {
			where.and(requirementDetails.requirementGeography.eq(geography));
		} else {
			where.and(requirementDetails.requirementGeography.isEmpty());
		}

		if (country != null) {
			where.and(requirementDetails.requirementCountry.eq(country));
		} else {
			where.and(requirementDetails.requirementCountry.isEmpty());
		}

		if (branch != null) {
			where.and(requirementDetails.requirementBranch.eq(branch));
		} else {
			where.and(requirementDetails.requirementBranch.isEmpty());
		}

		if (experience != null) {
			where.and(requirementDetails.totalExperience.eq(experience));
		} else {
			where.and(requirementDetails.totalExperience.isEmpty());
		}
		if (isu != null) {
			where.and(requirementDetails.isu.eq(experience));
		} else {
			where.and(requirementDetails.isu.isEmpty());
		}
		//todo
		List<RequirementDetails> reqDetails = (List<RequirementDetails>) requirementDetailRepo.findAll(where);

		if (reqDetails.isEmpty()) {
			return new ArrayList<>();

		} else {
			RequirementDetails temp;
			Iterator<RequirementDetails> itr = reqDetails.iterator();
			Integer appliedBy;
			GLRequirementData requirementData;
			List<GLRequirementData> dataList = new ArrayList<>();

			while (itr.hasNext()) {
				temp = itr.next();

				appliedBy = appliedRequirementsDetailRepo.getCountOfPositions(temp.getRequirementId());
				requirementData = new GLRequirementData(temp.getRequirementId(), temp.getRole(),
						temp.getTotalExperience(), temp.getRequestCreatedOn(), temp.getRequirementCity(),
						temp.getRequirementBranch(), temp.getRequirementCountry(), temp.getBusiness(),
						temp.getCompetencyProficiencyDetails(), appliedBy);
				dataList.add(requirementData);
			}
			return null;
		}
	}

	@Override
	public Integer getAppliedPositionsCountForRmg(Integer employeeNumber) {
		return appliedRequirementsDetailRepo.getAppliedPositionsCountForRmg(employeeNumber);
	}

	@Override
	public Integer getAppliedPositionsCountForGL(Integer employeeNumber) {
		return appliedRequirementsDetailRepo.getAppliedPositionsCountForGL(employeeNumber);
	}

	@Override
	public Integer getPendingPositionsCountForGL(Integer employeeNumber) {
		return appliedRequirementsDetailRepo.getPendingPositionsCountForGL(employeeNumber);
	}

	@Override
	public List<AppliedRequirementData> getAppliedPositionsListForRmg(Integer employeeNumber,String isu) {

		logger.info("employeeNumber"+employeeNumber);
		//todo
		List<Object> reqDetails = appliedRequirementsDetailRepo.getAppliedPositionsListForRmg();
		logger.info("RMG-APP-list----" + reqDetails.size());

		if (reqDetails.isEmpty()) {
			return new ArrayList<>();

		} else {
			Object[] temp;
			Iterator<Object> itr = reqDetails.iterator();
			AppliedRequirementData appliedRequirementData;
			List<AppliedRequirementData> dataList = new ArrayList<>();

			while (itr.hasNext()) {
				temp = (Object[]) itr.next();

				if (!(temp[1].toString().equals("Approved")) && !(temp[1].toString().equals("Rejected"))) {
					appliedRequirementData = new AppliedRequirementData(Integer.valueOf(temp[0].toString()),
							temp[3].toString(), temp[4].toString(), temp[5].toString(), temp[6].toString(),
							temp[7].toString(), temp[8].toString(), temp[9].toString(), temp[1].toString(),
							temp[2].toString());
					dataList.add(appliedRequirementData);
				}
			}
			return dataList;
		}
	}

	@Override
	public List<RMGWorklistFYA> getRmgWorklistFYA(Integer employeeNumber, String isu) {
		try {
		//todo
		List<Object> reqDetails = appliedRequirementsDetailRepo.getRmgWorklistFYA();
		logger.info("RMG-APP-list----" + reqDetails.size());
		//Double tFactor = 0D;
				
		if (reqDetails.isEmpty()) {
			return new ArrayList<>();
		} else {
			logger.info("getRmgWorklistFYA---ELSE");
			Object[] temp;
			Iterator<Object> itr = reqDetails.iterator();
			String employeeName;
			RMGWorklistFYA rmgData;
			List<RMGWorklistFYA> dataList = new ArrayList<>();

			while (itr.hasNext()) {
				logger.info("getRmgWorklistFYA--While");
				temp = (Object[]) itr.next();
				//employeeName = employeeDetailRepo.getEmployeeName(Integer.valueOf(temp[0].toString()));
				employeeName = userMasterRepo.getEmployeeName(temp[0].toString());
				
				/*tFactor = employeeTFactorDetailRepo.getTFactorDetails(Integer.valueOf(temp[0].toString()));
				tFactor = (null == tFactor) ? 0: (tFactor);*/
				
				String applicantContactNumber = temp[10] == null ? "" : temp[10].toString();
				
				String validVisa = temp[14] == null ? "" : temp[14].toString();
				String visaType = temp[15] == null ? "" : temp[15].toString();
				String visaIssueDate = temp[16] == null ? "" : temp[16].toString();
				String visaExpDate = temp[17] == null ? "" : temp[17].toString();

				rmgData = new RMGWorklistFYA(Integer.valueOf(temp[0].toString()), employeeName, temp[1].toString(),
						Integer.valueOf(temp[2].toString()), temp[3].toString(), temp[4].toString(), temp[5].toString(),
						temp[6].toString(), temp[7].toString(), temp[8].toString(), temp[9].toString(),//tFactor.toString(),
						applicantContactNumber, temp[11].toString(), temp[12].toString(),temp[13].toString(), validVisa, visaType, visaIssueDate, visaExpDate, temp[18].toString());
				dataList.add(rmgData);
			}
		
			return dataList;
		}
		}catch(Exception e) {
			logger.info("getRmgWorklistFYA---exception --"+e);
		}
		return null;
	}

	@Override
	public List<AppliedRequirementData> getPendingPositionsListForRmg(Integer employeeNumber,String isu) {

		List<Object> reqDetails = appliedRequirementsDetailRepo.getPendingPositionsListForRmg(employeeNumber);

		if (reqDetails.isEmpty()) {
			return new ArrayList<>();
		} else {
			Object[] temp;
			Iterator<Object> itr = reqDetails.iterator();
			AppliedRequirementData appliedRequirementData;
			List<AppliedRequirementData> dataList = new ArrayList<>();

			while (itr.hasNext()) {
				temp = (Object[]) itr.next();
				appliedRequirementData = new AppliedRequirementData(Integer.valueOf(temp[0].toString()),
						temp[3].toString(), temp[4].toString(), temp[5].toString(), temp[6].toString(),
						temp[7].toString(), temp[8].toString(), temp[9].toString(), temp[1].toString(),
						temp[2].toString());
				dataList.add(appliedRequirementData);
			}
			return dataList;
		}
	}

	@Override
	public List<GLWorkList> getGLWorklist(Integer employeeNumber,String isu) {

		List<Object> reqDetails = appliedRequirementsDetailRepo.getGLWorkList(employeeNumber);

		if (reqDetails.isEmpty()) {
			return new ArrayList<>();
		} else {
			Object[] temp;
			Iterator<Object> itr = reqDetails.iterator();
			String employeeName;
			GLWorkList glData;
			List<GLWorkList> dataList = new ArrayList<>();

			while (itr.hasNext()) {
				temp = (Object[]) itr.next();
				//employeeName = employeeDetailRepo.getEmployeeName(Integer.valueOf(temp[0].toString()));
				
				employeeName = userMasterRepo.getEmployeeName(temp[0].toString());
				
				glData = new GLWorkList(employeeName, Integer.valueOf(temp[0].toString()), temp[1].toString(),
						temp[2].toString(), Integer.valueOf(temp[3].toString()), temp[4].toString(),
						temp[5].toString());
				dataList.add(glData);
			}
			return dataList;
		}
	}

	@Override
	public List<GLWorkList> getGLPendingWorklist(Integer employeeNumber,String isu) {

		List<Object> reqDetails = appliedRequirementsDetailRepo.getGLPendingWorklist(employeeNumber);

		if (reqDetails.isEmpty()) {
			return new ArrayList<>();

		} else {
			Object[] temp;
			Iterator<Object> itr = reqDetails.iterator();
			String employeeName;
			GLWorkList glData;
			List<GLWorkList> dataList = new ArrayList<>();

			while (itr.hasNext()) {
				temp = (Object[]) itr.next();
				//employeeName = employeeDetailRepo.getEmployeeName(Integer.valueOf(temp[0].toString()));
				employeeName = userMasterRepo.getEmployeeName(temp[0].toString());
				
				glData = new GLWorkList(employeeName, Integer.valueOf(temp[0].toString()), temp[1].toString(),
						temp[2].toString(), Integer.valueOf(temp[3].toString()), temp[4].toString(),
						temp[5].toString());
				dataList.add(glData);
			}
			return dataList;
		}
	}

	@Override
	public String addAppliedPositionData(ApplyButtonFields applyButtonFields) throws RmgAppException {

		try {
				logger.info("----in service addAppliedPositionData----");
				//List<RmgDetails> rmgDetailList = rmgDetailsHelperRepo.findAll();
				
				Integer requestorEmployeeId=null;
				String excOppFlag =requirementDetailRepo.getExcitingOpportunityFLAG(applyButtonFields.getRequirementId());
				if(excOppFlag!=null && !excOppFlag.isEmpty()) {
					logger.info("----in if exciting opp addAppliedPositionData----"+excOppFlag);
					requestorEmployeeId=0;
				}
				else {
					logger.info("----in else not  exciting opp addAppliedPositionData----"+excOppFlag);
					 requestorEmployeeId = requirementDetailRepo.getRequestorEmployeeId(applyButtonFields.getRequirementId());
				}
				List<String> rmgDetailList = userAuthorizationRepo.getRmgList();
				logger.info("----in if exciting opp addAppliedPositionData---rmgDetailList-"+rmgDetailList);

				Integer requestId = requirementDetailRepo.getRequirementRequestId(applyButtonFields.getRequirementId());
				//Integer requestorEmployeeId = requirementDetailRepo.getRequestorEmployeeId(applyButtonFields.getRequirementId());
				logger.info("----in if exciting opp addAppliedPositionData---requestId-"+requestId);

				List<String> requiremnetList = appliedRequirementsDetailRepo.getAppliedRequirementListForUserApplied(applyButtonFields.getEmployeeId());
				logger.info("----in if exciting opp addAppliedPositionData---requiremnetList-"+requiremnetList);

				Integer glEmployeeId = 0;
				String rmgStatus = "Pending";
				String requestorStatus = "Pending";
				String rmgComments = "";
				String glComments = "";
				String releaseDate = "0000-00-00";
				String description = "";
				//String rmgIdCombine = "";
				String rmgIdCombine1 = "";
				Calendar calendar = Calendar.getInstance();
				Date createdDate = calendar.getTime();
				String date =sdf.format(createdDate); //updated date format by Apurva on 22nd Apr2020
				
				
				for (String rmgIdCombine : rmgDetailList) {
					rmgIdCombine1 =  rmgIdCombine + "," + rmgIdCombine1;
				}
				
				if(!rmgDetailList.contains(applyButtonFields.getEmployeeId().toString())){
					logger.info("----in if 1-contains-");

					if(!requiremnetList.contains(applyButtonFields.getRequirementId())) {
						logger.info("----in if 2-contains-");

						appliedRequirementsDetailRepo.addAppliedPositionData(requestId, applyButtonFields.getRequirementId(),
								requestorEmployeeId, applyButtonFields.getEmployeeId(), rmgIdCombine1, rmgStatus, requestorStatus,
								rmgComments, glEmployeeId, glComments, applyButtonFields.getComments(), releaseDate, description,
								applyButtonFields.getExperience(), applyButtonFields.getContactNumber(), applyButtonFields.getEmployeeId(), date,
								applyButtonFields.getValidVisa(), applyButtonFields.getVisaType(), applyButtonFields.getVisaIssueDate(), applyButtonFields.getVisaExpiryDate());
						
						UserRequirementMapping userRequirementMapping = new UserRequirementMapping();
						userRequirementMapping.setRequirementId(applyButtonFields.getRequirementId());
						userRequirementMapping.setUserId(applyButtonFields.getEmployeeId());
						userRequirementMappingHelperRepo.save(userRequirementMapping);
						logger.info("----in if 3-contains-");

						logger.info("----End addAppliedPositionData----");
						return "SUCCESS";
					}else {	
						logger.info("----IN ELSE END addAppliedPositionData----");

					throw new RmgAppException(AppConstant.ERROR_CODE_1003, AppConstant.ERROR_MSG_1003);
				}
			}else {
				logger.info("----IN ELSE FINAL addAppliedPositionData----");
				throw new RmgAppException(AppConstant.ERROR_CODE_1002, AppConstant.ERROR_MSG_1002);
			}									
		}catch (RmgAppException e) {
			logger.info("Error  into  addAppliedPositionData --");
			logger.debug("Error  into  addAppliedPositionData debug--"+e);
			if(AppConstant.ERROR_CODE_1002.equals(e.getErrorCode())) {
				throw new RmgAppException(AppConstant.ERROR_CODE_1002, AppConstant.ERROR_MSG_1002);
			}else if(AppConstant.ERROR_CODE_1003.equals(e.getErrorCode())) {
				throw new RmgAppException(AppConstant.ERROR_CODE_1003, AppConstant.ERROR_MSG_1003);
			}else {
				throw new RmgAppException(AppConstant.ERROR_CODE_1001, AppConstant.ERROR_MSG_1001);
			}
		}
	}
	
	@Override
	public String saveAutoAppliedPositionData() {
		try {
		logger.info("----in service saveAutoAppliedPositionData----");
		List<AutoApplyRequirement> autoApplyList= autoApplyRequirementRepository.getRemainingAppliedPositionsForUser();
		logger.info("----in service autoApplyList----"+autoApplyList);
		List<String> rmgDetailList = userAuthorizationRepo.getRmgList();
		Integer glEmployeeId = 0;
		String rmgStatus = "Pending";
		String requestorStatus = "Pending";
		String rmgComments = "";
		String glComments = "";
		String releaseDate = "0000-00-00";
		String description = "";
		//String rmgIdCombine = "";
		String rmgIdCombine1 = "";
		for (String rmgIdCombine : rmgDetailList) {
			rmgIdCombine1 =  rmgIdCombine1 + "," + rmgIdCombine ;
		}
		logger.info("----saveAutoAppliedPositionData----rmgIdCombine1 --"+rmgIdCombine1);
		logger.info("----saveAutoAppliedPositionData----before loop--");
			if(autoApplyList!=null &&! autoApplyList.isEmpty()) {
				logger.info("----Auto-Apply requirement autoApplyList not null----");
				for(AutoApplyRequirement autoReq:autoApplyList) {
					try {
					logger.info("---saveAutoAppliedPositionData -autoReq Object----"+autoReq);
					Integer requestId = requirementDetailRepo.getRequirementRequestId(autoReq.getRequirementId());
					if(null==requestId) {
						logger.info("---saveAutoAppliedPositionData  requirement is close or null requestId----"+requestId);
						autoApplyRequirementRepository.updateAutoAppliedRequirementwithFailureReason("Requirement is closed or request id is null", autoReq.getRequirementId(), autoReq.getApplicantEmployeeId(), autoReq.getAutoapplyRequirementId());
					}else {
						List<Object> applicantDataList=appliedRequirementsDetailRepo.getSingleRowforAppliedUserDetail(autoReq.getApplicantEmployeeId());
						String validVisa="";
						String visaType ="";
						String visaIssueDate ="";
						String visaExpDate ="";
						String experience="";
						String contact_number="";
						if(applicantDataList!=null && !applicantDataList.isEmpty()) {
							Object[] applicantData=(Object[]) applicantDataList.get(0);
							 validVisa =applicantData[0] == null ? "" :applicantData[0].toString();
							 visaType = applicantData[1] == null ? "" : applicantData[1].toString();
							 visaIssueDate = applicantData[2] == null ? "" : applicantData[2].toString();
							 visaExpDate = applicantData[3] == null ? "" :applicantData[3].toString();
							 experience = applicantData[4] == null ? "" :applicantData[4].toString();
							 contact_number = applicantData[5] == null ? "" :applicantData[5].toString();
							 logger.info("---saveAutoAppliedPositionData -autoReq requestId requiremnt not closed requestId----"+requestId);
							 Calendar calendar = Calendar.getInstance();
							 Date createdDate = calendar.getTime();
							 String date =sdf.format(createdDate); //updated date format by Apurva on 22nd Apr2020
							 
							 logger.info("----saveAutoAppliedPositionData----before saving-"+autoReq.getRequestId()+"-requestorEmployeeId-"+autoReq.getRequestorEmpId());
							 appliedRequirementsDetailRepo.addAppliedPositionData(autoReq.getRequestId(), autoReq.getRequirementId(),
									 autoReq.getRequestorEmpId(), autoReq.getApplicantEmployeeId(), rmgIdCombine1, rmgStatus, requestorStatus,
									 rmgComments, glEmployeeId, glComments,"Auto_Applied Requirement", releaseDate, description,
									 experience,contact_number, autoReq.getApplicantEmployeeId(),date,
									 validVisa,visaType, visaIssueDate, visaExpDate);
							 logger.info("----saveAutoAppliedPositionData----after saving-");
							 UserRequirementMapping userRequirementMapping = new UserRequirementMapping();
							 userRequirementMapping.setRequirementId(autoReq.getRequirementId());
							 userRequirementMapping.setUserId(autoReq.getApplicantEmployeeId());
							 userRequirementMappingHelperRepo.save(userRequirementMapping);
							 autoApplyRequirementRepository.updateAutoAppliedRequirement(autoReq.getRequirementId(), autoReq.getApplicantEmployeeId(), autoReq.getAutoapplyRequirementId());
							 try {
								 sendEmailOnUserApplication(autoReq.getApplicantEmployeeId(), autoReq.getRequirementId(),true);
							 } catch (AddressException e) {
								 logger.info("----Issue for AddressException sending mail for requestId and ----getEmployeeId"+e);
								 logger.info("----Issue for AddressException so updating flag");
								 autoApplyRequirementRepository.updateAutoAppliedRequirementwithFailureReason(e.getMessage(), autoReq.getRequirementId(), autoReq.getApplicantEmployeeId(), autoReq.getAutoapplyRequirementId());
								 throw new RmgAppException("Exception in AddressException so updating flag", AppConstant.ERROR_CODE_501); 
							 } catch (MessagingException e) {
								 logger.info("----Issue for MessagingException sending mail for requestId and ----getEmployeeId"+e);
								 autoApplyRequirementRepository.updateAutoAppliedRequirementwithFailureReason(e.getMessage(), autoReq.getRequirementId(), autoReq.getApplicantEmployeeId(), autoReq.getAutoapplyRequirementId());
								 throw new RmgAppException("Exception in MessagingException sending mail", AppConstant.ERROR_CODE_501);
							 }		
							 logger.info("----before audit "+autoReq.getRequestId());
							 saveAuditEventforAutoCreate(autoReq.getApplicantEmployeeId(), "AUTO_APPLY");
							 logger.info("----after audit "+autoReq.getRequestId());
							 
						}else {
							logger.info("---saveAutoAppliedPositionData -applicant data not found---"+autoReq);
							autoApplyRequirementRepository.updateAutoAppliedRequirementwithFailureReason("could not find any details of applicant", autoReq.getRequirementId(), autoReq.getApplicantEmployeeId(), autoReq.getAutoapplyRequirementId());
						}
					}
					/*	Integer requestId = requirementDetailRepo.getRequirementRequestId(autoReq.getRequirementId());
							Integer requestorEmployeeId = requirementDetailRepo.getRequestorEmployeeId(autoReq.getRequirementId());
						 */
					}catch(Exception e) {
						logger.info("----issue in for loop for "+e);
						autoApplyRequirementRepository.updateAutoAppliedRequirementwithFailureReason(e.getMessage(), autoReq.getRequirementId(), autoReq.getApplicantEmployeeId(), autoReq.getAutoapplyRequirementId());
						 throw new RmgAppException("Exception in for loop---", AppConstant.ERROR_CODE_501);	
					}
				}
			}
		}catch(Exception e) {
			logger.info("----issue in Exception fail "+e);
			return "FAIL";
		}
		return "SUCCESS";
	}
	
	private void saveAuditEventforAutoCreate(Integer userId, String action) {
		UserAuditDetails auditDtls=new UserAuditDetails();
		auditDtls.setUserId(userId);
		auditDtls.setAuditTimestamp(new Date());
		auditDtls.setUserAction(action);
		userAuditDetailsHelperRepo.save(auditDtls);
	}
	@Override
	public String confirmRelease(ConfirmRelease confirmRelease) {
		logger.info("----in confirmRelease----");
		Calendar calendar = Calendar.getInstance();
		Date updatedDate = calendar.getTime();
		
		String date =sdf.format(updatedDate); //updated date format by Apurva on 22nd Apr2020

		if (confirmRelease.getRelease()) {
			logger.info("----in if confirmRelease----");
			appliedRequirementsDetailRepo.updateReleaseDate(confirmRelease.getRequirementId(),
					confirmRelease.getReleaseDate(), confirmRelease.getEmployeeId(), date, confirmRelease.getComments());
			return "Approved";
		} else {
			logger.info("----in else confirmRelease----");
			appliedRequirementsDetailRepo.updateReleaseDateReject(confirmRelease.getRequirementId(),
					confirmRelease.getEmployeeId(), confirmRelease.getRejectionReason(), confirmRelease.getComments(), date);
			return "Rejected";
		}
	}

	@Override
	public Integer getPendingPositionsCountForRmg(Integer employeeNumber) {
		return appliedRequirementsDetailRepo.getPendingPositionsCountForRmg(employeeNumber);
	}

	@Override
	public HSSFWorkbook excelExport(List<GLRequirementData> list) throws RmgAppException {

		HSSFWorkbook hssfWorkbook;
		try {
			hssfWorkbook = new HSSFWorkbook();
			HSSFSheet hssfSheet = hssfWorkbook.createSheet();

			HSSFRow hssfRow = hssfSheet.createRow(0);
			hssfRow.createCell(0).setCellValue("Request Id");
			hssfRow.createCell(1).setCellValue("Experience");
			hssfRow.createCell(2).setCellValue("Posted On");
			hssfRow.createCell(3).setCellValue("Location");
			hssfRow.createCell(4).setCellValue("Business Name");
			hssfRow.createCell(5).setCellValue("Competency");
			hssfRow.createCell(6).setCellValue("Applied By");

			int i = 1;
			for (GLRequirementData w : list) {
				hssfRow = hssfSheet.createRow(i);
				hssfRow.createCell(0).setCellValue(w.getRequirementId());
				hssfRow.createCell(1).setCellValue(w.getExperience());
				hssfRow.createCell(2).setCellValue(w.getPostedOn());
				hssfRow.createCell(3).setCellValue(w.getCity() + ", " + w.getBranch() + ", " + w.getCountry());
				hssfRow.createCell(4).setCellValue(w.getBusinessName());
				hssfRow.createCell(5).setCellValue(w.getCompetency());
				hssfRow.createCell(6).setCellValue(w.getAppliedBy());
				i++;
			}

		} catch (Exception e) {
			logger.info("Error  into  sendmail --"+e);
			throw new RmgAppException(AppConstant.ERROR_CODE_501, "Unable to create Excel file");
		}
		return hssfWorkbook;
	}

	@Override
	public List<String> getRequirementParentIOUList() throws RmgAppException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getRequirementChildIOUList() throws RmgAppException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getHorizontalParentIOUList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getHorizontalChildIOUList() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String checkTFactorEligibility(String employeeId) {
		//Double tFactor = 0D;
		try {
			
			String grade= userMasterRepo.getGradeOfEmployee(employeeId);
			
			if(null != grade && grade.contains("BP")) {
				return "ELIGIBLE";
			}
			String tFactor= userMasterRepo.getTFactorFlagDetails(employeeId);
			if (null != tFactor && tFactor.equalsIgnoreCase("Y")) {
				return "ELIGIBLE";
			}
		} catch (Exception e) {
			logger.info("Error  into  checkTFactorEligibility --"+e);
		}
		return "NON_ELIGIBLE";
	}

	@Override
	public List<RMGWorklistFYA> getRequestorWorklistFYA(Integer employeeNumber, String isu) {

		List<String> reqIdList=  userAuthorizationRepo.getRequesterIdList();
		logger.info("Entry  into  getRequestorWorklistFYA --"+reqIdList);

		List<Object> reqDetails1=null;
		if(reqIdList!=null && !reqIdList.isEmpty()) {
			logger.info("In IF  reqIdList not null  getRequestorWorklistFYA --"+reqIdList);
		
			if(reqIdList.contains(employeeNumber.toString().trim())) {
				logger.info("In IF  employeeNumber match getRequestorWorklistFYA --"+employeeNumber);
					reqDetails1 = appliedRequirementsDetailRepo.getRequestorWorklistForExcOppFYA(employeeNumber);

			}
		}
		else {
			logger.info("In ELSE  into  getRequestorWorklistFYA --");
		}
		
		List<Object> reqDetails = appliedRequirementsDetailRepo.getRequestorWorklistFYA(employeeNumber);
		//Double tFactor = 0D;
		if(reqDetails1!=null && !reqDetails1.isEmpty()) {
			logger.info("In IF 2 reqDetails1 not null into  getRequestorWorklistFYA --");
				reqDetails.addAll(reqDetails1);
		}
		if (null==reqDetails || reqDetails.isEmpty()) {
			logger.info("In IF reqDetailsnot empty into  getRequestorWorklistFYA --");
				return new ArrayList<>();

		} else {
			Object[] temp;
			Iterator<Object> itr = reqDetails.iterator();
			String employeeName;
			RMGWorklistFYA rmgData;
			List<RMGWorklistFYA> dataList = new ArrayList<>();

			while (itr.hasNext()) {
				temp = (Object[]) itr.next();

				//employeeName = employeeDetailRepo.getEmployeeName(Integer.valueOf(temp[0].toString()));
				employeeName = userMasterRepo.getEmployeeName(temp[0].toString());
				//tFactor = employeeTFactorDetailRepo.getTFactorDetails(Integer.valueOf(temp[0].toString()));
				
				//tFactor = (null == tFactor) ? 0: (tFactor);
				String tFactor ="";
				
				String applicantContactNumber = temp[10] == null ? "" : temp[10].toString();
				String applicantComment = temp[11] == null ? "" : temp[11].toString();
				
				String validVisa = temp[13] == null ? "" : temp[13].toString();
				String visaType = temp[14] == null ? "" : temp[14].toString();
				String visaIssueDate = temp[15] == null ? "" : temp[15].toString();
				String visaExpDate = temp[16] == null ? "" : temp[16].toString();

				rmgData = new RMGWorklistFYA(Integer.valueOf(temp[0].toString()), employeeName, temp[1].toString(),
						Integer.valueOf(temp[2].toString()), temp[3].toString(), temp[4].toString(), temp[5].toString(),
						temp[6].toString(), temp[7].toString(), temp[8].toString(), temp[9].toString(),//tFactor,
						applicantContactNumber, applicantComment, temp[12].toString(), validVisa, visaType, visaIssueDate, visaExpDate,  temp[17].toString());
				String prerequisite_exp = temp[18] == null ? "" : temp[18].toString();
				String role_description = temp[19] == null ? "" : temp[19].toString();
				String exciting_opp = temp[20] == null ? "" : temp[20].toString();
				
				rmgData.setPrerequisite_exp(prerequisite_exp);
				rmgData.setRole_description(role_description);
				rmgData.setExciting_opp(exciting_opp);
				dataList.add(rmgData);
			}
			return dataList;
		}
	}
	
	@Override
	public List<RMGWorklistFYA> getApprovedRequestorWorklistFYA(Integer employeeNumber, Integer requirementId,String isu) {

		List<Object> reqDetails = appliedRequirementsDetailRepo.getApprovedRequestorWorklistFYA(employeeNumber,requirementId);
		//Double tFactor = 0D;

		if (reqDetails.isEmpty()) {
			return new ArrayList<>();

		} else {
			Object[] temp;
			Iterator<Object> itr = reqDetails.iterator();
			String employeeName;
			RMGWorklistFYA rmgData;
			List<RMGWorklistFYA> dataList = new ArrayList<>();

			while (itr.hasNext()) {
				temp = (Object[]) itr.next();

				//employeeName = employeeDetailRepo.getEmployeeName(Integer.valueOf(temp[0].toString()));
				employeeName = userMasterRepo.getEmployeeName(temp[0].toString());
				/*tFactor = employeeTFactorDetailRepo.getTFactorDetails(Integer.valueOf(temp[0].toString()));
				tFactor = (null == tFactor) ? 0: (tFactor);*/
				
				String applicantContactNumber = temp[10] == null ? "" : temp[10].toString();
				
				String applicantComment = temp[11] == null ? "" : temp[11].toString();
				
				String validVisa = temp[13] == null ? "" : temp[13].toString();
				String visaType = temp[14] == null ? "" : temp[14].toString();
				String visaIssueDate = temp[15] == null ? "" : temp[15].toString();
				String visaExpDate = temp[16] == null ? "" : temp[16].toString();

				rmgData = new RMGWorklistFYA(Integer.valueOf(temp[0].toString()), employeeName, temp[1].toString(),
						Integer.valueOf(temp[2].toString()), temp[3].toString(), temp[4].toString(), temp[5].toString(),
						temp[6].toString(), temp[7].toString(), temp[8].toString(), temp[9].toString(),//tFactor.toString(),
						applicantContactNumber, applicantComment,temp[12].toString(),validVisa, visaType, visaIssueDate, visaExpDate, temp[17].toString());
				dataList.add(rmgData);
			}
			return dataList;
		}
	}

	@Override
	public String confirmRequestorRelease(ConfirmRelease confirmRelease) {

		//To check EX-OPP Requester id -start
	
		Calendar calendar = Calendar.getInstance();
		Date updatedDate = calendar.getTime();
		
		String date =sdf.format(updatedDate); //updated date format by Apurva on 22nd Apr2020
		logger.info("date update rq::" +date);
	
		String excFlag = requirementDetailRepo.getExcitingOpportunityFLAG(confirmRelease.getRequirementId());
		boolean isExcOpp=false;
		logger.info("confirmRequestorRelease--- excFlag"+excFlag );
		if(excFlag!=null && !excFlag.isEmpty()) {
			if(excFlag.equalsIgnoreCase("Y")) {
				List<String>  requestorIdList = userAuthorizationRepo.getRequesterIdList();
				logger.info("confirmRequestorRelease--- requestorIdList"+requestorIdList );
				if(requestorIdList.contains(confirmRelease.getRequestorEmployeeId().toString())) {
					isExcOpp=true;
					logger.info("confirmRequestorRelease--- EXC OPP  UPDATE setting isExcOpp as true");
				}else {
					logger.info("confirmRequestorRelease--- EXC OPP  no match for "+confirmRelease.getRequestorEmployeeId());
	
				}
					
				}
			}
			logger.info("confirmRequestorRelease--- FLAG Value"+excFlag );
			
		
		//To check EX-OPP Requester id -end

		
		
		if (confirmRelease.getRelease()) {
			logger.info("confirmRequestorRelease--- if 1" );
			if(isExcOpp) {
				logger.info("confirmRequestor Release--- if 2" );
				appliedRequirementsDetailRepo.updateExcOppRequestorReqReleaseDate(confirmRelease.getRequirementId(),
						confirmRelease.getReleaseDate(),confirmRelease.getRequestorEmployeeId(),  confirmRelease.getEmployeeId(),
						date,
						confirmRelease.getComments());
			}else {
				logger.info("confirmRequestorRelease--- if 2" );
				appliedRequirementsDetailRepo.updateRequestorReqReleaseDate(confirmRelease.getRequirementId(),
						confirmRelease.getReleaseDate(), confirmRelease.getRequestorEmployeeId(),confirmRelease.getEmployeeId(),
						date,
						confirmRelease.getComments());
			}
			logger.info("confirmRequestorRelease--- if 2 ----" );

			return "Approved";
		} else {
			logger.info("confirmRequestorRelease--- ELSE 1" );
			if(isExcOpp) {
				logger.info("confirmRequestorRelease--- ELSE  1 1" );
				appliedRequirementsDetailRepo.updateExcOppRequestorReqReleaseDateReject(confirmRelease.getRequirementId(),
						 confirmRelease.getEmployeeId(),confirmRelease.getRejectionReason(),
						confirmRelease.getComments(), date,confirmRelease.getRequestorEmployeeId());

			}
			else {
				appliedRequirementsDetailRepo.updateRequestorReqReleaseDateReject(confirmRelease.getRequirementId(),
						confirmRelease.getRequestorEmployeeId(), confirmRelease.getEmployeeId(),confirmRelease.getRejectionReason(),
						confirmRelease.getComments(), date);
				logger.info("confirmRequestorRelease--- ELSE  2 2" );
			}
			return "Rejected";
			
		}
	}

	
	@Override
	public boolean sendEmailOnUserApplication(Integer employeeId, Integer requirementId,boolean isAutoApprove)
			throws AddressException, MessagingException {
		boolean result1 = false, result2 = true, result4 = false, result5 = false;
		try {
			logger.info("sendEmailOnUserApplication Entry---");
			//EmployeeDetails employeeDetails = employeeDetailRepo.findById(employeeId).get();
			String Empno = (employeeId == null) ? "": (employeeId.toString());
			UserMasterEntity employeeDetails = userMasterRepo.findByEmpNo(Empno);
			
			/*String amname = employeeDetails.getAm();
			String glname = employeeDetails.getgl();
			String amEmpno = (employeeDetails.getAmEmployeeNumber() == null) ? "": (employeeDetails.getAmEmployeeNumber().toString());*/
			
			String amname = employeeDetails.getEmpAMName();
			String glname = employeeDetails.getEmpGLName();
			String amEmpno = (employeeDetails.getEmpAMNumber() == null) ? "": (employeeDetails.getEmpAMNumber().toString());

			RequirementDetails requirementDetails = requirementDetailRepo.findByRequirementId(requirementId);
			

			Integer requestorId = requirementDetails.getRequestorEmpId();
			String reqId = (requestorId == null) ? "": (requestorId.toString());
			//EmployeeDetails employeeDetails2 = userMasterRepo.findById(requestorId).get();
			UserMasterEntity employeeDetails2 = userMasterRepo.findByEmpNo(reqId);
			//String requestorName = employeeDetails2.getEmployeeName();
			String requestorName =  "";
			if(employeeDetails2!=null )
				 requestorName =  (employeeDetails2.getEmpName() == null) ? "": (employeeDetails2.getEmpName().toString());
			
			
			String description = requirementDetails.getCompetencyProficiencyDetails();

			//EXCITING_OPPORTUNITY --requestor mail id change
			List<String> requestorIdlist =null;
			boolean isExcitingOpp=false;
			if(requirementDetails.getExciting_opp()!=null && !requirementDetails.getExciting_opp().isEmpty() && ("Y").equalsIgnoreCase(requirementDetails.getExciting_opp())) {
				isExcitingOpp=true;
				requestorIdlist =	userAuthorizationRepo.getRequesterIdList();
				logger.info("sendEmailOnUserApplication for EXCITING_OPPORTUNITY requestorIdlist List---"+requestorIdlist);
			
			}

			String amEmailMessage = "Dear " + amname + ",<br><br>" + employeeDetails.getEmpName() + "("
					+ employeeId + ") has applied for Requirement ID(" + requirementId + ") - " +  "("
					+ description
					+ ").<br>It is pending with Requestor for confirmation. You will be notified once it is approved by Requestor.<br>Please note: This is system generated mail.Do not reply to it.<br><br>Regards,<br>iAspire";
			String requestorEmailMessage="";
			String userEmailMessage ="";
			String glEmailMessage="";
			if(isAutoApprove) {
				logger.info("isAutoApprove--"+isAutoApprove);
				if(isExcitingOpp) {
					logger.info(" in if isExcitingOpp--requestorEmailMessage"+isExcitingOpp);
					 requestorEmailMessage = "Dear All"+ ",<br><br>Associate " + employeeDetails.getEmpName()
						+ "(" + employeeId + ") has been succesfully proposed for requirement(" + requirementId + "). Request you to evaluate and share the feedback in the system." 
						+ "<br>https://iaspire.ext-ultimatix.net/iAspire<br><br>Please note: This is system generated mail. Do not reply to it.<br><br>Regards,<br>iAspire";
							logger.info(" isExcitingOpp isAutoApprove--requestorEmailMessage"+requestorEmailMessage);
			
				}else {
					requestorEmailMessage = "Dear " + requestorName + ",<br><br>Associate " + employeeDetails.getEmpName()
					+ "(" + employeeId + ") has been succesfully proposed for requirement(" + requirementId + "). Request you to evaluate and share the feedback in the system." 
					+ "<br>https://iaspire.ext-ultimatix.net/iAspire<br><br>Please note: This is system generated mail. Do not reply to it.<br><br>Regards,<br>iAspire";
					logger.info("isAutoApprove--requestorEmailMessage"+requestorEmailMessage);
				}
					/*
				 requestorEmailMessage = "Dear " + requestorName + ",<br><br>" + employeeDetails.getEmpName()
				+ "(" + employeeId + ") has applied for Requirement ID(" + requirementId + ") - " +  "("
				+ description
				+ ").<br>It is pending at your end, please take action.<br>.Please note: This is system generated mail.Do not reply to it.<br><br>Regards,<br>Exciting Opportunities";
		
			*/}else {
				if(isExcitingOpp) {
					logger.info(" else isExcitingOpp-- requestorEmailMessage"+requestorEmailMessage);
			
					requestorEmailMessage = "Dear Requestor"  + ",<br><br>" + employeeDetails.getEmpName()
						+ "(" + employeeId + ") has applied for below Requirement."+"<br><br>Requirement ID : "+requirementId+"<br>Role : "+requirementDetails.getRole()+
						"<br>Role Description : "+requirementDetails.getRole_description()+"<br>Prerequisite : "+requirementDetails.getPrerequisite_exp()+
						"<br>Location : "+requirementDetails.getRequirementCity()+","+requirementDetails.getRequirementCountry()
						+ "<br><br>It is pending at your end, request you to take action.<br><br>Please note: This is system generated mail. Do not reply to it.<br><br>Regards,<br>iAspire";
			
					/*
					 * requestorEmailMessage = "Dear All" + ",<br><br>" +
					 * employeeDetails.getEmpName() + "(" + employeeId +
					 * ") has applied for Requirement ID(" + requirementId + ") - " + "(" +
					 * description +
					 * ").<br>It is pending at your end, please take action.<br>.Please note: This is system generated mail. Do not reply to it.<br><br>Regards,<br>iAspire"
					 * ;
					 * 
					 */	
					}else {
					 requestorEmailMessage = "Dear " + requestorName + ",<br><br>" + employeeDetails.getEmpName()
						+ "(" + employeeId + ") has applied for Requirement ID(" + requirementId + ") - " +  "("
						+ description
						+ ").<br>It is pending at your end, please take action.<br>Please note: This is system generated mail. Do not reply to it.<br><br>Regards,<br>iAspire";
				
				}
				}
				if(isAutoApprove) {	
					glEmailMessage = "Dear " + glname + ",<br><br>" + employeeDetails.getEmpName() + "("
							+ employeeId + ") has been succesfully proposed for requirement id(" + requirementId + ")"
							+ "<br>It is pending with Requestor for confirmation. You will be notified once it is approved by Requestor.<br>Please note: This is system generated mail. Do not reply to it.<br><br>Regards,<br>iAspire";
					logger.info("isAutoApprove--ExcitingOpp glEmailMessage"+glEmailMessage);
					}else {
					glEmailMessage = "Dear " + glname + ",<br><br>" + employeeDetails.getEmpName() + "("
						+ employeeId + ") has applied for Requirement ID(" + requirementId + ") - " +  "("
						+ description
						+ ").<br>It is pending with Requestor for confirmation. You will be notified once it is approved by Requestor.<br>Please note: This is system generated mail. Do not reply to it.<br><br>Regards,<br>iAspire";
	
				}
			if(isAutoApprove) {	
				logger.info("isAutoApprove--"+isAutoApprove);
				if(isExcitingOpp) {
					userEmailMessage = "Dear " + employeeDetails.getEmpName()
					+ ",<br><br>You have been proposed for Requirement ID(" + requirementId + "), " 
					+ "location (" + requirementDetails.getRequirementCity() +  "),"
					+ "skill ("+ requirementDetails.getSkill() + "). You are requested to connect with requestor for further disucssion<br><br>For any issue or concern connect with Raviraj Jain (raviraj.jain@tcs.com).<br>https://iaspire.ext-ultimatix.net/iAspire<br><br>Please note: This is system generated mail. Do not reply to it.<br><br>Regards,<br>iAspire"; 
					logger.info("isAutoApprove--ExcitingOpp"+userEmailMessage);
			
				}else {
					userEmailMessage = "Dear " + employeeDetails.getEmpName()
					+ ",<br><br>You have been proposed for Requirement ID(" + requirementId + "), " 
					+ "location (" + requirementDetails.getRequirementCity() +  "),"
					+ "skill ("+ requirementDetails.getSkill() + "). You are requested to connect with requestor ("
					+employeeDetails2.getEmpNo()+") for further disucssion<br><br>For any issue or concern connect with Raviraj Jain (raviraj.jain@tcs.com).<br>https://iaspire.ext-ultimatix.net/iAspire<br><br>Please note: This is system generated mail. Do not reply to it.<br><br>Regards,<br>iAspire"; 
					logger.info("isAutoApprove--userEmailMessage"+userEmailMessage);
				
				}
					/*				userEmailMessage = "Dear " + employeeDetails.getEmpName()
				+ ",<br><br>You have sucessfully applied for Requirement ID(" + requirementId + ") - " + "("
				+ description
				+ ").<br>It is pending with Requestor for confirmation. You will be notified once action is taken by Requestor.<br>.Please note: This is system generated mail.Do not reply to it.<br><br>Regards,<br>Exciting Opportunities";
				 */			
				}else {
					if(isExcitingOpp) {
						 userEmailMessage = "Dear " + employeeDetails.getEmpName()
							+ ",<br><br>You have sucessfully applied for Requirement ID(" + requirementId + ") - " + "("
							+ description
							+ ").<br>It is pending with Requestor for confirmation. You will be notified once action is taken by Requestor.<br>Please note: This is system generated mail. Do not reply to it.<br><br>Regards,<br>iAspire ";
							logger.info("In else--userEmailMessage for isExcitingOpp "+userEmailMessage);
					
					}else {
						 userEmailMessage = "Dear " + employeeDetails.getEmpName()
							+ ",<br><br>You have sucessfully applied for Requirement ID(" + requirementId + ") - " + "("
							+ description
							+ ").<br>It is pending with Requestor for confirmation. You will be notified once action is taken by Requestor.<br>Please note: This is system generated mail. Do not reply to it.<br><br>Regards,<br>iAspire ";
					}
				}
			if(amEmpno!=null && !amEmpno.isEmpty()) {
				logger.info("---amEmpno Message---"+amEmailMessage);
				result1 = mailSender.sendMail(amEmailMessage, amEmpno);
			}
			if(employeeDetails.getEmpNo()!=null) {
				logger.info("---userEmailMessage Message---"+userEmailMessage);
				result4 = mailSender.sendMail(userEmailMessage, (employeeDetails.getEmpNo().toString()));
			//result4 = mailSender.sendMail(userEmailMessage, ("Receiver.Test@tcsdev.com"));
			}
			
			if(requestorId!=null && !isExcitingOpp)  {
				logger.info("---requestorIdlist not EX OPP  in IF---"+requestorIdlist);
				logger.info("---requestorEmailMessage Message---"+requestorEmailMessage);
				result5 = mailSender.sendMail(requestorEmailMessage, (requestorId.toString()));
			//result5 = mailSender.sendMail(requestorEmailMessage, ("Receiver.Test@tcsdev.com"));
			}
			else {
				logger.info("---requestorIdlist for EX OPP in ELSE---"+requestorEmailMessage);
				if(requestorIdlist!=null && isExcitingOpp) {
					logger.info(" for isExcitingOpp---requestorIdlist for EX OPP---"+requestorIdlist);
					String requesterIdList = String.join(", ", requestorIdlist);
					result5 = mailSender.sendMail(requestorEmailMessage, (requesterIdList));
				}
			}
			//logger.info(amEmailMessage);
		} catch (AddressException e) {
			logger.info("Error  into  sendmail --"+e);
			e.printStackTrace();
			throw e;
		} catch (MessagingException e) {
			logger.info("Error  into  sendmail --"+e);
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			logger.info("Error  into  sendmail --"+e);
			try {
				e.printStackTrace();
				throw e;
			} catch (Exception e1) {
				e1.printStackTrace();
				logger.info("Error  into  sendmail exception e1--"+e1);
			}
		}

		if (result1 && result4 && result5) {
			return true;
		}else {
			return false;
		}
	}
	
	@Override
	public boolean sendEmailOnRmgAction(Integer employeeId, Integer requirementId, Boolean release)
			throws AddressException, MessagingException {
		boolean result1 = false, result2 = true, result4 = false, result5 = false;
		try {
			logger.info("sendEmailOnRmgAction Entry---");
			//EmployeeDetails employeeDetails = employeeDetailRepo.findById(employeeId).get();
			
			String Empno = (employeeId == null) ? "": (employeeId.toString());
			UserMasterEntity employeeDetails = userMasterRepo.findByEmpNo(Empno);
			
			/*String amname = employeeDetails.getAm();
			String glname = employeeDetails.getgl();
			String amEmpno = (employeeDetails.getAmEmployeeNumber() == null) ? "": (employeeDetails.getAmEmployeeNumber().toString());*/
			
			String amname = employeeDetails.getEmpAMName();
			String glname = employeeDetails.getEmpGLName();
			String amEmpno = (employeeDetails.getEmpAMNumber() == null) ? "": (employeeDetails.getEmpAMNumber().toString());
			
			RequirementDetails requirementDetails = requirementDetailRepo.findByRequirementId(requirementId);
			Integer requestorId = requirementDetails.getRequestorEmpId();
			logger.info("requestorId---" + requestorId);

			//String requestorEmail = employeeDetailRepo.getEmployeerEmail(requestorId);
			//logger.info("sendEmailOnRmgAction Entry requestorEmail---" + requestorEmail);

			//String requestorName = employeeDetailRepo.getEmployeeName(requestorId);
			String requestorName = userMasterRepo.getEmployeeName(Integer.toString(requestorId));
			
			String description = requirementDetails.getCompetencyProficiencyDetails();

			//List<RmgDetails> rmgDetailsList = rmgDetailsHelperRepo.findAll();
			List<String> rmgDetailsList = userAuthorizationRepo.getRmgList();
			String amEmailMessage;
			String requestorEmailMessage;
			String glEmailMessage;
			String rmgEmailMessage;
			String userEmailMessage;
			if (release) {
				amEmailMessage = "Dear " + amname + ",<br><br>" + employeeDetails.getEmpName() + "(" + employeeId
						+ ") request has been approved by RMG for Requirement ID(" + requirementId + ") - "
						+ "(" + description
						+ ").<br>Please note: This is system generated mail.Do not reply to it.<br><br>Regards,<br>iAspire";
				requestorEmailMessage = "Dear " + requestorName + ",<br><br>" + employeeDetails.getEmpName() + "("
						+ employeeId + ") request has been approved by RMG for Requirement ID(" + requirementId + ") - "
						+ "(" + description
						+ ").<br>Please note: This is system generated mail.Do not reply to it.<br><br>Regards,<br>iAspire";
				glEmailMessage = "Dear " + glname + ",<br><br>" + employeeDetails.getEmpName() + "(" + employeeId
						+ ") request has been approved by RMG for Requirement ID(" + requirementId + ") - "
						+ "(" + description
						+ ").<br>Please note: This is system generated mail.Do not reply to it.<br><br>Regards,<br>iAspire";

				String rmgName;
				String rmgEmail;
				
				for (String rmgIdCombine : rmgDetailsList) {
				
				//for (RmgDetails w : rmgDetailsList) {--changes by Apurva on 2nd Dec19
					
					//rmgName = employeeDetailRepo.getEmployeeName(w.getRmgId());
					rmgName = userMasterRepo.getEmployeeName(rmgIdCombine.toString()); //changes by Apurva on 2nd Dec19
					//rmgEmail = employeeDetailRepo.getEmployeerEmail(w.getRmgId());
					rmgEmailMessage = "Dear " + rmgName + ",<br><br>" + employeeDetails.getEmpName() + "("
							+ employeeId + ") request has been approved by RMG for Requirement ID(" + requirementId
							+ ") - " + "(" + description
							+ ").<br>Please note: This is system generated mail.Do not reply to it.<br><br>Regards,<br>iAspire";
					if( Integer.valueOf(rmgIdCombine.toString()) !=null)
					mailSender.sendMail(rmgEmailMessage, rmgIdCombine);
				}
				userEmailMessage = "Dear " + employeeDetails.getEmpName()
						+ ",<br><br>Your request for Requirement ID(" + requirementId + ") - " + "("
						+ description
						+ ") has been sucessfully approved by RMG.<br>Please note: This is system generated mail.Do not reply to it.<br><br>Regards,<br>iAspire";
			} else {
				amEmailMessage = "Dear " + amname + ",<br><br>" + employeeDetails.getEmpName() + "(" + employeeId
						+ ") request has been rejected by RMG for Requirement ID(" + requirementId + ") - "
						+ "(" + description
						+ ").<br>Please note: This is system generated mail.Do not reply to it.<br><br>Regards,<br>iAspire";
				requestorEmailMessage = "Dear " + requestorName + ",<br><br>" + employeeDetails.getEmpName() + "("
						+ employeeId + ") request has been rejected by RMG for Requirement ID(" + requirementId + ") - "
						+ "(" + description
						+ ").<br>Please note: This is system generated mail.Do not reply to it.<br><br>Regards,<br>iAspire";
				glEmailMessage = "Dear " + glname + ",<br><br>" + employeeDetails.getEmpName() + "(" + employeeId
						+ ") request has been rejected by RMG for Requirement ID(" + requirementId + ") - "
						+ "(" + description
						+ ").<br>Please note: This is system generated mail.Do not reply to it.<br><br>Regards,<br>iAspire";
				String rmgName;
				String rmgEmail;
				//for (RmgDetails w : rmgDetailsList) {
				
				for (String rmgIdCombine : rmgDetailsList) {
					//rmgName = employeeDetailRepo.getEmployeeName(w.getRmgId());
					rmgName = userMasterRepo.getEmployeeName(rmgIdCombine.toString());
					//rmgEmail = employeeDetailRepo.getEmployeerEmail(w.getRmgId());
					rmgEmailMessage = "Dear " + rmgName + ",<br><br>" + employeeDetails.getEmpName() + "("
							+ employeeId + ") request has been Rejected by RMG for Requirement ID(" + requirementId
							+ ") - " + "(" + description
							+ ").<br>Please note: This is system generated mail.Do not reply to it.<br><br>Regards,<br>iAspire";
						if(Integer.valueOf(rmgIdCombine.toString())!=null)
							mailSender.sendMail(rmgEmailMessage, rmgIdCombine);

				}
				userEmailMessage = "Dear " + employeeDetails.getEmpName()
						+ ",<br><br>Your request for Requirement ID(" + requirementId + ") - " + "("
						+ description
						+ ") has been rejected by RMG.<br>Please note: This is system generated mail.Do not reply to it.<br><br>Regards,<br>iAspire";
			}

			if(amEmpno!=null && !amEmpno.isEmpty())
					result1 = mailSender.sendMail(amEmailMessage, amEmpno);
			if(employeeDetails.getEmpNo()!=null)
					result4 = mailSender.sendMail(userEmailMessage, employeeDetails.getEmpNo().toString());
			if(requestorId!=null)
					result5 = mailSender.sendMail(requestorEmailMessage, requestorId.toString());
		} catch (AddressException e) {
			logger.info("Error  into  sendmail --"+e);
			throw e;
		} catch (MessagingException e) {
			logger.info("Error  into  sendmail --"+e);
			throw e;
		} catch (Exception e) {
			logger.info("Error  into  sendmail --"+e);
			try {
				throw e;
			} catch (Exception e1) {
				logger.info("Error  into  sendmail --"+e1);
			}
		}

		if (result1 && result4 && result5) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean sendEmailOnRequestorAction(Integer employeeId, Integer requirementId, Boolean release, Integer requestorEmployeeId)
			throws AddressException, MessagingException {
		boolean result1 = false, result2 = true, result4 = false, result5 = false;
		try {
			logger.info("sendEmailOnRequestorAction Entry---");
			//EmployeeDetails employeeDetails = employeeDetailRepo.findById(employeeId).get();
			String Empno = (employeeId == null) ? "": (employeeId.toString());
			UserMasterEntity employeeDetails = userMasterRepo.findByEmpNo(Empno);
			
			/*String amname = employeeDetails.getAm();
			String glname = employeeDetails.getgl();
			String amEmpno = (employeeDetails.getAmEmployeeNumber() == null) ? "": (employeeDetails.getAmEmployeeNumber().toString());*/
			
			String amname = employeeDetails.getEmpAMName();
			String glname = employeeDetails.getEmpGLName();
			String amEmpno = (employeeDetails.getEmpAMNumber() == null) ? "": (employeeDetails.getEmpAMNumber().toString());
			

			RequirementDetails requirementDetails = requirementDetailRepo.findByRequirementId(requirementId);
			Integer requestorId = requirementDetails.getRequestorEmpId();
			if(requestorId==null) {
				requestorId=requestorEmployeeId;
				logger.info("requestorId is null so added--"+requestorId);
			}
			//EmployeeDetails employeeDetails2 = employeeDetailRepo.findById(requestorId).get();
			String reqId = (requestorId == null) ? "": (requestorId.toString());
			UserMasterEntity employeeDetails2 = userMasterRepo.findByEmpNo(reqId);
			
			String requestorName = employeeDetails2.getEmpName();
			String description = requirementDetails.getCompetencyProficiencyDetails();

			//List<RmgDetails> rmgDetailsList = rmgDetailsHelperRepo.findAll();
			
			List<String> rmgDetailsList = userAuthorizationRepo.getRmgList();
			
			String amEmailMessage;
			String requestorEmailMessage;
			String glEmailMessage;
			String rmgEmailMessage;
			String userEmailMessage;
			if (release) {
				amEmailMessage = "Dear " + amname + ",<br><br>" + employeeDetails.getEmpName() + "(" + employeeId
						+ ") request has been approved by Requestor for Requirement ID(" + requirementId + ") - "
						+ "(" + description
						+ ").<br>It is pending with RMG for confirmation.You will be notified once it is approved by RMG.<br>Please note: This is system generated mail.Do not reply to it.<br><br>Regards,<br>iAspire";
				requestorEmailMessage = "Dear " + requestorName + ",<br><br>" + employeeDetails.getEmpName() + "("
						+ employeeId + ") request has been approved by You for Requirement ID(" + requirementId + ") - "
						+ "(" + description
						+ ").<br>It is pending with RMG for confirmation.You will be notified once it is approved by RMG.<br>Please note: This is system generated mail.Do not reply to it.<br><br>Regards,<br>iAspire";
				glEmailMessage = "Dear " + glname + ",<br><br>" + employeeDetails.getEmpName() + "(" + employeeId
						+ ") request has been approved by Requestor for Requirement ID(" + requirementId + ") - "
						+ "(" + description
						+ ").<br>It is pending with RMG for confirmation.You will be notified once it is approved by RMG.<br>Please note: This is system generated mail.Do not reply to it.<br><br>Regards,<br>iAspire";

				String rmgName;
				String rmgEmail;
				
				for (String rmgIdCombine : rmgDetailsList) {
				
					
					//.intValue() 
				//for (RmgDetails w : rmgDetailsList) {
					//rmgName = employeeDetailRepo.getEmployeeName(w.getRmgId());
					
					//rmgName = userMasterRepo.getEmployeeName(Integer.parseInt(rmgIdCombine.toString()));
					rmgName = userMasterRepo.getEmployeeName(rmgIdCombine.toString());
					
					
					//rmgEmail = employeeDetailRepo.getEmployeerEmail(w.getRmgId());
					rmgEmailMessage = "Dear " + rmgName + ",<br><br>" + employeeDetails.getEmpName() + "("
							+ employeeId + ") has applied for Requirement ID(" + requirementId + ") - " + "("
							+ description
							+ ").<br>It is pending with you for confirmation.<br>Please note: This is system generated mail.Do not reply to it.<br><br>Regards,<br>iAspire";
					if(Integer.valueOf(rmgIdCombine)!=null)
						mailSender.sendMail(rmgEmailMessage, rmgIdCombine.toString());
				}
				userEmailMessage = "Dear " + employeeDetails.getEmpName()
						+ ",<br><br>Your request for Requirement ID(" + requirementId + ") - " + "("
						+ description
						+ ") has been sucessfully approved by Requestor.<br>It is pending with RMG for confirmation.You will be notified once it is approved by RMG.<br>Please note: This is system generated mail.Do not reply to it.<br><br>Regards,<br>iAspire";
			} else {
				amEmailMessage = "Dear " + amname + ",<br><br>" + employeeDetails.getEmpName() + "(" + employeeId
						+ ") request has been rejected by Requestor for Requirement ID(" + requirementId + ") - "
						+  "(" + description
						+ ").<br>Please note: This is system generated mail.Do not reply to it.<br><br>Regards,<br>iAspire";
				requestorEmailMessage = "Dear " + requestorName + ",<br><br>" + employeeDetails.getEmpName() + "("
						+ employeeId + ") request has been rejected by You for Requirement ID(" + requirementId + ") - "
						+ "(" + description
						+ ").<br>Please note: This is system generated mail.Do not reply to it.<br><br>Regards,<br>iAspire";
				glEmailMessage = "Dear " + glname + ",<br><br>" + employeeDetails.getEmpName() + "(" + employeeId
						+ ") request has been rejected by Requestor for Requirement ID(" + requirementId + ") - "
						+ "(" + description
						+ ").<br>Please note: This is system generated mail.Do not reply to it.<br><br>Regards,<br>iAspire";
				userEmailMessage = "Dear " + employeeDetails.getEmpName()
						+ ",<br><br>Your request for Requirement ID(" + requirementId + ") - " + "("
						+ description
						+ ") has been rejected by Requestor.<br>Please note: This is system generated mail.Do not reply to it.<br><br>Regards,<br>iAspire";
			}
			if(amEmpno!=null && !amEmpno.isEmpty()) {
				logger.info("amEmpno not null sendmail --"+amEmpno);
						result1 = mailSender.sendMail(amEmailMessage, amEmpno);
				
			}
			if(employeeDetails.getEmpNo()!=null) {
				logger.info("employeeDetails.getEmpNo() not null sendmail --"+employeeDetails.getEmpNo());
				result4 = mailSender.sendMail(userEmailMessage, employeeDetails.getEmpNo().toString());
			}
			if(requestorId!=null) {
				logger.info("amEmpno not null sendmail --"+amEmpno);
				result5 = mailSender.sendMail(requestorEmailMessage, requestorId.toString());
			}
			
			//logger.info(amEmailMessage);
		} catch (AddressException e) {
			logger.info("Error  into  sendmail --"+e);
			throw e;
		} catch (MessagingException e) {
			logger.info("Error  into  sendmail --"+e);
			throw e;
		} catch (Exception e) {
			logger.info("Error  into  sendmail --"+e);
			try {
				throw e;
			} catch (Exception e1) {
				logger.info("Error  into  sendmail --"+e1);
			}
		}
		if (result1 && result4 && result5) {
			return true;
		}else {
			return false;
		}
	}
	
	@Override
	public List<Object> getRequestorRecommandations(Integer employeeId,String isu) {

		//todo
		List<Object> reqRecDetails = requestorRecommendationDetailsRepo.getRequestorRecommandations(employeeId,isu);
		List<UserRequirementMapping> userRequirementMappings = userRequirementMappingHelperRepo.getByUser(employeeId);

		Boolean flag = true;
		Object[] temp;
		Iterator<Object> itr = reqRecDetails.iterator();
		List<Object> dataList1 = new ArrayList<>();
		
		while (itr.hasNext()) {
				temp = (Object[]) itr.next(); 
			for (UserRequirementMapping userRequirementMapping : userRequirementMappings) {
				/*logger.info("1--" +userRequirementMapping.getRequirementId());
				logger.info("2--" +Integer.valueOf(temp[1].toString()));*/
				if (userRequirementMapping.getRequirementId().intValue() == Integer.valueOf(temp[1].toString())) {
					logger.info("test");
					flag = false;
					break;
				}
			}
			if (flag) {
				RequestorRecommendationData requRecData = new RequestorRecommendationData();

				requRecData.setEmployeeNumber(Integer.valueOf(temp[0].toString()));
				requRecData.setRequirementId(Integer.valueOf(temp[1].toString()));
				requRecData.setIevolveMatch(temp[2].toString());
				requRecData.setRole(temp[3].toString());
				requRecData.setExperience(temp[4].toString());
				requRecData.setBranch(temp[5].toString());
				requRecData.setCity(temp[6].toString());
				requRecData.setCountry(temp[7].toString());
				requRecData.setBusinessName(temp[8].toString());
				requRecData.setCompetency(temp[9].toString());
				requRecData.setPostedOn(temp[10].toString());

				dataList1.add(requRecData);
			}
			flag = true;
		}
		logger.info("getRequestorRecommandations 3--"+userRequirementMappings.size());
		for (UserRequirementMapping userRequirementMapping : userRequirementMappings) {
			//logger.info("userRequirementMapping::"+userRequirementMapping.getRequirementId());
		}
		return dataList1;
	}
	@Override
	public Integer getRequestorRecommandationsCount(Integer employeeNumber) {
		return requestorRecommendationDetailsRepo.getRequestorRecommandationsCount(employeeNumber);
	}
	
	/*@Override
	/*@Scheduled(cron = " 0 30 13 * * *") 
	//@Scheduled(cron = "0 15 * * *") 

	public void updateUsers() throws RmgAppException {
		List<RequirementDetails> closedRequirementDetails=requirementDetailRepo.getClosedRequirements();
		
		logger.info("updateUsers---"+closedRequirementDetails.size());
		
		for(RequirementDetails w:closedRequirementDetails) {
			//logger.info("updateUsers 1---"+w.getRequirementId());
			List<Integer> employeeIds=appliedRequirementsDetailRepo.getUserAppliedData(w.getRequirementId());
			for(Integer q:employeeIds) {
				try {
					sendClosedEmail(q.intValue(),w.getRequirementId());
				} catch (AddressException e) {
					// TODO Auto-generated catch block
					logger.error("Exception in AddressException - ",e);
					e.printStackTrace();
				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					logger.error("Exception in MessagingException - ",e);
					e.printStackTrace();
				}
			}
			logger.info("updateUsers 2---"+employeeIds.size());
		}
		logger.info(" updateUsers 3----"+closedRequirementDetails.size());

		//requirementDetailRepo.updateUserNotified();
	}*/ 
	@Override
	@Scheduled(cron = " 0 0 3 * * *") 
	public void updateUsers() throws RmgAppException {
		
		List<Object> appliedRequirementsDetails=appliedRequirementsDetailRepo.getPendingApplicantList(); 
		logger.info("inside updateUsers appliedRequirementsDetails---"+appliedRequirementsDetails.size());
		
		Calendar calendar = Calendar.getInstance();
		Date updatedDate = calendar.getTime();
		Object[] temp;
		Iterator<Object> itr = appliedRequirementsDetails.iterator();
		
			while (itr.hasNext()) {
				temp = (Object[]) itr.next();
				String date =sdf.format(updatedDate);	
				try {
					appliedRequirementsDetailRepo.updateAutoReject(Integer.valueOf(temp[0].toString()),Integer.valueOf(temp[1].toString()),date);
					sendClosedEmail(Integer.valueOf(temp[1].toString()),Integer.valueOf(temp[0].toString()));
				}catch (AddressException e) {
					logger.error("Exception in AddressException - ",e);
				} catch (MessagingException e) {
					logger.error("Exception in MessagingException - ",e);
				}
			}
	}
	
	private void sendClosedEmail(Integer getapplicantEmployeeId, Integer reqId) throws RmgAppException, AddressException, MessagingException {

		String name=userMasterRepo.getEmployeeName(Integer.toString(getapplicantEmployeeId));
		String Empno = (getapplicantEmployeeId == null) ? "": (getapplicantEmployeeId.toString());
		logger.info("Inside sendClosedEmail 1---");
		String message="Dear "+name+",<br><br>Requirement Id:  "+reqId+" has been Closed hence Request has been rejected by system.<br>Please note: This is system generated mail. Do not reply to it.<br><br>Regards,<br>iAspire";
		logger.info("name"+name);
		logger.info("message"+message);
		if(!mailSender.sendMail(message, Empno)) {
			throw new RmgAppException(AppConstant.ERROR_CODE_501,"Unable to Send Mail");
		}
	} 
	
	@Override
	public Map<String, List<String>> getdropdownValues() throws RmgAppException {
		
		Map<String, List<String>> ddValueMap = new HashMap<>();
		try{
			logger.info("Inside fetching dropdown values service");
			List<String> ddEntity = dropDownRepo.getUniqueDDColumn();
			for(String str: ddEntity) {
				List<String> ddVal = dropDownRepo.getDropDownValueBasedOnCol(str);
				ddValueMap.put(str, ddVal);
			}
			logger.info("Drop down values populated : " + ddValueMap);		
		} catch(Exception ex) {
			logger.info("Exception :" + ex);
			throw new RmgAppException(AppConstant.ERROR_CODE_501, "Exception occured while fetching dropdown values in service");
		}
		return ddValueMap;
	}

	@Override
	public String getVisaEligibility(String employeeId,Integer requirementId) throws RmgAppException{
		
		try{
			logger.info("Inside getVisaEligibility service 1:");
			String employeeDputeCountry = userMasterRepo.getEmployeeDeputeCountry(employeeId);
			String requirementCountry = requirementDetailRepo.getRequirementCountry(requirementId);
		
				if(employeeDputeCountry!=null && requirementCountry!=null  && employeeDputeCountry.equals(requirementCountry)) {
					logger.info("Inside getVisaEligibility service 2:offshore"); 
					return "offshore";
				}else {
					logger.info("Inside getVisaEligibility service 3:onsite"); 
					return "onsite";
				}
		}catch(Exception ex) {
			logger.info("Exception :" + ex);
			throw new RmgAppException(AppConstant.ERROR_CODE_501,"Exception in getVisaEligibility service 4::");
		}
	}

	@Override
	public Integer getExcitingOpportunitiesCount(String isu) {
		try {
			return requirementDetailRepo.getExcitingOpportunitiesCount(isu);
		}catch(Exception e) {
			logger.error("Exception in getExcitingOpportunitiesCount - ",e);
			throw new RmgAppException(AppConstant.ERROR_CODE_501, "Exception in getExcitingOpportunitiesCount");
		}
	}

	@Override
	public List<RequirementData> getExcitingOpportunitiesList(String isu) throws RmgAppException{
		List<Object> reqDetails;
		try {
			reqDetails = requirementDetailRepo.getExcitingOpportunitiesList(isu);
		} catch (Exception e) {
			logger.error("Exception in getExcitingOpportunitiesList - ",e);
			throw new RmgAppException(AppConstant.ERROR_CODE_501, "Unable to get Exciting Opportunities list -> Data Source not avilable or wrong sql query");
		}
		if (reqDetails.isEmpty()) {
			return new ArrayList<>();

		} else {
			Object[] temp;
			Iterator<Object> itr = reqDetails.iterator();
			RequirementData requirementData;
			List<RequirementData> dataList = new ArrayList<>();
			while (itr.hasNext()) {
				temp = (Object[]) itr.next();
				requirementData = new RequirementData(Integer.valueOf(temp[0].toString()), temp[1].toString(),
						temp[2].toString(), temp[3].toString(), temp[4].toString(), temp[5].toString(),
						temp[6].toString(), temp[7].toString(), temp[8].toString(), temp[9].toString(), temp[10].toString());
				dataList.add(requirementData);
			}
			return dataList;
		}
	}


	@Override
	public ExcitingOpportunitiesDataResponse getExcitingOpportunitiesList(TotalExcitingOpportunitiesDetails totalExcitingOpportunitiesDetails,String isu) {
		logger.info("In method getExcitingOpportunitiesList");

		ExcitingOpportunitiesDataResponse response = new ExcitingOpportunitiesDataResponse();
		try {
			Pageable pageRequest = PageRequest.of(totalExcitingOpportunitiesDetails.getPageNumber(),
					totalExcitingOpportunitiesDetails.getPageSize());

			StringBuilder query = new StringBuilder();
			StringBuilder queryCount = new StringBuilder();

			query.append(
					"select requirement_id, total_experience, Request_Created_On, Requirement_City, Requirement_Branch, Requirement_Country, Business, Competency_Proficiency_Details, Role, requirement_geography, onsite_offshore, role_description,prerequisite_exp,exciting_opp from  rmg_app.requirement_details  where exciting_opp = 'Y'and requirement_status ='OPEN'");
			queryCount.append(
					"select count(*) from rmg_app.requirement_details  where exciting_opp = 'Y' and requirement_status ='OPEN'");

			//changed
			if(isu!=null)
			{
				query.append(" and isu = '"+isu+"'");
				queryCount.append(" and isu = '"+isu+"'");
			}
			logger.info("query -> " + query);
			logger.info("queryCount -> " + queryCount);

			Query q = em.createNativeQuery(query.toString());

			Query queryTotal = em.createNativeQuery(queryCount.toString());

			int countResult = ((BigInteger) queryTotal.getSingleResult()).intValue();
			int pageNumber = (int) ((countResult / pageRequest.getPageSize()) + 1);

			response.setTotalPages(pageNumber);
			response.setTotalCount(countResult);

			q.setFirstResult((totalExcitingOpportunitiesDetails.getPageNumber() - 1)
					* totalExcitingOpportunitiesDetails.getPageSize());
			q.setMaxResults(totalExcitingOpportunitiesDetails.getPageSize());

			List<Object> reqDetails = (List<Object>) q.getResultList();

			List<RequirementData> dataList = new ArrayList<>();

			if (reqDetails != null && !reqDetails.isEmpty()) {
				logger.info("Total pages -> " + pageNumber);
				response.setTotalPages(pageNumber);
				logger.info("Total Count -> " + countResult);
				response.setTotalCount(countResult);

				Object[] temp;
				Iterator<Object> itr = reqDetails.iterator();

				while (itr.hasNext()) {
					temp = (Object[]) itr.next();
					RequirementData requirementData = new RequirementData();
					requirementData.setRequirementId(Integer.parseInt(temp[0].toString()));
					requirementData.setExperience(temp[1].toString());
					requirementData.setPostedOn(temp[2].toString());
					requirementData.setCity(temp[3].toString());
					requirementData.setBranch(temp[4].toString());
					requirementData.setCountry(temp[5].toString());
					requirementData.setBusinessName(temp[6].toString());
					requirementData.setCompetency(temp[7].toString());
					requirementData.setRole(temp[8].toString());
					requirementData.setGeography((temp[9]==null)?"":temp[9].toString());
					requirementData.setOnsiteOffshore((temp[10]==null)?"":temp[10].toString());
					requirementData.setRole_description((temp[11]==null)?"":temp[11].toString());
					requirementData.setPrerequisite_exp((temp[12]==null)?"":temp[12].toString());
					requirementData.setExciting_opp((temp[13]==null)?"":temp[13].toString());

					dataList.add(requirementData);
				}
				response.setTotalReqData(dataList);
			}
			logger.info("Size" + reqDetails.size());
		} catch (Exception e) {
			logger.error("Error in getExcitingOpportunitiesList ", e);
		}
		return response;
	}

}
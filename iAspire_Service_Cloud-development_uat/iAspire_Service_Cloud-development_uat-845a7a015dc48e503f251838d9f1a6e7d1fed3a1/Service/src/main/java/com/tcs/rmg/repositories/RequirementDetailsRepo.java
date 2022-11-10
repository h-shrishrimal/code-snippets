package com.tcs.rmg.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;

import com.tcs.rmg.domain.RequirementDetails;


public interface RequirementDetailsRepo extends CrudRepository<RequirementDetails, Integer>, QuerydslPredicateExecutor<RequirementDetails>,JpaSpecificationExecutor  {


	public RequirementDetails findByRequirementId(Integer requirementId) throws Exception; //requirementId
	
	//changed 
	@Query(value = "select s from  RequirementDetails  s where s.requirementStatus NOT IN('CLOSED') and s.isu in(:isu)")
	List<RequirementDetails> getTotalRequirementDetails(@Param("isu") String isu);
	
	@Query(value = "select requirementId, totalExperience, requestCreatedOn, role, business, competencyProficiencyDetails, requirementCity, requirementBranch, requirementCountry, requirementGeography from  RequirementDetails  s where requirementStatus NOT IN('CLOSED')")
	Page<Object> getTestTotalRequirementDetails(Pageable pageable);
		
	@Query(value = "select requirementId, totalExperience, requestCreatedOn, requirementCity, requirementBranch, requirementCountry, business, competencyProficiencyDetails from  RequirementDetails where requirementStatus NOT IN('CLOSED') and competencyProficiencyDetails = :competency and role = :role and requirementGeography = :geography")
	List<Object> getRequirementSearchList(@Param("competency") String competency, @Param("role") String role, @Param("geography") String geography);
	
	//@Query(value = "select Requirement_Id, total_experience, Request_Created_On, Requirement_City, Requirement_Branch, Requirement_Country, business, Competency_Proficiency_Details, Role, onsite_offshore from rmg_app.requirement_details where requirement_status NOT IN('CLOSED') and Request_Created_On >= (to_char((now() - interval '7 day'), 'dd-Mon-yyyy'))", nativeQuery = true)
	//Changes by Apurva on 4th Jan 21 to get recent open requiremnt based on data upload date
	//changed
	@Query(value = "select  Requirement_Id, total_experience, Request_Created_On, Requirement_City, Requirement_Branch, Requirement_Country, business, Competency_Proficiency_Details, Role, requirement_geography, onsite_offshore from  rmg_app.requirement_details where requirement_status NOT IN('CLOSED') and new_requirment_flag is null and isu IN (:isu)", nativeQuery = true)
	List<Object> getRecentOpenRequirementList(@Param("isu") String isu);
	
	//@Query(value = "select count(*) from  rmg_app.Requirement_Details where requirement_status NOT IN('CLOSED') and to_date(Request_Created_On,'DD Mon YY') >= (current_date - interval '7 day')", nativeQuery = true)
	//Changes by Apurva on 4th Jan 21 to get recent open requiremnt based on data upload date
	//changed
	@Query(value = "select count(*) from  rmg_app.requirement_details where requirement_status NOT IN('CLOSED') and new_requirment_flag is null and isu IN (:isu)", nativeQuery = true)
	Integer getRecentOpenRequirementCount(@Param("isu") String isu);
	
	//todo
	//changed
	@Query(value = "select count(*) from  rmg_app.requirement_details where requirement_status NOT IN('CLOSED')  and isu IN(:isu)",nativeQuery = true)
	Integer getTotalRequirementCount(@Param("isu") String isu);
	
	@Query(value = "select count(*) from  RequirementDetails where requirementStatus NOT IN('CLOSED') and business = :businessUnit")
	Integer getRequirementCountInEmpBusinessUnit(@Param("businessUnit") String businessUnit);
	
	//changed
	@Query(value = "select requirementId, totalExperience, requestCreatedOn, requirementCity, requirementBranch, requirementCountry, business, competencyProficiencyDetails, role, onsiteOffshore from  RequirementDetails where requirementStatus NOT IN('CLOSED') and business = :businessUnit and isu IN (:isu)")
	List<Object> getRequirementListInEmpBusinessUnit(@Param("businessUnit") String businessUnit,@Param("isu") String isu);
	
	//changed
	@Query(value = "select competencyProficiencyDetails from  RequirementDetails where requirementStatus NOT IN('CLOSED') and isu IN(:isu)")
	List<String> getCompetencyList(@Param("isu") String isu);
	
	@Query(value = "select DISTINCT(role) from  RequirementDetails where requirementStatus NOT IN('CLOSED')")
	List<String> getRoleList();
	
	//changed
	@Query(value = "select DISTINCT(requirementCountry) from  RequirementDetails where requirementStatus NOT IN('CLOSED') and isu IN(:isu)")
	List<String> getCountryList(@Param("isu") String isu);
	
	//changed
	@Query(value = "select DISTINCT(requirementBranch) from  RequirementDetails where requirementStatus NOT IN('CLOSED') and isu IN(:isu)")
	List<String> getBranchList(@Param("isu") String isu);
	
	//changed
	@Query(value = "select DISTINCT(requirementGeography) from  RequirementDetails where requirementStatus NOT IN('CLOSED') and isu IN(:isu)")
	List<String> getGeographyList(@Param("isu") String isu);

	@Query(value = "select DISTINCT(requestorEmpId) from  RequirementDetails where requestorEmpId = :employeeNumber and requirementStatus NOT IN('CLOSED')")
	Integer checkIfRequestorExist(@Param("employeeNumber") Integer employeeNumber);

	@Query(value = "select requestorEmpId from  RequirementDetails where requirementId = :requirementId and requirementStatus NOT IN('CLOSED')")
	Integer getRequestorEmployeeId(@Param("requirementId") Integer requirementId);

	@Query(value = "select requestId from  RequirementDetails where requirementId = :requirementId and requirementStatus NOT IN('CLOSED')")
	Integer getRequirementRequestId(@Param("requirementId") Integer requirementId);
	
	/*@Query(value = "select DISTINCT(a.requirementId) from  RequirementDetails a,  AppliedRequirementsDetails b where a.requirementStatus ='CLOSED' and a.requirementId= b.requirementId")
	List<Integer> getClosedRequirements();*/
	
	@Transactional
	@Modifying
	@Query("update RequirementDetails set userNotified=1 where requirementStatus='CLOSED'")
	void updateUserNotified();
	
	//changed
	@Query(value = "select count(b.Requirement_Id) from global_login.project_details a,rmg_app.requirement_details b where a.project_number = b.project_number and b.requirement_status NOT IN('CLOSED') and a.digital_flagging NOT IN ('Not Applicable') and b.isu in(:isu)", nativeQuery = true)
	Integer getRequirementCountInOpenDigitalPosition(@Param("isu") String isu);
	
	@Query(value = "select s from  RequirementDetails  s where requirementStatus NOT IN('CLOSED')")
	List<RequirementDetails> getOneRequirementDetailsforData();
	
	@Query(value = "select requirementCountry from RequirementDetails where requirementId = :requirementId")
	String getRequirementCountry(@Param("requirementId") Integer requirementId);

	//changed
	@Query(value = "select count(*) from rmg_app.requirement_details where exciting_opp = 'Y' and requirement_status ='OPEN' and isu IN(:isu)",nativeQuery = true)
	Integer getExcitingOpportunitiesCount(@Param("isu") String isu);

	@Query(value = "select requirementId, totalExperience, requestCreatedOn, requirementCity, requirementBranch, requirementCountry, business, competencyProficiencyDetails, role, requirementGeography, onsiteOffshore from  RequirementDetails where exciting_opp = 'Y' and requirement_status ='OPEN' and isu IN(:isu)")
	List<Object> getExcitingOpportunitiesList(@Param("isu") String isu);
	
	//Open Digital Positions
	@Query(value = "select exciting_opp from  RequirementDetails where requirementId = :requirementId and requirementStatus ='OPEN'")
	String  getExcitingOpportunityFLAG(@Param("requirementId") Integer requirementId);

}
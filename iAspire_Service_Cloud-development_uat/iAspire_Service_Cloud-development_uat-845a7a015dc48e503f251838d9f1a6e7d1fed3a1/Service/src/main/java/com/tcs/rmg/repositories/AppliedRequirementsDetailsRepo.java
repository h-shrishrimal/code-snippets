package com.tcs.rmg.repositories;

import java.util.List;

import javax.persistence.Column;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.tcs.rmg.domain.AppliedRequirementsDetails;


/**
 * @author 1077397
 *
 */


public interface AppliedRequirementsDetailsRepo extends CrudRepository<AppliedRequirementsDetails, String>, JpaRepository<AppliedRequirementsDetails, String> {

	
	@Query(value = "select count(*) from AppliedRequirementsDetails where applicantEmployeeId = :employeeNumber")
	Integer getAppliedPositionsCountForUser(@Param("employeeNumber") Integer employeeNumber);
	
	@Query(value = "select count(*) from AppliedRequirementsDetails where requirementId = :requirementId")
	Integer getCountOfPositions(@Param("requirementId") Integer requirementId);
	
	@Query(value = "select a.requirementId, a.rmgStatus, a.rmgEmployeeId, b.totalExperience, b.requestCreatedOn, b.requirementCity, b.requirementBranch, b.requirementCountry, b.business, b.competencyProficiencyDetails, b.role from AppliedRequirementsDetails a, RequirementDetails b where b.requirementId = a.requirementId and a.applicantEmployeeId = :employeeNumber")
	List<Object> getAppliedPositionsListForUser(@Param("employeeNumber") Integer employeeNumber);
	
	@Query(value = "select a.Requirement_Id,a.rmg_status, a.rmg_employeeid, b.total_experience,b.Request_Created_On, b.Requirement_City, b.Requirement_Branch, b.Requirement_Country, b.Business, b.Competency_Proficiency_Details,b.Role from rmg_app.applied_requirement a, rmg_app.requirement_details b where b.Requirement_Id = a.Requirement_Id and a.applicant_employeeid = :employeeNumber and a.rmg_status='Approved' and to_date(a.created_date_timestamp,'dd-Mon-yyyy') >= (now() - interval '90 day')", nativeQuery = true)
	List<Object> getAppliedPositionsListForUserApplied(@Param("employeeNumber")Integer employeeNumber);
	
	//changed
	@Query(value = "select a.requirementId, a.rmgStatus, a.rmgEmployeeId, b.totalExperience, b.requestCreatedOn, b.requirementCity, b.requirementBranch, b.requirementCountry, b.business, b.competencyProficiencyDetails, b.role from AppliedRequirementsDetails a, RequirementDetails b where b.requirementId = a.requirementId and a.applicantEmployeeId = :employeeNumber and a.rmgStatus = 'Pending'")
	List<Object> getPendingPositionsListForUser(@Param("employeeNumber") Integer employeeNumber );
	
	@Query(value = "select count(*) from AppliedRequirementsDetails where applicantEmployeeId = :employeeNumber and rmgStatus = 'Pending'")
	Integer getPendingPositionsCountForUser(@Param("employeeNumber") Integer employeeNumber);
	
	@Query(value = "select count(*) from AppliedRequirementsDetails where rmgEmployeeId = :employeeNumber")
	Integer getAppliedPositionsCountForRmg(@Param("employeeNumber") Integer employeeNumber);
	
	//changed 
	@Query(value = "select a.requirementId, a.rmgStatus, a.rmgEmployeeId, b.totalExperience, b.requestCreatedOn, b.requirementCity, b.requirementBranch, b.requirementCountry, b.business, b.competencyProficiencyDetails, b.role from AppliedRequirementsDetails a, RequirementDetails b where b.requirementId = a.requirementId ")
	List<Object> getAppliedPositionsListForRmg();
	
	@Query(value = "select count(*) from AppliedRequirementsDetails where glEmployeeId = :employeeNumber")
	Integer getAppliedPositionsCountForGL(@Param("employeeNumber") Integer employeeNumber);
	
	@Query(value = "select count(*) from AppliedRequirementsDetails where glEmployeeId = :employeeNumber and rmgStatus = 'Pending'")
	Integer getPendingPositionsCountForGL(@Param("employeeNumber") Integer employeeNumber);
	
	//changed
	@Query(value = "select a.applicantEmployeeId, b.role, a.requirementId, b.totalExperience, b.requestCreatedOn, b.requirementCity, b.requirementBranch, b.requirementCountry, b.business, b.competencyProficiencyDetails, a.applicantContactNumber, a.requestorEmployeeId, a.requestorComments, a.rmgStatus, a.validVisa, a.visaType, a.visaIssueDate, a.visaExpiryDate, b.onsiteOffshore from AppliedRequirementsDetails a, RequirementDetails b where b.requirementId = a.requirementId and a.rmgStatus IN ('Pending')  and a.requestorStatus='Approved' and b.requirementStatus in('OPEN','PROPOSED')")
	List<Object> getRmgWorklistFYA();
	
	//Changed
	@Query(value = "select a.applicantEmployeeId, b.role, a.requirementId, b.totalExperience, b.requestCreatedOn, b.requirementCity, b.requirementBranch, b.requirementCountry, b.business, b.competencyProficiencyDetails, a.applicantContactNumber, a.applicantComments, a.rmgStatus, a.validVisa, a.visaType, a.visaIssueDate, a.visaExpiryDate, b.onsiteOffshore,b.prerequisite_exp,b.role_description,b.exciting_opp from AppliedRequirementsDetails a, RequirementDetails b where b.requirementId = a.requirementId and a.requestorStatus='Pending' and b.requirementStatus in('OPEN','PROPOSED') and a.requestorEmployeeId=:requestorEmployeeId")
	List<Object> getRequestorWorklistFYA(@Param("requestorEmployeeId") Integer requestorEmployeeId);
	
	//changed
	@Query(value = "select a.applicantEmployeeId, b.role, a.requirementId, b.totalExperience, b.requestCreatedOn, b.requirementCity, b.requirementBranch, b.requirementCountry, b.business, b.competencyProficiencyDetails, a.applicantContactNumber, a.applicantComments, a.rmgStatus, a.validVisa, a.visaType, a.visaIssueDate, a.visaExpiryDate, b.onsiteOffshore from AppliedRequirementsDetails a, RequirementDetails b where b.requirementId = a.requirementId and a.requestorStatus='Approved' and b.requirementStatus in('OPEN','PROPOSED') and a.rmgStatus NOT IN ('Approved') and a.requestorEmployeeId=:requestorEmployeeId and a.requirementId=:requirementId")
	List<Object> getApprovedRequestorWorklistFYA(@Param("requestorEmployeeId") Integer requestorEmployeeId, @Param("requirementId") Integer requirementId );
	
	//changed
	@Query(value = "select a.applicantEmployeeId, a.releaseDate, b.totalExperience, a.requirementId, b.role, a.applicantComments from AppliedRequirementsDetails a, RequirementDetails b where b.requirementId = a.requirementId and a.glEmployeeId = :employeeNumber")
	List<Object> getGLWorkList(@Param("employeeNumber") Integer employeeNumber);
	
	//changed
	@Query(value = "select a.applicantEmployeeId, a.releaseDate, b.totalExperience, a.requirementId, b.role, a.applicantComments from AppliedRequirementsDetails a, RequirementDetails b where b.requirementId = a.requirementId and a.glEmployeeId = :employeeNumber and a.rmgStatus = 'Pending'")
	List<Object> getGLPendingWorklist(@Param("employeeNumber") Integer employeeNumber );
	
	//changed
	@Query(value = "select a.requirementId, a.rmgStatus, a.rmgEmployeeId, b.totalExperience, b.requestCreatedOn, b.requirementCity, b.requirementBranch, b.requirementCountry, b.business, b.competencyProficiencyDetails, b.role from AppliedRequirementsDetails a, RequirementDetails b where b.requirementId = a.requirementId and a.rmgEmployeeId = :employeeNumber and a.rmgStatus = 'Pending'")
	List<Object> getPendingPositionsListForRmg(@Param("employeeNumber") Integer employeeNumber);
	
	@Query(value = "select count(*) from AppliedRequirementsDetails where rmgEmployeeId = :employeeNumber and rmgStatus = 'Pending'")
	Integer getPendingPositionsCountForRmg(@Param("employeeNumber") Integer employeeNumber);
	
	@Query(value = "select DISTINCT(requestId) from AppliedRequirementsDetails where requestorEmployeeId=:requestorEmployeeId")
	List<Integer> getRequestIdList(@Param("requestorEmployeeId") Integer requestorEmployeeId);
	
	@Transactional
	@Modifying
	@Query(value = "insert into rmg_app.applied_requirement (Request_Id, Requirement_Id, Requestor_employeeid, applicant_employeeid, rmg_employeeid, rmg_status, requestor_status,"
			+ " rmg_comments, gl_employeeid, gl_comments, applicant_comments, release_date, description, applicant_experience, applicant_contactnumber, created_by, created_date_timestamp,"
			+ "valid_visa, visa_type, visa_issue_date, visa_expiry_date)"
			+ "values (:requestId, :requirementId, :requestorEmployeeId, :employeeId, :rmgEmployeeId, :rmgStatus, :requestorStatus, :rmgComments, :glEmployeeId, :glComments, :comments," 
			+ ":releaseDate,:description, :experience, :contactNumber, :createdBy, :createdDate, :validVisa, :visaType, :visaIssueDate, :visaExpDate)", nativeQuery = true) 
	void addAppliedPositionData(@Param("requestId") Integer requestId,
			@Param("requirementId") Integer requirementId,
			@Param("requestorEmployeeId") Integer requestorEmployeeId,
			@Param("employeeId") Integer employeeId,
			@Param("rmgEmployeeId") String rmgEmployeeId,
			@Param("rmgStatus") String rmgStatus,
			@Param("requestorStatus") String requestorStatus,
			@Param("rmgComments") String rmgComments,
			@Param("glEmployeeId") Integer glEmployeeId,
			@Param("glComments") String glComments,
			@Param("comments") String comments,
			@Param("releaseDate") String releaseDate,
			@Param("description") String description,
			@Param("experience") String experience,
			@Param("contactNumber") String contactNumber,
			@Param("createdBy") Integer createdBy,
			@Param("createdDate") String createdDate,
			@Param("validVisa") String validVisa,
			@Param("visaType") String visaType,
			@Param("visaIssueDate") String visaIssueDate,
			@Param("visaExpDate") String visaExpDate);

	@Transactional
	@Modifying
	@Query(value = "update AppliedRequirementsDetails set releaseDate = :releaseDate, rmgStatus='Approved', updatedBy =:employeeId, updatedDateTimestamp =:updatedDate, rmgComments=:rmgComments where requirementId = :requirementId and applicantEmployeeId=:employeeId") 
	void updateReleaseDate(@Param("requirementId") Integer requirementId,
			@Param("releaseDate") String releaseDate,@Param("employeeId")Integer employeeId, @Param("updatedDate")String updatedDate,@Param("rmgComments")String rmgComments);
	
	@Transactional
	@Modifying
	@Query(value = "update AppliedRequirementsDetails set rmgStatus='Rejected',rejReasonRmg = :rejReasonRmg, rmgComments=:comments, updatedBy =:employeeId, updatedDateTimestamp =:updatedDate where requirementId = :requirementId and applicantEmployeeId=:employeeId") 
	void updateReleaseDateReject(@Param("requirementId") Integer requirementId, @Param("employeeId")Integer employeeId, @Param("rejReasonRmg")String rejReasonRmg, @Param("comments")String comments, @Param("updatedDate")String updatedDate);

	@Transactional
	@Modifying
	@Query(value = "update AppliedRequirementsDetails set releaseDate = :releaseDate, requestorStatus='Approved', updatedBy =:requestorEmployeeId, updatedDateTimestamp =:updatedDate, requestorComments=:requestorComments  where requirementId = :requirementId and requestorEmployeeId=:requestorEmployeeId and applicantEmployeeId=:employeeId") 
	void updateRequestorReqReleaseDate(@Param("requirementId")Integer requirementId, @Param("releaseDate")String releaseDate, @Param("requestorEmployeeId")Integer requestorEmployeeId, @Param("employeeId")Integer employeeId, @Param("updatedDate")String updatedDate, @Param("requestorComments")String requestorComments);

	@Transactional
	@Modifying
	@Query(value = "update AppliedRequirementsDetails set requestorStatus='Rejected', rmgStatus='NA', rejReasonRq = :rejReasonRq, requestorComments=:comments, updatedBy =:requestorEmployeeId, updatedDateTimestamp =:updatedDate where requirementId = :requirementId and requestorEmployeeId=:requestorEmployeeId and applicantEmployeeId=:employeeId") 
	void updateRequestorReqReleaseDateReject(@Param("requirementId")Integer requirementId, @Param("requestorEmployeeId")Integer requestorEmployeeId, @Param("employeeId")Integer employeeId, @Param("rejReasonRq")String rejReasonRq, @Param("comments")String comments,  @Param("updatedDate")String updatedDate);
	
	/*@Query("select s.applicantEmployeeId from AppliedRequirementsDetails s where s.requirementId=:requirementId")
	List<Integer> getUserAppliedData(@Param("requirementId")Integer requirementId);*/
	
	@Query("select s.applicantEmployeeId from AppliedRequirementsDetails s where s.requirementId=:requirementId and requestorStatus ='Pending'")
	List<Integer> getUserAppliedData(@Param("requirementId")Integer requirementId);
	
/*	@Query(value = "select a from AppliedRequirementsDetails a where a.applicantEmployeeId = :employeeId ")
	List<AppliedRequirementsDetails> getAppliedUserDetail(@Param("employeeId") Integer employeeId);
*/	
	@Query(value = "select a.Requirement_Id from rmg_app.applied_requirement a, rmg_app.requirement_details b where b.Requirement_Id = a.Requirement_Id and a.applicant_employeeid = :employeeNumber", nativeQuery = true)
	List<String> getAppliedRequirementListForUserApplied(@Param("employeeNumber")Integer employeeNumber);
	// and a.rmg_status='Approved' commented on 28th Jan to fix  Users can apply for any job positions or Requirements for indefinite times
	
	@Query(value = "select   a.validVisa, a.visaType, a.visaIssueDate, a.visaExpiryDate from AppliedRequirementsDetails a where a.applicantEmployeeId = :employeeNumber  ")
	List<Object> getAppliedUserDetail(@Param("employeeNumber") Integer employeeNumber);

	//Changed 
	@Query(value = "select a.applicantEmployeeId, b.role, a.requirementId, b.totalExperience, b.requestCreatedOn, b.requirementCity, b.requirementBranch, b.requirementCountry, b.business, b.competencyProficiencyDetails, a.applicantContactNumber, a.applicantComments, a.rmgStatus, a.validVisa, a.visaType, a.visaIssueDate, a.visaExpiryDate, b.onsiteOffshore,b.prerequisite_exp,b.role_description,b.exciting_opp from AppliedRequirementsDetails a, RequirementDetails b where b.requirementId = a.requirementId and a.requestorStatus='Pending' and b.requirementStatus in('OPEN','PROPOSED') and b.exciting_opp = 'Y' and a.requestorEmployeeId IN(:requestorEmployeeId) ")
	//and  b.isu IN (:isu)")
	//List<Object> getRequestorWorklistForExcOppFYA(@Param("requestorEmployeeId") Integer requestorEmployeeId,@Param("isu") String isu);
	List<Object> getRequestorWorklistForExcOppFYA(@Param("requestorEmployeeId") Integer requestorEmployeeId);


	@Transactional
	@Modifying
	@Query(value = "update AppliedRequirementsDetails set requestorEmployeeId=:requestorEmployeeId, releaseDate = :releaseDate, requestorStatus='Approved', updatedBy =:requestorEmployeeId, updatedDateTimestamp =:updatedDate, requestorComments=:requestorComments  where requirementId = :requirementId  and applicantEmployeeId=:employeeId") 
	void updateExcOppRequestorReqReleaseDate(@Param("requirementId")Integer requirementId, @Param("releaseDate")String releaseDate, @Param("requestorEmployeeId")Integer requestorEmployeeId, @Param("employeeId")Integer employeeId, @Param("updatedDate")String updatedDate, @Param("requestorComments")String requestorComments);



	@Transactional
	@Modifying
	@Query(value = "update AppliedRequirementsDetails set requestorEmployeeId=:requestorEmployeeId, requestorStatus='Rejected', rmgStatus='NA', rejReasonRq = :rejReasonRq, requestorComments=:comments, updatedBy =:requestorEmployeeId, updatedDateTimestamp =:updatedDate where requirementId = :requirementId and applicantEmployeeId=:employeeId") 
	void updateExcOppRequestorReqReleaseDateReject(@Param("requirementId")Integer requirementId, @Param("employeeId")Integer employeeId, @Param("rejReasonRq")String rejReasonRq, @Param("comments")String comments,  @Param("updatedDate")String updatedDate, @Param("requestorEmployeeId")Integer requestorEmployeeId);

	@Query(nativeQuery=true,value = "select  a.valid_visa,a.visa_type,a.visa_issue_date,a.visa_expiry_date,a.applicant_experience,a.applicant_contactnumber from rmg_app.applied_requirement a where a.applicant_employeeid = :employeeNumber   limit 1")
	List<Object> getSingleRowforAppliedUserDetail(@Param("employeeNumber") Integer employeeNumber);
	
	@Transactional
	@Modifying
	@Query(value = "update AppliedRequirementsDetails set requestorStatus='Rejected', rmgStatus='Rejected', requestorComments='Requirement is closed hence Auto Rejected',"
			+ "updatedBy =:employeeId, updatedDateTimestamp =:updatedDate where requirementId = :requirementId and applicantEmployeeId=:employeeId") 
	void updateAutoReject(@Param("requirementId") Integer requirementId,@Param("employeeId")Integer employeeId, @Param("updatedDate")String updatedDate);
	
	
	@Query(value="select s.requirement_id, s.applicant_employeeid,s.requestor_status from rmg_app.applied_requirement s where s.requestor_status ='Pending' "
			+ "AND exists(select 1 from  rmg_app.applied_requirement a where a.rmg_Status='Approved' AND a.requirement_id = s.requirement_id "
			+ "union all select 1 from  rmg_app.requirement_details a, rmg_app.applied_requirement b where a.requirement_status ='CLOSED' "
			+ "and a.requirement_id= b.requirement_id AND a.requirement_id = s.requirement_id)" ,nativeQuery=true)
	List<Object> getPendingApplicantList();
}
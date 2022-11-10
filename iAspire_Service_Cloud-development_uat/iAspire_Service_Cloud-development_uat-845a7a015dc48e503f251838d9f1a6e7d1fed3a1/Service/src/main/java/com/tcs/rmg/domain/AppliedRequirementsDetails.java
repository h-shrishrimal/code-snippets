package com.tcs.rmg.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "applied_requirement", schema = "rmg_app")
public class AppliedRequirementsDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	@Column(name = "application_id")
	private Integer applicationId;

	@Column(name = "Request_Id")
	private Integer requestId;

	@Column(name = "Requirement_Id")
	private Integer requirementId;

	@Column(name = "Requestor_employeeid")
	private Integer requestorEmployeeId;

	@Column(name = "applicant_employeeid")
	private Integer applicantEmployeeId;

	@Column(name = "rmg_employeeid")
	private String rmgEmployeeId;

	@Column(name = "rmg_status")
	private String rmgStatus;
	
	@Column(name = "requestor_status")
	private String requestorStatus;

	@Column(name = "rmg_comments")
	private String rmgComments;

	@Column(name = "gl_employeeid")
	private Integer glEmployeeId;

	@Column(name = "gl_comments")
	private String glComments;

	@Column(name = "applicant_comments")
	private String applicantComments;

	@Column(name = "release_date")
	private String releaseDate;

	@Column(name = "description")
	private String description;
	
	@Column(name = "applicant_experience")
	private String applicantExperience;

	@Column(name = "applicant_contactnumber")
	private String applicantContactNumber;
	
	@Column(name = "requestor_comments")
	private String requestorComments;
	
	@Column(name = "created_by")
	private Integer createdBy;
	
	@Column(name = "created_date_timestamp")
	private String createdDateTimestamp;
  	  
	@Column(name = "updated_by")
	private Integer updatedBy;
	
	@Column(name = "updated_date_timestamp")
	private String updatedDateTimestamp;
	
	@Column(name = "valid_visa")
	private String validVisa;
	
	@Column(name = "visa_type")
	private String visaType;
	
	@Column(name = "visa_issue_date")
	private String visaIssueDate;
	
	@Column(name = "visa_expiry_date")
	private String visaExpiryDate;
	
	@Column(name = "rejection_reason_rq")
	private String rejReasonRq;
	
	@Column(name = "rejection_reason_rmg")
	private String rejReasonRmg;

	public String getRequestorStatus() {
		return requestorStatus;
	}

	public void setRequestorStatus(String requestorStatus) {
		this.requestorStatus = requestorStatus;
	}

	public Integer getApplicationId() {
		return applicationId;
	}

	public void setapplicationId(Integer applicationId) {
		this.applicationId = applicationId;
	}

	public Integer getrequestId() {
		return requestId;
	}

	public void setrequestId(Integer requestId) {
		this.requestId = requestId;
	}

	public Integer getrequirementId() {
		return requirementId;
	}

	public void setrequirementId(Integer requirementId) {
		this.requirementId = requirementId;
	}

	public Integer getrequestorEmployeeId() {
		return requestorEmployeeId;
	}

	public void setrequestorEmployeeId(Integer requestorEmployeeId) {
		this.requestorEmployeeId = requestorEmployeeId;
	}

	public Integer getapplicantEmployeeId() {
		return applicantEmployeeId;
	}

	public void setapplicantEmployeeId(Integer applicantEmployeeId) {
		this.applicantEmployeeId = applicantEmployeeId;
	}

	
	public String getRmgEmployeeId() {
		return rmgEmployeeId;
	}

	public void setRmgEmployeeId(String rmgEmployeeId) {
		this.rmgEmployeeId = rmgEmployeeId;
	}

	public String getrmgStatus() {
		return rmgStatus;
	}

	public void setrmgStatus(String rmgStatus) {
		this.rmgStatus = rmgStatus;
	}

	public String getrmgComments() {
		return rmgComments;
	}

	public void setrmgComments(String rmgComments) {
		this.rmgComments = rmgComments;
	}

	public Integer getglEmployeeId() {
		return glEmployeeId;
	}

	public void setglEmployeeId(Integer glEmployeeId) {
		this.glEmployeeId = glEmployeeId;
	}

	public String getglComments() {
		return glComments;
	}

	public void setglComments(String glComments) {
		this.glComments = glComments;
	}

	public String getapplicantComments() {
		return applicantComments;
	}

	public void setapplicantComments(String applicantComments) {
		this.applicantComments = applicantComments;
	}

	public String getreleaseDate() {
		return releaseDate;
	}

	public void setreleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getdescription() {
		return description;
	}

	public void setdescription(String description) {
		this.description = description;
	}

	public String getApplicantExperience() {
		return applicantExperience;
	}

	public void setApplicantExperience(String applicantExperience) {
		this.applicantExperience = applicantExperience;
	}

	public String getApplicantContactNumber() {
		return applicantContactNumber;
	}

	public void setApplicantContactNumber(String applicantContactNumber) {
		this.applicantContactNumber = applicantContactNumber;
	}

	public String getRequestorComments() {
		return requestorComments;
	}

	public void setRequestorComments(String requestorComments) {
		this.requestorComments = requestorComments;
	}

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public Integer getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(Integer updatedBy) {
		this.updatedBy = updatedBy;
	}

	public String getCreatedDateTimestamp() {
		return createdDateTimestamp;
	}

	public void setCreatedDateTimestamp(String createdDateTimestamp) {
		this.createdDateTimestamp = createdDateTimestamp;
	}

	public String getUpdatedDateTimestamp() {
		return updatedDateTimestamp;
	}

	public void setUpdatedDateTimestamp(String updatedDateTimestamp) {
		this.updatedDateTimestamp = updatedDateTimestamp;
	}
	
	@Column(name="created_date", insertable=true, nullable=false, updatable=false)
	@UpdateTimestamp
	private LocalDateTime creationDate;


	public Integer getRequestId() {
		return requestId;
	}

	public void setRequestId(Integer requestId) {
		this.requestId = requestId;
	}

	public Integer getRequirementId() {
		return requirementId;
	}

	public void setRequirementId(Integer requirementId) {
		this.requirementId = requirementId;
	}

	public Integer getRequestorEmployeeId() {
		return requestorEmployeeId;
	}

	public void setRequestorEmployeeId(Integer requestorEmployeeId) {
		this.requestorEmployeeId = requestorEmployeeId;
	}

	public Integer getApplicantEmployeeId() {
		return applicantEmployeeId;
	}

	public void setApplicantEmployeeId(Integer applicantEmployeeId) {
		this.applicantEmployeeId = applicantEmployeeId;
	}

	public String getRmgStatus() {
		return rmgStatus;
	}

	public void setRmgStatus(String rmgStatus) {
		this.rmgStatus = rmgStatus;
	}

	public String getRmgComments() {
		return rmgComments;
	}

	public void setRmgComments(String rmgComments) {
		this.rmgComments = rmgComments;
	}

	public Integer getGlEmployeeId() {
		return glEmployeeId;
	}

	public void setGlEmployeeId(Integer glEmployeeId) {
		this.glEmployeeId = glEmployeeId;
	}

	public String getGlComments() {
		return glComments;
	}

	public void setGlComments(String glComments) {
		this.glComments = glComments;
	}

	public String getApplicantComments() {
		return applicantComments;
	}

	public void setApplicantComments(String applicantComments) {
		this.applicantComments = applicantComments;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getValidVisa() {
		return validVisa;
	}

	public void setValidVisa(String validVisa) {
		this.validVisa = validVisa;
	}

	public String getVisaType() {
		return visaType;
	}

	public void setVisaType(String visaType) {
		this.visaType = visaType;
	}
	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}

	public void setApplicationId(Integer applicationId) {
		this.applicationId = applicationId;
	}

	public String getVisaIssueDate() {
		return visaIssueDate;
	}

	public void setVisaIssueDate(String visaIssueDate) {
		this.visaIssueDate = visaIssueDate;
	}

	public String getVisaExpiryDate() {
		return visaExpiryDate;
	}

	public void setVisaExpiryDate(String visaExpiryDate) {
		this.visaExpiryDate = visaExpiryDate;
	}

	public String getRejReasonRq() {
		return rejReasonRq;
	}

	public void setRejReasonRq(String rejReasonRq) {
		this.rejReasonRq = rejReasonRq;
	}

	public String getRejReasonRmg() {
		return rejReasonRmg;
	}

	public void setRejReasonRmg(String rejReasonRmg) {
		this.rejReasonRmg = rejReasonRmg;
	}
	
}

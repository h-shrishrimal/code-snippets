package com.tcs.rmg.domain;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "auto_apply_requirement", schema = "rmg_app")
public class AutoApplyRequirement {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	@Column(name = "auto_apply_requirement_id")
	private Integer autoapplyRequirementId;
	
	@Column(name = "Requirement_Id")
	private Integer requirementId;

	@Column(name = "applicant_employeeid")
	private Integer applicantEmployeeId;

	@Column(name = "Request_Id")
	private Integer requestId;
	
	@Column(name = "Requestor_Employee_Id")
	private Integer requestorEmpId;

	@Column(name = "isapplied")
	private String isapplied;

	@Column(name = "Reason_For_Failure")
	private String reasonForFailure;

	@Column(name = "cretaeduserid")
	private String cretaeduserid;

	@Column(name = "updateduserid")
	private String updateduserid;

	@Column(name = "createdtimestamp")
	private Timestamp createdtimestamp;

	@Column(name = "updatedtimestamp")
	private Timestamp updatedtimestamp;
	
	
	public Integer getAutoapplyRequirementId() {
		return autoapplyRequirementId;
	}

	public void setAutoapplyRequirementId(Integer autoapplyRequirementId) {
		this.autoapplyRequirementId = autoapplyRequirementId;
	}
	public Integer getRequirementId() {
		return requirementId;
	}

	public void setRequirementId(Integer requirementId) {
		this.requirementId = requirementId;
	}



	public String getIsapplied() {
		return isapplied;
	}

	public void setIsapplied(String isapplied) {
		this.isapplied = isapplied;
	}

	public Integer getApplicantEmployeeId() {
		return applicantEmployeeId;
	}

	public void setApplicantEmployeeId(Integer applicantEmployeeId) {
		this.applicantEmployeeId = applicantEmployeeId;
	}

	public Integer getRequestId() {
		return requestId;
	}

	public void setRequestId(Integer requestId) {
		this.requestId = requestId;
	}

	public Integer getRequestorEmpId() {
		return requestorEmpId;
	}

	public void setRequestorEmpId(Integer requestorEmpId) {
		this.requestorEmpId = requestorEmpId;
	}

	public String getReasonForFailure() {
		return reasonForFailure;
	}

	public void setReasonForFailure(String reasonForFailure) {
		this.reasonForFailure = reasonForFailure;
	}

	
	public String getCretaeduserid() {
		return cretaeduserid;
	}

	public void setCretaeduserid(String cretaeduserid) {
		this.cretaeduserid = cretaeduserid;
	}

	public String getUpdateduserid() {
		return updateduserid;
	}

	public void setUpdateduserid(String updateduserid) {
		this.updateduserid = updateduserid;
	}

	

	public Timestamp getCreatedtimestamp() {
		return createdtimestamp;
	}

	public void setCreatedtimestamp(Timestamp createdtimestamp) {
		this.createdtimestamp = createdtimestamp;
	}

	public Timestamp getUpdatedtimestamp() {
		return updatedtimestamp;
	}

	public void setUpdatedtimestamp(Timestamp updatedtimestamp) {
		this.updatedtimestamp = updatedtimestamp;
	}

	@Override
	public String toString() {
		return "AutoApplyRequirement [autoapplyRequirementId=" + autoapplyRequirementId + ", requirementId="
				+ requirementId + ", applicantEmployeeId=" + applicantEmployeeId + ", requestId=" + requestId
				+ ", requestorEmpId=" + requestorEmpId + ", isapplied=" + isapplied + ", reasonForFailure="
				+ reasonForFailure + "]";
	}
}
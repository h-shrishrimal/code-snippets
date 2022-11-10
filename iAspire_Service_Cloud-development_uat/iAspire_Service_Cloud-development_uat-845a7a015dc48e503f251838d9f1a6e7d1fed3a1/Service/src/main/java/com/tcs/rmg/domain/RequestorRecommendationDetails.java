package com.tcs.rmg.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "recommendations_requirement", schema = "rmg_app")
public class RequestorRecommendationDetails {

	/*@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	@Column(name = "application_id")
	private Integer applicationId;*/
	@Id
	@Column(name = "Request_Id")
	private Integer requestId;

	@Column(name = "requirement_id")
	private Integer requirementId;

	@Column(name = "requestor_employee_id")
	private Integer requestorEmployeeId;
	
	@Column(name = "requestor_employee_name") 
	private String requestorEmployeeName;

	@Column(name = "required_competency")
	private String reqCometency;
	
	@Column(name = "applicant_experience")
	private String applicantExperience;
	
	@Column(name = "Employee_Name")
	private String employeeName;

	@Column(name = "Employee_Number")
	private Integer employeeId;
	
	@Column(name = "employee_competency")
	private String empCompetency;
	
	@Column(name = "ievolve_match")
	private String ievolveMatch;
	
	@Column(name = "Overall_T_Factor")
	private String overallTFactor;
	
	@Column(name = "Employee_Experience")
	private String employeeExperience;

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

	public String getRequestorEmployeeName() {
		return requestorEmployeeName;
	}

	public void setRequestorEmployeeName(String requestorEmployeeName) {
		this.requestorEmployeeName = requestorEmployeeName;
	}

	public String getReqCometency() {
		return reqCometency;
	}

	public void setReqCometency(String reqCometency) {
		this.reqCometency = reqCometency;
	}

	public String getApplicantExperience() {
		return applicantExperience;
	}

	public void setApplicantExperience(String applicantExperience) {
		this.applicantExperience = applicantExperience;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmpCompetency() {
		return empCompetency;
	}

	public void setEmpCompetency(String empCompetency) {
		this.empCompetency = empCompetency;
	}

	public String getIevolveMatch() {
		return ievolveMatch;
	}

	public void setIevolveMatch(String ievolveMatch) {
		this.ievolveMatch = ievolveMatch;
	}

	public String getOverallTFactor() {
		return overallTFactor;
	}

	public void setOverallTFactor(String overallTFactor) {
		this.overallTFactor = overallTFactor;
	}

	public String getEmployeeExperience() {
		return employeeExperience;
	}

	public void setEmployeeExperience(String employeeExperience) {
		this.employeeExperience = employeeExperience;
	}
	
}

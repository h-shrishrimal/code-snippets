package com.tcs.rmg.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="requirement_details", schema="rmg_app")
public class RequirementDetails {

	@Id
	@Column(name = "Requirement_Id")
	private Integer requirementId;
	
	@Column(name = "Request_Id")
	private Integer requestId;
	
	@Column(name = "total_experience")
	private String totalExperience;
	
	@Column(name = "Request_Created_On")
	private String requestCreatedOn;
	
	@Column(name = "Requirement_City")
	private String requirementCity;
	
	@Column(name = "Requirement_Country")
	private String requirementCountry;
	
	@Column(name = "Requirement_Branch")
	private String requirementBranch;
	
	
	@Column(name = "Competency_Proficiency_Details")
	private String competencyProficiencyDetails;
	
	@Column(name = "Business")
	private String business;
	
	@Column(name = "Role")
	private String role;
	
	@Column(name = "requirement_geography")
	private String requirementGeography;

	@Column(name = "Requestor_Employee_Id")
	private Integer requestorEmpId;
	
	@Column(name="Skill")
	private String skill;
	
	@Column(name = "requirement_status")
	private String requirementStatus;
	
	@Column(name = "user_notified")
	private String userNotified;
	
	@Column(name = "onsite_offshore")
	private String onsiteOffshore;

	/*
	 * @Column(name = "new_requirment_flag") private String newRequirmentFlag;
	 */	
	
	@Column(name = "role_description")
	private String role_description;

	@Column(name = "prerequisite_exp")
	private String prerequisite_exp;

	@Column(name = "exciting_opp")
	private String exciting_opp;
	
	@Column(name ="isu")
	private String isu;


		public String getIsu() {
		return isu;
	}

	public void setIsu(String isu) {
		this.isu = isu;
	}

	public String getRole_description() {
		return role_description;
	}

	public void setRole_description(String role_description) {
		this.role_description = role_description;
	}

	public String getPrerequisite_exp() {
		return prerequisite_exp;
	}

	public void setPrerequisite_exp(String prerequisite_exp) {
		this.prerequisite_exp = prerequisite_exp;
	}

	public String getExciting_opp() {
		return exciting_opp;
	}

	public void setExciting_opp(String exciting_opp) {
		this.exciting_opp = exciting_opp;
	}

	public String getUserNotified() {
		return userNotified;
	}

	public void setUserNotified(String userNotified) {
		this.userNotified = userNotified;
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
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

	public String getRequirementGeography() {
		return requirementGeography;
	}

	public void setRequirementGeography(String requirementGeography) {
		this.requirementGeography = requirementGeography;
	}

	public Integer getRequirementId() {
		return requirementId;
	}

	public void setRequirementId(Integer requirementId) {
		this.requirementId = requirementId;
	}

	public String getTotalExperience() {
		return totalExperience;
	}

	public void setTotalExperience(String totalExperience) {
		this.totalExperience = totalExperience;
	}

	public String getRequestCreatedOn() {
		return requestCreatedOn;
	}

	public void setRequestCreatedOn(String requestCreatedOn) {
		this.requestCreatedOn = requestCreatedOn;
	}

	public String getRequirementCity() {
		return requirementCity;
	}

	public void setRequirementCity(String requirementCity) {
		this.requirementCity = requirementCity;
	}

	public String getRequirementCountry() {
		return requirementCountry;
	}

	public void setRequirementCountry(String requirementCountry) {
		this.requirementCountry = requirementCountry;
	}

	public String getRequirementBranch() {
		return requirementBranch;
	}

	public void setRequirementBranch(String requirementBranch) {
		this.requirementBranch = requirementBranch;
	}

	public String getCompetencyProficiencyDetails() {
		return competencyProficiencyDetails;
	}

	public void setCompetencyProficiencyDetails(String competencyProficiencyDetails) {
		this.competencyProficiencyDetails = competencyProficiencyDetails;
	}

	public String getBusiness() {
		return business;
	}

	public void setBusiness(String business) {
		this.business = business;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getRequirementStatus() {
		return requirementStatus;
	}

	public void setRequirementStatus(String requirementStatus) {
		this.requirementStatus = requirementStatus;
	}
	
	public String getOnsiteOffshore() {
		return onsiteOffshore;
	}

	public void setOnsiteOffshore(String onsiteOffshore) {
		this.onsiteOffshore = onsiteOffshore;
	}
	
	

	/*
	 * public String getNewRequirmentFlag() { return newRequirmentFlag; }
	 * 
	 * public void setNewRequirmentFlag(String newRequirmentFlag) {
	 * this.newRequirmentFlag = newRequirmentFlag; }
	 */
	
}
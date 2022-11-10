package com.tcs.rmg.data;

public class AppliedRequirementData {
	
	Integer requirementId;
	String role;
	String experience;
	String postedOn;
	String city;
	String branch;
	String country;
	String businessName;
	String competency;
	String rmgStatus;
	String requestorStatus;
    String rmgEmployeeId;
	
	public AppliedRequirementData() {
	//default constructor
	}
	
	public AppliedRequirementData(Integer requirementId, String experience, String postedOn, String city, String branch, String country, String businessName, String competency, String rmgStatus, String rmgEmployeeId) {
		
		this.requirementId = requirementId;
		this.experience = experience;
		this.postedOn = postedOn;
		this.city = city;
		this.branch = branch;
		this.country = country;
		this.businessName = businessName;
		this.competency = competency;
		this.rmgStatus = rmgStatus;
		this.rmgEmployeeId = rmgEmployeeId;
	}
	
	public String getRequestorStatus() {
		return requestorStatus;
	}

	public void setRequestorStatus(String requestorStatus) {
		this.requestorStatus = requestorStatus;
	}

	public String getRmgEmployeeId() {
		return rmgEmployeeId;
	}

	public void setRmgEmployeeId(String rmgEmployeeId) {
		this.rmgEmployeeId = rmgEmployeeId;
	}

	public String getRmgStatus() {
		return rmgStatus;
	}

	public void setRmgStatus(String rmgStatus) {
		this.rmgStatus = rmgStatus;
	}

	public void setRequirementId(Integer requirementId) {
		this.requirementId = requirementId;
	}

	public Integer getRequirementId() {
		return requirementId;
	}
	
	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getExperience() {
		return experience;
	}
	
	public void setPostedOn(String postedOn) {
		this.postedOn = postedOn;
	}

	public String getPostedOn() {
		return postedOn;
	}
	
	public void setCity(String city) {
		this.city = city;
	}

	public String getCity() {
		return city;
	}
	
	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getBranch() {
		return branch;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}

	public String getCountry() {
		return country;
	}
	
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public String getBusinessName() {
		return businessName;
	}
	
	public void setCompetency(String competency) {
		this.competency = competency;
	}
	
	public String getCompetency() {
		return competency;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}

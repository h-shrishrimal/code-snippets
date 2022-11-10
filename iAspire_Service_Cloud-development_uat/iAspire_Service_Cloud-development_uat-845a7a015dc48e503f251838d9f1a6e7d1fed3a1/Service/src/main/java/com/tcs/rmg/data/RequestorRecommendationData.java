package com.tcs.rmg.data;

public class RequestorRecommendationData {
	
	Integer employeeNumber;
	String ievolveMatch;
	Integer requirementId;
	String experience;
	String city;
	String branch;
	String country;
	String businessName;
	String competency;
	String role;
	String postedOn;
	
	public RequestorRecommendationData() {
		//default Constructor
	}
	
	public RequestorRecommendationData(Integer employeeNumber, Integer requirementId, String ievolveMatch, String role,String experience, 
			String branch, String city, String country, String businessName, String competency, String postedOn) {
		super();
		this.employeeNumber = employeeNumber;
		this.requirementId = requirementId;
		this.ievolveMatch =ievolveMatch;
		this.role=role;
		this.experience = experience;
		this.branch = branch;
		this.city = city;
		this.country = country;
		this.businessName = businessName;
		this.competency = competency;
		this.postedOn = postedOn;
	}

	public Integer getEmployeeNumber() {
		return employeeNumber;
	}

	public void setEmployeeNumber(Integer employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	public String getIevolveMatch() {
		return ievolveMatch;
	}

	public void setIevolveMatch(String ievolveMatch) {
		this.ievolveMatch = ievolveMatch;
	}

	public Integer getRequirementId() {
		return requirementId;
	}

	public void setRequirementId(Integer requirementId) {
		this.requirementId = requirementId;
	}
	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public String getCompetency() {
		return competency;
	}

	public void setCompetency(String competency) {
		this.competency = competency;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPostedOn() {
		return postedOn;
	}

	public void setPostedOn(String postedOn) {
		this.postedOn = postedOn;
	}
	
}

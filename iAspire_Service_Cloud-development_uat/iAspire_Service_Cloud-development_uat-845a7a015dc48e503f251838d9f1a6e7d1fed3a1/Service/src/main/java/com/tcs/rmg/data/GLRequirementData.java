package com.tcs.rmg.data;

public class GLRequirementData {
	
	Integer requirementId;
	String role;
	String experience;
	String postedOn;
	String city;
	String branch;
	String country;
	String businessName;
	String competency;
	Integer appliedBy;



	public GLRequirementData() {
		super();
		// TODO Auto-generated constructor stub
	}
	
    public GLRequirementData(Integer requirementId, String role, String experience, String postedOn, String city,
		String branch, String country, String businessName, String competency, Integer appliedBy) {
	super();
	this.requirementId = requirementId;
	this.role = role;
	this.experience = experience;
	this.postedOn = postedOn;
	this.city = city;
	this.branch = branch;
	this.country = country;
	this.businessName = businessName;
	this.competency = competency;
	this.appliedBy = appliedBy;
}

	public Integer getRequirementId() {
		return requirementId;
	}

	public void setRequirementId(Integer requirementId) {
		this.requirementId = requirementId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getPostedOn() {
		return postedOn;
	}

	public void setPostedOn(String postedOn) {
		this.postedOn = postedOn;
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

	public Integer getAppliedBy() {
		return appliedBy;
	}

	public void setAppliedBy(Integer appliedBy) {
		this.appliedBy = appliedBy;
	}
}

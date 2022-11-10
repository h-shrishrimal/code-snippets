package com.tcs.rmg.data;

import javax.persistence.Column;

public class RequirementData {
	
	Integer requirementId;
	String experience;
	String postedOn;
	String role;
	String businessName;
	String competency;
	String city;
	String branch;
	String country;
	String geography;
	String onsiteOffshore;
 String role_description;
 String prerequisite_exp;
  String exciting_opp;
	public RequirementData() {
		//default Constructor
	}
	
	public RequirementData(Integer requirementId, String experience, String postedOn, String city, String branch, String country, String businessName, String competency, String role, String geography, String onsiteOffshore) {
		
		this.requirementId = requirementId;
		this.experience = experience;
		this.postedOn = postedOn;
		this.city = city;
		this.branch = branch;
		this.country = country;
		this.businessName = businessName;
		this.competency = competency;
		this.role = role;
		this.geography = geography;
		this.onsiteOffshore = onsiteOffshore;
	}
	
	
	public String getExciting_opp() {
		return exciting_opp;
	}

	public void setExciting_opp(String exciting_opp) {
		this.exciting_opp = exciting_opp;
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

	public String getGeography() {
		return geography;
	}

	public void setGeography(String geography) {
		this.geography = geography;
	}

	public String getOnsiteOffshore() {
		return onsiteOffshore;
	}

	public void setOnsiteOffshore(String onsiteOffshore) {
		this.onsiteOffshore = onsiteOffshore;
	}
	
}

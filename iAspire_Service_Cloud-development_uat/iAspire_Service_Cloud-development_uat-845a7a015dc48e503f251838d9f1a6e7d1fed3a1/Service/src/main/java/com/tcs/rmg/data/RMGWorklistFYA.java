package com.tcs.rmg.data;

public class RMGWorklistFYA {
	
	Integer employeeNumber;
	String employeeName;
	String role;
	Integer requirementId;
	String experience;
	String postedOn;
	String city;
	String branch;
	String country;
	String businessName;
	String competency;
	String contactNumber;
	String requestorEmployeeId;
	String requestorComment;
	String applicantComments;
	String tFactor;
	String rmgStatus;
	String validVisa;
	String visaType;
	String visaIssueDate;
	String visaExpDate;
	String onsiteOffshore;
	String prerequisite_exp;
	String role_description;
	String exciting_opp;

	public RMGWorklistFYA() {
		//default Constructor
	}
	
	public RMGWorklistFYA(Integer employeeNumber, String employeeName, String role, Integer requirementId,
			String experience, String postedOn, String city, String branch, String country, String businessName,
			String competency,/*String tFactor,*/ String contactNumber, String requestorEmployeeId, String requestorComment, String rmgStatus,
			String validVisa, String visaType, String visaIssueDate, String visaExpDate, String onsiteOffshore) {
		super();
		this.employeeNumber = employeeNumber;
		this.employeeName = employeeName;
		this.role = role;
		this.requirementId = requirementId;
		this.experience = experience;
		this.postedOn = postedOn;
		this.city = city;
		this.branch = branch;
		this.country = country;
		this.businessName = businessName;
		this.competency = competency;
		//this.tFactor = tFactor;
		this.contactNumber =contactNumber;
		this.requestorEmployeeId = requestorEmployeeId;
		this.requestorComment = requestorComment;
		this.rmgStatus =rmgStatus;
		this.validVisa =validVisa;
		this.visaType =visaType;
		this.visaIssueDate =visaIssueDate;
		this.visaExpDate =visaExpDate;
		this.onsiteOffshore =onsiteOffshore;
	}
	
	public RMGWorklistFYA(Integer employeeNumber, String employeeName, String role, Integer requirementId,
			String experience, String postedOn, String city, String branch, String country, String businessName,
			String competency, /*String tFactor,*/ String contactNumber, String applicantComments,String rmgStatus,
			String validVisa, String visaType, String visaIssueDate, String visaExpDate, String onsiteOffshore) {
		super();
		this.employeeNumber = employeeNumber;
		this.employeeName = employeeName;
		this.role = role;
		this.requirementId = requirementId;
		this.experience = experience;
		this.postedOn = postedOn;
		this.city = city;
		this.branch = branch;
		this.country = country;
		this.businessName = businessName;
		this.competency = competency;
		//this.tFactor = tFactor;
		this.contactNumber =contactNumber;
		this.applicantComments = applicantComments;
		this.rmgStatus =rmgStatus;
		this.validVisa =validVisa;
		this.visaType =visaType;
		this.visaIssueDate =visaIssueDate;
		this.visaExpDate =visaExpDate;
		this.onsiteOffshore =onsiteOffshore;
	}
	
	
	public Integer getEmployeeNumber() {
		return employeeNumber;
	}
	public void setEmployeeNumber(Integer employeeNumber) {
		this.employeeNumber = employeeNumber;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
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
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getRequestorEmployeeId() {
		return requestorEmployeeId;
	}
	public void setRequestorEmployeeId(String requestorEmployeeId) {
		this.requestorEmployeeId = requestorEmployeeId;
	}
	public String getRequestorComment() {
		return requestorComment;
	}
	public void setRequestorComment(String requestorComment) {
		this.requestorComment = requestorComment;
	}
	public String getApplicantComments() {
		return applicantComments;
	}
	public void setApplicantComments(String applicantComments) {
		this.applicantComments = applicantComments;
	}
	public String gettFactor() {
		return tFactor;
	}
	public void settFactor(String tFactor) {
		this.tFactor = tFactor;
	}
	public String getRmgStatus() {
		return rmgStatus;
	}
	public void setRmgStatus(String rmgStatus) {
		this.rmgStatus = rmgStatus;
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
	public String getVisaIssueDate() {
		return visaIssueDate;
	}
	public void setVisaIssueDate(String visaIssueDate) {
		this.visaIssueDate = visaIssueDate;
	}
	public String getVisaExpDate() {
		return visaExpDate;
	}
	public void setVisaExpDate(String visaExpDate) {
		this.visaExpDate = visaExpDate;
	}
	public String getOnsiteOffshore() {
		return onsiteOffshore;
	}
	public void setOnsiteOffshore(String onsiteOffshore) {
		this.onsiteOffshore = onsiteOffshore;
	}

	public String getPrerequisite_exp() {
		return prerequisite_exp;
	}

	public void setPrerequisite_exp(String prerequisite_exp) {
		this.prerequisite_exp = prerequisite_exp;
	}

	public String getRole_description() {
		return role_description;
	}

	public void setRole_description(String role_description) {
		this.role_description = role_description;
	}

	public String getExciting_opp() {
		return exciting_opp;
	}

	public void setExciting_opp(String exciting_opp) {
		this.exciting_opp = exciting_opp;
	}
	
}

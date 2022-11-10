package com.tcs.rmg.data;

public class GLWorkList {

	
	String employeeName;
	Integer employeeId;
	String releaseDate;
	String experience;
	Integer requirementId;
	String role;
	String employeeComments;
	
	public GLWorkList() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GLWorkList(String employeeName, Integer employeeId, String releaseDate, String experience,
			Integer requirementId, String role, String employeeComments) {
		super();
		this.employeeName = employeeName;
		this.employeeId = employeeId;
		this.releaseDate = releaseDate;
		this.experience = experience;
		this.requirementId = requirementId;
		this.role = role;
		this.employeeComments = employeeComments;
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

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public Integer getRequirementId() {
		return requirementId;
	}

	public void setRequirementId(Integer requirementId) {
		this.requirementId = requirementId;
	}

	public String getEmployeeComments() {
		return employeeComments;
	}

	public void setEmployeeComments(String employeeComments) {
		this.employeeComments = employeeComments;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	
	
	
}

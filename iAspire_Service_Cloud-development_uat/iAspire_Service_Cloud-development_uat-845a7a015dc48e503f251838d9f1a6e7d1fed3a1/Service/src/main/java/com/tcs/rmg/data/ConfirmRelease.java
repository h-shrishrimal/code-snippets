package com.tcs.rmg.data;

public class ConfirmRelease {

	private Integer employeeId;
	private Integer requestorEmployeeId;
	private Integer requirementId;
	private String releaseDate;
	private Boolean release;
	private String comments;
	private String rejectionReason;
	//private String rmgRejectionReason;
	
	
	public Integer getRequestorEmployeeId() {
		return requestorEmployeeId;
	}
	public void setRequestorEmployeeId(Integer requestorEmployeeId) {
		this.requestorEmployeeId = requestorEmployeeId;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public Integer getRequirementId() {
		return requirementId;
	}
	public void setRequirementId(Integer requirementId) {
		this.requirementId = requirementId;
	}
	public String getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
	public Integer getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
	public Boolean getRelease() {
		return release;
	}
	public void setRelease(Boolean release) {
		this.release = release;
	}
	public String getRejectionReason() {
		return rejectionReason;
	}
	public void setRejectionReason(String rejectionReason) {
		this.rejectionReason = rejectionReason;
	}

	
}

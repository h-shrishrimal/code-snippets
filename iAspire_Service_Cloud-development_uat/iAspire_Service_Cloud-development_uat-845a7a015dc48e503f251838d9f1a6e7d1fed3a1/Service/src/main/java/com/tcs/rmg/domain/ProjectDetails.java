package com.tcs.rmg.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "project_details", schema = "global_login")
public class ProjectDetails {
	
	@Id
	@Column(name = "project_number")
	private Integer projectNumber;

	@Column(name = "project_name")
	private String projectName;

	@Column(name = "project_type")
	private String projectType;

	@Column(name = "project_status")
	private String projectStatus;

	@Column(name = "project_start_date")
	private String projectStartDate;

	@Column(name = "project_completion_date")
	private String projectCompletionDate;

	@Column(name = "digital_flagging")
	private String digitalFlagging;
	

	public Integer getProjectNumber() {
		return projectNumber;
	}

	public void setProjectNumber(Integer projectNumber) {
		this.projectNumber = projectNumber;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectType() {
		return projectType;
	}

	public void setProjectType(String projectType) {
		this.projectType = projectType;
	}

	public String getProjectStatus() {
		return projectStatus;
	}

	public void setProjectStatus(String projectStatus) {
		this.projectStatus = projectStatus;
	}

	public String getProjectStartDate() {
		return projectStartDate;
	}

	public void setProjectStartDate(String projectStartDate) {
		this.projectStartDate = projectStartDate;
	}

	public String getProjectCompletionDate() {
		return projectCompletionDate;
	}

	public void setProjectCompletionDate(String projectCompletionDate) {
		this.projectCompletionDate = projectCompletionDate;
	}

	public String getDigitalFlagging() {
		return digitalFlagging;
	}

	public void setDigitalFlagging(String digitalFlagging) {
		this.digitalFlagging = digitalFlagging;
	}

}

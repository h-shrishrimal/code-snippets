package com.tcs.rmg.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "requirement_rmg_details", schema = "rmg_app")
public class RequirementRMGDetails {

	@Id
	@Column(name = "GE_Business")
	private String geBusiness;

	@Column(name = "RMG_Emp_No")
	private Integer rmgEmpNo;

	@Column(name = "Requirement_Location")
	private String requirementLocation;

	@Column(name = "gl_employeeid")
	private Integer glEmployeeId;

	

	

	public String getgeBusiness() {
		return geBusiness;
	}

	public void setgeBusiness(String geBusiness) {
		this.geBusiness = geBusiness;
	}

	public Integer getrmgEmpNo() {
		return rmgEmpNo;
	}

	public void setrmgEmpNo(Integer rmgEmpNo) {
		this.rmgEmpNo = rmgEmpNo;
	}

	public String getrequirementLocation() {
		return requirementLocation;
	}

	public void setrequirementLocation(String requirementLocation) {
		this.requirementLocation = requirementLocation;
	}

	public Integer getglEmployeeId() {
		return glEmployeeId;
	}

	public void setglEmployeeId(Integer glEmployeeId) {
		this.glEmployeeId = glEmployeeId;
	}

	
	
}

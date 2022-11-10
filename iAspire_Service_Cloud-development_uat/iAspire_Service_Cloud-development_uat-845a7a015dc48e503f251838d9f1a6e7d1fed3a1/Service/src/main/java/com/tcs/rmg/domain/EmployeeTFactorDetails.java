package com.tcs.rmg.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="EMP_T_FACTOR_DETAILS", schema="rmg_app")
public class EmployeeTFactorDetails {
	
	@Id
	@Column(name = "Employee_Number")
	private Integer employeeNumber;

	@Column(name = "Employee_Name")
	private String employeeName;

	@Column(name = "T_FACTOR")
	private String tFactor;

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

	public String gettFactor() {
		return tFactor;
	}

	public void settFactor(String tFactor) {
		this.tFactor = tFactor;
	}
	
	

}

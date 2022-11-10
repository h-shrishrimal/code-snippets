package com.tcs.rmg.data;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_master", schema="global_login")
public class UserMasterData {

	@Id
	@Column(name="emp_no")
	private String empNumber;
	
	@Column(name="emp_name")
	private String empName;
	
	@Column(name="portal_group")
	private String role;
	
	@Column(name="team_role")
	private String teamRole;
	
	@Column(name="customer")
	private String customer;
	
	@Column(name="iou")
	private String iou;
	
	@Column(name="sub_iou")
	private String segment;
	
	@Column(name="work_location")
	private String workLocation;
	
	@Column(name="work_country")
	private String workCountry;
	
	@Column(name="project_location_india")
	private String projectLocationIndia;
	
	@Column(name="allocation_end_date")
	private Date allocationEndDate;
	
	@Column(name="allocation_start_date")
	private Date allocationStartDate;
	
	@Column(name="won_or_swon")
	private String wonOrSwon;
	
	@Column(name="emp_supervisor_no")
	private String empSupervisorNumber;
	
	@Column(name="emp_supervisor_name")
	private String empSupervisorName;
	
	@Column(name="senior_or_junior")
	private String seniorOrJunior;

	@Column(name="grade")
	private String grade;
	
	@Column(name="designation")
	private String designation;
	
	@Column(name="account_name")
	private String account;
	
	public String getEmpNumber() {
		return empNumber;
	}

	public void setEmpNumber(String empNumber) {
		this.empNumber = empNumber;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getTeamRole() {
		return teamRole;
	}

	public void setTeamRole(String teamRole) {
		this.teamRole = teamRole;
	}

	/*public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}*/

	public String getIou() {
		return iou;
	}

	public String getSegment() {
		return segment;
	}

	public void setSegment(String segment) {
		this.segment = segment;
	}

	public void setIou(String iou) {
		this.iou = iou;
	}

	/*public String getSubIou() {
		return subIou;
	}

	public void setSubIou(String subIou) {
		this.subIou = subIou;
	}*/

	public String getWorkLocation() {
		return workLocation;
	}

	public void setWorkLocation(String workLocation) {
		this.workLocation = workLocation;
	}

	public String getWorkCountry() {
		return workCountry;
	}

	public void setWorkCountry(String workCountry) {
		this.workCountry = workCountry;
	}

	public String getProjectLocationIndia() {
		return projectLocationIndia;
	}

	public void setProjectLocationIndia(String projectLocationIndia) {
		this.projectLocationIndia = projectLocationIndia;
	}

	public Date getAllocationEndDate() {
		return allocationEndDate;
	}

	public void setAllocationEndDate(Date allocationEndDate) {
		this.allocationEndDate = allocationEndDate;
	}

	public Date getAllocationStartDate() {
		return allocationStartDate;
	}

	public void setAllocationStartDate(Date allocationStartDate) {
		this.allocationStartDate = allocationStartDate;
	}

	public String getWonOrSwon() {
		return wonOrSwon;
	}

	public void setWonOrSwon(String wonOrSwon) {
		this.wonOrSwon = wonOrSwon;
	}

	public String getEmpSupervisorNumber() {
		return empSupervisorNumber;
	}

	public void setEmpSupervisorNumber(String empSupervisorNumber) {
		this.empSupervisorNumber = empSupervisorNumber;
	}

	public String getEmpSupervisorName() {
		return empSupervisorName;
	}

	public void setEmpSupervisorName(String empSupervisorName) {
		this.empSupervisorName = empSupervisorName;
	}

	public String getSeniorOrJunior() {
		return seniorOrJunior;
	}

	public void setSeniorOrJunior(String seniorOrJunior) {
		this.seniorOrJunior = seniorOrJunior;
	}
	
	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "UserMasterData [empNumber=" + empNumber + ", empName=" + empName + ", portalGroup=" + role
				+ ", teamRole=" + teamRole + ", customer=" + customer + ", iou=" + iou + ", subIou=" + segment
				+ ", workLocation=" + workLocation + ", workCountry=" + workCountry + ", projectLocationIndia="
				+ projectLocationIndia + ", allocationEndDate=" + allocationEndDate + ", allocationStartDate="
				+ allocationStartDate + ", wonOrSwon=" + wonOrSwon + ", empSupervisorNumber=" + empSupervisorNumber
				+ ", empSupervisorName=" + empSupervisorName + ", seniorOrJunior=" + seniorOrJunior + ",  account=" + account +"]";
	}	
	
}

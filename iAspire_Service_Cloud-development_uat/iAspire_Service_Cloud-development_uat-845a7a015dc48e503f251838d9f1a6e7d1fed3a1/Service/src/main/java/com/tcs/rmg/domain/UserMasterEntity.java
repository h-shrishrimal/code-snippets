package com.tcs.rmg.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_master", schema= "global_login")
public class UserMasterEntity {
	
		@Id
		@Column(name="emp_no")
		private String empNo;
		
		@Column(name="emp_name")
		private String empName;
		
		@Column(name="portal_group")
		private String role;
		
		@Column(name="team_role")
		private String teamRole;
		
		@Column(name="customer")
		private String account;
		
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
		
		@Column(name="person_type")
		private String personType;
		
		@Column(name="total_experience")
		private String totExperience;
		
		@Column(name="depute_branch")
		private String deputeBranch;
		
		@Column(name = "emp_am_no")
		private Integer empAMNumber;

		@Column(name = "emp_am_name")
		private String empAMName;

		@Column(name = "emp_brm_no")
		private Integer empBRMNumber;

		@Column(name = "emp_brm_name")
		private String empBRMName;

		@Column(name = "emp_rm_no")
		private Integer empRMNumber;

		@Column(name = "emp_rm_name")
		private String empRMName;

		@Column(name = "emp_gl_no")
		private Integer empGLNumber;

		@Column(name = "emp_gl_name")
		private String empGLName;

		@Column(name = "emp_pl_no")
		private Integer empPLNumber;

		@Column(name = "emp_pl_name")
		private String empPLName;

		@Column(name = "employee_depute_country")
		private String employeeDeputeCountry;
		
		@Column(name = "tfactor_flag")
		private String tfactorFlag;
		
		public String getEmpNo() {
			return empNo;
		}

		public void setEmpNo(String empNo) {
			this.empNo = empNo;
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

		public String getIou() {
			return iou;
		}

		public String getAccount() {
			return account;
		}

		public void setAccount(String account) {
			this.account = account;
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

		public String getGrade() {
			return grade;
		}

		public void setGrade(String grade) {
			this.grade = grade;
		}

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

		public String getDesignation() {
			return designation;
		}

		public void setDesignation(String designation) {
			this.designation = designation;
		}

		public String getPersonType() {
			return personType;
		}

		public void setPersonType(String personType) {
			this.personType = personType;
		}

		public String getTotExperience() {
			return totExperience;
		}

		public void setTotExperience(String totExperience) {
			this.totExperience = totExperience;
		}
		
		public String getDeputeBranch() {
			return deputeBranch;
		}

		public void setDeputeBranch(String deputeBranch) {
			this.deputeBranch = deputeBranch;
		}

		public Integer getEmpAMNumber() {
			return empAMNumber;
		}

		public void setEmpAMNumber(Integer empAMNumber) {
			this.empAMNumber = empAMNumber;
		}

		public String getEmpAMName() {
			return empAMName;
		}

		public void setEmpAMName(String empAMName) {
			this.empAMName = empAMName;
		}

		public Integer getEmpBRMNumber() {
			return empBRMNumber;
		}

		public void setEmpBRMNumber(Integer empBRMNumber) {
			this.empBRMNumber = empBRMNumber;
		}

		public String getEmpBRMName() {
			return empBRMName;
		}

		public void setEmpBRMName(String empBRMName) {
			this.empBRMName = empBRMName;
		}

		public Integer getEmpRMNumber() {
			return empRMNumber;
		}

		public void setEmpRMNumber(Integer empRMNumber) {
			this.empRMNumber = empRMNumber;
		}

		public String getEmpRMName() {
			return empRMName;
		}

		public void setEmpRMName(String empRMName) {
			this.empRMName = empRMName;
		}

		public Integer getEmpGLNumber() {
			return empGLNumber;
		}

		public void setEmpGLNumber(Integer empGLNumber) {
			this.empGLNumber = empGLNumber;
		}

		public String getEmpGLName() {
			return empGLName;
		}

		public void setEmpGLName(String empGLName) {
			this.empGLName = empGLName;
		}

		public Integer getEmpPLNumber() {
			return empPLNumber;
		}

		public void setEmpPLNumber(Integer empPLNumber) {
			this.empPLNumber = empPLNumber;
		}

		public String getEmpPLName() {
			return empPLName;
		}

		public void setEmpPLName(String empPLName) {
			this.empPLName = empPLName;
		}

		public String getEmployeeDeputeCountry() {
			return employeeDeputeCountry;
		}

		public void setEmployeeDeputeCountry(String employeeDeputeCountry) {
			this.employeeDeputeCountry = employeeDeputeCountry;
		}
		
		public String getTfactorFlag() {
			return tfactorFlag;
		}

		public void setTfactorFlag(String tfactorFlag) {
			this.tfactorFlag = tfactorFlag;
		}

		@Override
		public String toString() {
			return "UserMasterEntity [empNo=" + empNo + ", empName=" + empName + ", role=" + role + ", teamRole="
					+ teamRole + ", account=" + account + ", iou=" + iou + ", segment=" + segment + ", workLocation="
					+ workLocation + ", workCountry=" + workCountry + ", projectLocationIndia=" + projectLocationIndia
					+ ", allocationEndDate=" + allocationEndDate + ", allocationStartDate=" + allocationStartDate
					+ ", wonOrSwon=" + wonOrSwon + ", empSupervisorNumber=" + empSupervisorNumber
					+ ", empSupervisorName=" + empSupervisorName + ", seniorOrJunior=" + seniorOrJunior + ", grade="
					+ grade + ", designation=" + designation + ", personType=" + personType + ", totExperience="
					+ totExperience + ", deputeBranch=" + deputeBranch + "]";
		}
}

/*package com.tcs.rmg.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee_master_rmg_proc", schema = "rmg_app")
public class EmployeeDetails {

	@Id
	@Column(name = "Employee_Number")
	private Integer employeeNumber;

	@Column(name = "Employee_Name")
	private String employeeName;

	@Column(name = "Email_Address")
	private String emailAddress;

	@Column(name = "Grade")
	private String grade;

	@Column(name = "Designation")
	private String designation;

	@Column(name = "Male_Female")
	private String gender;

	@Column(name = "Employee_Department")
	private String employeeDepartment;

	@Column(name = "Department")
	private String department;

	@Column(name = "Birth_date")
	private String birthDate;

	@Column(name = "Base_Country")
	private String baseCountry;

	@Column(name = "Base_Branch")
	private String baseBranch;

	@Column(name = "TCS_Experience_yrs")
	private Integer tcsExperience;

	@Column(name = "Prev_Experience_yrs")
	private Integer previousExperience;

	@Column(name = "Total_Experience_yrs")
	private Integer totalExperience;

	@Column(name = "Portal_Group")
	private String portalGroup;

	@Column(name = "Team_Role")
	private String teamRole;

	@Column(name = "Parent_Project_no")
	private Integer parentProjectNo;

	@Column(name = "Project_no")
	private Integer projectNo;

	@Column(name = "Project_Name")
	private String projectName;

	@Column(name = "Project_Description")
	private String projectDescription;

	@Column(name = "Project_Status")
	private String projectStatus;

	@Column(name = "Project_Type")
	private String projectType;

	@Column(name = "Business")
	private String business;

	@Column(name = "Customer")
	private String customer;

	@Column(name = "GE_Business")
	private String geBusiness;

	@Column(name = "Account_Head")
	private String accountHead;

	@Column(name = "Sub_Group_Customer")
	private String subGroupCustomer;

	@Column(name = "IOU")
	private String iou;

	@Column(name = "SUB_IOU")
	private String subIOU;

	@Column(name = "Parent_IOU_Name")
	private String parentIOUName;

	@Column(name = "Child_IOU_Name")
	private String childIOUName;

	@Column(name = "Delivery_Centre")
	private String deliveryCentre;

	@Column(name = "Excecuting_DC")
	private String executingDC;

	@Column(name = "Excecuting_DC_Branch")
	private String executingDCBranch;

	@Column(name = "Employee_Depute_DC")
	private String employeeDeputeDC;

	@Column(name = "Depute_Branch")
	private String deputeBranch;

	@Column(name = "Work_City")
	private String workCity;

	@Column(name = "Work_Country")
	private String workCountry;

	@Column(name = "Project_Location")
	private String projectLocation;

	@Column(name = "Project_Location_wrt_india")
	private String projectLocationWrtIndia;

	@Column(name = "Onsite_Offshore")
	private String onsiteOffShore;

	@Column(name = "HR_Branch")
	private String hrBranch;

	@Column(name = "HRMS_Location")
	private String hrmsLocation;

	@Column(name = "Location")
	private String location;

	@Column(name = "Country")
	private String country;

	@Column(name = "Offshore_Branch")
	private String offshoreBranch;

	@Column(name = "Offshore_DC")
	private String offshoreDC;

	@Column(name = "Executing_Company_Name")
	private String executingCompanyName;

	@Column(name = "Front_Ending_Company_Name")
	private String frontEndingCompanyName;

	@Column(name = "Allocation_End_Date")
	private String allocationEndDate;

	@Column(name = "Allocation_Start_Date")
	private String allocationStartDate;

	@Column(name = "WON_OR_SWON")
	private String wonOrSwon;

	@Column(name = "SWON_Category")
	private String swonCategory;

	@Column(name = "Type")
	private String type;

	@Column(name = "PL_no")
	private Integer plNo;

	@Column(name = "Project_Leader_Employee_Number")
	private Integer plEmployeeNumber;

	@Column(name = "PL")
	private String pl;

	@Column(name = "Project_Leader_Email")
	private String plEmail;

	@Column(name = "AM_Employee_Number")
	private Integer amEmployeeNumber;

	@Column(name = "AM")
	private String am;

	@Column(name = "AM_Email")
	private String amEmail;

	@Column(name = "BRM_Employee_Number")
	private Integer brmEmployeeNumber;

	@Column(name = "BRM")
	private String brm;

	@Column(name = "BRM_Email")
	private String brmEmail;

	@Column(name = "RM_Employee_Number")
	private Integer rmEmployeeNumber;

	@Column(name = "RM")
	private String rm;

	@Column(name = "RM_Email")
	private String rmEmail;

	@Column(name = "GL_Emp_no")
	private Integer glEmpNo;

	@Column(name = "GL")
	private String gl;

	@Column(name = "GL_Email")
	private String glEmail;

	@Column(name = "Supervisor_Employee_Number")
	private Integer supervisorEmployeeNumber;

	@Column(name = "Supervisor_Number")
	private Integer supervisorNumber;

	@Column(name = "Supervisor")
	private String supervisor;

	@Column(name = "Supervisor_Name")
	private String supervisorName;

	@Column(name = "Deputy_Owner")
	private String deputyOwner;

	@Column(name = "Owner_Employee_Number")
	private Integer ownerEmployeeNumber;

	@Column(name = "Project_Owner")
	private String projectOwner;

	@Column(name = "derived_supervisor_empno")
	private Integer derivedSupervisorEmpno;

	@Column(name = "derived_supervisor")
	private String derivedSupervisor;

	@Column(name = "derived_supervisor_email")
	private String derivedSupervisorEmail;

	@Column(name = "valid")
	private String valid;

	@Column(name = "BA_COMPANY")
	private String baCompany;

	@Column(name = "UPDATED_DATE")
	private String updatedDate;

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

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmployeeDepartment() {
		return employeeDepartment;
	}

	public void setEmployeeDepartment(String employeeDepartment) {
		this.employeeDepartment = employeeDepartment;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getBaseBranch() {
		return baseBranch;
	}

	public void setBaseBranch(String baseBranch) {
		this.baseBranch = baseBranch;
	}

	public String getBaseCountry() {
		return baseCountry;
	}

	public void setBaseCountry(String baseCountry) {
		this.baseCountry = baseCountry;
	}

	public Integer getTcsExperience() {
		return tcsExperience;
	}

	public void setTcsExperience(Integer tcsExperience) {
		this.tcsExperience = tcsExperience;
	}

	public Integer getPreviousExperience() {
		return previousExperience;
	}

	public void setPreviousExperience(Integer previousExperience) {
		this.previousExperience = previousExperience;
	}

	public Integer getTotalExperience() {
		return totalExperience;
	}

	public void setTotalExperience(Integer totalExperience) {
		this.totalExperience = totalExperience;
	}

	public String getPortalGroup() {
		return portalGroup;
	}

	public void setPortalGroup(String portalGroup) {
		this.portalGroup = portalGroup;
	}

	public String getTeamRole() {
		return teamRole;
	}

	public void setTeamRole(String teamRole) {
		this.teamRole = teamRole;
	}

	public Integer getParentProjectNo() {
		return parentProjectNo;
	}

	public void setParentProjectNo(Integer parentProjectNo) {
		this.parentProjectNo = parentProjectNo;
	}

	public Integer getProjectNumber() {
		return projectNo;
	}

	public void setProjectNumber(Integer projectNo) {
		this.projectNo = projectNo;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectStatus() {
		return projectStatus;
	}

	public void setProjectStatus(String projectStatus) {
		this.projectStatus = projectStatus;
	}

	public String getProjectDescription() {
		return projectDescription;
	}

	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}

	public String getProjectType() {
		return projectType;
	}

	public void setProjectType(String projectType) {
		this.projectType = projectType;
	}

	public String getBusiness() {
		return business;
	}

	public void setBusiness(String business) {
		this.business = business;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getGeBusiness() {
		return geBusiness;
	}

	public void setGeBusiness(String geBusiness) {
		this.geBusiness = geBusiness;
	}

	public String getAccountHead() {
		return accountHead;
	}

	public void setAccountHead(String accountHead) {
		this.accountHead = accountHead;
	}

	public String getSubGroupCustomer() {
		return subGroupCustomer;
	}

	public void setSubGroupCustomer(String subGroupCustomer) {
		this.subGroupCustomer = subGroupCustomer;
	}

	public String getIou() {
		return iou;
	}

	public void setIou(String iou) {
		this.iou = iou;
	}

	public String getSubIOU() {
		return subIOU;
	}

	public void setSubIOU(String subIOU) {
		this.subIOU = subIOU;
	}

	public String getParentIouName() {
		return parentIOUName;
	}

	public void setParentIOUName(String parentIOUName) {
		this.parentIOUName = parentIOUName;
	}

	public String getchildIOUName() {
		return childIOUName;
	}

	public void setChildIOUName(String childIOUName) {
		this.childIOUName = childIOUName;
	}

	public String getDeliveryCentre() {
		return deliveryCentre;
	}

	public void setDeliveryCentre(String deliveryCentre) {
		this.deliveryCentre = deliveryCentre;
	}

	public String getExecutingDC() {
		return executingDC;
	}

	public void setExecutingDC(String executingDC) {
		this.executingDC = executingDC;
	}

	public String getExecutingDCBranch() {
		return executingDCBranch;
	}

	public void setExecutingDCBranch(String executingDCBranch) {
		this.executingDCBranch = executingDCBranch;
	}

	public String getEmployeeDeputeDC() {
		return employeeDeputeDC;
	}

	public void setEmployeeDeputeDC(String employeeDeputeDC) {
		this.employeeDeputeDC = employeeDeputeDC;
	}

	public String getDeputeBranch() {
		return deputeBranch;
	}

	public void setDeputeBranch(String deputeBranch) {
		this.deputeBranch = deputeBranch;
	}

	public String getWorkCity() {
		return workCity;
	}

	public void setWorkCity(String workCity) {
		this.workCity = workCity;
	}

	public String getWorkCountry() {
		return workCountry;
	}

	public void setWorkCountry(String workCountry) {
		this.workCountry = workCountry;
	}

	public String getProjectLocation() {
		return projectLocation;
	}

	public void setProjectLocation(String projectLocation) {
		this.projectLocation = projectLocation;
	}

	public String getProjectLocationWrtIndia() {
		return projectLocationWrtIndia;
	}

	public void setProjectLocationWrtIndia(String projectLocationWrtIndia) {
		this.projectLocationWrtIndia = projectLocationWrtIndia;
	}

	public String getOnsiteOffShore() {
		return onsiteOffShore;
	}

	public void setOnsiteOffShore(String OnsiteOffShore) {
		this.onsiteOffShore = OnsiteOffShore;
	}

	public String getHrBranch() {
		return hrBranch;
	}

	public void setHrBranch(String hrBranch) {
		this.hrBranch = hrBranch;
	}

	public String getHRMSLocation() {
		return hrmsLocation;
	}

	public void setHRMSLocation(String hrmsLocation) {
		this.hrmsLocation = hrmsLocation;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getOffshoreBranch() {
		return offshoreBranch;
	}

	public void setOffshoreBranch(String offshoreBranch) {
		this.offshoreBranch = offshoreBranch;
	}

	public String getOffshoreDC() {
		return offshoreDC;
	}

	public void setOffshoreDC(String offshoreDC) {
		this.offshoreDC = offshoreDC;
	}

	public String getExecutingCompanyName() {
		return executingCompanyName;
	}

	public void setExecutingCompanyName(String executingCompanyName) {
		this.executingCompanyName = executingCompanyName;
	}

	public String getFrontEndingCompanyName() {
		return frontEndingCompanyName;
	}

	public void setFrontEndingCompanyName(String frontEndingCompanyName) {
		this.frontEndingCompanyName = frontEndingCompanyName;
	}

	public String getAllocationEndDate() {
		return allocationEndDate;
	}

	public void setAllocationEndDate(String allocationEndDate) {
		this.allocationEndDate = allocationEndDate;
	}

	public String getAllocationStartDate() {
		return allocationStartDate;
	}

	public void setAllocationStartDate(String allocationStartDate) {
		this.allocationStartDate = allocationStartDate;
	}

	public String getWonOrSwon() {
		return wonOrSwon;
	}
	

	public void setWonOrSwon(String wonOrSwon) {
		this.wonOrSwon = wonOrSwon;
	}

	public String getSwonCategory() {
		return swonCategory;
	}

	public void setSwonCategory(String swonCategory) {
		this.swonCategory = swonCategory;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getPlNo() {
		return plNo;
	}

	public void setPlNo(Integer plNo) {
		this.plNo = plNo;
	}

	public Integer getPlEmployeeNumber() {
		return plEmployeeNumber;
	}

	public void setPlEmployeeNumber(Integer plEmployeeNumber) {
		this.plEmployeeNumber = plEmployeeNumber;
	}

	public String getPl() {
		return pl;
	}

	public void setPl(String pl) {
		this.pl = pl;
	}

	public String getPlEmail() {
		return plEmail;
	}

	public void setPlEmail(String plEmail) {
		this.plEmail = plEmail;
	}

	public Integer getAmEmployeeNumber() {
		return amEmployeeNumber;
	}

	public void setAmEmployeeNumber(Integer amEmployeeNumber) {
		this.amEmployeeNumber = amEmployeeNumber;
	}

	public String getAm() {
		return am;
	}

	public void setAm(String am) {
		this.am = am;
	}

	public String getAmEmail() {
		return amEmail;
	}

	public void setAmEmail(String amEmail) {
		this.amEmail = amEmail;
	}

	public Integer getBrmEmployeeNumber() {
		return brmEmployeeNumber;
	}

	public void setBrmEmployeeNumber(Integer brmEmployeeNumber) {
		this.brmEmployeeNumber = brmEmployeeNumber;
	}

	public String getBrm() {
		return brm;
	}

	public void setBrm(String brm) {
		this.brm = brm;
	}

	public String getBrmEmail() {
		return brmEmail;
	}

	public void setBrmEmail(String brmEmail) {
		this.brmEmail = brmEmail;
	}

	public Integer getrmEmployeeNumber() {
		return rmEmployeeNumber;
	}

	public void setrmEmployeeNumber(Integer rmEmployeeNumber) {
		this.rmEmployeeNumber = rmEmployeeNumber;
	}

	public String getrm() {
		return rm;
	}

	public void setrm(String rm) {
		this.rm = rm;
	}

	public String getrmEmail() {
		return rmEmail;
	}

	public void setrmEmail(String rmEmail) {
		this.rmEmail = rmEmail;
	}

	public Integer getglEmpNo() {
		return glEmpNo;
	}

	public void setglEmpNo(Integer glEmpNo) {
		this.glEmpNo = glEmpNo;
	}

	public String getgl() {
		return gl;
	}

	public void setgl(String gl) {
		this.gl = gl;
	}

	public String getglEmail() {
		return glEmail;
	}

	public void setglEmail(String glEmail) {
		this.glEmail = glEmail;
	}

	public Integer getsupervisorEmployeeNumber() {
		return supervisorEmployeeNumber;
	}

	public void setsupervisorEmployeeNumber(Integer supervisorEmployeeNumber) {
		this.supervisorEmployeeNumber = supervisorEmployeeNumber;
	}

	public Integer getsupervisorNumber() {
		return supervisorNumber;
	}

	public void setsupervisorNumber(Integer supervisorNumber) {
		this.supervisorNumber = supervisorNumber;
	}

	public String getsupervisor() {
		return supervisor;
	}

	public void setsupervisor(String supervisor) {
		this.supervisor = supervisor;
	}

	public String getsupervisorName() {
		return supervisorName;
	}

	public void setsupervisorName(String supervisorName) {
		this.supervisorName = supervisorName;
	}

	public String getdeputyOwner() {
		return deputyOwner;
	}

	public void setdeputyOwner(String deputyOwner) {
		this.deputyOwner = deputyOwner;
	}

	public Integer getownerEmployeeNumber() {
		return ownerEmployeeNumber;
	}

	public void setownerEmployeeNumber(Integer ownerEmployeeNumber) {
		this.ownerEmployeeNumber = ownerEmployeeNumber;
	}

	public String getprojectOwner() {
		return projectOwner;
	}

	public void setprojectOwner(String projectOwner) {
		this.projectOwner = projectOwner;
	}

	public Integer getderivedSupervisorEmpno() {
		return derivedSupervisorEmpno;
	}

	public void setderivedSupervisorEmpno(Integer derivedSupervisorEmpno) {
		this.derivedSupervisorEmpno = derivedSupervisorEmpno;
	}

	public String getderivedSupervisor() {
		return derivedSupervisor;
	}

	public void setderivedSupervisor(String derivedSupervisor) {
		this.derivedSupervisor = derivedSupervisor;
	}

	public String getderivedSupervisorEmail() {
		return derivedSupervisorEmail;
	}

	public void setderivedSupervisorEmail(String derivedSupervisorEmail) {
		this.derivedSupervisorEmail = derivedSupervisorEmail;
	}

	public String getvalid() {
		return valid;
	}

	public void setvalid(String valid) {
		this.valid = valid;
	}

	public String getbaCompany() {
		return baCompany;
	}

	public void setbaCompany(String baCompany) {
		this.baCompany = baCompany;
	}

	public String getupdatedDate() {
		return updatedDate;
	}

	public void setupdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}

}
*/
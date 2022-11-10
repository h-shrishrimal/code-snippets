package com.tcs.rmg.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee_headcount", schema = "rmg_iaspire")
public class EmployeeHeadCount {

  @Id @Column(name ="employee_id") private Integer employeeId;
  @Column(name ="mlt_pool") private String mltPool;
  @Column(name ="ani_pool") private String aniPool;
  @Column(name ="employee_name") private String employeeName;
  @Column(name ="project_name") private String projectName;
  @Column(name ="date_of_joining") private String dateOfJoining;
  @Column(name ="hc_category") private String hcCategory;
  @Column(name ="parent_horizontal") private String parentHorizontal;
  @Column(name ="mapped_isu_parent") private String mappedIsuParent;
  @Column(name ="mapped_sub_isu_parent") private String mappedSubIsuParent;
  @Column(name ="mapped_isu_project") private String mappedIsuProject;
  @Column(name ="mapped_sub_isu_project") private String mappedSubIsuProject;
  @Column(name ="customer") private String customer;
  @Column(name ="group_customer") private String groupCustomer;
  @Column(name ="unique_group_customer") private String uniqueGroupCustomer;
  @Column(name ="account") private String account;
  @Column(name ="won_swon") private String wonSwon;
  @Column(name ="employee_parent_iou") private String employeeParentIou;
  @Column(name ="employee_child_iou") private String employeeChildIou;
  @Column(name ="project_iou") private String projectIou;
  @Column(name ="project_sub_iou") private String projectSubIou;
  @Column(name ="project_du") private String projectDu;
  @Column(name ="project_sub_du") private String projectSubDu;
  @Column(name ="emp_current_role") private String empCurrentRole;
  @Column(name ="person_type") private String personType;
  @Column(name ="employee_department_name") private String employeeDepartmentName;
  @Column(name ="employee_designation_name") private String employeeDesignationName;
  @Column(name ="cc_non_cc") private String ccNonCc;
  @Column(name ="employee_grade") private String employeeGrade;
  @Column(name ="mapped_grade") private String mappedGrade;
  @Column(name ="junior_middle_senior") private String juniorMiddleSenior;
  @Column(name ="it_bps") private String itBps;
  @Column(name ="same_group_customer_duration_year") private String sameGroupCustomerDurationYear;
  @Column(name ="same_customer_three_yrs_and_above") private String sameCustomerThreeYrsAndAbove;
  @Column(name ="employee_depute_sob") private String employeeDeputeSob;
  @Column(name ="employee_base_branch") private String employeeBaseBranch;
  @Column(name ="employee_base_country") private String employeeBaseCountry;
  @Column(name ="employee_base_dc") private String employeeBaseDc;
  @Column(name ="employee_depute_branch") private String employeeDeputeBranch;
  @Column(name ="employee_depute_country") private String employeeDeputeCountry;
  @Column(name ="depute_geo") private String deputeGeo;
  @Column(name ="onsite_offshore") private String onsiteOffshore;
  @Column(name ="work_location") private String workLocation;
  @Column(name ="project_description") private String projectDescription;
  @Column(name ="project_ip") private String projectIp;
  @Column(name ="project_sp") private String projectSp;
  @Column(name ="sub_sp") private String subSp;
  @Column(name ="project_sub_ip") private String projectSubIp;
  @Column(name ="work_country") private String workCountry;
  @Column(name ="work_state") private String workState;
  @Column(name ="client_geography") private String clientGeography;
  @Column(name ="client_country") private String clientCountry;
  @Column(name ="gl_emp_id") private String glEmpId;
  @Column(name ="gl_name") private String glName;
  @Column(name ="pl_emp_id") private String plEmpId;
  @Column(name ="pl_name") private String plName;
  @Column(name ="project_number") private String projectNumber;
  @Column(name ="project_owner_emp_id") private String projectOwnerEmpId;
  @Column(name ="project_owner_name") private String projectOwnerName;
  @Column(name ="project_owner_misc") private String projectOwnerMisc;
  @Column(name ="project_type") private String projectType;
  @Column(name ="employee_location") private String employeeLocation;
  @Column(name ="allocation_start_date") private String allocationStartDate;
  @Column(name ="allocation_end_date") private String allocationEndDate;
  @Column(name ="age") private String age;
  @Column(name ="gender") private String gender;
  @Column(name ="prev_rel_expin_yrs") private String prevRelExpinYrs;
  @Column(name ="tcs_expin_yrs") private String tcsExpinYrs;
  @Column(name ="total_rel_expin_yrs") private String totalRelExpinYrs;
  @Column(name ="ba_company_name") private String baCompanyName;
  @Column(name ="nationality") private String nationality;
  @Column(name ="travel_country") private String travelCountry;
  @Column(name ="travel_type") private String travelType;
  @Column(name ="assignment_status") private String assignmentStatus;
  @Column(name ="employee_organization") private String employeeOrganization;
  @Column(name ="employee_cluster") private String employeeCluster;
  @Column(name ="expat_local") private String expatLocal;
  @Column(name ="high_performer_two_years_band") private String highPerformerTwoYearsBand;
  @Column(name ="email_id") private String emailId;
  @Column(name ="span_of_control_total") private String spanOfControlTotal;


  public Integer getEmployeeId() {
    return employeeId;
  }

  public void setEmployeeId(Integer employeeId) {
    this.employeeId = employeeId;
  }

  public String getMltPool() {
    return mltPool;
  }

  public void setMltPool(String mltPool) {
    this.mltPool = mltPool;
  }

  public String getAniPool() {
    return aniPool;
  }

  public void setAniPool(String aniPool) {
    this.aniPool = aniPool;
  }

  public String getEmployeeName() {
    return employeeName;
  }

  public void setEmployeeName(String employeeName) {
    this.employeeName = employeeName;
  }

  public String getProjectName() {
    return projectName;
  }

  public void setProjectName(String projectName) {
    this.projectName = projectName;
  }

  public String getDateOfJoining() {
    return dateOfJoining;
  }

  public void setDateOfJoining(String dateOfJoining) {
    this.dateOfJoining = dateOfJoining;
  }

  public String getHcCategory() {
    return hcCategory;
  }

  public void setHcCategory(String hcCategory) {
    this.hcCategory = hcCategory;
  }

  public String getParentHorizontal() {
    return parentHorizontal;
  }

  public void setParentHorizontal(String parentHorizontal) {
    this.parentHorizontal = parentHorizontal;
  }

  public String getMappedIsuParent() {
    return mappedIsuParent;
  }

  public void setMappedIsuParent(String mappedIsuParent) {
    this.mappedIsuParent = mappedIsuParent;
  }

  public String getMappedSubIsuParent() {
    return mappedSubIsuParent;
  }

  public void setMappedSubIsuParent(String mappedSubIsuParent) {
    this.mappedSubIsuParent = mappedSubIsuParent;
  }

  public String getMappedIsuProject() {
    return mappedIsuProject;
  }

  public void setMappedIsuProject(String mappedIsuProject) {
    this.mappedIsuProject = mappedIsuProject;
  }

  public String getMappedSubIsuProject() {
    return mappedSubIsuProject;
  }

  public void setMappedSubIsuProject(String mappedSubIsuProject) {
    this.mappedSubIsuProject = mappedSubIsuProject;
  }

  public String getCustomer() {
    return customer;
  }

  public void setCustomer(String customer) {
    this.customer = customer;
  }

  public String getGroupCustomer() {
    return groupCustomer;
  }

  public void setGroupCustomer(String groupCustomer) {
    this.groupCustomer = groupCustomer;
  }

  public String getUniqueGroupCustomer() {
    return uniqueGroupCustomer;
  }

  public void setUniqueGroupCustomer(String uniqueGroupCustomer) {
    this.uniqueGroupCustomer = uniqueGroupCustomer;
  }

  public String getAccount() {
    return account;
  }

  public void setAccount(String account) {
    this.account = account;
  }

  public String getWonSwon() {
    return wonSwon;
  }

  public void setWonSwon(String wonSwon) {
    this.wonSwon = wonSwon;
  }

  public String getEmployeeParentIou() {
    return employeeParentIou;
  }

  public void setEmployeeParentIou(String employeeParentIou) {
    this.employeeParentIou = employeeParentIou;
  }

  public String getEmployeeChildIou() {
    return employeeChildIou;
  }

  public void setEmployeeChildIou(String employeeChildIou) {
    this.employeeChildIou = employeeChildIou;
  }

  public String getProjectIou() {
    return projectIou;
  }

  public void setProjectIou(String projectIou) {
    this.projectIou = projectIou;
  }

  public String getProjectSubIou() {
    return projectSubIou;
  }

  public void setProjectSubIou(String projectSubIou) {
    this.projectSubIou = projectSubIou;
  }

  public String getProjectDu() {
    return projectDu;
  }

  public void setProjectDu(String projectDu) {
    this.projectDu = projectDu;
  }

  public String getProjectSubDu() {
    return projectSubDu;
  }

  public void setProjectSubDu(String projectSubDu) {
    this.projectSubDu = projectSubDu;
  }

  public String getEmpCurrentRole() {
    return empCurrentRole;
  }

  public void setEmpCurrentRole(String empCurrentRole) {
    this.empCurrentRole = empCurrentRole;
  }

  public String getPersonType() {
    return personType;
  }

  public void setPersonType(String personType) {
    this.personType = personType;
  }

  public String getEmployeeDepartmentName() {
    return employeeDepartmentName;
  }

  public void setEmployeeDepartmentName(String employeeDepartmentName) {
    this.employeeDepartmentName = employeeDepartmentName;
  }

  public String getEmployeeDesignationName() {
    return employeeDesignationName;
  }

  public void setEmployeeDesignationName(String employeeDesignationName) {
    this.employeeDesignationName = employeeDesignationName;
  }

  public String getCcNonCc() {
    return ccNonCc;
  }

  public void setCcNonCc(String ccNonCc) {
    this.ccNonCc = ccNonCc;
  }

  public String getEmployeeGrade() {
    return employeeGrade;
  }

  public void setEmployeeGrade(String employeeGrade) {
    this.employeeGrade = employeeGrade;
  }

  public String getMappedGrade() {
    return mappedGrade;
  }

  public void setMappedGrade(String mappedGrade) {
    this.mappedGrade = mappedGrade;
  }

  public String getJuniorMiddleSenior() {
    return juniorMiddleSenior;
  }

  public void setJuniorMiddleSenior(String juniorMiddleSenior) {
    this.juniorMiddleSenior = juniorMiddleSenior;
  }

  public String getItBps() {
    return itBps;
  }

  public void setItBps(String itBps) {
    this.itBps = itBps;
  }

  public String getSameGroupCustomerDurationYear() {
    return sameGroupCustomerDurationYear;
  }

  public void setSameGroupCustomerDurationYear(String sameGroupCustomerDurationYear) {
    this.sameGroupCustomerDurationYear = sameGroupCustomerDurationYear;
  }

  public String getSameCustomerThreeYrsAndAbove() {
    return sameCustomerThreeYrsAndAbove;
  }

  public void setSameCustomerThreeYrsAndAbove(String sameCustomerThreeYrsAndAbove) {
    this.sameCustomerThreeYrsAndAbove = sameCustomerThreeYrsAndAbove;
  }

  public String getEmployeeDeputeSob() {
    return employeeDeputeSob;
  }

  public void setEmployeeDeputeSob(String employeeDeputeSob) {
    this.employeeDeputeSob = employeeDeputeSob;
  }

  public String getEmployeeBaseBranch() {
    return employeeBaseBranch;
  }

  public void setEmployeeBaseBranch(String employeeBaseBranch) {
    this.employeeBaseBranch = employeeBaseBranch;
  }

  public String getEmployeeBaseCountry() {
    return employeeBaseCountry;
  }

  public void setEmployeeBaseCountry(String employeeBaseCountry) {
    this.employeeBaseCountry = employeeBaseCountry;
  }

  public String getEmployeeBaseDc() {
    return employeeBaseDc;
  }

  public void setEmployeeBaseDc(String employeeBaseDc) {
    this.employeeBaseDc = employeeBaseDc;
  }

  public String getEmployeeDeputeBranch() {
    return employeeDeputeBranch;
  }

  public void setEmployeeDeputeBranch(String employeeDeputeBranch) {
    this.employeeDeputeBranch = employeeDeputeBranch;
  }

  public String getEmployeeDeputeCountry() {
    return employeeDeputeCountry;
  }

  public void setEmployeeDeputeCountry(String employeeDeputeCountry) {
    this.employeeDeputeCountry = employeeDeputeCountry;
  }

  public String getDeputeGeo() {
    return deputeGeo;
  }

  public void setDeputeGeo(String deputeGeo) {
    this.deputeGeo = deputeGeo;
  }

  public String getOnsiteOffshore() {
    return onsiteOffshore;
  }

  public void setOnsiteOffshore(String onsiteOffshore) {
    this.onsiteOffshore = onsiteOffshore;
  }

  public String getWorkLocation() {
    return workLocation;
  }

  public void setWorkLocation(String workLocation) {
    this.workLocation = workLocation;
  }

  public String getProjectDescription() {
    return projectDescription;
  }

  public void setProjectDescription(String projectDescription) {
    this.projectDescription = projectDescription;
  }

  public String getProjectIp() {
    return projectIp;
  }

  public void setProjectIp(String projectIp) {
    this.projectIp = projectIp;
  }

  public String getProjectSp() {
    return projectSp;
  }

  public void setProjectSp(String projectSp) {
    this.projectSp = projectSp;
  }

  public String getSubSp() {
    return subSp;
  }

  public void setSubSp(String subSp) {
    this.subSp = subSp;
  }

  public String getProjectSubIp() {
    return projectSubIp;
  }

  public void setProjectSubIp(String projectSubIp) {
    this.projectSubIp = projectSubIp;
  }

  public String getWorkCountry() {
    return workCountry;
  }

  public void setWorkCountry(String workCountry) {
    this.workCountry = workCountry;
  }

  public String getWorkState() {
    return workState;
  }

  public void setWorkState(String workState) {
    this.workState = workState;
  }

  public String getClientGeography() {
    return clientGeography;
  }

  public void setClientGeography(String clientGeography) {
    this.clientGeography = clientGeography;
  }

  public String getClientCountry() {
    return clientCountry;
  }

  public void setClientCountry(String clientCountry) {
    this.clientCountry = clientCountry;
  }

  public String getGlEmpId() {
    return glEmpId;
  }

  public void setGlEmpId(String glEmpId) {
    this.glEmpId = glEmpId;
  }

  public String getGlName() {
    return glName;
  }

  public void setGlName(String glName) {
    this.glName = glName;
  }

  public String getPlEmpId() {
    return plEmpId;
  }

  public void setPlEmpId(String plEmpId) {
    this.plEmpId = plEmpId;
  }

  public String getPlName() {
    return plName;
  }

  public void setPlName(String plName) {
    this.plName = plName;
  }

  public String getProjectNumber() {
    return projectNumber;
  }

  public void setProjectNumber(String projectNumber) {
    this.projectNumber = projectNumber;
  }

  public String getProjectOwnerEmpId() {
    return projectOwnerEmpId;
  }

  public void setProjectOwnerEmpId(String projectOwnerEmpId) {
    this.projectOwnerEmpId = projectOwnerEmpId;
  }

  public String getProjectOwnerName() {
    return projectOwnerName;
  }

  public void setProjectOwnerName(String projectOwnerName) {
    this.projectOwnerName = projectOwnerName;
  }

  public String getProjectOwnerMisc() {
    return projectOwnerMisc;
  }

  public void setProjectOwnerMisc(String projectOwnerMisc) {
    this.projectOwnerMisc = projectOwnerMisc;
  }

  public String getProjectType() {
    return projectType;
  }

  public void setProjectType(String projectType) {
    this.projectType = projectType;
  }

  public String getEmployeeLocation() {
    return employeeLocation;
  }

  public void setEmployeeLocation(String employeeLocation) {
    this.employeeLocation = employeeLocation;
  }

  public String getAllocationStartDate() {
    return allocationStartDate;
  }

  public void setAllocationStartDate(String allocationStartDate) {
    this.allocationStartDate = allocationStartDate;
  }

  public String getAllocationEndDate() {
    return allocationEndDate;
  }

  public void setAllocationEndDate(String allocationEndDate) {
    this.allocationEndDate = allocationEndDate;
  }

  public String getAge() {
    return age;
  }

  public void setAge(String age) {
    this.age = age;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public String getPrevRelExpinYrs() {
    return prevRelExpinYrs;
  }

  public void setPrevRelExpinYrs(String prevRelExpinYrs) {
    this.prevRelExpinYrs = prevRelExpinYrs;
  }

  public String getTcsExpinYrs() {
    return tcsExpinYrs;
  }

  public void setTcsExpinYrs(String tcsExpinYrs) {
    this.tcsExpinYrs = tcsExpinYrs;
  }

  public String getTotalRelExpinYrs() {
    return totalRelExpinYrs;
  }

  public void setTotalRelExpinYrs(String totalRelExpinYrs) {
    this.totalRelExpinYrs = totalRelExpinYrs;
  }

  public String getBaCompanyName() {
    return baCompanyName;
  }

  public void setBaCompanyName(String baCompanyName) {
    this.baCompanyName = baCompanyName;
  }

  public String getNationality() {
    return nationality;
  }

  public void setNationality(String nationality) {
    this.nationality = nationality;
  }

  public String getTravelCountry() {
    return travelCountry;
  }

  public void setTravelCountry(String travelCountry) {
    this.travelCountry = travelCountry;
  }

  public String getTravelType() {
    return travelType;
  }

  public void setTravelType(String travelType) {
    this.travelType = travelType;
  }

  public String getAssignmentStatus() {
    return assignmentStatus;
  }

  public void setAssignmentStatus(String assignmentStatus) {
    this.assignmentStatus = assignmentStatus;
  }

  public String getEmployeeOrganization() {
    return employeeOrganization;
  }

  public void setEmployeeOrganization(String employeeOrganization) {
    this.employeeOrganization = employeeOrganization;
  }

  public String getEmployeeCluster() {
    return employeeCluster;
  }

  public void setEmployeeCluster(String employeeCluster) {
    this.employeeCluster = employeeCluster;
  }

  public String getExpatLocal() {
    return expatLocal;
  }

  public void setExpatLocal(String expatLocal) {
    this.expatLocal = expatLocal;
  }

  public String getHighPerformerTwoYearsBand() {
    return highPerformerTwoYearsBand;
  }

  public void setHighPerformerTwoYearsBand(String highPerformerTwoYearsBand) {
    this.highPerformerTwoYearsBand = highPerformerTwoYearsBand;
  }

  public String getEmailId() {
    return emailId;
  }

  public void setEmailId(String emailId) {
    this.emailId = emailId;
  }

  public String getSpanOfControlTotal() {
    return spanOfControlTotal;
  }

  public void setSpanOfControlTotal(String spanOfControlTotal) {
    this.spanOfControlTotal = spanOfControlTotal;
  }
}

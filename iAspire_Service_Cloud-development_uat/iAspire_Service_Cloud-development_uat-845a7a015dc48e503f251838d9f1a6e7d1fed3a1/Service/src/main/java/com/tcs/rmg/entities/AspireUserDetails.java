package com.tcs.rmg.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "emp_user_details", schema = "rmg_iaspire")
public class AspireUserDetails {

  @Id @Column(name ="employee_number") private Integer employeeNumber;
  @Column(name ="employee_grade") private String employeeGrade;
  @Column(name ="local_expat") private String localExpat;
  @Column(name ="assignment_status") private String assignmentStatus;
  @Column(name ="employee_depute_branch") private String employeeDeputeBranch;
  @Column(name ="region") private String region;
  @Column(name ="geography") private String geography;
  @Column(name ="group_customer") private String groupCustomer;
  @Column(name ="project_iou") private String projectIou;
  @Column(name ="project_type") private String projectType;
  @Column(name ="department") private String department;
  @Column(name ="employee_parent_iou") private String employeeParentIou;
  @Column(name ="mapped_parent_ou_excluding_bps") private String mappedParentOuExcludingBps;
  @Column(name ="mapped_sub_iou_parent_ou_excluding_bps") private String mappedSubIouParentOuExcludingBps;
  @Column(name ="mapped_project_ou") private String mappedProjectOu;
  @Column(name ="mapped_sub_project_ou") private String mappedSubProjectOu;
  @Column(name ="tcs_exp") private String tcsExp;
  @Column(name ="total_rel_exp") private String totalRelExp;
  @Column(name ="won_swon") private String wonSwon;
  @Column(name ="delivery_unit") private String deliveryUnit;
  @Column(name ="bg") private String bg;
  @Column(name ="emp_role") private String empRole;
  @Column(name ="mlt_pool_category") private String mltPoolCategory;
  @Column(name ="status") private String status;
  @Column(name ="completion_certification_id") private String completionCertificationId;
  @Column(name ="completion_certification_name") private String completionCertificationName;
  @Column(name ="completion_date") private String completionDate;
  @Column(name ="unlock_other_isu") private String unlockOtherIsu;

  public String getUnlockOtherIsu() {
    return unlockOtherIsu;
  }

  public void setUnlockOtherIsu(String unlockOtherIsu) {
    this.unlockOtherIsu = unlockOtherIsu;
  }

  public Integer getEmployeeNumber() {
    return employeeNumber;
  }

  public void setEmployeeNumber(Integer employeeNumber) {
    this.employeeNumber = employeeNumber;
  }

  public String getEmployeeGrade() {
    return employeeGrade;
  }

  public void setEmployeeGrade(String employeeGrade) {
    this.employeeGrade = employeeGrade;
  }

  public String getLocalExpat() {
    return localExpat;
  }

  public void setLocalExpat(String localExpat) {
    this.localExpat = localExpat;
  }

  public String getAssignmentStatus() {
    return assignmentStatus;
  }

  public void setAssignmentStatus(String assignmentStatus) {
    this.assignmentStatus = assignmentStatus;
  }

  public String getEmployeeDeputeBranch() {
    return employeeDeputeBranch;
  }

  public void setEmployeeDeputeBranch(String employeeDeputeBranch) {
    this.employeeDeputeBranch = employeeDeputeBranch;
  }

  public String getRegion() {
    return region;
  }

  public void setRegion(String region) {
    this.region = region;
  }

  public String getGeography() {
    return geography;
  }

  public void setGeography(String geography) {
    this.geography = geography;
  }

  public String getGroupCustomer() {
    return groupCustomer;
  }

  public void setGroupCustomer(String groupCustomer) {
    this.groupCustomer = groupCustomer;
  }

  public String getProjectIou() {
    return projectIou;
  }

  public void setProjectIou(String projectIou) {
    this.projectIou = projectIou;
  }

  public String getProjectType() {
    return projectType;
  }

  public void setProjectType(String projectType) {
    this.projectType = projectType;
  }

  public String getDepartment() {
    return department;
  }

  public void setDepartment(String department) {
    this.department = department;
  }

  public String getEmployeeParentIou() {
    return employeeParentIou;
  }

  public void setEmployeeParentIou(String employeeParentIou) {
    this.employeeParentIou = employeeParentIou;
  }

  public String getMappedParentOuExcludingBps() {
    return mappedParentOuExcludingBps;
  }

  public void setMappedParentOuExcludingBps(String mappedParentOuExcludingBps) {
    this.mappedParentOuExcludingBps = mappedParentOuExcludingBps;
  }

  public String getMappedSubIouParentOuExcludingBps() {
    return mappedSubIouParentOuExcludingBps;
  }

  public void setMappedSubIouParentOuExcludingBps(String mappedSubIouParentOuExcludingBps) {
    this.mappedSubIouParentOuExcludingBps = mappedSubIouParentOuExcludingBps;
  }

  public String getMappedProjectOu() {
    return mappedProjectOu;
  }

  public void setMappedProjectOu(String mappedProjectOu) {
    this.mappedProjectOu = mappedProjectOu;
  }

  public String getMappedSubProjectOu() {
    return mappedSubProjectOu;
  }

  public void setMappedSubProjectOu(String mappedSubProjectOu) {
    this.mappedSubProjectOu = mappedSubProjectOu;
  }

  public String getTcsExp() {
    return tcsExp;
  }

  public void setTcsExp(String tcsExp) {
    this.tcsExp = tcsExp;
  }

  public String getTotalRelExp() {
    return totalRelExp;
  }

  public void setTotalRelExp(String totalRelExp) {
    this.totalRelExp = totalRelExp;
  }

  public String getWonSwon() {
    return wonSwon;
  }

  public void setWonSwon(String wonSwon) {
    this.wonSwon = wonSwon;
  }

  public String getDeliveryUnit() {
    return deliveryUnit;
  }

  public void setDeliveryUnit(String deliveryUnit) {
    this.deliveryUnit = deliveryUnit;
  }

  public String getBg() {
    return bg;
  }

  public void setBg(String bg) {
    this.bg = bg;
  }

  public String getEmpRole() {
    return empRole;
  }

  public void setEmpRole(String empRole) {
    this.empRole = empRole;
  }

  public String getMltPoolCategory() {
    return mltPoolCategory;
  }

  public void setMltPoolCategory(String mltPoolCategory) {
    this.mltPoolCategory = mltPoolCategory;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getCompletionCertificationId() {
    return completionCertificationId;
  }

  public void setCompletionCertificationId(String completionCertificationId) {
    this.completionCertificationId = completionCertificationId;
  }

  public String getCompletionCertificationName() {
    return completionCertificationName;
  }

  public void setCompletionCertificationName(String completionCertificationName) {
    this.completionCertificationName = completionCertificationName;
  }

  public String getCompletionDate() {
    return completionDate;
  }

  public void setCompletionDate(String completionDate) {
    this.completionDate = completionDate;
  }
}

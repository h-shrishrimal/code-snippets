package com.tcs.rmg.entities;

import javax.persistence.*;

@Entity
@Table(name = "emp_mlt_hcr", schema = "rmg_iaspire")
public class EmpMltHcrData {
  @Id @GeneratedValue(strategy = GenerationType.SEQUENCE) private long id;
  @Column(name ="employee_number") private Integer employeeNumber;
  @Column(name ="employee_name") private String employeeName;
  @Column(name ="project_iou") private String projectIou;
  @Column(name ="employee_parent_iou") private String employeeParentIou;
  @Column(name ="employee_child_iou") private String employeeChildIou;
  @Column(name ="employee_base_branch") private String employeeBaseBranch;
  @Column(name ="employee_depute_branch") private String employeeDeputeBranch;
  @Column(name ="employee_depute_country") private String employeeDeputeCountry;
  @Column(name ="employee_depute_geography") private String employeeDeputeGeography;
  @Column(name ="employee_base_country") private String employeeBaseCountry;
  @Column(name ="group_customer") private String groupCustomer;
  @Column(name ="customer") private String customer;
  @Column(name ="project_number") private String projectNumber;
  @Column(name ="project_name") private String projectName;
  @Column(name ="competency_id") private String competencyId;
  @Column(name ="competency_name") private String competencyName;
  @Column(name ="held_level") private String heldLevel;
  @Column(name ="competency_type") private String competencyType;
  @Column(name ="category") private String category;
  @Column(name ="actual_date_of_assessment") private String actualDateOfAssessment;
  @Column(name ="holding_since") private String holdingSince;
  @Column(name ="holding_type") private String holdingType;
  @Column(name ="focus_area") private String focusArea;
  @Column(name ="sub_focus_area") private String subFocusArea;
  @Column(name ="sub_sub_focus_area") private String subSubFocusArea;
  @Column(name ="source") private String source;
  @Column(name ="competency_declaration") private String competencyDeclaration;
  @Column(name ="valid_till") private String validTill;
  @Column(name ="path_name") private String pathName;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

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

  public String getProjectIou() {
    return projectIou;
  }

  public void setProjectIou(String projectIou) {
    this.projectIou = projectIou;
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

  public String getEmployeeBaseBranch() {
    return employeeBaseBranch;
  }

  public void setEmployeeBaseBranch(String employeeBaseBranch) {
    this.employeeBaseBranch = employeeBaseBranch;
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

  public String getEmployeeDeputeGeography() {
    return employeeDeputeGeography;
  }

  public void setEmployeeDeputeGeography(String employeeDeputeGeography) {
    this.employeeDeputeGeography = employeeDeputeGeography;
  }

  public String getEmployeeBaseCountry() {
    return employeeBaseCountry;
  }

  public void setEmployeeBaseCountry(String employeeBaseCountry) {
    this.employeeBaseCountry = employeeBaseCountry;
  }

  public String getGroupCustomer() {
    return groupCustomer;
  }

  public void setGroupCustomer(String groupCustomer) {
    this.groupCustomer = groupCustomer;
  }

  public String getCustomer() {
    return customer;
  }

  public void setCustomer(String customer) {
    this.customer = customer;
  }

  public String getProjectNumber() {
    return projectNumber;
  }

  public void setProjectNumber(String projectNumber) {
    this.projectNumber = projectNumber;
  }

  public String getProjectName() {
    return projectName;
  }

  public void setProjectName(String projectName) {
    this.projectName = projectName;
  }

  public String getCompetencyId() {
    return competencyId;
  }

  public void setCompetencyId(String competencyId) {
    this.competencyId = competencyId;
  }

  public String getCompetencyName() {
    return competencyName;
  }

  public void setCompetencyName(String competencyName) {
    this.competencyName = competencyName;
  }

  public String getHeldLevel() {
    return heldLevel;
  }

  public void setHeldLevel(String heldLevel) {
    this.heldLevel = heldLevel;
  }

  public String getCompetencyType() {
    return competencyType;
  }

  public void setCompetencyType(String competencyType) {
    this.competencyType = competencyType;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public String getActualDateOfAssessment() {
    return actualDateOfAssessment;
  }

  public void setActualDateOfAssessment(String actualDateOfAssessment) {
    this.actualDateOfAssessment = actualDateOfAssessment;
  }

  public String getHoldingSince() {
    return holdingSince;
  }

  public void setHoldingSince(String holdingSince) {
    this.holdingSince = holdingSince;
  }

  public String getHoldingType() {
    return holdingType;
  }

  public void setHoldingType(String holdingType) {
    this.holdingType = holdingType;
  }

  public String getFocusArea() {
    return focusArea;
  }

  public void setFocusArea(String focusArea) {
    this.focusArea = focusArea;
  }

  public String getSubFocusArea() {
    return subFocusArea;
  }

  public void setSubFocusArea(String subFocusArea) {
    this.subFocusArea = subFocusArea;
  }

  public String getSubSubFocusArea() {
    return subSubFocusArea;
  }

  public void setSubSubFocusArea(String subSubFocusArea) {
    this.subSubFocusArea = subSubFocusArea;
  }

  public String getSource() {
    return source;
  }

  public void setSource(String source) {
    this.source = source;
  }

  public String getCompetencyDeclaration() {
    return competencyDeclaration;
  }

  public void setCompetencyDeclaration(String competencyDeclaration) {
    this.competencyDeclaration = competencyDeclaration;
  }

  public String getValidTill() {
    return validTill;
  }

  public void setValidTill(String validTill) {
    this.validTill = validTill;
  }

  public String getPathName() {
    return pathName;
  }

  public void setPathName(String pathName) {
    this.pathName = pathName;
  }
}

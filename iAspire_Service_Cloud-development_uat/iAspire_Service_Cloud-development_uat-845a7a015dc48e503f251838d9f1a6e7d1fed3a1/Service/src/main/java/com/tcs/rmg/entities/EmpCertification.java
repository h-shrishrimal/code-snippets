package com.tcs.rmg.entities;


import javax.persistence.*;

@Entity
@Table(name = "emp_certification", schema = "rmg_iaspire")
public class EmpCertification {
  @Id private long id;
  @Column(name ="employee_number") private Integer employeeNumber;
  @Column(name ="employee_name") private String employeeName;
  @Column(name ="certification_curriculum_id") private String certificationCurriculumId;
  @Column(name ="certification_curriculum_name") private String certificationCurriculumName;
  @Column(name ="certification_curriculum_assigned_on") private String certificationCurriculumAssignedOn;
  @Column(name ="certification_curriculum_acquired_on") private String certificationCurriculumAcquiredOn;
  @Column(name ="named_flag") private String namedFlag;
  @Column(name ="employee_base_branch") private String employeeBaseBranch;
  @Column(name ="employee_depute_branch") private String employeeDeputeBranch;
  @Column(name ="employee_base_sector") private String employeeBaseSector;
  @Column(name ="employee_depute_country") private String employeeDeputeCountry;
  @Column(name ="employee_child_iou") private String employeeChildIou;
  @Column(name ="sub_iou_id") private String subIouId;
  @Column(name ="original_iou") private String originalIou;
  @Column(name ="project_iou") private String projectIou;
  @Column(name ="employee_delivery_unit") private String employeeDeliveryUnit;
  @Column(name ="customer") private String customer;
  @Column(name ="group_customer") private String groupCustomer;
  @Column(name ="exam_id") private String examId;
  @Column(name ="exam_name") private String examName;
  @Column(name ="certification_curriculum_expiry_date") private String certificationCurriculumExpiryDate;
  @Column(name ="certification_type") private String certificationType;
  @Column(name ="vendor_name") private String vendorName;
  @Column(name ="exam_status") private String examStatus;
  @Column(name ="certification_curriculum_status") private String certificationCurriculumStatus;
  @Column(name ="recommended_learning_hours") private String recommendedLearningHours;
  @Column(name ="candidate_id") private String candidateId;
  @Column(name ="category") private String category;
  @Column(name ="focus_area") private String focusArea;
  @Column(name ="sub_focus_area") private String subFocusArea;
  @Column(name ="requested_reimbursement_amount") private String requestedReimbursementAmount;
  @Column(name ="requested_reimbursement_currency") private String requestedReimbursementCurrency;
  @Column(name ="reimbursable_non_reimbursable_status") private String reimbursableNonReimbursableStatus;
  @Column(name ="reimbursement_swon") private String reimbursablenonreimbursablestatus;
  @Column(name ="reimbursement_s_won_name") private String reimbursementSWonName;
  @Column(name ="reimbursement_iou") private String reimbursementIou;
  @Column(name ="exam_completed_on") private String examCompletedOn;
  @Column(name ="exam_reimbursed_date") private String examReimbursedDate;
  @Column(name ="certification_request_id") private String certificationRequestId;
  @Column(name ="exam_workflow_status") private String examWorkflowStatus;
  @Column(name ="pending_with_employee_names") private String pendingWithEmployeeNames;
  @Column(name ="pending_with_employee_numbers") private String pendingWithEmployeeNumbers;
  @Column(name ="request_raised_date") private String requestRaisedDate;
  @Column(name ="requested_reimbursement_amount_in_beacon_currency_inr") private String requestedReimbursementAmountInBeaconCurrencyInr;
  @Column(name ="person_type") private String personType;
  @Column(name ="project_number") private String projectNumber;
  @Column(name ="digital_certificate") private String digitalCertificate;
  @Column(name ="employee_parent_iou") private String employeeParentIou;
  @Column(name ="is_curricula") private String isCurricula;

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

  public String getCertificationCurriculumId() {
    return certificationCurriculumId;
  }

  public void setCertificationCurriculumId(String certificationCurriculumId) {
    this.certificationCurriculumId = certificationCurriculumId;
  }

  public String getCertificationCurriculumName() {
    return certificationCurriculumName;
  }

  public void setCertificationCurriculumName(String certificationCurriculumName) {
    this.certificationCurriculumName = certificationCurriculumName;
  }

  public String getCertificationCurriculumAssignedOn() {
    return certificationCurriculumAssignedOn;
  }

  public void setCertificationCurriculumAssignedOn(String certificationCurriculumAssignedOn) {
    this.certificationCurriculumAssignedOn = certificationCurriculumAssignedOn;
  }

  public String getCertificationCurriculumAcquiredOn() {
    return certificationCurriculumAcquiredOn;
  }

  public void setCertificationCurriculumAcquiredOn(String certificationCurriculumAcquiredOn) {
    this.certificationCurriculumAcquiredOn = certificationCurriculumAcquiredOn;
  }

  public String getNamedFlag() {
    return namedFlag;
  }

  public void setNamedFlag(String namedFlag) {
    this.namedFlag = namedFlag;
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

  public String getEmployeeBaseSector() {
    return employeeBaseSector;
  }

  public void setEmployeeBaseSector(String employeeBaseSector) {
    this.employeeBaseSector = employeeBaseSector;
  }

  public String getEmployeeDeputeCountry() {
    return employeeDeputeCountry;
  }

  public void setEmployeeDeputeCountry(String employeeDeputeCountry) {
    this.employeeDeputeCountry = employeeDeputeCountry;
  }

  public String getEmployeeChildIou() {
    return employeeChildIou;
  }

  public void setEmployeeChildIou(String employeeChildIou) {
    this.employeeChildIou = employeeChildIou;
  }

  public String getSubIouId() {
    return subIouId;
  }

  public void setSubIouId(String subIouId) {
    this.subIouId = subIouId;
  }

  public String getOriginalIou() {
    return originalIou;
  }

  public void setOriginalIou(String originalIou) {
    this.originalIou = originalIou;
  }

  public String getProjectIou() {
    return projectIou;
  }

  public void setProjectIou(String projectIou) {
    this.projectIou = projectIou;
  }

  public String getEmployeeDeliveryUnit() {
    return employeeDeliveryUnit;
  }

  public void setEmployeeDeliveryUnit(String employeeDeliveryUnit) {
    this.employeeDeliveryUnit = employeeDeliveryUnit;
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

  public String getExamId() {
    return examId;
  }

  public void setExamId(String examId) {
    this.examId = examId;
  }

  public String getExamName() {
    return examName;
  }

  public void setExamName(String examName) {
    this.examName = examName;
  }

  public String getCertificationCurriculumExpiryDate() {
    return certificationCurriculumExpiryDate;
  }

  public void setCertificationCurriculumExpiryDate(String certificationCurriculumExpiryDate) {
    this.certificationCurriculumExpiryDate = certificationCurriculumExpiryDate;
  }

  public String getCertificationType() {
    return certificationType;
  }

  public void setCertificationType(String certificationType) {
    this.certificationType = certificationType;
  }

  public String getVendorName() {
    return vendorName;
  }

  public void setVendorName(String vendorName) {
    this.vendorName = vendorName;
  }

  public String getExamStatus() {
    return examStatus;
  }

  public void setExamStatus(String examStatus) {
    this.examStatus = examStatus;
  }

  public String getCertificationCurriculumStatus() {
    return certificationCurriculumStatus;
  }

  public void setCertificationCurriculumStatus(String certificationCurriculumStatus) {
    this.certificationCurriculumStatus = certificationCurriculumStatus;
  }

  public String getRecommendedLearningHours() {
    return recommendedLearningHours;
  }

  public void setRecommendedLearningHours(String recommendedLearningHours) {
    this.recommendedLearningHours = recommendedLearningHours;
  }

  public String getCandidateId() {
    return candidateId;
  }

  public void setCandidateId(String candidateId) {
    this.candidateId = candidateId;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
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

  public String getRequestedReimbursementAmount() {
    return requestedReimbursementAmount;
  }

  public void setRequestedReimbursementAmount(String requestedReimbursementAmount) {
    this.requestedReimbursementAmount = requestedReimbursementAmount;
  }

  public String getRequestedReimbursementCurrency() {
    return requestedReimbursementCurrency;
  }

  public void setRequestedReimbursementCurrency(String requestedReimbursementCurrency) {
    this.requestedReimbursementCurrency = requestedReimbursementCurrency;
  }

  public String getReimbursableNonReimbursableStatus() {
    return reimbursableNonReimbursableStatus;
  }

  public void setReimbursableNonReimbursableStatus(String reimbursableNonReimbursableStatus) {
    this.reimbursableNonReimbursableStatus = reimbursableNonReimbursableStatus;
  }

  public String getReimbursablenonreimbursablestatus() {
    return reimbursablenonreimbursablestatus;
  }

  public void setReimbursablenonreimbursablestatus(String reimbursablenonreimbursablestatus) {
    this.reimbursablenonreimbursablestatus = reimbursablenonreimbursablestatus;
  }

  public String getReimbursementSWonName() {
    return reimbursementSWonName;
  }

  public void setReimbursementSWonName(String reimbursementSWonName) {
    this.reimbursementSWonName = reimbursementSWonName;
  }

  public String getReimbursementIou() {
    return reimbursementIou;
  }

  public void setReimbursementIou(String reimbursementIou) {
    this.reimbursementIou = reimbursementIou;
  }

  public String getExamCompletedOn() {
    return examCompletedOn;
  }

  public void setExamCompletedOn(String examCompletedOn) {
    this.examCompletedOn = examCompletedOn;
  }

  public String getExamReimbursedDate() {
    return examReimbursedDate;
  }

  public void setExamReimbursedDate(String examReimbursedDate) {
    this.examReimbursedDate = examReimbursedDate;
  }

  public String getCertificationRequestId() {
    return certificationRequestId;
  }

  public void setCertificationRequestId(String certificationRequestId) {
    this.certificationRequestId = certificationRequestId;
  }

  public String getExamWorkflowStatus() {
    return examWorkflowStatus;
  }

  public void setExamWorkflowStatus(String examWorkflowStatus) {
    this.examWorkflowStatus = examWorkflowStatus;
  }

  public String getPendingWithEmployeeNames() {
    return pendingWithEmployeeNames;
  }

  public void setPendingWithEmployeeNames(String pendingWithEmployeeNames) {
    this.pendingWithEmployeeNames = pendingWithEmployeeNames;
  }

  public String getPendingWithEmployeeNumbers() {
    return pendingWithEmployeeNumbers;
  }

  public void setPendingWithEmployeeNumbers(String pendingWithEmployeeNumbers) {
    this.pendingWithEmployeeNumbers = pendingWithEmployeeNumbers;
  }

  public String getRequestRaisedDate() {
    return requestRaisedDate;
  }

  public void setRequestRaisedDate(String requestRaisedDate) {
    this.requestRaisedDate = requestRaisedDate;
  }

  public String getRequestedReimbursementAmountInBeaconCurrencyInr() {
    return requestedReimbursementAmountInBeaconCurrencyInr;
  }

  public void setRequestedReimbursementAmountInBeaconCurrencyInr(String requestedReimbursementAmountInBeaconCurrencyInr) {
    this.requestedReimbursementAmountInBeaconCurrencyInr = requestedReimbursementAmountInBeaconCurrencyInr;
  }

  public String getPersonType() {
    return personType;
  }

  public void setPersonType(String personType) {
    this.personType = personType;
  }

  public String getProjectNumber() {
    return projectNumber;
  }

  public void setProjectNumber(String projectNumber) {
    this.projectNumber = projectNumber;
  }

  public String getDigitalCertificate() {
    return digitalCertificate;
  }

  public void setDigitalCertificate(String digitalCertificate) {
    this.digitalCertificate = digitalCertificate;
  }

  public String getEmployeeParentIou() {
    return employeeParentIou;
  }

  public void setEmployeeParentIou(String employeeParentIou) {
    this.employeeParentIou = employeeParentIou;
  }

  public String getIsCurricula() {
    return isCurricula;
  }

  public void setIsCurricula(String isCurricula) {
    this.isCurricula = isCurricula;
  }
}

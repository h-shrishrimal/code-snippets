package com.tcs.rmg.entities;

import javax.persistence.*;

@Entity
@Table(name = "requirement_details_iaspire", schema = "rmg_iaspire")
public class RequirementIAspire {


  @Id @Column(name ="requirement_id") private Integer requirementId;
  @Column(name ="request_id") private Integer requestId;
  @Lob @Column(name ="requirement_status") private String requirementStatus;
  @Lob @Column(name ="requirement_type") private String requirementType;
  @Lob @Column(name ="onsite_offshore") private String onsiteOffshore;
  @Lob @Column(name ="requirement_pending_with") private String requirementPendingWith;
  @Lob @Column(name ="requirement_start_date") private String requirementStartDate;
  @Lob @Column(name ="requirement_end_date") private String requirementEndDate;
  @Lob @Column(name ="aging_wrt_rqmt_st_dt") private String agingWrtRqmtStDt;
  @Lob @Column(name ="bucket_wrt_rqmt_st_dt") private String bucketWrtRqmtStDt;
  @Lob @Column(name ="require_status_requirement_start_date") private String requireStatusRequirementStartDate;
  @Lob @Column(name ="won_swon") private String wonSwon;
  @Lob @Column(name ="project_number") private String projectNumber;
  @Lob @Column(name ="parent_du") private String parentDu;
  @Lob @Column(name ="du_type") private String duType;
  @Lob @Column(name ="group_customer_name") private String groupCustomerName;
  @Lob @Column(name ="customer_name") private String customerName;
  @Lob @Column(name ="bfsi_account_name") private String bfsiAccountName;
  @Lob @Column(name ="bfsi_sub_segment_name") private String bfsiSubSegmentName;
  @Lob @Column(name ="new_segment_iou_name") private String newSegmentIouName;
  @Lob @Column(name ="requirement_bg_cluster") private String requirementBgCluster;
  @Lob @Column(name ="requirement_parent_iou") private String requirementParentIou;
  @Lob @Column(name ="horizontal_parent_iou") private String horizontalParentIou;
  @Lob @Column(name ="horizontal_child_iou") private String horizontalChildIou;
  @Lob @Column(name ="requirement_geography") private String requirementGeography;
  @Lob @Column(name ="requirement_country") private String requirementCountry;
  @Lob @Column(name ="requirement_branch") private String requirementBranch;
  @Lob @Column(name ="requirement_city") private String requirementCity;
  @Lob @Column(name ="requirement_location") private String requirementLocation;
  @Lob @Column(name ="rmg_offshore_branch") private String rmgOffshoreBranch;
  @Lob @Column(name ="branch") private String branch;
  @Lob @Column(name ="total_experience") private String totalExperience;
  @Lob @Column(name ="primary_competency_proficiency_details") private String primaryCompetencyProficiencyDetails;

  public Integer getRequestId() {
    return requestId;
  }

  public void setRequestId(Integer requestId) {
    this.requestId = requestId;
  }

  public Integer getRequirementId() {
    return requirementId;
  }

  public void setRequirementId(Integer requirementId) {
    this.requirementId = requirementId;
  }

  public String getRequirementStatus() {
    return requirementStatus;
  }

  public void setRequirementStatus(String requirementStatus) {
    this.requirementStatus = requirementStatus;
  }

  public String getRequirementType() {
    return requirementType;
  }

  public void setRequirementType(String requirementType) {
    this.requirementType = requirementType;
  }

  public String getOnsiteOffshore() {
    return onsiteOffshore;
  }

  public void setOnsiteOffshore(String onsiteOffshore) {
    this.onsiteOffshore = onsiteOffshore;
  }

  public String getRequirementPendingWith() {
    return requirementPendingWith;
  }

  public void setRequirementPendingWith(String requirementPendingWith) {
    this.requirementPendingWith = requirementPendingWith;
  }

  public String getRequirementStartDate() {
    return requirementStartDate;
  }

  public void setRequirementStartDate(String requirementStartDate) {
    this.requirementStartDate = requirementStartDate;
  }

  public String getRequirementEndDate() {
    return requirementEndDate;
  }

  public void setRequirementEndDate(String requirementEndDate) {
    this.requirementEndDate = requirementEndDate;
  }

  public String getAgingWrtRqmtStDt() {
    return agingWrtRqmtStDt;
  }

  public void setAgingWrtRqmtStDt(String agingWrtRqmtStDt) {
    this.agingWrtRqmtStDt = agingWrtRqmtStDt;
  }

  public String getBucketWrtRqmtStDt() {
    return bucketWrtRqmtStDt;
  }

  public void setBucketWrtRqmtStDt(String bucketWrtRqmtStDt) {
    this.bucketWrtRqmtStDt = bucketWrtRqmtStDt;
  }

  public String getRequireStatusRequirementStartDate() {
    return requireStatusRequirementStartDate;
  }

  public void setRequireStatusRequirementStartDate(String requireStatusRequirementStartDate) {
    this.requireStatusRequirementStartDate = requireStatusRequirementStartDate;
  }

  public String getWonSwon() {
    return wonSwon;
  }

  public void setWonSwon(String wonSwon) {
    this.wonSwon = wonSwon;
  }

  public String getProjectNumber() {
    return projectNumber;
  }

  public void setProjectNumber(String projectNumber) {
    this.projectNumber = projectNumber;
  }

  public String getParentDu() {
    return parentDu;
  }

  public void setParentDu(String parentDu) {
    this.parentDu = parentDu;
  }

  public String getDuType() {
    return duType;
  }

  public void setDuType(String duType) {
    this.duType = duType;
  }

  public String getGroupCustomerName() {
    return groupCustomerName;
  }

  public void setGroupCustomerName(String groupCustomerName) {
    this.groupCustomerName = groupCustomerName;
  }

  public String getCustomerName() {
    return customerName;
  }

  public void setCustomerName(String customerName) {
    this.customerName = customerName;
  }

  public String getBfsiAccountName() {
    return bfsiAccountName;
  }

  public void setBfsiAccountName(String bfsiAccountName) {
    this.bfsiAccountName = bfsiAccountName;
  }

  public String getBfsiSubSegmentName() {
    return bfsiSubSegmentName;
  }

  public void setBfsiSubSegmentName(String bfsiSubSegmentName) {
    this.bfsiSubSegmentName = bfsiSubSegmentName;
  }

  public String getNewSegmentIouName() {
    return newSegmentIouName;
  }

  public void setNewSegmentIouName(String newSegmentIouName) {
    this.newSegmentIouName = newSegmentIouName;
  }

  public String getRequirementBgCluster() {
    return requirementBgCluster;
  }

  public void setRequirementBgCluster(String requirementBgCluster) {
    this.requirementBgCluster = requirementBgCluster;
  }

  public String getRequirementParentIou() {
    return requirementParentIou;
  }

  public void setRequirementParentIou(String requirementParentIou) {
    this.requirementParentIou = requirementParentIou;
  }

  public String getHorizontalParentIou() {
    return horizontalParentIou;
  }

  public void setHorizontalParentIou(String horizontalParentIou) {
    this.horizontalParentIou = horizontalParentIou;
  }

  public String getHorizontalChildIou() {
    return horizontalChildIou;
  }

  public void setHorizontalChildIou(String horizontalChildIou) {
    this.horizontalChildIou = horizontalChildIou;
  }

  public String getRequirementGeography() {
    return requirementGeography;
  }

  public void setRequirementGeography(String requirementGeography) {
    this.requirementGeography = requirementGeography;
  }

  public String getRequirementCountry() {
    return requirementCountry;
  }

  public void setRequirementCountry(String requirementCountry) {
    this.requirementCountry = requirementCountry;
  }

  public String getRequirementBranch() {
    return requirementBranch;
  }

  public void setRequirementBranch(String requirementBranch) {
    this.requirementBranch = requirementBranch;
  }

  public String getRequirementCity() {
    return requirementCity;
  }

  public void setRequirementCity(String requirementCity) {
    this.requirementCity = requirementCity;
  }

  public String getRequirementLocation() {
    return requirementLocation;
  }

  public void setRequirementLocation(String requirementLocation) {
    this.requirementLocation = requirementLocation;
  }

  public String getRmgOffshoreBranch() {
    return rmgOffshoreBranch;
  }

  public void setRmgOffshoreBranch(String rmgOffshoreBranch) {
    this.rmgOffshoreBranch = rmgOffshoreBranch;
  }

  public String getBranch() {
    return branch;
  }

  public void setBranch(String branch) {
    this.branch = branch;
  }

  public String getTotalExperience() {
    return totalExperience;
  }

  public void setTotalExperience(String totalExperience) {
    this.totalExperience = totalExperience;
  }

  public String getPrimaryCompetencyProficiencyDetails() {
    return primaryCompetencyProficiencyDetails;
  }

  public void setPrimaryCompetencyProficiencyDetails(String primaryCompetencyProficiencyDetails) {
    this.primaryCompetencyProficiencyDetails = primaryCompetencyProficiencyDetails;
  }
}

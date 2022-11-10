package com.tcs.iaspire.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "requirement")
public class Requirement {

  private String request_id;

  @Id private String requirement_id;
  @Lob private String requirement_status;
  @Lob private String requirement_type;
  @Lob private String onsite_offshore;
  @Lob private String requirement_pending_with;
  @Lob private String requirement_start_date;
  @Lob private String requirement_end_date;
  @Lob private String aging_wrt_rqmt_st_dt;
  @Lob private String bucket_wrt_rqmt_st_dt;
  @Lob private String require_status_requirement_start_date;
  @Lob private String won_swon;
  @Lob private String project_number;
  @Lob private String parent_du;
  @Lob private String du_type;
  @Lob private String group_customer_name;
  @Lob private String customer_name;
  @Lob private String bfsi_account_name;
  @Lob private String bfsi_sub_segment_name;
  @Lob private String new_segment_iou_name;
  @Lob private String requirement_bg_cluster;
  @Lob private String requirement_parent_iou;
  @Lob private String horizontal_parent_iou;
  @Lob private String horizontal_child_iou;
  @Lob private String requirement_geography;
  @Lob private String requirement_country;
  @Lob private String requirement_branch;
  @Lob private String requirement_city;
  @Lob private String requirement_location;
  @Lob private String rmg_offshore_branch;
  @Lob private String branch;
  @Lob private String total_experience;
  @Lob private String primary_competency_proficiency_details;

  public String getRequest_id() {
    return request_id;
  }

  public void setRequest_id(String request_id) {
    this.request_id = request_id;
  }

  public String getRequirement_id() {
    return requirement_id;
  }

  public void setRequirement_id(String requirement_id) {
    this.requirement_id = requirement_id;
  }

  public String getRequirement_status() {
    return requirement_status;
  }

  public void setRequirement_status(String requirement_status) {
    this.requirement_status = requirement_status;
  }

  public String getRequirement_type() {
    return requirement_type;
  }

  public void setRequirement_type(String requirement_type) {
    this.requirement_type = requirement_type;
  }

  public String getOnsite_offshore() {
    return onsite_offshore;
  }

  public void setOnsite_offshore(String onsite_offshore) {
    this.onsite_offshore = onsite_offshore;
  }

  public String getRequirement_pending_with() {
    return requirement_pending_with;
  }

  public void setRequirement_pending_with(String requirement_pending_with) {
    this.requirement_pending_with = requirement_pending_with;
  }

  public String getRequirement_start_date() {
    return requirement_start_date;
  }

  public void setRequirement_start_date(String requirement_start_date) {
    this.requirement_start_date = requirement_start_date;
  }

  public String getRequirement_end_date() {
    return requirement_end_date;
  }

  public void setRequirement_end_date(String requirement_end_date) {
    this.requirement_end_date = requirement_end_date;
  }

  public String getAging_wrt_rqmt_st_dt() {
    return aging_wrt_rqmt_st_dt;
  }

  public void setAging_wrt_rqmt_st_dt(String aging_wrt_rqmt_st_dt) {
    this.aging_wrt_rqmt_st_dt = aging_wrt_rqmt_st_dt;
  }

  public String getBucket_wrt_rqmt_st_dt() {
    return bucket_wrt_rqmt_st_dt;
  }

  public void setBucket_wrt_rqmt_st_dt(String bucket_wrt_rqmt_st_dt) {
    this.bucket_wrt_rqmt_st_dt = bucket_wrt_rqmt_st_dt;
  }

  public String getRequire_status_requirement_start_date() {
    return require_status_requirement_start_date;
  }

  public void setRequire_status_requirement_start_date(
      String require_status_requirement_start_date) {
    this.require_status_requirement_start_date = require_status_requirement_start_date;
  }

  public String getWon_swon() {
    return won_swon;
  }

  public void setWon_swon(String won_swon) {
    this.won_swon = won_swon;
  }

  public String getProject_number() {
    return project_number;
  }

  public void setProject_number(String project_number) {
    this.project_number = project_number;
  }

  public String getParent_du() {
    return parent_du;
  }

  public void setParent_du(String parent_du) {
    this.parent_du = parent_du;
  }

  public String getDu_type() {
    return du_type;
  }

  public void setDu_type(String du_type) {
    this.du_type = du_type;
  }

  public String getGroup_customer_name() {
    return group_customer_name;
  }

  public void setGroup_customer_name(String group_customer_name) {
    this.group_customer_name = group_customer_name;
  }

  public String getCustomer_name() {
    return customer_name;
  }

  public void setCustomer_name(String customer_name) {
    this.customer_name = customer_name;
  }

  public String getBfsi_account_name() {
    return bfsi_account_name;
  }

  public void setBfsi_account_name(String bfsi_account_name) {
    this.bfsi_account_name = bfsi_account_name;
  }

  public String getBfsi_sub_segment_name() {
    return bfsi_sub_segment_name;
  }

  public void setBfsi_sub_segment_name(String bfsi_sub_segment_name) {
    this.bfsi_sub_segment_name = bfsi_sub_segment_name;
  }

  public String getNew_segment_iou_name() {
    return new_segment_iou_name;
  }

  public void setNew_segment_iou_name(String new_segment_iou_name) {
    this.new_segment_iou_name = new_segment_iou_name;
  }

  public String getRequirement_bg_cluster() {
    return requirement_bg_cluster;
  }

  public void setRequirement_bg_cluster(String requirement_bg_cluster) {
    this.requirement_bg_cluster = requirement_bg_cluster;
  }

  public String getRequirement_parent_iou() {
    return requirement_parent_iou;
  }

  public void setRequirement_parent_iou(String requirement_parent_iou) {
    this.requirement_parent_iou = requirement_parent_iou;
  }

  public String getHorizontal_parent_iou() {
    return horizontal_parent_iou;
  }

  public void setHorizontal_parent_iou(String horizontal_parent_iou) {
    this.horizontal_parent_iou = horizontal_parent_iou;
  }

  public String getHorizontal_child_iou() {
    return horizontal_child_iou;
  }

  public void setHorizontal_child_iou(String horizontal_child_iou) {
    this.horizontal_child_iou = horizontal_child_iou;
  }

  public String getRequirement_geography() {
    return requirement_geography;
  }

  public void setRequirement_geography(String requirement_geography) {
    this.requirement_geography = requirement_geography;
  }

  public String getRequirement_country() {
    return requirement_country;
  }

  public void setRequirement_country(String requirement_country) {
    this.requirement_country = requirement_country;
  }

  public String getRequirement_branch() {
    return requirement_branch;
  }

  public void setRequirement_branch(String requirement_branch) {
    this.requirement_branch = requirement_branch;
  }

  public String getRequirement_city() {
    return requirement_city;
  }

  public void setRequirement_city(String requirement_city) {
    this.requirement_city = requirement_city;
  }

  public String getRequirement_location() {
    return requirement_location;
  }

  public void setRequirement_location(String requirement_location) {
    this.requirement_location = requirement_location;
  }

  public String getRmg_offshore_branch() {
    return rmg_offshore_branch;
  }

  public void setRmg_offshore_branch(String rmg_offshore_branch) {
    this.rmg_offshore_branch = rmg_offshore_branch;
  }

  public String getBranch() {
    return branch;
  }

  public void setBranch(String branch) {
    this.branch = branch;
  }

  public String getTotal_experience() {
    return total_experience;
  }

  public void setTotal_experience(String total_experience) {
    this.total_experience = total_experience;
  }

  public String getPrimary_competency_proficiency_details() {
    return primary_competency_proficiency_details;
  }

  public void setPrimary_competency_proficiency_details(
      String primary_competency_proficiency_details) {
    this.primary_competency_proficiency_details = primary_competency_proficiency_details;
  }
}

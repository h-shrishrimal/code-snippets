package com.tcs.rmg.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_authorization_details", schema= "global_login")
public class UserAuthorizationDetails {

	@Id
	@Column(name = "auth_id")
	@GeneratedValue(generator = "user_authorization_details_auth_id_seq")
	private Long id;
	
	@Column(name="emp_no")
	private String empNumber;
	 
	@Column(name="emp_name")
	private String empName;
	
	@Column(name="segment")
	private String segment;
	
	@Column(name="account")
	private String account;
	
	@Column(name="role_name")
	private String roleName;
	
	@Column(name="app_id")
	private Integer appId;
	
	@Column(name="app_name")
	private String appName;

	@Column(name="application_owner")
	private String appOwner;
	
	@Column(name="super_user")
	private String superUser;
	
	@Column(name="created_date")
	private LocalDate createdDate;
	
	@Column(name="created_user_id")
	private String createdUserId;
	
	@Column(name="updated_date")
	private LocalDate updatedDate;
	
	@Column(name="updated_user_id")
	private String updatedUserId;
	
	@Column(name="level_id")
	private Integer level;
	
	@Column(name="isuname")
	private String isuName;
	
	public String getIsuName() {
		return isuName;
	}

	public void setIsuName(String isuName) {
		this.isuName = isuName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public String getSegment() {
		return segment;
	}

	public void setSegment(String segment) {
		this.segment = segment;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Integer getAppId() {
		return appId;
	}

	public void setAppId(Integer appId) {
		this.appId = appId;
	}
	
	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public String getAppOwner() {
		return appOwner;
	}

	public void setAppOwner(String appOwner) {
		this.appOwner = appOwner;
	}

	public String getSuperUser() {
		return superUser;
	}

	public void setSuperUser(String superUser) {
		this.superUser = superUser;
	}

	public LocalDate getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatedUserId() {
		return createdUserId;
	}

	public void setCreatedUserId(String createdUserId) {
		this.createdUserId = createdUserId;
	}

	public LocalDate getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(LocalDate updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getUpdatedUserId() {
		return updatedUserId;
	}

	public void setUpdatedUserId(String updatedUserId) {
		this.updatedUserId = updatedUserId;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}
	
}

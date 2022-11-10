package com.tcs.rmg.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_audit_details", schema="rmg_app")
public class UserAuditDetails {


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	//@GeneratedValue(generator = "user_audit_details_user_id_seq")
	@Column(name = "audit_id")
	private int auditId;

	@Column(name = "user_id")
	private int userId;

	@Column(name = "user_action")
	private String userAction;

	@Column(name = "audit_timestamp")
	private Date auditTimestamp;

	public int getAuditId() {
		return auditId;
	}

	public void setAuditId(int auditId) {
		this.auditId = auditId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserAction() {
		return userAction;
	}

	public void setUserAction(String userAction) {
		this.userAction = userAction;
	}

	public Date getAuditTimestamp() {
		return auditTimestamp;
	}

	public void setAuditTimestamp(Date auditTimestamp) {
		this.auditTimestamp = auditTimestamp;
	}


}
package com.ics.domainObjects;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

@MappedSuperclass
public class EnterpriseBaseDomain implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "G_AUD_USER_ID")
	@ColumnDefault("SYSTEM")
	private String auditUserID;

	@CreationTimestamp
	@Column(name = "G_AUD_TS")
	private Date auditTimeStamp;

	@Column(name = "G_AUD_ADD_USER_ID")
	@ColumnDefault("SYSTEM")
	private String addedAuditUserID;

	@CreationTimestamp
	@Column(name = "G_AUD_ADD_TS")
	private Date addedAuditTimeStamp;

	public String getAuditUserID() {
		return auditUserID;
	}

	public void setAuditUserID(String auditUserID) {
		this.auditUserID = auditUserID;
	}

	public Date getAuditTimeStamp() {
		return auditTimeStamp;
	}

	public void setAuditTimeStamp(Date auditTimeStamp) {
		this.auditTimeStamp = auditTimeStamp;
	}

	public String getAddedAuditUserID() {
		return addedAuditUserID;
	}

	public void setAddedAuditUserID(String addedAuditUserID) {
		this.addedAuditUserID = addedAuditUserID;
	}

	public Date getAddedAuditTimeStamp() {
		return addedAuditTimeStamp;
	}

	public void setAddedAuditTimeStamp(Date addedAuditTimeStamp) {
		this.addedAuditTimeStamp = addedAuditTimeStamp;
	}

}

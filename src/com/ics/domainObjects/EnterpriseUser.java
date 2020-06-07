package com.ics.domainObjects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "G_USER_TB")
public class EnterpriseUser extends EnterpriseBaseDomain {

	@Id
	@Column(name = "G_USER_ID")
	private String userID;
	@Column(name = "G_FIRST_NAME")
	private String firstName;
	@Column(name = "G_LAST_NAME")
	private String lastName;
	@Column(name = "G_ORG_ID")
	private String orgID;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "G_USER_WORK_UNIT_SK")
	private WorkUnit workUnit;

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getOrgID() {
		return orgID;
	}

	public void setOrgID(String orgID) {
		this.orgID = orgID;
	}

	public WorkUnit getWorkUnit() {
		return workUnit;
	}

	public void setWorkUnit(WorkUnit workUnit) {
		this.workUnit = workUnit;
	}

	public EnterpriseUser(String userID, String firstName, String lastName, String orgID, WorkUnit workUnit) {
		super();
		this.userID = userID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.orgID = orgID;
		this.workUnit = workUnit;
	}

	public EnterpriseUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "EnterpriseUser [id=" + userID + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}

}

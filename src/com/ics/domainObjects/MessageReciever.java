package com.ics.domainObjects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "G_MSG_RECR_TB")
public class MessageReciever extends EnterpriseBaseDomain {

	@Id
	@ManyToOne
	@JoinColumn(name = "G_MSG_SK")
	private Message message;

	@Id
	@ManyToOne
	@JoinColumn(name = "G_TO_WORK_UNIT_SK")
	private WorkUnit toWorkUnit;

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	public WorkUnit getToWorkUnit() {
		return toWorkUnit;
	}

	public void setToWorkUnit(WorkUnit toWorkUnit) {
		this.toWorkUnit = toWorkUnit;
	}

}

package com.ics.domainObjects;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "G_WORK_UNIT_TB")
public class WorkUnit extends EnterpriseBaseDomain {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "G_WORK_UNIT_SK")
	private Long workUnitSK;

	@Column(name = "G_WORK_UNIT_TY_CD")
	private String workUnitTypeCode;

	@OneToOne(mappedBy = "workUnit", cascade = CascadeType.ALL)
	private EnterpriseUser user;

	@OneToMany(mappedBy = "fromWorkUnit", cascade = CascadeType.ALL)
	private List<Message> messages;

	@OneToMany(mappedBy = "toWorkUnit", cascade = CascadeType.ALL)
	private List<MessageReciever> messageRecievers;

	public WorkUnit() {
		super();
	}

	@Override
	public String toString() {
		return "WorkUnit [workUnitSK=" + workUnitSK + ", workUnitTypeCode=" + workUnitTypeCode + "]";
	}

	public EnterpriseUser getUser() {
		return user;
	}

	public void setUser(EnterpriseUser user) {
		this.user = user;
	}

	public String getWorkUnitTypeCode() {
		return workUnitTypeCode;
	}

	public void setWorkUnitTypeCode(String workUnitTypeCode) {
		this.workUnitTypeCode = workUnitTypeCode;
	}

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	public void addMessage(Message message) {

		if (messages == null) {
			messages = new ArrayList<>();
		}

		messages.add(message);
		message.setFromWorkUnit(this);

	}

	public List<MessageReciever> getMessageRecievers() {
		return messageRecievers;
	}

	public void setMessageRecievers(List<MessageReciever> messageRecievers) {
		this.messageRecievers = messageRecievers;
	}

	public void addMessageReciever(MessageReciever messageReciever) {

		if (messageRecievers == null) {
			messageRecievers = new ArrayList<>();
		}

		messageRecievers.add(messageReciever);
		messageReciever.setToWorkUnit(this);
	}

}

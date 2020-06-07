package com.ics.domainObjects;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "G_MSG_TB")
public class Message extends EnterpriseBaseDomain {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "G_MSG_SK")
	private Long messageSK;

	@Column(name = "MESSAGE_SUBJECT")
	private String messageSubject;

	@Column(name = "MESSAGE_TEXT")
	private String messageText;

	@ManyToOne
	@JoinColumn(name = "G_FROM_WORK_UNIT_SK")
	private WorkUnit fromWorkUnit;

	@OneToMany(mappedBy = "message", cascade = CascadeType.ALL)
	private List<MessageReciever> messageRecievers;

	public Message() {
		super();
	}

	public String getMessageSubject() {
		return messageSubject;
	}

	public void setMessageSubject(String messageSubject) {
		this.messageSubject = messageSubject;
	}

	public String getMessageText() {
		return messageText;
	}

	public void setMessageText(String messageText) {
		this.messageText = messageText;
	}

	public WorkUnit getFromWorkUnit() {
		return fromWorkUnit;
	}

	public void setFromWorkUnit(WorkUnit workUnit) {
		this.fromWorkUnit = workUnit;
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
		messageReciever.setMessage(this);
	}

}

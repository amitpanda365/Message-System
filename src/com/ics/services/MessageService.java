package com.ics.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ics.dao.MessageDAO;
import com.ics.dao.UserDAO;
import com.ics.domainObjects.EnterpriseUser;
import com.ics.domainObjects.Message;
import com.ics.domainObjects.MessageReciever;
import com.ics.utils.MessageConstants;
import com.ics.utils.MessageHelper;

@Service
public class MessageService {

	@Autowired
	UserDAO userDAO;
	
	@Autowired
	MessageDAO messageDAO;

	public void sendWelcomeMessage(String userID) {
		EnterpriseUser touser = userDAO.getUser(userID);

		EnterpriseUser fromuser = userDAO.getUser(MessageConstants.SYSTEMUSERID);

		Message message = new Message();
		message.setAddedAuditUserID(MessageConstants.SYSTEMUSERID);
		message.setAuditUserID(MessageConstants.SYSTEMUSERID);
		message.setMessageSubject("Welcome Email");
		message.setMessageText(
				"Hi " + touser.getFirstName() + ", Welcome to Email Services. Thank you for creating account.");
		message.setFromWorkUnit(fromuser.getWorkUnit());

		MessageReciever messageReciever = new MessageReciever();
		messageReciever.setToWorkUnit(touser.getWorkUnit());
		messageReciever.setAddedAuditUserID(MessageConstants.SYSTEMUSERID);
		messageReciever.setAuditUserID(MessageConstants.SYSTEMUSERID);
		message.addMessageReciever(messageReciever);
		messageDAO.sendMessage(message);
	}

	public boolean sendMessage(MessageHelper messageHelper) {

		EnterpriseUser touser = userDAO.getUser(messageHelper.getToUserID());

		EnterpriseUser fromuser = userDAO.getUser(messageHelper.getFromUserID());

		Message message = new Message();
		message.setAddedAuditUserID(MessageConstants.SYSTEMUSERID);
		message.setAuditUserID(MessageConstants.SYSTEMUSERID);
		message.setMessageSubject(messageHelper.getMessageSubject());
		message.setMessageText(messageHelper.getMeesgaeText());
		message.setFromWorkUnit(fromuser.getWorkUnit());

		MessageReciever messageReciever = new MessageReciever();
		messageReciever.setToWorkUnit(touser.getWorkUnit());
		messageReciever.setAddedAuditUserID(MessageConstants.SYSTEMUSERID);
		messageReciever.setAuditUserID(MessageConstants.SYSTEMUSERID);
		message.addMessageReciever(messageReciever);
		messageDAO.sendMessage(message);
		return true;
	}

}

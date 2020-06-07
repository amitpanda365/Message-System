package com.ics.dao;

import java.util.List;

import com.ics.domainObjects.Message;

public interface MessageDAO {
	
	public boolean sendMessage(Message message);

	public List<Message> getAllMessages(Long id);
}

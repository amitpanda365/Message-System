package com.ics.daoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ics.dao.MessageDAO;
import com.ics.domainObjects.Message;

@Repository
@Transactional
public class MessageDAOImpl implements MessageDAO {
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean sendMessage(Message message) {
		
		sessionFactory.getCurrentSession().save(message);
		return true;
	}
	
	@Override
	public List<Message> getAllMessages(Long id) {

		Session currentSession = sessionFactory.getCurrentSession();

		List<Message> messages = currentSession.createCriteria(Message.class).createAlias("recr", "messageReciever")
				.add(Restrictions.eq("recr.toWorkUnit", id)).list();

		return messages;
	}

}

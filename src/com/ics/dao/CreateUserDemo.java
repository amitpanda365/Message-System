package com.ics.dao;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ics.domainObjects.Message;
import com.ics.domainObjects.MessageReciever;
import com.ics.domainObjects.WorkUnit;

@Repository
@Transactional
public class CreateUserDemo {
	
	@Autowired
	SessionFactory sessionFactory;

	public void test() {
		

		// create session
		Session session = sessionFactory.getCurrentSession();

		try {
			/*
			 * WorkUnit unit = new WorkUnit("SY"); unit.setAddedAuditUserID("API-027");
			 * unit.setAuditUserID("API-027"); //unit.setAddedAuditTimeStamp(new Date());
			 * EnterpriseUser user = new EnterpriseUser("Test8", "Vasudha", "U V",
			 * "56773120", unit); user.setAddedAuditUserID("API-027");
			 * user.setAuditUserID("API-027"); //user.setAddedAuditTimeStamp(new Date());
			 * //user.setWorkUnit(unit); unit.setUser(user); session.beginTransaction();
			 * session.save(unit); // commit transaction session.getTransaction().commit();
			 */

			//session.beginTransaction();
			WorkUnit fromUnit = session.get(WorkUnit.class, 4l);
			WorkUnit toUnit = session.get(WorkUnit.class, 5l);
			WorkUnit toUnit2 = session.get(WorkUnit.class, 6l);
			String BPN = "API-027";
			
			//Message msg = session.get(Message.class, 1l);

			Message msg = new Message();
			msg.setAddedAuditUserID(BPN);
			msg.setAuditUserID(BPN);
			msg.setMessageSubject("Test 2");
			msg.setMessageText("Hi Vikram and Vasudha 2");
			msg.setFromWorkUnit(fromUnit);

			MessageReciever recr = new MessageReciever();
			recr.setToWorkUnit(toUnit);
			recr.setAddedAuditUserID(BPN);
			recr.setAuditUserID(BPN);
			msg.addMessageReciever(recr);
			//session.save(recr);

			MessageReciever recr2 = new MessageReciever();
			recr2.setToWorkUnit(toUnit2);
			recr2.setAddedAuditUserID(BPN);
			recr2.setAuditUserID(BPN);
			msg.addMessageReciever(recr2);
			//session.save(recr2);
			
			session.save(msg);
			
			// commit transaction
			//session.getTransaction().commit();
			System.out.println("Done!");
		} finally {
		}
	}

}

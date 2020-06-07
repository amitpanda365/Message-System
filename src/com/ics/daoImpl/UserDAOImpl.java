package com.ics.daoImpl;

import java.util.List;

import javax.persistence.criteria.CriteriaQuery;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ics.dao.UserDAO;
import com.ics.domainObjects.EnterpriseUser;

@Repository
@Transactional
public class UserDAOImpl implements UserDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean addUser(EnterpriseUser user) {

		sessionFactory.getCurrentSession().save(user);
		return true;
	}

	@Override
	public EnterpriseUser getUser(String userID) {

		EnterpriseUser user = sessionFactory.getCurrentSession().get(EnterpriseUser.class, userID);
		return user;
	}

	@Override
	public List<EnterpriseUser> getAllUsers() {

		Session currentSession = sessionFactory.getCurrentSession();
		CriteriaQuery<EnterpriseUser> cq = currentSession.getCriteriaBuilder().createQuery(EnterpriseUser.class);
		cq.from(EnterpriseUser.class);

		return currentSession.createQuery(cq).getResultList();
	}

	@Override
	public boolean updateUser(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deleteUser(String userID) {
		System.out.println("deleteUser starts in DAOImpl");
		Session currentSession = sessionFactory.getCurrentSession();
		EnterpriseUser user = currentSession.get(EnterpriseUser.class, userID);
		currentSession.delete(user);
		System.out.println("deleteUser ends in DAOImpl");
		return true;
	}

}

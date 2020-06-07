package com.ics.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ics.dao.UserDAO;
import com.ics.domainObjects.EnterpriseUser;
import com.ics.domainObjects.WorkUnit;
import com.ics.utils.MessageConstants;

@Service
public class UserService {
	
	@Autowired
	UserDAO userDAO;
	
	
	public void createUser(EnterpriseUser user) {
		WorkUnit unit = new WorkUnit();
		unit.setWorkUnitTypeCode("SY");
		unit.setAddedAuditUserID(MessageConstants.SYSTEMUSERID);
		unit.setAuditUserID(MessageConstants.SYSTEMUSERID);
		user.setWorkUnit(unit);
		user.setAddedAuditUserID(MessageConstants.SYSTEMUSERID);
		user.setAuditUserID(MessageConstants.SYSTEMUSERID);
		userDAO.addUser(user);
	}

}

package com.ics.dao;

import java.util.List;

import com.ics.domainObjects.EnterpriseUser;
import com.ics.domainObjects.Message;
import com.ics.domainObjects.WorkUnit;

public interface UserDAO {

	public boolean addUser(EnterpriseUser user);

	public EnterpriseUser getUser(String userID);

	public List<EnterpriseUser> getAllUsers();

	public boolean updateUser(Long id);

	public boolean deleteUser(String userID);

}

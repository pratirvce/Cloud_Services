package org.akhila.cloudservices.rest.services;

import org.akhila.cloudservices.rest.services.UserDAOImpl;
import org.akhila.cloudservices.rest.model.User;

public interface UserDAO {
	
	public User getUserByEmail(String email,String password);
	public int createOrUpdateUser(User u);
	
}


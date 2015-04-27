package com.dataart.risingsun.app.controller.service;

import java.util.List;

import org.hibernate.criterion.Restrictions;

import com.dataart.risingsun.app.controller.connection.DAOManager;
import com.dataart.risingsun.app.model.instances.User;

/**
 * 
 * @author kapitoha
 *
 */
public class InstanceServiceManager {

    /**
     * Check if required user presents in DB
     * @param user
     * @return
     */
    public static boolean validateUser(User user)
    {
	List<User> list = (List<User>) DAOManager.getInstanceList(User.class, 
		Restrictions.eq("login", user.getLogin()), 
		Restrictions.eq("password", user.getPassword()));
	if (list.size() > 1)
	    System.err.println("Alert!!!!!!!! Something wrong with Users table");
	return list.size() == 1;
    }
}

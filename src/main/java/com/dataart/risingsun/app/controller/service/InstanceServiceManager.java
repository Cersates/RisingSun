package com.dataart.risingsun.app.controller.service;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.dataart.risingsun.app.controller.connection.SessionFactoryManager;
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
	User u = null;
	Session session = null;
	try
	{
	    session = SessionFactoryManager.getSessionFactory().openSession();
	    Query query = session
		    .createQuery(String
			    .format("SELECT u FROM %s u WHERE u.login=:login AND u.password=:password",
				    user.getClass().getSimpleName()));
	    query.setParameter("login", user.getLogin());
	    query.setParameter("password", user.getPassword());
	    u = (User) query.uniqueResult();
	}
	catch (HibernateException e)
	{
	    System.err.println(e.getLocalizedMessage());
	}
	finally
	{
	    if (null != session && session.isOpen())
		session.close();
	}
	return u != null;
    }
}

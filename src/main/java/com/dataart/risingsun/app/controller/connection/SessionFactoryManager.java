package com.dataart.risingsun.app.controller.connection;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * 
 * @author kapitoha
 *
 */
public class SessionFactoryManager {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory()
    {
	if (sessionFactory == null)
	{
	    // loads configuration and mappings
	    Configuration configuration = new Configuration().configure();
	    ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
		    .applySettings(configuration.getProperties()).build();

	    // builds a session factory from the service registry
	    sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	}

	return sessionFactory;
    }

}

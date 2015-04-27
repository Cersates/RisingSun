package com.dataart.risingsun.app.controller.connection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.dataart.risingsun.app.model.instances.RSInstance;

/**
 * 
 * @author kapitoha
 *
 */
public class DAOManager {
    public static boolean saveInstance(RSInstance instance)
    {
	Session session = null;
	Transaction trans = null;
	try
	{
	    session = SessionFactoryManager.getSessionFactory().openSession();
	    trans = session.beginTransaction();
	    session.save(instance);
	    trans.commit();
	    return true;
	}
	catch (HibernateException e)
	{
	    if (trans != null)
	    {
		trans.rollback();
	    }
	    System.err.println(instance.getClass().getName()
		    + " Save was unsuccessful. Rollback");
//	    e.printStackTrace();
	    return false;
	}
	finally
	{
	    if (null != session && session.isOpen())
	    {
		session.close();
	    }
	}
    }

    public static boolean updateInstance(RSInstance instance)
    {
	Session session = null;
	Transaction trans = null;
	try
	{
	    session = SessionFactoryManager.getSessionFactory().openSession();
	    trans = session.beginTransaction();
	    session.update(instance);
	    trans.commit();
	    return true;
	}
	catch (Exception e)
	{
	    if (trans != null)
	    {
		trans.rollback();
	    }
	    System.err.println("Update was unsuccessful. Rollback");
	    return false;
	}
	finally
	{
	    if (null != session && session.isOpen())
	    {
		session.close();
	    }
	}
    }

    /**
     * Returns list of Instances Where instance param is Instance.class
     * 
     * @param instance
     * @return
     */
    public static <T extends RSInstance> List<T> getInstanceList(
	    Class<T> instance)
    {
	String query = "Select u FROM " + instance.getSimpleName() + " u";
	Session session = SessionFactoryManager.getSessionFactory()
		.openSession();
	Query que = session.createQuery(query);
	@SuppressWarnings("unchecked")
	List<T> list = que.list();
	session.close();
	return (List<T>) list;
    }
    
    /**
     * Get Instance list with necessary criteria.
     * @param instanceClass
     * @param criterion
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T extends RSInstance> Collection<T> getInstanceList(Class<T> instanceClass, Criterion... criterion)
    {
	Collection<T> list = new ArrayList<>();
	Criteria criteria = null;
	try
	{
	    criteria = SessionFactoryManager.getSessionFactory().openSession().createCriteria(instanceClass);
	    if (criterion.length > 0)
	    {
	        for (Criterion crit : criterion)
	        {
	    		criteria.add(crit);
	        }
	    }
	}
	catch (HibernateException e)
	{
	    System.err.println("getInstanceList(class, Criterion) " + e.getMessage());
	}
	if (null != criteria)
	    list.addAll(criteria.list());
	return list;
    }

    @SuppressWarnings("hiding")
    public static <T extends RSInstance, N extends Integer, Long> RSInstance getInstance(
	    Class<T> instanceClass, N id)
    {
	RSInstance inst = null;
	Session session = SessionFactoryManager.getSessionFactory()
		.openSession();
	session.beginTransaction();
	inst = (RSInstance) session.get(instanceClass, id);
	if (session.isOpen())
	{
	    session.close();
	}
	return inst;
    }

    /**
     * Delete instance from DB where
     * 
     * @param id
     *            - id of instance
     * @param instanceClass
     *            - Class of instance
     */
    public static <T extends RSInstance> void deleteInstance(int id,
	    Class<T> instanceClass)
    {
	Session session = null;
	try
	{
	    session = SessionFactoryManager.getSessionFactory().openSession();
	    RSInstance instance = (RSInstance) session.load(instanceClass, id);
	    if (null != instance)
	    {
		Transaction transaction = session.beginTransaction();
		session.delete(instance);
		transaction.commit();
	    }
	}
	finally
	{
	    if (null != session && session.isOpen())
		session.close();
	}

    }
}

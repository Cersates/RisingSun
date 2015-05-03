package com.dataart.risingsun.connection;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;

import com.dataart.risingsun.model.RSInstance;

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
    public static <T extends RSInstance> List<T> getInstanceList(Class<T> instance)
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
    public static <T extends RSInstance> List<T> getInstanceList(Class<T> instanceClass, Criterion... criterion)
    {
	List<T> list = new ArrayList<>();
	Session session = null;
	Criteria criteria = null;
	try
	{
	    session = SessionFactoryManager.getSessionFactory().openSession();
	    criteria = session.createCriteria(instanceClass);
	    if (null != criterion && criterion.length > 0)
	    {
	        for (Criterion crit : criterion)
	        {
	    		criteria.add(crit);
	        }
	    }
	    if (null != criteria)
		list.addAll(criteria.list());
	}
	catch (HibernateException e)
	{
	    System.err.println("getInstanceList(class, Criterion) " + e.getMessage());
	}
	finally
	{
	    if (null != session && session.isOpen())
		session.close();
	}
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
	if (session != null && session.isOpen())
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
    public static <T extends RSInstance> void deleteInstance(int id, Class<T> instanceClass)
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

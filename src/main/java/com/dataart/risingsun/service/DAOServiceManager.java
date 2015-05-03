package com.dataart.risingsun.service;

import java.util.List;

import org.hibernate.criterion.Restrictions;

import com.dataart.risingsun.connection.DAOManager;
import com.dataart.risingsun.enums.ArticleSelection;
import com.dataart.risingsun.enums.UserRights;
import com.dataart.risingsun.model.Article;
import com.dataart.risingsun.model.User;

/**
 * (DAOService)
 * @author kapitoha
 *
 */
public class DAOServiceManager {

    /**
     * Check if user exists in DB
     * @param user
     * @return
     */
    public static boolean validateUser(User user)
    {
	List<User> list = (List<User>) DAOManager.getInstanceList(User.class, 
		Restrictions.eq("login", user.getLogin()), 
		Restrictions.eq("password", user.getPassword()));
	if (list.size() > 1)
	    System.err.println("Alert!!!!!!!! Something wrong with Users table (maybe duplicates)");
	return list.size() == 1;
    }
    
    /**
     * Return user access rights
     * @param user
     * @return
     */
    public static UserRights getUserRights(User user)
    {
	return UserRights.ADMIN; //temporary solution
    }
    
    /**
     * Returns List of Articles depending on selection argument.
     * @param selection
     * @return
     */
    public static List<Article> getArticleList(ArticleSelection selection)
    {
	List<Article> list = null;
	switch (selection)
	{
	    case PUBLISHED:
		
		break;
	    case UNPULISHED:
		break;
	    case ARCHIVED:
		break;
	    case ALL:
		list = DAOManager.getInstanceList(Article.class);
		break;
	}
	return list;
    }
}

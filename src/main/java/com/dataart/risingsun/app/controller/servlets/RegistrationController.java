package com.dataart.risingsun.app.controller.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.criterion.Restrictions;

import com.dataart.risingsun.app.controller.connection.DAOManager;
import com.dataart.risingsun.app.model.instances.User;
import com.dataart.risingsun.app.utils.StringUtils;

/**
 * 
 * @author kapitoha
 *
 */
public class RegistrationController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp)
	    throws ServletException, IOException
    {
	String allowed = "Allowed [A-Z a-z 0-9] only characters without spaces";
	String name = request.getParameter("name");
	String login = request.getParameter("login");
	String password = request.getParameter("password");
	boolean errorPresents = false;
	if (null == name || !StringUtils.checkIfAllowed(name))
	{
	    request.setAttribute("nameError", allowed);
	    errorPresents = true;
	}
	else if (null == login || !StringUtils.checkIfAllowed(login))
	{
	    request.setAttribute("loginError", allowed);
	    errorPresents = true;
	}
	else if (null == password || !StringUtils.checkIfAllowed(password))
	{
	    request.setAttribute("passwordError", allowed);
	    errorPresents = true;
	}
	List<User> matches =  (List<User>) DAOManager.getInstanceList(User.class, Restrictions.eq("name", name), Restrictions.eq("login", login));
	if (matches.size() > 0)
	{
	    errorPresents = true;
	    for (User user : matches)
	    {
		if (user.getName().equals(name))
		    request.setAttribute("existsName", "Name already exists. Try another");
		if (user.getLogin().equals(login))
		    request.setAttribute("existsLogin", "Login already exists. Try another");
	    }
	}
	if (!errorPresents)
	{
	    User user = new User();
	    user.setName(name);
	    user.setLogin(login);
	    user.setPassword(password.toCharArray());
	    //save into DB
	    if (!DAOManager.saveInstance(user))
		System.err.println("Cannot save user");
	}
	request.setAttribute("errorPresents", errorPresents);
	request.getRequestDispatcher("/registration.jsp").forward(request, resp);
    }
    
    

}

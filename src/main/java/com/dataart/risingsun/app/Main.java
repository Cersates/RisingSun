package com.dataart.risingsun.app;

import java.util.Date;
import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dataart.risingsun.app.controller.connection.DAOManager;
import com.dataart.risingsun.app.controller.connection.SessionFactoryManager;
import com.dataart.risingsun.app.controller.service.DAOServiceManager;
import com.dataart.risingsun.app.model.instances.Article;
import com.dataart.risingsun.app.model.instances.User;

public class Main {
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        LOGGER.info("Start application");
        createArticles();

    }
    
    
    public static void createArticles()
    {
        SessionFactoryManager.getSessionFactory();
        String login = "admin";
        String name = "Admin";
        char[] password = "admin".toCharArray();
        User user = new User();
        user.setName(name);
        user.setLogin(login);
        user.setPassword(password);
        if (!DAOServiceManager.validateUser(user))
        {
            DAOManager.saveInstance(user);
        }
        List<User> userList = DAOManager.getInstanceList(User.class, Restrictions.eq("name", name));
        if (userList != null && userList.size() > 0)
        {
            user = DAOManager.getInstanceList(User.class, Restrictions.eq("name", name)).get(0);
            for (int i = 0; i < 10; i++)
            {
        	Article article = new Article();
        	article.setAuthor(user);
        	article.setContent("Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Nam vulputate turpis vel mauris. Aenean sapien mauris, ultrices sed, rhoncus at, pellentesque sed, lectus. In hac habitasse platea dictumst. Donec adipiscing, mauris eu varius consectetuer, nulla orci iaculis neque, ac rhoncus est lacus in augue. Maecenas ac dolor. Vestibulum semper eleifend arcu. Sed leo. Suspendisse vestibulum dolor sed eros ullamcorper tincidunt. Nulla at sapien vel mi fermentum adipiscing. Sed sit amet orci vel nisl mattis pretium. Nullam tristique mi eu magna. Duis odio ante, suscipit non, iaculis et, porta malesuada, neque. Suspendisse fringilla, purus dictum pretium nonummy, leo leo ullamcorper felis, id semper quam neque sit amet ante. Ut nec mi. Ut congue massa fermentum justo. ");
        	article.setDate(new Date());
        	article.setDescription("Description");
        	article.setTitle("article " + i);
        	DAOManager.saveInstance(article);
            }
            
        }
    }
}

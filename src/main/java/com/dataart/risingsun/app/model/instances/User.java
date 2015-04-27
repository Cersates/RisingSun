package com.dataart.risingsun.app.model.instances;

import javax.persistence.*;

import com.dataart.risingsun.app.Constants;

/**
 * 
 * @author kapitoha
 *
 */
@Entity
@Table (name="Users")
public class User implements RSInstance {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue
    private long id;
    
    @Column (nullable=false, unique= true, length=Constants.MAX_NAME_LENGTH)
    private String name;
    @Column (nullable=false, unique= true, length=Constants.MAX_LOGIN_LENGTH)
    private String login;
    @Column (nullable=false, length=Constants.MAX_PASSWORD_LENGTH)
    private char[] password;
    
    public User() {}

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getLogin()
    {
        return login;
    }

    public void setLogin(String login)
    {
        this.login = login;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public long getId()
    {
	return id;
    }

    public char[] getPassword()
    {
	return password;
    }

    public void setPassword(char[] password)
    {
	this.password = password;
    }

}

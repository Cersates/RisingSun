package com.dataart.risingsun.app.model.instances;

import java.util.Date;

import javax.persistence.*;

/**
 * 
 * @author kapitoha
 *
 */
@Entity
@Table(name="Articles")
public class Article implements RSInstance {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    private long id;
    @Column (nullable=false)
    private String title;
    
    @ManyToOne
    @JoinColumn(name="user_id")
    private User author;
    
    private String description;
    private Date date;
    @Lob
    @Column(unique=false, nullable=false)
    private String content;

    public long getId()
    {
	return id;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public User getAuthor()
    {
        return author;
    }

    public void setAuthor(User author)
    {
        this.author = author;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public Date getDate()
    {
        return date;
    }

    public void setDate(Date date)
    {
        this.date = date;
    }

    public String getContent()
    {
        return content;
    }

    public void setContent(String content)
    {
        this.content = content;
    }

    public void setId(long id)
    {
        this.id = id;
    }

}

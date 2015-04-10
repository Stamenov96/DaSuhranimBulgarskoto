package com.dasuhranimbulgarskoto.blog.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity(name="Posts")
@NamedQueries({
	@NamedQuery(name = "allPosts", 
			query = "SELECT p from Posts p"),
	@NamedQuery(name = "postsByAuthor", 
			query = "SELECT p from Posts p where p.author=:author")
})
public class Post {

	@Id
	@GeneratedValue
	private long id;
	
	@Column(nullable=false,length=50)
	private String title;
	
	@Column(nullable=false,length=500)
	private String body;
	
	@ManyToOne(optional=false)
	private User author;
	
	@Column(nullable=false)
	private long subCategoryId;
	
	public User getAuthor() {
		return author;
	}
	
	public void setAuthor(User author) {
		this.author = author;
	}

	public long getSubCategoryId() {
		return subCategoryId;
	}

	public void setSubCategoryId(long subCategoryId) {
		this.subCategoryId = subCategoryId;
	}

	public Post(String title,String body){
		this.title=title;
		this.body=body;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	
	
}

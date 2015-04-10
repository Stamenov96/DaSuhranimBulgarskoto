package com.dasuhranimbulgarskoto.blog.models;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "allMainCategories", 
			query = "SELECT mc from MainCategory mc"),
	@NamedQuery(name = "mainCategoriesByAuthor", 
			query = "SELECT mc from MainCategory mc where mc.author=:author")
})
public class MainCategory {
	
	@Id
	@GeneratedValue
	private long id;
	
	@Column(nullable=false,length=50)
	private String title;
	
	@Column(nullable = false,length = 500)
	private String description;
	
	@ManyToOne(optional=false)
	private User author;
	
	public void setAuthor(User author) {
		this.author = author;
	}
	public User getAuthor() {
		return author;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public MainCategory(String title){
		this.title=title;
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
	
	
}

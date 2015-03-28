package com.dasuhranimbulgarskoto.blog.models;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


public class SubCategory {
	
	@Id
	@GeneratedValue
	private long id;
	
	@Column(nullable=false,length=255)
	private String title;
	
	@Column(nullable=false,length=50)
	private long mainCategoryId;
	
	@Column(nullable=false,length=500)
	private String description;
	
	public long getMainCategoryId() {
		return mainCategoryId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setMainCategoryId(long mainCategoryId) {
		this.mainCategoryId = mainCategoryId;
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

package com.dasuhranimbulgarskoto.blog.models;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


public class MainCategory {
	
	@Id
	@GeneratedValue
	private long id;
	
	@Column(nullable=false,length=255)
	private String title;
	
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

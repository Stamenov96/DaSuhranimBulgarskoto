package com.dasuhranimbulgarskoto.blog.models;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


public class SubCategory {
	
	@Id
	@GeneratedValue
	private int id;
	
	@Column(nullable=false,length=255)
	private String title;
	
	@Column(nullable=false,length=50)
	private MainCategory mainCategoy;
	
	public SubCategory(String title){
		this.title=title;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public MainCategory getMainCategoy() {
		return mainCategoy;
	}

	public void setMainCategoy(MainCategory mainCategoy) {
		this.mainCategoy = mainCategoy;
	}
	
	
}

package com.dasuhranimbulgarskoto.blog.models;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Post {

	@Id
	@GeneratedValue
	private long id;
	
	@Column(nullable=false,length=50)
	private String title;
	
	@Column(nullable=false,length=500)
	private String body;
	//private User author;
	

	@Column(nullable=false,length=50)
	private SubCategory subCategory;
	
	public SubCategory getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(SubCategory subCategory) {
		this.subCategory = subCategory;
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

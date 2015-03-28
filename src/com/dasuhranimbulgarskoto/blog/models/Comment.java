package com.dasuhranimbulgarskoto.blog.models;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Comment {
	
	@Id
	@GeneratedValue
	private long id;
	
	
	@Column(nullable=false,length=500)
	private String body;
	//private User author;
	

	@Column(nullable=false,length=50)
	private Post post;
	
	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public Comment(String title,String body){
		this.body=body;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	
	
	
}

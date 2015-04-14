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
@Entity(name="Comment")
@NamedQueries({
	@NamedQuery(name = "allComments", 
			query = "SELECT c from Comment c"),
	@NamedQuery(name = "commentsByAuthor", 
			query = "SELECT c from Comment c where c.author=:author")
})
public class Comment {
	
	@Id
	@GeneratedValue
	private long id;
	
	
	@Column(nullable=false,length=500)
	private String body;
	
	@ManyToOne(optional=false)
	private User author;

	@Column(nullable=false,length=50)
	private long postId;
	
	public User getAuthor() {
		return author;
	}
	
	public void setAuthor(User author) {
		this.author=author;
	}

	public long getPostId() {
		return postId;
	}

	public void setPostId(long postId) {
		this.postId = postId;
	}

	public Comment(String title,String body){
		this.body=body;
	}

	public Comment(){
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

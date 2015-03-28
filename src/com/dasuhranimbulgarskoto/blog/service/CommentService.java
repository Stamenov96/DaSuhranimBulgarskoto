package com.dasuhranimbulgarskoto.blog.service;

import java.util.ArrayList;
import java.util.List;

import com.dasuhranimbulgarskoto.blog.models.Comment;

public class CommentService {

	private final List<Comment> comments = new ArrayList<Comment>();
	private long lastCommentId=0;
	
	public List<Comment> getComments() {
		return comments;
	}

	public Comment getComment(long commentId){
		for (Comment comment : comments) {
			if (comment.getId() == commentId) {
				return comment;
			}
		}
		return null;
	}
	
	public synchronized Comment createComment(Comment comment){
		lastCommentId++;
		comment.setId(lastCommentId);
		comments.add(comment);
		return comment;
	}
	
	public Comment updateComment(long commentId,Comment comment){
		Comment toChange = getComment(commentId);
		toChange.setPostId(comment.getPostId());
		toChange.setBody(comment.getBody());
		return toChange;
	}
	
	public void deleteComment(long commentId){
		final Comment toDelete = getComment(commentId);
		comments.remove(toDelete);
	}
	
}

package com.dasuhranimbulgarskoto.blog.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.dasuhranimbulgarskoto.blog.models.Comment;
import com.dasuhranimbulgarskoto.blog.models.User;
import com.dasuhranimbulgarskoto.blog.service.CommentService;
import com.dasuhranimbulgarskoto.blog.service.Services;

@Path("comments")
public class CommentRest {
		
	private final CommentService commentService;
	private final User defaultAuthor;
 	
	public CommentRest(){
		commentService = Services.getCommentService();
		defaultAuthor = new User();
		defaultAuthor.setEmail("hello@world");
		defaultAuthor.setPassword("secret");
		
	}

	@GET
	@Path("/")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<Comment> getComments(){
		return commentService.getComments();
	}
	
	@GET
	@Path("/{commentId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Comment getComment(@PathParam("commentId") long commentId){
		return commentService.getComment(commentId);
	}		
	
	@POST
	@Path("/")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Comment createComment(Comment comment){
		comment.setAuthor(defaultAuthor);
		return commentService.createComment(comment);
	}
			
	@PUT
	@Path("/{commentId}")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Comment updateComment(@PathParam("commentId") long commentId, Comment comment){
		return commentService.updateComment(commentId, comment);
	}
	
	@DELETE
	@Path("/{commentId}")
	public void deleteComment(@PathParam("commentId") long commentId){
		commentService.deleteComment(commentId);
	}

}

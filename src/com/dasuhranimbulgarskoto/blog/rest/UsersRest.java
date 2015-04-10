package com.dasuhranimbulgarskoto.blog.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.dasuhranimbulgarskoto.blog.models.Post;
import com.dasuhranimbulgarskoto.blog.models.User;
import com.dasuhranimbulgarskoto.blog.service.PostService;
import com.dasuhranimbulgarskoto.blog.service.Services;
import com.dasuhranimbulgarskoto.blog.service.UsersService;

@Path("users")
public class UsersRest {
	private final UsersService usersService;
	private final PostService postService;


// In real world projects this is done by injection
// see https://github.com/google/guice
//	@Inject
//	public UsersRest(UsersService postsService) {
	public UsersRest() {
		usersService = Services.getUsersService();
		postService = Services.getPostService();
	}

	@GET
	@Path("/{userId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	// @PathParam binds url parameter (postId) to method parameter (postId)
	public User getUser(@PathParam("userId") long userId) {
		return usersService.getUser(userId);
	}
	
	@GET
	@Path("/{userId}/posts")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	// @PathParam binds url parameter (postId) to method parameter (postId)
	public List<Post> getUserPosts(@PathParam("userId") long userId) {
		final User author = usersService.getUser(userId);
		return postService.getPostsByAuthor(author);
	}
	
	
	@POST
	@Path("/")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public User createUser(User user) {
		// TODO set author by user session
//		post.setAuthor(defaultAuthor);
		return usersService.createUser(user);
	}
	// TODO implement update, delete
}
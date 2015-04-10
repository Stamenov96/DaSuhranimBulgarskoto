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

import com.dasuhranimbulgarskoto.blog.models.Post;
import com.dasuhranimbulgarskoto.blog.models.User;
import com.dasuhranimbulgarskoto.blog.service.PostService;
import com.dasuhranimbulgarskoto.blog.service.Services;
import com.dasuhranimbulgarskoto.blog.service.UsersService;

@Path("posts")
public class PostRest {
	
	private final PostService postService;
	private final UsersService usersService;
		// TODO should be get from session
		private final String defaultAuthorEmail ="hello@world";

	public PostRest() {
			postService = Services.getPostService();	
			usersService = Services.getUsersService();

		}

		@GET
		@Path("/")
		@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
		public List<Post> getPosts() {
			return postService.getPosts();
		}
		
		@GET
		@Path("/{postId}")
		@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
		public Post getPost(@PathParam("postId") long postId) {
			return postService.getPost(postId);
		}
		
		@POST
		@Path("/")
		@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
		@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
		public Post createPost(Post post) {
			final User author =
							usersService.getUserByEmail(defaultAuthorEmail);
			post.setAuthor(author);
			return postService.createPost(post);
		}
		
		@PUT
		@Path("/{postId}")
		@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
		@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
		public Post updatePost(@PathParam("postId") long postId,Post post) {
			return postService.updatePost(postId, post);
		}
		
		@DELETE
		@Path("/{postId}")
		public void deletePost(@PathParam("postId") long postId) {
			postService.deletePost(postId);
		}

}

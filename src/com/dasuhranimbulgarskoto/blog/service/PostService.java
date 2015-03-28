package com.dasuhranimbulgarskoto.blog.service;

import java.util.ArrayList;
import java.util.List;

import com.dasuhranimbulgarskoto.blog.models.Post;

public class PostService {

	private final List<Post> posts = new ArrayList<Post>();
	private long lastPostId=0;


	public List<Post> getPost() {
		return posts;
	}
	
	public Post getPost(long postId){
		for (Post post : posts) {
			if (post.getId() == postId) {
				return post;
			}
		}
		return null;
	}
	
	public synchronized Post createPost(Post post){
		lastPostId++;
		post.setId(lastPostId);
		posts.add(post);
		return post;
	}
	
	public Post updatePost(long postId,Post post){
		Post toChange = getPost(postId);
		toChange.setSubCategoryId(post.getSubCategoryId());
		toChange.setTitle(post.getTitle());
		toChange.setBody(post.getBody());
		return toChange;
	}
	
	
	public void deletePost(long postId){
		final Post toDelete = getPost(postId);
		posts.remove(toDelete);
	}
		
}

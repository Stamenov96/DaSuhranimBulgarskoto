package com.dasuhranimbulgarskoto.blog.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import com.dasuhranimbulgarskoto.blog.models.Post;

public class PostService {

	//private final List<Post> posts = new ArrayList<Post>();
	//private long lastPostId=0;

	private final EntityManagerFactory emf;
	
	public PostService(){
		emf=Services.getEntityManagerFactory();
		
	}
	
	public List<Post> getPost() {
		//return posts;
		final EntityManager em=emf.createEntityManager();
		try {
			return em 
					.createNamedQuery("allPosts",Post.class)
					.getResultList();
		} finally {
			em.close();
		}
		
		
		
	}
	
	public Post getPost(long postId){
		final EntityManager em =
							emf.createEntityManager();
						try {
							return em.find(Post.class, postId);
						} finally {
							em.close();
		}
	}
	
	public synchronized Post createPost(Post post){
		EntityManager em =
							emf.createEntityManager();
						final EntityTransaction tx =
							em.getTransaction();
						try {
							tx.begin();
							em.persist(post);
							tx.commit();
							return post;
						} finally {
							if (tx.isActive()) {
								tx.rollback();
							}
							em.close();
						}
	}
	
	public Post updatePost(long postId,Post post){
		EntityManager em =
							emf.createEntityManager();
						final EntityTransaction tx =
							em.getTransaction();
						try {
							tx.begin();
							final Post fromDb = em.find(Post.class, postId);
						if (fromDb != null) {
								// only body and title should be updated
								// author should not be changed
								// disadvantage is that we can miss some
								// fields that can be updated								
								fromDb.setBody(post.getBody());
								fromDb.setTitle(post.getTitle());
								em.merge(fromDb);
							}
							tx.commit();
							return fromDb;
						} finally {
							if (tx.isActive()) {
								tx.rollback();
							}
							em.close();
						}
	}
	
	
	public void deletePost(long postId){
		EntityManager em =
							emf.createEntityManager();
						final EntityTransaction tx =
							em.getTransaction();
						try {
							tx.begin();
							final Post fromDb = em.find(Post.class, postId);
							if (fromDb != null) {
								em.remove(fromDb);
							}
							tx.commit();
						} finally {
							if (tx.isActive()) {
								tx.rollback();
							}
							em.close();
						}
				 	}		
}

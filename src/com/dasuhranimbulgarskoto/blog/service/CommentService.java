package com.dasuhranimbulgarskoto.blog.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import com.dasuhranimbulgarskoto.blog.models.Comment;
import com.dasuhranimbulgarskoto.blog.models.User;

public class CommentService {

	private final EntityManagerFactory emf;
	
	public CommentService(){
		emf=Services.getEntityManagerFactory();
		
	}
	
	public List<Comment> getComments() {
		//return posts;
		final EntityManager em=emf.createEntityManager();
		try {
			return em 
					.createNamedQuery("allComments",Comment.class)
					.getResultList();
		} finally {
			em.close();
		}
		
		
		
	}
	
	public Comment getComment(long commentId){
		final EntityManager em =
							emf.createEntityManager();
						try {
							return em.find(Comment.class, commentId);
						} finally {
							em.close();
		}
	}
	
	public synchronized Comment createComment(Comment comment){
		EntityManager em =
							emf.createEntityManager();
						final EntityTransaction tx =
							em.getTransaction();
						try {
							tx.begin();
							em.persist(comment);
							tx.commit();
							return comment;
						} finally {
							if (tx.isActive()) {
								tx.rollback();
							}
							em.close();
						}
	}
	
	public Comment updateComment(long commentId,Comment comment){
		EntityManager em =
							emf.createEntityManager();
						final EntityTransaction tx =
							em.getTransaction();
						try {
							tx.begin();
							final Comment fromDb = em.find(Comment.class, commentId);
						if (fromDb != null) {
								// only body and title should be updated
								// author should not be changed
								// disadvantage is that we can miss some
								// fields that can be updated								
								fromDb.setBody(comment.getBody());
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
	
	
	public void deleteComment(long commentId){
		EntityManager em =
							emf.createEntityManager();
						final EntityTransaction tx =
							em.getTransaction();
						try {
							tx.begin();
							final Comment fromDb = em.find(Comment.class, commentId);
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

	public List<Comment> getCommentsByAuthor(User author) {
		final EntityManager em =
						emf.createEntityManager();
					try {
						return em
							.createNamedQuery("commentsByAuthor", Comment.class)
							.setParameter("author", author)
							.getResultList();
					} finally {
						em.close();
					}
	}

}

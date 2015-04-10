package com.dasuhranimbulgarskoto.blog.service;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Services {
	
	private static MainCategoryService mainCategoryService;
	private static SubCategoryService subCategoryService;
	private static PostService postService;
	private static UsersService usersService;
	private static CommentService commentService;
	private static EntityManagerFactory entityManagerFactory;
	
	public synchronized static MainCategoryService getMainCategoryService(){
		if (mainCategoryService == null) {
			mainCategoryService = new MainCategoryService();
		}
		return mainCategoryService;
		
	}
	
	public synchronized static SubCategoryService getSubCategoryService(){
		if (subCategoryService == null) {
			subCategoryService = new SubCategoryService();
		}
		return subCategoryService;
	}

	public static PostService getPostService() {
		if (postService == null) {
			postService = new PostService();
		}
		return postService;
	}

	public static CommentService getCommentService(){
		if(commentService == null){
			commentService = new CommentService();
		}
		return commentService;
	}
	
	
	public synchronized static EntityManagerFactory getEntityManagerFactory() {
			// lazy loading
			if (entityManagerFactory == null) {
				try {
					Class.forName("org.apache.derby.jdbc.ClientDriver");
				} catch (ClassNotFoundException e) {
					throw new IllegalStateException("No driver", e);
				}
				entityManagerFactory = Persistence.createEntityManagerFactory("DaSuhranimBulgarskoto");
			}
			return entityManagerFactory;
		}
		
		// for tests purposes
		static void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
			Services.entityManagerFactory = entityManagerFactory;
		}

		public synchronized static UsersService getUsersService() {
				// lazy loading
				if (usersService == null) {
					usersService = new UsersService();
					// TODO ensure there is at least one admin user
				}
				return usersService;
			}
			
			// for tests purposes
			static void setUsersService(UsersService usersService) {
				Services.usersService = usersService;
			}
				
}

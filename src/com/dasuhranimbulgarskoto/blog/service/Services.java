package com.dasuhranimbulgarskoto.blog.service;

public class Services {
	
	private static MainCategoryService mainCategoryService;
	private static SubCategoryService subCategoryService;
	private static PostService postService;
	
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


	
	
}

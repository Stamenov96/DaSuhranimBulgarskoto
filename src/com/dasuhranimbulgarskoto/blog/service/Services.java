package com.dasuhranimbulgarskoto.blog.service;

public class Services {
	
	private static MainCategoryService mainCategoryService;
	
	public synchronized static MainCategoryService getMainCategoryService(){
		if (mainCategoryService == null) {
			mainCategoryService = new MainCategoryService();
		}
		return mainCategoryService;
		
	}
}

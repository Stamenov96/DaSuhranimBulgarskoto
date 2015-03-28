package com.dasuhranimbulgarskoto.blog.service;

public class Services {
	
	private static MainCategoryService mainCategoryService;
	private static SubCategoryService subCategoryService;
	
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

	
	
}

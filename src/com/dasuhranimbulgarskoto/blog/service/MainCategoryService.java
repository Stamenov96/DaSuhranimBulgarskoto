package com.dasuhranimbulgarskoto.blog.service;

import java.util.ArrayList;
import java.util.List;

import com.dasuhranimbulgarskoto.blog.models.MainCategory;

public class MainCategoryService {

	
	private final List<MainCategory> mainCategories = new ArrayList<MainCategory>();
	private long lastMainCategoryId = 0 ;
	
	
	public List<MainCategory> getMainCategories() {
		return mainCategories;
	}
	
	public MainCategory getMainCategory(long mainCategoryId){
		for (MainCategory mainCategory : mainCategories) {
			if(mainCategory.getId() == mainCategoryId){
				return mainCategory;
			}
		}
		return null;
		
	}
	
	public synchronized MainCategory createMainCategory(MainCategory mainCategory){
		lastMainCategoryId++;
			mainCategory.setId(lastMainCategoryId);
			mainCategories.add(mainCategory);
			return mainCategory;
		
	}
	
	public MainCategory updateMainCategory(long mainCategoryId,MainCategory mainCategory){
		MainCategory toChange = getMainCategory(mainCategoryId);
		toChange.setTitle(mainCategory.getTitle());
		toChange.setDescription(mainCategory.getDescription());
		return toChange;
	}
	
	public void deleteMainCategory(long mainCategoryId){
		final MainCategory toDelete = getMainCategory(mainCategoryId);
		mainCategories.remove(toDelete);
	}
		
	
}

package com.dasuhranimbulgarskoto.blog.service;

import java.util.ArrayList;
import java.util.List;

import com.dasuhranimbulgarskoto.blog.models.SubCategory;

public class SubCategoryService {

	private final List<SubCategory> subCategories = new ArrayList<SubCategory>();
	private long lastSubCategoryId = 0 ;
	
	
	public List<SubCategory> getSubCategories() {
		return subCategories;
	}
	
	public SubCategory getSubCategory(long subCategoryId){
		for (SubCategory subCategory : subCategories) {
			if (subCategory.getId() == subCategoryId) {
				return subCategory;
			}
		}
		
		return null;
	}
	
	public synchronized SubCategory createSubCategory(SubCategory subCategory){
		lastSubCategoryId++;
		subCategory.setId(lastSubCategoryId);
		subCategories.add(subCategory);
			return subCategory;
		
	}
	
	public SubCategory updateSubCategory(long subCategoryId,SubCategory subCategory){
		SubCategory toChange = getSubCategory(subCategoryId);
		toChange.setMainCategoryId(subCategory.getMainCategoryId());
		toChange.setTitle(subCategory.getTitle());
		toChange.setDescription(subCategory.getDescription());
		return toChange;
	}
	
	public void deleteSubCategory(long subCategoryId){
		final SubCategory toDelete =getSubCategory(subCategoryId);
		subCategories.remove(toDelete);
	}
	
//	public void deleteMainCategory(long mainCategoryId){
//		final MainCategory toDelete = getMainCategory(mainCategoryId);
//		mainCategories.remove(toDelete);
//	}
//		

	
}

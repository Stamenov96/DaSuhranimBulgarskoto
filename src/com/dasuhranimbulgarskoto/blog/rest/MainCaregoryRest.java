package com.dasuhranimbulgarskoto.blog.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.dasuhranimbulgarskoto.blog.service.MainCategoryService;
import com.dasuhranimbulgarskoto.blog.service.Services;
import com.dasuhranimbulgarskoto.blog.models.MainCategory;


@Path("MainCategories")
public class MainCaregoryRest {

	private final MainCategoryService mainCategoryService;
	
	public MainCaregoryRest(){
		mainCategoryService = Services.getMainCategoryService();
	}
	
	@GET
	@Path("/")
	@Produces({MediaType.APPLICATION_JSON})
	public List<MainCategory> getMainCategories(){
		return mainCategoryService.getMainCategories();
	}
	
	@GET
	@Path("/{mainCategoryId}")
	@Produces({ MediaType.APPLICATION_JSON })
	public MainCategory getMainCategory(@PathParam("mainCategoryId") long mainCategoryId ){
		return mainCategoryService.getMainCategory(mainCategoryId);
		
	}
		
	@POST
	@Path("/")
	@Produces({ MediaType.APPLICATION_JSON })
	public MainCategory createMainCategory(MainCategory mainCategory){
		return mainCategoryService.createMainCategory(mainCategory);
	}
	
	
}

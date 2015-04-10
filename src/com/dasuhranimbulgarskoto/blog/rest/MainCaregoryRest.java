package com.dasuhranimbulgarskoto.blog.rest;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.dasuhranimbulgarskoto.blog.service.MainCategoryService;
import com.dasuhranimbulgarskoto.blog.service.Services;
import com.dasuhranimbulgarskoto.blog.service.UsersService;
import com.dasuhranimbulgarskoto.blog.models.MainCategory;
import com.dasuhranimbulgarskoto.blog.models.User;


@Path("MainCategories")
public class MainCaregoryRest {

	private final MainCategoryService mainCategoryService;
	private final UsersService usersService;
	private final String defaultAuthorEmail ="hello@world";
	
	public MainCaregoryRest(){
		mainCategoryService = Services.getMainCategoryService();
		usersService = Services.getUsersService();
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
		final User author =
				usersService.getUserByEmail(defaultAuthorEmail);
		mainCategory.setAuthor(author);
		return mainCategoryService.createMainCategory(mainCategory);
	}
	
	@PUT
	@Path("/{mainCategoryId}")
	@Produces({ MediaType.APPLICATION_JSON })
	public MainCategory updateMainCategory(@PathParam("mainCategoryId") long mainCategoryId, MainCategory mainCategory){
	return mainCategoryService.updateMainCategory(mainCategoryId, mainCategory);	
	}
	
	
	@DELETE
	@Path("/{mainCategoryId}")
	@Produces({ MediaType.APPLICATION_JSON })
	public void deleteMainCategory(@PathParam("mainCategoryId") long mainCategoryId){
		mainCategoryService.deleteMainCategory(mainCategoryId);
	}
	
}

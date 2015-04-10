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

import com.dasuhranimbulgarskoto.blog.models.SubCategory;
import com.dasuhranimbulgarskoto.blog.models.User;
import com.dasuhranimbulgarskoto.blog.service.Services;
import com.dasuhranimbulgarskoto.blog.service.SubCategoryService;
import com.dasuhranimbulgarskoto.blog.service.UsersService;

@Path("SubCategories")
public class SubCategoryRest {
		
		private final SubCategoryService subCategoryService;
		private final UsersService usersService;
		private final String defaultAuthorEmail ="hello@world";
		
		public SubCategoryRest() {
			subCategoryService = Services.getSubCategoryService();
			usersService = Services.getUsersService();
		}
		
		@GET
		@Path("/")
		@Produces({MediaType.APPLICATION_JSON})
		public List<SubCategory> getSubCategories(){
			return subCategoryService.getSubCategories();
		}
		
		@GET
		@Path("/{subCategoryId}")
		@Produces({ MediaType.APPLICATION_JSON })
		
		public SubCategory getSubCategory(@PathParam("subCategoryId") long subCategoryId){
			return subCategoryService.getSubCategory(subCategoryId);
		} 
			
		@POST
		@Path("/")
		@Produces({ MediaType.APPLICATION_JSON })
		public SubCategory createSubCategory(SubCategory subCategory){
			final User author =usersService.getUserByEmail(defaultAuthorEmail);
			subCategory.setAuthor(author);
			return subCategoryService.createSubCategory(subCategory);
		}
		
		@PUT
		@Path("/{subCategoryId}")
		@Produces({ MediaType.APPLICATION_JSON })
		public SubCategory upSubCategory(@PathParam("subCategoryId") long subCategoryId,SubCategory subCategory){
			return subCategoryService.updateSubCategory(subCategoryId, subCategory);
		}
		
		@DELETE
		@Path("/{subCategoryId}")
		@Produces({ MediaType.APPLICATION_JSON })
		public void deleteSubCategory(@PathParam("subCategoryId") long subCategoryId){
			subCategoryService.deleteSubCategory(subCategoryId);
		}
		
		
}

	
package com.dasuhranimbulgarskoto.blog.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import com.dasuhranimbulgarskoto.blog.models.MainCategory;
import com.dasuhranimbulgarskoto.blog.models.SubCategory;
import com.dasuhranimbulgarskoto.blog.models.User;

public class SubCategoryService {


	private final EntityManagerFactory emf;
	
	public SubCategoryService(){
		emf=Services.getEntityManagerFactory();
	}
	
	public List<SubCategory> getSubCategories() {
		final EntityManager em=emf.createEntityManager();
		try {
			return em 
					.createNamedQuery("allSubCategories",SubCategory.class)
					.getResultList();
		} finally {
			em.close();
		}
			
		
	}
	
	public SubCategory getSubCategory(long subcategoryId){
		final EntityManager em =
							emf.createEntityManager();
						try {
							return em.find(SubCategory.class, subcategoryId);
						} finally {
							em.close();
		}
	}
	
	public synchronized SubCategory createSubCategory(SubCategory subCategory){
		EntityManager em =
							emf.createEntityManager();
						final EntityTransaction tx =
							em.getTransaction();
						try {
							tx.begin();
							em.persist(subCategory);
							tx.commit();
							return subCategory;
						} finally {
							if (tx.isActive()) {
								tx.rollback();
							}
							em.close();
						}
	}
	
	public SubCategory updateSubCategory(long subcategoryId,SubCategory subCategory){
		EntityManager em =
							emf.createEntityManager();
						final EntityTransaction tx =
							em.getTransaction();
						try {
							tx.begin();
							final SubCategory fromDb = em.find(SubCategory.class, subcategoryId);
						if (fromDb != null) {
								// only body and title should be updated
								// author should not be changed
								// disadvantage is that we can miss some
								// fields that can be updated								
								fromDb.setDescription(subCategory.getDescription());
								fromDb.setTitle(subCategory.getTitle());
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
	
	
	public void deleteSubCategory(long subcategoryId){
		EntityManager em =
							emf.createEntityManager();
						final EntityTransaction tx =
							em.getTransaction();
						try {
							tx.begin();
							final SubCategory fromDb = em.find(SubCategory.class, subcategoryId);
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

	public List<SubCategory> getSubCategoriesByAuthor(User author) {
		final EntityManager em =
						emf.createEntityManager();
					try {
						return em
							.createNamedQuery("subCategoriesByAuthor", SubCategory.class)
							.setParameter("author", author)
							.getResultList();
					} finally {
						em.close();
					}
	}

	public List<SubCategory> getSubCategoriesForMainCategory(MainCategory mainCategory) {
		final EntityManager em =
				emf.createEntityManager();
			try {
				return em
					.createNamedQuery("subCategoriesForMainCategory", SubCategory.class)
					.setParameter("mainCategory", mainCategory)
					.getResultList();
			} finally {
				em.close();
			}
		
	}	
	
	
}

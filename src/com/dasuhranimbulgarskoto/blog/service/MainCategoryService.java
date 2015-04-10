package com.dasuhranimbulgarskoto.blog.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import com.dasuhranimbulgarskoto.blog.models.MainCategory;
import com.dasuhranimbulgarskoto.blog.models.User;

public class MainCategoryService {



	private final EntityManagerFactory emf;
	
	public MainCategoryService(){
		emf=Services.getEntityManagerFactory();
	}
	
	public List<MainCategory> getMainCategories() {
		final EntityManager em=emf.createEntityManager();
		try {
			return em 
					.createNamedQuery("allMainCategories",MainCategory.class)
					.getResultList();
		} finally {
			em.close();
		}
			
		
	}
	
	public MainCategory getMainCategory(long maincategoryId){
		final EntityManager em =
							emf.createEntityManager();
						try {
							return em.find(MainCategory.class, maincategoryId);
						} finally {
							em.close();
		}
	}
	
	public synchronized MainCategory createMainCategory(MainCategory mainCategory){
		EntityManager em =
							emf.createEntityManager();
						final EntityTransaction tx =
							em.getTransaction();
						try {
							tx.begin();
							em.persist(mainCategory);
							tx.commit();
							return mainCategory;
						} finally {
							if (tx.isActive()) {
								tx.rollback();
							}
							em.close();
						}
	}
	
	public MainCategory updateMainCategory(long maincategoryId,MainCategory mainCategory){
		EntityManager em =
							emf.createEntityManager();
						final EntityTransaction tx =
							em.getTransaction();
						try {
							tx.begin();
							final MainCategory fromDb = em.find(MainCategory.class, maincategoryId);
						if (fromDb != null) {
								
							
								fromDb.setDescription(mainCategory.getDescription());
								fromDb.setTitle(mainCategory.getTitle());
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
	
	
	public void deleteMainCategory(long maincategoryId){
		EntityManager em =
							emf.createEntityManager();
						final EntityTransaction tx =
							em.getTransaction();
						try {
							tx.begin();
							final MainCategory fromDb = em.find(MainCategory.class, maincategoryId);
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

	public List<MainCategory> getMainCategoriesByAuthor(User author) {
		final EntityManager em =
						emf.createEntityManager();
					try {
						return em
							.createNamedQuery("mainCategoriesByAuthor", MainCategory.class)
							.setParameter("author", author)
							.getResultList();
					} finally {
						em.close();
					}
	}	
	
	
}

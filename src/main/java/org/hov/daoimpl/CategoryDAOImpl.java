package org.hov.daoimpl;

import java.util.List;
import java.util.UUID;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.hov.dao.CategoryDAO;
import org.hov.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO{
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean addCategory(Category category) {
		try{
			sessionFactory.getCurrentSession().persist(category);
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateCategory(Category category) {
		try{
			sessionFactory.getCurrentSession().update(category);
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteCategory(UUID categoryId) {
		try{
			Category category = new Category();
			category.setCategoryid(categoryId);
			sessionFactory.getCurrentSession().delete(category);
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public Category getCategoryById(UUID categoryId) {
		try {
			Query query = sessionFactory.getCurrentSession().createQuery(
					      "from org.hov.model.Category where categoryid = :id");
			query.setParameter("id", categoryId);
			return (Category)query.getResultList().get(0);
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Category> getAllCategories() {
		try {
			return sessionFactory.getCurrentSession().createQuery(
				   "from org.hov.model.Category").list();
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
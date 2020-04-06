package org.hov.daoimpl;

import java.util.List;
import java.util.UUID;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hov.dao.SubCategoryDAO;
import org.hov.model.Admin;
import org.hov.model.SubCategory;
import org.springframework.beans.factory.annotation.Autowired;

public class SubCategoryDAOImpl implements SubCategoryDAO{
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public UUID addCategory(SubCategory subCategory) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			session.persist(subCategory);
			tx.commit();
			return subCategory.getSubCategoryId();
		}
		catch(Exception e){
			e.printStackTrace();
			tx.rollback();
			return null;
		}
		finally{
			session.close();
		}
	}

	@Override
	public boolean updateCategory(SubCategory subCategory) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			session.update(subCategory);
			tx.commit();
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
			tx.rollback();
			return false;
		}
		finally {
			session.close();
		}
	}

	@Override
	public SubCategory getCategoryById(UUID subCategoryId) {
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query=session.createQuery("from org.hov.model.SubCategory " +
											"where subCategoryId = :id");
			query.setParameter("id", subCategoryId);
			return (SubCategory) query.getResultList().get(0);
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<SubCategory> getAllCategories() {
		try {
			Session session = sessionFactory.getCurrentSession();
			return session.createQuery("from org.hov.model.SubCategory").list();
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}

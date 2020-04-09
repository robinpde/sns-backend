package org.hov.daoimpl;

import java.util.List;
import java.util.UUID;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.hov.dao.SubCategoryDAO;
import org.hov.model.SubCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("subCategoryDAO")
@Transactional
public class SubCategoryDAOImpl implements SubCategoryDAO{
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public boolean addSubCategory(SubCategory subCategory) {
		try{
			sessionFactory.getCurrentSession().persist(subCategory);
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateSubCategory(SubCategory subCategory) {
		try{
			sessionFactory.getCurrentSession().update(subCategory);
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteSubCategory(UUID subCategoryId) {
		try{
			SubCategory subCategory = new SubCategory();
			subCategory.setSubcategoryid(subCategoryId);
			sessionFactory.getCurrentSession().delete(subCategory);
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public SubCategory getSubCategoryById(UUID subCategoryId) {
		try {
			Query query = sessionFactory.getCurrentSession().createQuery(
						  "from org.hov.model.SubCategory where subcategoryid = :id");
			query.setParameter("id", subCategoryId);
			return (SubCategory)query.getResultList().get(0);
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<SubCategory> getSubCategoryList() {
		try {
			return sessionFactory.getCurrentSession().createQuery(
					"from org.hov.model.SubCategory").list();
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}

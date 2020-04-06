package org.hov.daoimpl;

import java.util.UUID;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hov.dao.BrandDAO;
import org.hov.model.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("brandDAO")
@Transactional
public class BrandDAOImpl implements BrandDAO{
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public UUID addBrand(Brand brand) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			session.persist(brand);
			tx.commit();
			return brand.getBrandId();
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
	public boolean updateBrand(Brand brand) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			session.update(brand);
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
	public Brand getBrandById(UUID brandId) {
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query=session.createQuery("from org.hov.model.Brand " +
											"where adminId = :id");
			query.setParameter("id", brandId);
			return (Brand)query.getResultList();
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
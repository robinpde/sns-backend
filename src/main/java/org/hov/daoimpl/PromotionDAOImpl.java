package org.hov.daoimpl;

import java.util.UUID;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hov.dao.PromotionDAO;
import org.hov.model.Admin;
import org.hov.model.Promotion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("promotionDAO")
@Transactional
public class PromotionDAOImpl implements PromotionDAO{
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public UUID createPromotion(Promotion promotion) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			session.persist(promotion);
			tx.commit();
			return promotion.getPromoId();
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
	public boolean updatePromotion(Promotion promotion) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			session.update(promotion);
			tx.commit();
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
			tx.rollback();
			return false;
		}
		finally{
			session.close();
		}
	}

	@Override
	public Promotion getPromotionById(UUID promotionId) {
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query=session.createQuery("from org.hov.model.Promotion " +
											"where promoId = :id");
			query.setParameter("id", promotionId);
			return (Promotion) query.getResultList().get(0);
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
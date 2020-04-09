package org.hov.daoimpl;

import java.util.UUID;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.hov.dao.PromotionDAO;
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
	public boolean addPromotion(Promotion promotion) {
		try{
			sessionFactory.getCurrentSession().persist(promotion);
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updatePromotion(Promotion promotion) {
		try{
			sessionFactory.getCurrentSession().update(promotion);
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public boolean deletePromotion(UUID promotionId) {
		try{
			Promotion promotion = new Promotion();
			promotion.setPromoid(promotionId);
			sessionFactory.getCurrentSession().delete(promotion);
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Promotion getPromotionById(UUID promotionId) {
		try {
			Query query = sessionFactory.getCurrentSession().createQuery(
						  "from org.hov.model.Promotion where promoid = :id");
			query.setParameter("id", promotionId);
			return (Promotion) query.getResultList().get(0);
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
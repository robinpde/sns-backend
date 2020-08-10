package org.hov.daoimpl;

import java.util.UUID;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.hov.dao.WishDAO;
import org.hov.model.Brand;
import org.hov.model.Wish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("wishDAO")
@Transactional
public class WishDAOImpl implements WishDAO{
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean addToWish(Wish wish) {
		try{
			sessionFactory.getCurrentSession().persist(wish);
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean removeFromWish(UUID wishId) {
		try{
			Wish wish = new Wish();
			wish.setWishid(wishId);
			sessionFactory.getCurrentSession().delete(wish);
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public Wish getWishItemById(UUID wishId) {
		try {
			Query query = sessionFactory.getCurrentSession().createQuery(
						  "from org.hov.model.Wish where wishid = :id");
			query.setParameter("id", wishId);
			return (Wish)query.getResultList().get(0);
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}

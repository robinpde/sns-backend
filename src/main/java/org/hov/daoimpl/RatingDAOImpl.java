package org.hov.daoimpl;

import java.util.UUID;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.hov.dao.RatingDAO;
import org.hov.model.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("ratingDAO")
@Transactional
public class RatingDAOImpl implements RatingDAO{
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public boolean addRating(Rating rating) {
		try{
			sessionFactory.getCurrentSession().persist(rating);
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateRating(Rating rating) {
		try{
			sessionFactory.getCurrentSession().update(rating);
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteRating(UUID ratingId) {
		try{
			Rating rating = new Rating();
			rating.setRatingid(ratingId);
			sessionFactory.getCurrentSession().delete(rating);
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Rating getRatingById(UUID ratingId) {
		try {
			Query query = sessionFactory.getCurrentSession().createQuery(
					      "from org.hov.model.Rating where ratingid = :id");
			query.setParameter("id", ratingId);
			return (Rating)query.getResultList().get(0);
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
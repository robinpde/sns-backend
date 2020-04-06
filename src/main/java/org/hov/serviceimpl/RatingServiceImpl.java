package org.hov.serviceimpl;

import java.util.UUID;

import org.hov.dao.RatingDAO;
import org.hov.model.Rating;
import org.hov.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RatingServiceImpl implements RatingService{
	@Autowired
	RatingDAO ratingDAO;
	
	@Override
	public UUID addRating(Rating rating) {
		return ratingDAO.addRating(rating);
	}

	@Override
	public boolean updateRating(Rating rating) {
		return ratingDAO.updateRating(rating);
	}

	@Override
	public Rating getRatingById(UUID ratingId) {
		return ratingDAO.getRatingById(ratingId);
	}
}
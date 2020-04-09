package org.hov.dao;

import java.util.UUID;

import org.hov.model.Rating;

public interface RatingDAO {
	public boolean addRating(Rating rating);
	public boolean updateRating(Rating rating);
	public boolean deleteRating(UUID ratingId);
	public Rating getRatingById(UUID ratingId);
}

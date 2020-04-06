package org.hov.dao;

import java.util.UUID;

import org.hov.model.Rating;

public interface RatingDAO {
	public UUID addRating(Rating rating);
	public boolean updateRating(Rating rating);
	public Rating getRatingById(UUID ratingId);
	public boolean deleteRatingById(Rating rating);
}

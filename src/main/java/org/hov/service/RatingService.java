package org.hov.service;

import java.util.UUID;

import org.hov.model.Rating;

public interface RatingService {
	public boolean addRating(Rating rating);
	public boolean updateRating(Rating rating);
	public boolean removeRating(UUID ratingId);
	public Rating getRatingById(UUID ratingId);
}

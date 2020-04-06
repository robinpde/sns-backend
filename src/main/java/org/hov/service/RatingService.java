package org.hov.service;

import java.util.UUID;

import org.hov.model.Rating;

public interface RatingService {
	public UUID addRating(Rating rating);
	public boolean updateRating(Rating rating);
	public Rating getRatingById(UUID ratingId);
}

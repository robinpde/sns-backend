package org.hov.test;

import static org.junit.Assert.assertTrue;

import java.util.UUID;

import org.hov.config.AppConfig;
import org.hov.model.Rating;
import org.hov.service.RatingService;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringJUnitConfig(classes = AppConfig.class)
public class RatingTestCases {
	@Autowired
	RatingService ratingService;

	@Test
	@Ignore
	public void addRatingValid1() {
		Rating r = new Rating();
		r.setValue(3);
		assertTrue(ratingService.addRating(r));
	}
	
	@Test
	@Ignore
	public void updateRatingValid1() {
		Rating r = ratingService.getRatingById(UUID.fromString("125eefe2-c4c6-4672-82f0-95b7a431a4be"));
		r.setValue(4);
		assertTrue(ratingService.updateRating(r));
	}

	@Test
	@Ignore
	public void removeRatingValid1() {
		assertTrue(ratingService.removeRating(UUID.fromString("125eefe2-c4c6-4672-82f0-95b7a431a4be")));
	}
}

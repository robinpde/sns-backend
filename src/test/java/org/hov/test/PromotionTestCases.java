package org.hov.test;

import static org.junit.Assert.assertTrue;

import java.util.UUID;

import org.hov.config.AppConfig;
import org.hov.model.Promotion;
import org.hov.service.PromotionService;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringJUnitConfig(AppConfig.class)
public class PromotionTestCases {
	@Autowired
	PromotionService promotionService;
	
	@Test
	@Ignore
	public void addPromotionValid1() {
		Promotion p = new Promotion();
		p.setActive(true);
		assertTrue(promotionService.createPromotion(p));
	}
	
	@Test
	@Ignore
	public void updatePromotionValid1() {
		Promotion p = promotionService.getPromotionById(UUID.fromString("e384b036-042e-45cb-92b2-8295486f0bc0"));
		p.setActive(false);
		assertTrue(promotionService.updatePromotion(p));
	}
	
	@Test
	//@Ignore
	public void removePromotion() {
		assertTrue(promotionService.removePromotion(UUID.fromString("e384b036-042e-45cb-92b2-8295486f0bc0")));
	}
}

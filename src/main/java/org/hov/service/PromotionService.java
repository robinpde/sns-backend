package org.hov.service;

import java.util.UUID;

import org.hov.model.Promotion;

public interface PromotionService {
	public boolean createPromotion(Promotion promotion);
	public boolean updatePromotion(Promotion promotion);
	public Promotion getPromotionById(UUID promotionId);
}

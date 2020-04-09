package org.hov.service;

import java.util.UUID;

import org.hov.model.Promotion;

public interface PromotionService {
	public boolean createPromotion(Promotion promotion);
	public boolean updatePromotion(Promotion promotion);
	public boolean removePromotion(UUID promotionId);
	public Promotion getPromotionById(UUID promotionId);
}

package org.hov.dao;

import java.util.UUID;

import org.hov.model.Promotion;

public interface PromotionDAO {
	public UUID createPromotion(Promotion promotion);
	public boolean updatePromotion(Promotion promotion);
	public Promotion getPromotionById(UUID promotionId);
}

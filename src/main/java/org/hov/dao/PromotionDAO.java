package org.hov.dao;

import java.util.UUID;

import org.hov.model.Promotion;

public interface PromotionDAO {
	public boolean addPromotion(Promotion promotion);
	public boolean updatePromotion(Promotion promotion);
	public boolean deletePromotion(UUID promotionId);
	public Promotion getPromotionById(UUID promotionId);
}

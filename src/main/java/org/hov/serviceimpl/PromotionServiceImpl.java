package org.hov.serviceimpl;

import java.util.UUID;

import org.hov.dao.PromotionDAO;
import org.hov.model.Promotion;
import org.hov.service.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PromotionServiceImpl implements PromotionService{
	@Autowired
	PromotionDAO promotionDAO;

	@Override
	public boolean createPromotion(Promotion promotion) {
		if(promotionDAO.createPromotion(promotion) != null) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean updatePromotion(Promotion promotion) {
		return promotionDAO.updatePromotion(promotion);
	}

	@Override
	public Promotion getPromotionById(UUID promotionId) {
		return promotionDAO.getPromotionById(promotionId);
	}
}
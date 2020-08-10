package org.hov.serviceimpl;

import java.util.UUID;

import org.hov.dao.WishDAO;
import org.hov.model.Wish;
import org.hov.service.WishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WishServiceImpl implements WishService {
	@Autowired
	WishDAO wishDAO;

	@Override
	public boolean addToWish(Wish wish) {
		return wishDAO.addToWish(wish);
	}

	@Override
	public boolean removeFromWish(UUID wishId) {
		return wishDAO.removeFromWish(wishId);
	}

	@Override
	public Wish getWishItemById(UUID wishId) {
		return wishDAO.getWishItemById(wishId);
	}
}


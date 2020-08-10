package org.hov.service;

import java.util.UUID;

import org.hov.model.Wish;

public interface WishService {
	public boolean addToWish(Wish wish);
	public boolean removeFromWish(UUID wishId);
	public Wish getWishItemById(UUID wishId);
}

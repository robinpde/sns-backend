package org.hov.dao;

import java.util.UUID;
import org.hov.model.Wish;

public interface WishDAO {
	public boolean addToWish(Wish wish);
	public boolean removeFromWish(UUID wishId);
	public Wish getWishItemById(UUID wishId);
}

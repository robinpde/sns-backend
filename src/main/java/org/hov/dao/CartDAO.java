package org.hov.dao;

import java.util.UUID;

import org.hov.model.Cart;

public interface CartDAO {
		public boolean addToCart(Cart cart);
		public boolean removeFromCart(UUID cartId);
		public Cart getCartItemById(UUID cartId);
}

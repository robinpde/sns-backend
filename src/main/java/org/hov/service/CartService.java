package org.hov.service;

import java.util.UUID;

import org.hov.model.Cart;

public interface CartService {
	public boolean addToCart(Cart cart);
	public boolean removeFromCart(UUID cartId);
	public Cart getCartItemById(UUID cartId);
}

package org.hov.serviceimpl;

import java.util.UUID;

import org.hov.dao.CartDAO;
import org.hov.model.Cart;
import org.hov.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {
	@Autowired
	CartDAO cartDAO;
	
	@Override
	public boolean addToCart(Cart cart) {
		return cartDAO.addToCart(cart);
	}

	@Override
	public boolean removeFromCart(UUID cartId) {
		return cartDAO.removeFromCart(cartId);
	}

	@Override
	public Cart getCartItemById(UUID cartId) {
		return cartDAO.getCartItemById(cartId);
	}
}

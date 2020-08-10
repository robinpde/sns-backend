package org.hov.daoimpl;

import java.util.UUID;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.hov.dao.CartDAO;
import org.hov.model.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("cartDAO")
@Transactional
public class CartDAOImpl implements CartDAO{
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean addToCart(Cart cart) {
		try {
			sessionFactory.getCurrentSession().persist(cart);
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean removeFromCart(UUID cartId) {
		try {
			Cart cart = new Cart();
			cart.setCartid(cartId);
			sessionFactory.getCurrentSession().delete(cart);
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public Cart getCartItemById(UUID cartId) {
		try {
			Query query = sessionFactory.getCurrentSession().createQuery(
						  "from org.hov.model.Cart where cartid = :id");
			query.setParameter("id", cartId);
			return (Cart)query.getResultList().get(0);
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}


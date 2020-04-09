package org.hov.dao;

import java.util.UUID;

import org.hov.model.Order;

public interface OrderDAO {
	public boolean addOrder(Order order);
	public boolean updateOrder(Order order);
	public boolean deleteOrder(UUID orderId);
	public Order getOrderById(UUID OrderId);
}

package org.hov.dao;

import java.util.List;
import java.util.UUID;

import org.hov.model.Order;

public interface OrderDAO {
	public UUID addOrder(Order order);
	public boolean updateOrder(Order order);
	public Order getOrderById(UUID OrderId);
	public List<Order> getOrderListByUser(UUID userId);
}

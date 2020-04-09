package org.hov.service;

import java.util.UUID;

import org.hov.model.Order;

public interface OrderService {
	public boolean addOrder(Order order);
	public boolean updateOrder(Order order);
	public boolean removeOrder(UUID orderId);
	public Order getOrderById(UUID OrderId);
}

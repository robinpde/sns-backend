package org.hov.serviceimpl;

import java.util.UUID;

import org.hov.dao.OrderDAO;
import org.hov.model.Order;
import org.hov.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	OrderDAO orderDAO;

	@Override
	public boolean addOrder(Order order) {
		return orderDAO.addOrder(order);
	}

	@Override
	public boolean updateOrder(Order order) {
		return orderDAO.updateOrder(order);
	}
	
	@Override
	public boolean removeOrder(UUID orderId) {
		return orderDAO.deleteOrder(orderId);
	}

	@Override
	public Order getOrderById(UUID OrderId) {
		return orderDAO.getOrderById(OrderId);
	}
}
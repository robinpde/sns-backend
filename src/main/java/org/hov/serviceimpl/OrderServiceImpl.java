package org.hov.serviceimpl;

import java.util.List;
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
		if(orderDAO.addOrder(order) != null){
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean updateOrder(Order order) {
		return orderDAO.updateOrder(order);
	}

	@Override
	public Order getOrderById(UUID OrderId) {
		return orderDAO.getOrderById(OrderId);
	}

	@Override
	public List<Order> getOrderListByUser(UUID userId) {
		return orderDAO.getOrderListByUser(userId);
	}
}
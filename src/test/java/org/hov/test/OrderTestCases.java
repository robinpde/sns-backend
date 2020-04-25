package org.hov.test;

import static org.junit.Assert.assertTrue;

import java.util.UUID;

import org.hov.config.AppConfig;
import org.hov.enums.OrderStatus;
import org.hov.model.Order;
import org.hov.service.OrderService;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringJUnitConfig(AppConfig.class)
public class OrderTestCases {
	@Autowired
	OrderService orderService;
	
	@Test
	@Ignore
	public void addOrderValid1() {
		Order o = new Order();
		o.setOrderStatus(OrderStatus.ORDER_DELIVERED);
		assertTrue(orderService.addOrder(o));
	}	
	
	@Test
	@Ignore
	public void updaterderValid1() {
		Order o = orderService.getOrderById(UUID.fromString("86f4e59f-05f8-4c47-b1a8-f3a3b832bacb"));
		o.setOrderStatus(OrderStatus.ORDER_IN_CART);
		assertTrue(orderService.updateOrder(o));
	}
	
	@Test
	//@Ignore
	public void removeOrderValid1() {
		assertTrue(orderService.removeOrder(UUID.fromString("86f4e59f-05f8-4c47-b1a8-f3a3b832bacb")));
	}
}

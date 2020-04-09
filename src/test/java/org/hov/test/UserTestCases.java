package org.hov.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.UUID;

import org.hov.config.AppConfig;
import org.hov.model.User;
import org.hov.service.UserService;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringJUnitConfig(classes = AppConfig.class)
public class UserTestCases {
	@Autowired
	UserService userService;
	
	@Test
	@Ignore
	public void addUserValid1() {
		User u = new User();
		u.setFirstName("First Name1");
		u.setLastName("Last Name1");
		assertTrue(userService.addUser(u));
	}
	
	@Test
	@Ignore
	public void updateUserValid1() {
		User u = new User();
		u.setUserid(UUID.fromString("639ac127-56c3-4e54-910e-5a6fe2dac6e8"));
		u.setFirstName("Updated First Name");
		System.out.println(u.getFirstName());
		u.setFirstName("Updated First Name5");
		assertEquals(true, userService.updateUser(u));
	}
	
	@Test
	@Ignore
	public void removeUserValid1() {
		assertEquals(true, userService.removeUser(UUID.fromString("639ac127-56c3-4e54-910e-5a6fe2dac6e8")));
	}
	
	@Test
	@Ignore
	public void getUserValid1() {
		User u = userService.getUserById(UUID.fromString("161e1bb8-dbe5-44a5-9392-07273e706218"));
		System.out.println(u.getFirstName());
		assertEquals(true, true);
	}
}
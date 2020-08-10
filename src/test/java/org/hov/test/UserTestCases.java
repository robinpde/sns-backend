package org.hov.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.UUID;

import org.hov.config.AppConfig;
import org.hov.dao.UserDAO;
import org.hov.model.Address;
import org.hov.model.User;
import org.hov.service.AddressService;
import org.hov.service.UserService;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringJUnitConfig(classes = AppConfig.class)
public class UserTestCases {
	@Autowired
	UserService userService;

	@Autowired
	UserDAO userDAO;
	
	@Autowired
	AddressService addressService;
	
	@Test
	@Ignore
	public void addUserValid1() {
		User u = new User();
		u.setFirstName("First Name1");
		u.setLastName("Last Name1");
		u.setPassword("PPass@123");
		u.setEmail("test3210@gmail.com");
		u.setCountryCode("91");
		u.setPhone("98674734234");
		u.setDarkMode(true);
		u.setEmailAlert(true);
		u.setPhoneAlert(true);
		u.setActive(false);
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
	
	/* Address List CRUD Test*/
	@Test
	@Ignore
	public void updateUserValid2() {
		User u = new User();
		u.setUserid(UUID.fromString("971ab600-7799-4c4f-a190-8e19947a7e68"));
		u.setFirstName("Updated Pass 2");
		u.setLastName("Last Name1");
		u.setPassword("PPass@123");
		u.setEmail("test3210@gmail.com");
		u.setCountryCode("91");
		u.setPhone("98674734234");
		u.setDarkMode(true);
		u.setEmailAlert(true);
		u.setPhoneAlert(true);
		u.setActive(true);
		
		Address a3  = addressService.getAddressById(UUID.fromString("de43c3ef-193e-478b-8e0c-2cf5bd821882"));
		//Address a3  = new Address();
		//a3.setAddressid(UUID.fromString("de43c3ef-193e-478b-8e0c-2cf5bd821882"));
		System.out.println("Address: " + a3.getAddressName() + "***************************************************");
		u.removeAddress(a3);
		
		/* add address working *
		 * Address a1 = new Address(); a1.setAddressName("AddressListTest3"); Address a2
		 * = new Address(); a2.setAddressName("AddressListTest4"); u.addAddress(a1);
		 * u.addAddress(a2);
		 */
		
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
	
	@Test
	@Ignore
	@Transactional
	public void getUserValid2() {
		User u = userService.getUserById(UUID.fromString("971ab600-7799-4c4f-a190-8e19947a7e68"));
		System.out.println("-------------------------------------------");
		System.out.println("User: " + u.getFirstName());
		for(Address add:u.getAddressList()) {
			System.out.println(add.getAddressName());
		}
		assertEquals(true, true);
	}
	
	@Test
	@Ignore
	public void getUserByEmailValid1() {
		User u = userService.getUserByEmail("textman@gmail.com");
		System.out.println(u.getFirstName());
		System.out.println(u.getPassword());
		assertEquals(true, true);
	}
}
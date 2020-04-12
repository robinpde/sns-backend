package org.hov.test;

import static org.junit.Assert.assertTrue;

import java.util.UUID;

import org.hov.config.AppConfig;
import org.hov.model.Address;
import org.hov.service.AddressService;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringJUnitConfig(classes = AppConfig.class)
public class AddressTestCases {
	@Autowired
	AddressService addressService; 
	
	@Test
	@Ignore
	public void addAddressValid1() {
		Address a = new Address();
		a.setAddressName("Address1");
		a.setAddressText("AddressText1");
		a.setState("Mumbai");
		assertTrue(addressService.addAddress(a));
	}

	@Test
	@Ignore
	public void updateAddressValid1() {
		Address a = addressService.getAddressById(UUID.fromString("fd79430d-e8dd-4fe8-adbc-0ba4af67bc3b"));
		a.setAddressName("Updated Address Name123");
		assertTrue(addressService.updateAddress(a));
	}
	
	@Test
	@Ignore
	public void getAddressBById1() {
		Address a = addressService.getAddressById(UUID.fromString("fd79430d-e8dd-4fe8-adbc-0ba4af67bc3b"));
		System.out.println(a.getAddressName());
		assertTrue(true);
	}
}
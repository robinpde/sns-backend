package org.hov.test;

import static org.junit.Assert.assertTrue;

import java.util.UUID;

import org.hov.config.AppConfig;
import org.hov.model.Vendor;
import org.hov.service.VendorService;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringJUnitConfig(classes = AppConfig.class)
public class VendorTestCases {
	@Autowired
	VendorService vendorService;
	
	@Test
	@Ignore
	public void addVendorValid1() {
		Vendor v = new Vendor();
		v.setVendorName("VendorName");
		assertTrue(vendorService.addVendor(v));
	}
	
	@Test
	@Ignore
	public void updateVendorValid1() {
		Vendor v = vendorService.getVendorById(UUID.fromString("1845c5cd-f855-4c46-9d13-f8b42610960b"));
		v.setVendorName("VendorNamer");
		assertTrue(vendorService.updateVendor(v));
	}
	
	@Test
	@Ignore
	public void removeVendorValid1() {
		assertTrue(vendorService.removeVendor(UUID.fromString("1845c5cd-f855-4c46-9d13-f8b42610960b")));
	}
}

package org.hov.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.hov.config.AppConfig;
import org.hov.enums.AdminType;
import org.hov.model.Admin;
import org.hov.service.AdminService;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringJUnitConfig(classes = AppConfig.class)
public class AdminTestCases {
	@Autowired
	AdminService adminService;
	
	@Test
	@Ignore
	public void addAdmin1() {
		Admin admin = new Admin();
		admin.setAdminId("123456");
		admin.setEmail("mail1.robin@email.com");
		admin.setFirstName("Admin1 First Name");
		admin.setLastName("Admin1 Last Name");
		admin.setSuspended(true);
		admin.setAdminType(AdminType.DELIVERY_ADMIN);
		
		assertTrue(adminService.addAdmin(admin));
	}
	
	@Test
	@Ignore
	public void updateAdmin() {
		Admin admin = adminService.getAdminById("234567");
		admin.setPassword("pass");
		
		assertTrue(adminService.updateAdmin(admin));
	}
	
	@Test
	@Ignore
	public void getAdminbyId() {
		try{
			Admin admin = adminService.getAdminById("234567");
			System.out.println("Admin Name: "+ admin.getFirstName());
		}
		catch(Exception e){
			e.printStackTrace();
		}
		assertNotNull(adminService.getAdminById("234567"));
	}
	
	@Test
	@Ignore
	public void getAllAdmins() {
		assertNotNull(adminService.getAdminById("234567"));
	}
	
	@Test
	@Ignore
	public void toggleSuspend() {
		assertTrue(adminService.toggleSuspend("234567"));
	}
}
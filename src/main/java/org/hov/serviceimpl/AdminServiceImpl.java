package org.hov.serviceimpl;

import java.util.List;

import org.hov.dao.AdminDAO;
import org.hov.model.Admin;
import org.hov.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService{
	@Autowired
	AdminDAO adminDAO;
	
	@Override
	public boolean addAdmin(Admin admin) {
		return adminDAO.addAdmin(admin);
	}

	@Override
	public boolean updateAdmin(Admin admin) {
		return adminDAO.updateAdmin(admin);
	}

	@Override
	public Admin getAdminById(String adminId) {
		return adminDAO.getAdminbyId(adminId);
	}

	@Override
	public List<Admin> getAllAdmins() {
		return adminDAO.getAllAdmins();
	}
	
	@Override
	public boolean toggleSuspend(String adminId) {
		try {
			Admin admin = adminDAO.getAdminbyId(adminId);
			if(admin.isActive()) {
				admin.setActive(false);
			}else {
				admin.setActive(true);
			}
			updateAdmin(admin);
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}	
}
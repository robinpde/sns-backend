package org.hov.service;

import java.util.List;

import org.hov.model.Admin;

public interface AdminService {
	public boolean addAdmin(Admin admin);
	public boolean updateAdmin(Admin admin);
	public boolean deleteAdmin(String adminId);
	public Admin getAdminById(String adminId);
	public List<Admin> getAllAdmins();
	public boolean toggleSuspend(String adminId);
}

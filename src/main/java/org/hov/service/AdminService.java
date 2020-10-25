package org.hov.service;

import java.util.List;
import java.util.UUID;

import org.hov.model.Admin;

public interface AdminService {
	public boolean addAdmin(Admin admin);
	public boolean updateAdmin(Admin admin);
	public boolean deleteAdmin(UUID adminId);
	public Admin getAdminById(UUID adminId);
	public List<Admin> getAllAdmins();
	public boolean toggleSuspend(UUID adminId);
}

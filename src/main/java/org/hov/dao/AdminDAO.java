package org.hov.dao;

import java.util.List;

import org.hov.model.Admin;

public interface AdminDAO {
	public boolean addAdmin(Admin admin);
	public boolean updateAdmin(Admin admin);
	public Admin getAdminbyId(String adminId);
	public List<Admin> getAllAdmins();
}

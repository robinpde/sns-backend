package org.hov.dao;

import java.util.List;
import java.util.UUID;

import org.hov.model.Admin;

public interface AdminDAO {
	public boolean addAdmin(Admin admin);
	public boolean updateAdmin(Admin admin);
	public boolean deleteAdmin(UUID adminId);
	public Admin getAdminbyId(UUID adminId);
	public List<Admin> getAllAdmins();
}

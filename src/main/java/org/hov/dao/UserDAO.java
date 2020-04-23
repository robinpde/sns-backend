package org.hov.dao;

import java.util.List;
import java.util.UUID;

import org.hov.model.User;

public interface UserDAO {
	public boolean addUser(User user);
	public boolean updateUser(User user);
	public boolean deleteUser(UUID userId);
	public User getUserById(UUID userId);
	public User getUserByEmail(String email);
	public User getUserByPhone(String phone);
	public List<User> getAllUsers();
}

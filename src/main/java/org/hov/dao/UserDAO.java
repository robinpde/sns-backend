package org.hov.dao;

import java.util.List;
import java.util.UUID;

import org.hov.model.User;

public interface UserDAO {
	public UUID addUser(User user);
	public boolean updateUser(User user);
	public User getUserById(UUID userId);
	public List<User> getAllUsers();
}

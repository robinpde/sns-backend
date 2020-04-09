package org.hov.serviceimpl;

import java.util.List;
import java.util.UUID;

import org.hov.dao.UserDAO;
import org.hov.model.User;
import org.hov.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	UserDAO userDAO;
	
	@Override
	public boolean addUser(User user) {
		return userDAO.addUser(user);
	}

	@Override
	public boolean updateUser(User user) {
		return userDAO.updateUser(user);
	}
	
	@Override
	public boolean removeUser(UUID userId) {
		return userDAO.deleteUser(userId);
	}

	@Override
	public User getUserById(UUID userId) {
		return userDAO.getUserById(userId);
	}

	@Override
	public List<User> getAllUsers() {
		return userDAO.getAllUsers();
	}

	@Override
	public boolean activateUser(UUID userId) {
		try{
			User user = userDAO.getUserById(userId);
			user.setActive(true);
			userDAO.updateUser(user);
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deactivateUser(UUID userId) {
		try{
			User user = userDAO.getUserById(userId);
			user.setActive(false);
			userDAO.updateUser(user);
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
}
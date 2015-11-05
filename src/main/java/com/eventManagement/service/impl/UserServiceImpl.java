package com.eventManagement.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eventManagement.dao.UserDAO;
import com.eventManagement.entity.User;
import com.eventManagement.service.UserService;
import com.eventManagement.utility.Message;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;
	
	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	public Message delete(long userId) {
		
		return userDAO.delete(userId);
	}

	@Override
	public Message insert(User user) {
		System.out.println("in service");
		return userDAO.insert(user);
	}

	@Override
	public List<User> getAll() {
		return userDAO.getAll();
	}

	@Override
	public Message update(User user) {
		return userDAO.update(user);
	}

	@Override
	public User getById(long userId) {
		return userDAO.getById(userId);
	}

}

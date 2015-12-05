package com.eventManagement.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eventManagement.dao.UserDAO;
import com.eventManagement.entity.User;
import com.eventManagement.service.UserService;
import com.eventManagement.utility.Message;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

	
	private UserDAO userDAO;

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	public String remove(Long userId) {

		return userDAO.remove(userId,User.class);
	}

	@Override
	public User insert(User user) {
		Long id= userDAO.insert(user);
		user.setId(id);
		return user;
	}

	@Override
	public List<User> getAll() {
		return userDAO.getAll();
	}

	@Override
	public User update(User user) {
		return userDAO.update(user);
	}

	@Override
	public User getById(Long userId) {
		return userDAO.getById(userId,User.class);
	}

	@Override
	public List<User> getAllByIsDeleted(Boolean isDeleted) {
		return userDAO.getAllByIsDeleted(isDeleted);
	}

	@Override
	public List<User> getUserByEmail(String email) {
		return userDAO.getUserByEmail(email);
	}

	@Override
	public List<User> insertAll(List<User> eventUserList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> deleteAll(List<User> deletableList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> updateAll(List<User> updatableList) {
		// TODO Auto-generated method stub
		return null;
	}

}

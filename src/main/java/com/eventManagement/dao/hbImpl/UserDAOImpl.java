package com.eventManagement.dao.hbImpl;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.eventManagement.dao.UserDAO;
import com.eventManagement.entity.User;
import com.eventManagement.utility.Message;

@Repository("userDao")
public class UserDAOImpl extends AbstractDAOImpl<User> implements UserDAO {



	@Override
	public Message insert(User user) {
		return super.insert(user);
	}

	@Override
	public Message remove(Long userId, Class<User> tempClass) {
		return super.remove(userId,tempClass);
	}

	@Override
	public List<User> getAll() {
		return super.getAll();
	}

	@Override
	public User getById(Long userId,Class<User> tempClass) {
		return super.getById(userId,tempClass);
	}

	@Override
	public Message update(User user) {
		return super.update(user);
	}
}

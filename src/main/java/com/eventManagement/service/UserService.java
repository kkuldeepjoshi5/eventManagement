package com.eventManagement.service;

import java.util.List;

import com.eventManagement.entity.User;


public interface UserService extends CommanService<User> {

	public List<User> getUserByEmail(String email);

	
}

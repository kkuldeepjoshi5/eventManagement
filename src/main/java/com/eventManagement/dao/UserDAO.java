package com.eventManagement.dao;

import java.util.List;

import com.eventManagement.entity.User;
 
public interface UserDAO extends CommanDAO<User>{

	public List<User> getUserByEmail(String email);

}

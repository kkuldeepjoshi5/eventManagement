package com.eventManagement.dao.hbImpl;


import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eventManagement.dao.UserDAO;
import com.eventManagement.entity.User;
import com.eventManagement.utility.Message;

@Repository("userDao")
public class UserDAOImpl extends AbstractDAOImpl<User> implements UserDAO {


	 @Autowired
	 private SessionFactory sessionFactory;
	
	 protected Session getSession(){
		   return sessionFactory.getCurrentSession();
	 }

	@Override
	public Long insert(User user) {
		return super.insert(user);
	}

	@Override
	public String remove(Long userId, Class<User> tempClass) {
		return super.remove(userId,tempClass);
	}

	@Override
	public List<User> getAll() {
		String hql="From User";
		return super.getAll(hql);
	}

	@Override
	public User getById(Long userId,Class<User> tempClass) {
		return super.getById(userId,tempClass);
	}

	@Override
	public User update(User user) {
		return super.update(user);
	}

	@Override
	public List<User> getAllByIsDeleted(Boolean isDeleted) {
		String hql="From User WHERE isDeleted = :isDeleted";
		return super.getAllByIsDeleted(hql,isDeleted);
	}

	@Override
	public List<User> getUserByEmail(String email) {
		List<User> list = null;
		try {
			String hql="From User WHERE email = :email";
			Session session = this.sessionFactory.getCurrentSession();
			Transaction trans=session.beginTransaction();
			Query query = session.createQuery(hql);
			query.setParameter("email", email);
	         list = query.list();
	         trans.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return list;
	}

	@Override
	public List<User> updateAll(List<User> updatableList) {
		// TODO Auto-generated method stub
		return null;
	}
}

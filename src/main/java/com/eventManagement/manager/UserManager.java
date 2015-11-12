package com.eventManagement.manager;

import java.util.List;

import javax.servlet.ServletContext;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import com.eventManagement.entity.User;
import com.eventManagement.service.UserService;
import com.eventManagement.utility.Message;

public class UserManager{
	
	private UserService userService;
	
	 private static SessionFactory factory; 

	private ServletContext servletContext;
	
	private Message message=new Message();
	
	public ServletContext getServletContext() {
		return servletContext;
	}

	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public Message delete(Long userId) {
		User user=userService.getById(userId);
		//user.setDeleted(true);
		return userService.update(user);
	}

	public Message insert(User user) {
		Long userId=0L;
	  try{
	         factory = new AnnotationConfiguration().configure().addAnnotatedClass(User.class).buildSessionFactory();
	      }catch (Throwable ex) { 
	         System.err.println("Failed to create sessionFactory object." + ex);
	         throw new ExceptionInInitializerError(ex); 
	      }
		  Session session = factory.openSession();
	      Transaction tx = null;
	      try{
	         tx = session.beginTransaction();
	       
	         userId = (Long) session.save(user); 
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
	      if(userId==0L){
	    	  message.setMessageString("error in insert record");
	      }else{
	    	  message.setMessageString("success in insert record");
	      }
	      return message;
		//return userService.insert(user);
	}

	public List<User> getAll() {
		return userService.getAll();
	}

	

	public Message update(User user) {
		
		return userService.update(user);
	}

	public Message loginAction(User user) {
		return userService.update(user);
	}

	public List<User> getUserByEmail(String email) {
		return userService.getUserByEmail(email);
	}

	public List<User> getAllByIsDeleted(Boolean isDeleted) {
		return userService.getAllByIsDeleted(isDeleted);
	}
	
	
}
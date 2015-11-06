package com.eventManagement.dao.hbImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.eventManagement.entity.Event;
import com.eventManagement.utility.Message;

public abstract class AbstractDAOImpl<E> {


	 @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }

	public Message insert(E e)  {
		Message message=new Message();
		message.setMessageString("fail to insert data...");
		try {
			Session session = this.sessionFactory.getCurrentSession();
			Transaction trans=session.beginTransaction();
			session.save(e);
			trans.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			message.setMessageString(ex.getMessage());
		}

		return message;
	}

	public Message remove(Long id,Class<Event> tempClass) {
		Message message=new Message();
		try {
			 Session session = this.sessionFactory.getCurrentSession();
		        E e = (E) session.load(tempClass, new Long(id));
		        if(null != e){
		            session.delete(e);
		        }
		} catch (Exception ex) {
			message.setMessageString(ex.getMessage());
		}
		return message;
	}

	public List<E> getAll() {

		List<E> list = null;
		try {
			Session session = this.sessionFactory.getCurrentSession();
	         list = session.createQuery("from Person").list();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return list;
	}



	public E getById(Long id,Class<Event> tempClass) {
		E e=null;
		try {
			Session session = this.sessionFactory.getCurrentSession();
			  e = (E) session.load(tempClass, new Long(id));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return e;
	}



	public Message update(E e) {
		Message message=new Message();
		message.setMessageString("fail to update data...");
		try {
			Session session = this.sessionFactory.getCurrentSession();
	        session.update(e);
		} catch (Exception ex) {
			ex.printStackTrace();
			message.setMessageString(ex.getMessage());
		}
		return message;
	}



}

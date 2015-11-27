package com.eventManagement.dao.hbImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

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

	public Message remove(Long id,Class<E> tempClass) {
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

	public List<E> getAll(String hql) {

		List<E> list = null;
		try {
			Session session = this.sessionFactory.getCurrentSession();

	         list = session.createQuery(hql).list();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return list;
	}

	public List<E> getAllByIsDeleted(String hql, Boolean isDeleted) {
		List<E> list = null;
		try {
			Session session = this.sessionFactory.getCurrentSession();
			Transaction trans=session.beginTransaction();
			Query query = session.createQuery(hql);
			query.setParameter("isDeleted", isDeleted);
	         list = query.list();
	         trans.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return list;
	}

	public E getById(Long id,Class<E> tempClass) {
		E e=null;
		try {
			Session session = this.sessionFactory.getCurrentSession();
			Transaction trans=session.beginTransaction();
			  e = (E) session.get(tempClass, id);
			  trans.commit();
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
			Transaction trans=session.beginTransaction();
	        session.update(e);
	        trans.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			message.setMessageString(ex.getMessage());
		}
		return message;
	}

}

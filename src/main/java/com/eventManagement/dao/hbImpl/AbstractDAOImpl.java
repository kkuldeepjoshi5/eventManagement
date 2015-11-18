package com.eventManagement.dao.hbImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.eventManagement.entity.Event;
import com.eventManagement.entity.EventUser;
import com.eventManagement.utility.Message;

public abstract class AbstractDAOImpl<E> {


	 @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }

	public Long insert(E e)  {
		Long created=null;
		try {
			Session session = this.sessionFactory.getCurrentSession();
			Transaction trans=session.beginTransaction();
			 created= (Long) session.save(e);
			trans.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return created;
	}

	public Map<Long,E> insertAll(List<E> elist) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Map<Long,E> createdEntities = new HashMap<Long, E>();
		for (E e : elist) {
			Long created= (Long) session.save(e);
			createdEntities.put(created, e);
		}

		tx.commit();
		session.close();

		return createdEntities;
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
			Transaction trans=session.beginTransaction();
	         list = session.createQuery(hql).list();
	         trans.commit();
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



	public E update(E e) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			Transaction trans=session.beginTransaction();
			session.update(e);
	        trans.commit();
	        return e;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
		
	}

	public List<E> updateAll(List<E> updatableList) {
		List<E> updatedList=new ArrayList<E>();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		for (E e : updatableList) {
			session.update(e);
			updatedList.add(e);
		}
		tx.commit();
		session.close();
		return updatedList;
	}

	
}

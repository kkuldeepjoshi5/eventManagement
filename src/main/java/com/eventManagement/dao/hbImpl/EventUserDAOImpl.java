package com.eventManagement.dao.hbImpl;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eventManagement.dao.EventUserDAO;
import com.eventManagement.entity.EventUser;
import com.eventManagement.utility.Message;

@Repository("eventUserDao")
public class EventUserDAOImpl extends AbstractDAOImpl<EventUser> implements EventUserDAO {

	 @Autowired
	 private SessionFactory sessionFactory;

	 protected Session getSession(){
		   return sessionFactory.getCurrentSession();
	 }

	@Override
	public Message insert(EventUser eventUser) {
		return super.insert(eventUser);
	}

	@Override
	public Message remove(Long eventUserId, Class<EventUser> tempClass) {
		return super.remove(eventUserId,tempClass);
	}

	@Override
	public List<EventUser> getAll() {
		String hql="From EventUser";
		return super.getAll(hql);
	}

	@Override
	public EventUser getById(Long eventUserId,Class<EventUser> tempClass) {
		return super.getById(eventUserId,tempClass);
	}

	@Override
	public Message update(EventUser eventUser) {
		return super.update(eventUser);
	}

	@Override
	public List<EventUser> getAllByIsDeleted(Boolean isDeleted) {

		String hql="From EventUser Where isDeleted= :isDeleted";
		return super.getAllByIsDeleted(hql,isDeleted);
	}

	@Override
	public List<EventUser> getByEventId(Long eventID) {
		List<EventUser> list = null;
		try {
			String hql="From EventUser WHERE eventId = :eventId";
			Session session = this.sessionFactory.getCurrentSession();
			Transaction trans=session.beginTransaction();
			Query query = session.createQuery(hql);
			query.setParameter("eventId", eventID);
	         list = query.list();
	         trans.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return list;
	}
}

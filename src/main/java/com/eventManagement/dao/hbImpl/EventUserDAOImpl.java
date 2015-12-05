package com.eventManagement.dao.hbImpl;


import java.util.List;
import java.util.Map;

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

	@Override
	public Long insert(EventUser eventUser) {
		return  super.insert(eventUser);
	}

	@Override
	public Map<Long, EventUser> insertAll(List<EventUser> elist) {
		return super.insertAll(elist);
	}

	@Override
	public String remove(Long eventUserId, Class<EventUser> tempClass) {
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
	public EventUser update(EventUser eventUser) {
		return super.update(eventUser);
	}

	@Override
	public List<EventUser> getAllByIsDeleted(Boolean isDeleted) {

		String hql="From EventUser Where isDeleted= :isDeleted";
		return super.getAllByIsDeleted(hql,isDeleted);
	}

	@Override
	public List<EventUser> getByEventIdAndIsDeleted(Long eventID,Boolean isDeleted) {
		List<EventUser> list = null;
		try {
			String hql="From EventUser WHERE eventId = :eventId AND isDeleted = :isDeleted";
			Session session =sessionFactory.getCurrentSession();
			Transaction trans=session.beginTransaction();
			Query query = session.createQuery(hql);
			query.setParameter("eventId", eventID);
			query.setParameter("isDeleted", isDeleted);
	         list = query.list();
	         trans.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return list;
	}

	@Override
	public List<EventUser> updateAll(List<EventUser> updatableList) {
		return super.updateAll(updatableList);
	}
}

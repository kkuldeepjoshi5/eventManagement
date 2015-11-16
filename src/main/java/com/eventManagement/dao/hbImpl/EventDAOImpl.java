package com.eventManagement.dao.hbImpl;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.eventManagement.dao.EventDAO;
import com.eventManagement.entity.Event;
import com.eventManagement.utility.Message;

@Repository("eventDao")
public class EventDAOImpl extends AbstractDAOImpl<Event> implements EventDAO {



	@Override
	public Long insert(Event event) {
		return super.insert(event);
	}

	@Override
	public Message remove(Long eventId, Class<Event> tempClass) {
		return super.remove(eventId,tempClass);
	}

	@Override
	public List<Event> getAll() {
		String hql="From Event";
		return super.getAll(hql);
	}

	@Override
	public Event getById(Long eventId,Class<Event> tempClass) {
		return super.getById(eventId,tempClass);
	}

	@Override
	public Event update(Event event) {
		return super.update(event);
	}

	@Override
	public List<Event> getAllByIsDeleted(Boolean isDeleted) {
		
		String hql="From Event WHERE isDeleted = :isDeleted";
		return super.getAllByIsDeleted(hql,isDeleted);
	}
}

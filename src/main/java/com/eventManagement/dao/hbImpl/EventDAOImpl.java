package com.eventManagement.dao.hbImpl;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.eventManagement.dao.EventDAO;
import com.eventManagement.entity.Event;
import com.eventManagement.utility.Message;

@Repository("eventDao")
public class EventDAOImpl extends AbstractDAOImpl<Event> implements EventDAO {



	@Override
	public Message insert(Event event) {
		return super.insert(event);
	}

	@Override
	public Message remove(Long eventId, Class<Event> tempClass) {
		return super.remove(eventId,tempClass);
	}

	@Override
	public List<Event> getAll() {
		return super.getAll();
	}

	@Override
	public Event getById(Long eventId,Class<Event> tempClass) {
		return super.getById(eventId,tempClass);
	}

	@Override
	public Message update(Event event) {
		return super.update(event);
	}
}

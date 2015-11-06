package com.eventManagement.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eventManagement.dao.EventDAO;
import com.eventManagement.entity.Event;
import com.eventManagement.service.EventService;
import com.eventManagement.utility.Message;

@Service("eventService")
@Transactional
public class EventServiceImpl implements EventService {

	@Autowired
	private EventDAO eventDAO;

	public EventDAO getEventDAO() {
		return eventDAO;
	}

	public void setEventDAO(EventDAO eventDAO) {
		this.eventDAO = eventDAO;
	}

	@Override
	public Message delete(long eventId) {

		return eventDAO.remove(eventId,Event.class);
	}

	@Override
	public Message insert(Event event) {
		System.out.println("in service");
		return eventDAO.insert(event);
	}

	@Override
	public List<Event> getAll() {
		return eventDAO.getAll();
	}

	@Override
	public Message update(Event event) {
		return eventDAO.update(event);
	}

	@Override
	public Event getById(long eventId) {
		return eventDAO.getById(eventId,Event.class);
	}

}

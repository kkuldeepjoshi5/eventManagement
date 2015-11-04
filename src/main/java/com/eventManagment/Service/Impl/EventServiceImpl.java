package com.eventManagment.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eventManagment.DAO.EventDAO;
import com.eventManagment.Entity.Event;
import com.eventManagment.Service.EventService;
import com.eventManagment.Utility.Message;

@Service
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
		
		return eventDAO.delete(eventId);
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
		return eventDAO.getById(eventId);
	}

}

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
	public String remove(Long eventId) {

		return eventDAO.remove(eventId,Event.class);
	}

	@Override
	public Event insert(Event event) {
		System.out.println("in service");
		Long id=eventDAO.insert(event);
		event.setId(id);
		return event;
	}

	@Override
	public List<Event> getAll() {
		return eventDAO.getAll();
	}

	@Override
	public List<Event> getAllByIsDeleted(Boolean isDeleted) {
		return eventDAO.getAllByIsDeleted(isDeleted);
	}

	@Override
	public Event update(Event event) {
		return eventDAO.update(event);
	}

	@Override
	public Event getById(Long eventId) {
		return eventDAO.getById(eventId,Event.class);
	}

	@Override
	public List<Event> insertAll(List<Event> eventUserList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Event> deleteAll(List<Event> deletableList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Event> updateAll(List<Event> updatableList) {
		// TODO Auto-generated method stub
		return null;
	}




}

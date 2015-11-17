package com.eventManagement.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eventManagement.dao.EventUserDAO;
import com.eventManagement.entity.EventUser;
import com.eventManagement.service.EventUserService;
import com.eventManagement.utility.Message;

@Service("eventUserService")
@Transactional
public class EventUserServiceImpl implements EventUserService {

	@Autowired
	private EventUserDAO eventUserDAO;

	public EventUserDAO getEventUserDAO() {
		return eventUserDAO;
	}

	public void setEventUserDAO(EventUserDAO eventUserDAO) {
		this.eventUserDAO = eventUserDAO;
	}

	@Override
	public Message remove(Long eventUserId) {

		return eventUserDAO.remove(eventUserId,EventUser.class);
	}

	@Override
	public EventUser insert(EventUser eventUser) {
		System.out.println("in service");
		Long id = eventUserDAO.insert(eventUser);
		eventUser.setId(id);
		return eventUser;
	}

	@Override
	public List<EventUser> getAll() {
		return eventUserDAO.getAll();
	}

	@Override
	public List<EventUser> getAllByIsDeleted(Boolean isDeleted) {
		return eventUserDAO.getAllByIsDeleted(isDeleted);
	}

	@Override
	public EventUser update(EventUser eventUser) {
		return eventUserDAO.update(eventUser);
	}

	@Override
	public EventUser getById(Long eventUserId) {
		return eventUserDAO.getById(eventUserId,EventUser.class);
	}

	@Override
	public List<EventUser> getByEventId(Long eventID) {
		return eventUserDAO.getByEventId(eventID);
	}

	@Override
	public List<EventUser> insertAll(List<EventUser> eventUserList) {
		// TODO Auto-generated method stub
		return null;
	}



}

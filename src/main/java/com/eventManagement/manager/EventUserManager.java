package com.eventManagement.manager;

import java.util.List;

import com.eventManagement.entity.EventUser;
import com.eventManagement.service.EventUserService;
import com.eventManagement.utility.Message;

public class EventUserManager{

	private EventUserService eventUserService;

	public EventUserService getEventUserService() {
		return eventUserService;
	}

	public void setEventUserService(EventUserService eventUserService) {
		this.eventUserService = eventUserService;
	}

	public Message delete(Long eventUserId) {
		EventUser eventUser=eventUserService.getById(eventUserId);
		eventUser.setIsDeleted(Boolean.TRUE);
		return eventUserService.update(eventUser);
	}

	public Message insert(EventUser eventUser) {
		return eventUserService.insert(eventUser);
	}

	public List<EventUser> getAll() {
		return eventUserService.getAll();
	}

	public Message update(EventUser eventUser) {

		return eventUserService.update(eventUser);
	}

	public List<EventUser> getAllByIsDeleted(Boolean isDeleted) {
		return eventUserService.getAllByIsDeleted(isDeleted);
	}

	public List<EventUser> getByEventId(Long eventID) {

		return eventUserService.getByEventId(eventID);
	}


}
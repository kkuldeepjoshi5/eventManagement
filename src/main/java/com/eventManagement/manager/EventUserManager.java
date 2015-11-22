package com.eventManagement.manager;

import java.util.List;

import com.eventManagement.entity.EventUser;
import com.eventManagement.service.EventUserService;

public class EventUserManager{

	private EventUserService eventUserService;

	public EventUserService getEventUserService() {
		return eventUserService;
	}

	public void setEventUserService(EventUserService eventUserService) {
		this.eventUserService = eventUserService;
	}

	public EventUser delete(Long eventUserId) {
		EventUser eventUser=eventUserService.getById(eventUserId);
		eventUser.setIsDeleted(Boolean.TRUE);
		return eventUserService.update(eventUser);
	}

	public EventUser insert(EventUser eventUser) {
		return eventUserService.insert(eventUser);
	}

	public List<EventUser> getAll() {
		return eventUserService.getAll();
	}

	public EventUser update(EventUser eventUser) {
		return eventUserService.update(eventUser);
	}

	public List<EventUser> getAllByIsDeleted(Boolean isDeleted) {
		return eventUserService.getAllByIsDeleted(isDeleted);
	}

	public List<EventUser> getByEventIdAndIsDeleted(Long eventID,Boolean isDeleted) {
		return eventUserService.getByEventIdAndIsDeletedSearch(eventID,isDeleted);
	}

	public List<EventUser> insertAll(List<EventUser> eventUserList) {
		return eventUserService.insertAll(eventUserList);
	}

	public List<EventUser> deleteAll(List<EventUser> deletableList) {
		return eventUserService.deleteAll(deletableList);
	}

	public List<EventUser> updateAll(List<EventUser> deletableList) {
		return eventUserService.updateAll(deletableList);
	}


}
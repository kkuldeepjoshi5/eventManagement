package com.eventManagement.service;

import java.util.List;

import com.eventManagement.entity.EventUser;


public interface EventUserService extends CommanService<EventUser> {

	public List<EventUser> getByEventIdAndIsDeleted(Long eventID,Boolean isDelelted);

	public List<EventUser> getByEventIdAndIsDeletedSearch(Long eventID,	Boolean isDeleted);
}

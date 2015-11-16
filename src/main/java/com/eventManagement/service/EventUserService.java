package com.eventManagement.service;

import java.util.List;

import com.eventManagement.entity.EventUser;


public interface EventUserService extends CommanService<EventUser> {

	List<EventUser> getByEventId(Long eventID);
}

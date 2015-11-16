package com.eventManagement.dao;

import java.util.List;

import com.eventManagement.entity.EventUser;

public interface EventUserDAO extends CommanDAO<EventUser>{

	List<EventUser> getByEventId(Long eventID);

}

package com.eventManagement.dao;

import java.util.List;
import java.util.Map;

import com.eventManagement.entity.EventUser;

public interface EventUserDAO extends CommanDAO<EventUser>{

	public List<EventUser> getByEventId(Long eventID);

}

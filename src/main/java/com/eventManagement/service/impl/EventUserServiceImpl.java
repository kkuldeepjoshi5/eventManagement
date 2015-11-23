package com.eventManagement.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eventManagement.dao.EventUserDAO;
import com.eventManagement.entity.EventUser;
import com.eventManagement.enums.OperatorType;
import com.eventManagement.metadata.EventUserMetaData;
import com.eventManagement.service.EventUserService;
import com.eventManagement.utility.Message;
import com.eventManagement.utility.SearchService;

@Service("eventUserService")
@Transactional
public class EventUserServiceImpl implements EventUserService {

	@Autowired
	private EventUserDAO eventUserDAO;

	@Autowired
	private SearchService searchService ;

	public SearchService getSearchService() {
		return searchService;
	}

	public void setSearchService(SearchService searchService) {
		this.searchService = searchService;
	}

	private EventUserMetaData entityMetaData;

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
	public List<EventUser> getByEventIdAndIsDeleted(Long eventID,Boolean isDeleted) {
		return eventUserDAO.getByEventIdAndIsDeleted(eventID,isDeleted);
	}

	public List<EventUser> getByEventIdAndIsDeletedSearch(Long eventID,Boolean isDeleted){
		List<EventUser> eventUsers = new ArrayList<EventUser>();
		Map<String ,Object> criteria=new HashMap<String, Object>();
		if(eventID!=null){
			criteria.put(EventUserMetaData.EVENT_ID, eventID);
		}
		if(isDeleted!=null){
			criteria.put(EventUserMetaData.IS_DELETED, isDeleted);
		}


		searchService.setSearchParams(EventUser.class.getSimpleName(), criteria, OperatorType.AND);
		eventUsers =	searchService.doSearch();
		return eventUsers;
	}


	@Override
	public List<EventUser> insertAll(List<EventUser> eventUserList) {
		Map<Long, EventUser> results=eventUserDAO.insertAll(eventUserList);
		eventUserList.clear();
		for (Long eventUserId : results.keySet()) {
			results.get(eventUserId).setId(eventUserId);
			eventUserList.add(results.get(eventUserId));
		}
		return eventUserList;
	}

	@Override
	public List<EventUser> deleteAll(List<EventUser> deletableList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EventUser> updateAll(List<EventUser> updatableList) {
		return eventUserDAO.updateAll(updatableList);
	}

	public EventUserMetaData getEntityMetaData() {
		return entityMetaData;
	}

	public void setEntityMetaData(EventUserMetaData entityMetaData) {
		this.entityMetaData = entityMetaData;
	}



}

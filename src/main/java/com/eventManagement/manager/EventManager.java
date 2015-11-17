package com.eventManagement.manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.eventManagement.entity.Event;
import com.eventManagement.entity.EventUser;
import com.eventManagement.entity.User;
import com.eventManagement.enums.UserRoleType;
import com.eventManagement.service.EventService;
import com.eventManagement.vo.EventVO;

public class EventManager{

	private EventService eventService;

	private UserManager userManager;

	private EventUserManager eventUserManager;


	public EventUserManager getEventUserManager() {
		return eventUserManager;
	}

	public void setEventUserManager(EventUserManager eventUserManager) {
		this.eventUserManager = eventUserManager;
	}

	public UserManager getUserManager() {
		return userManager;
	}

	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}

	public EventService getEventService() {
		return eventService;
	}

	public void setEventService(EventService eventService) {
		this.eventService = eventService;
	}

	public Event delete(Long eventId) {
		Event event=eventService.getById(eventId);
		event.setIsDeleted(Boolean.TRUE);
		return eventService.update(event);
	}

	/*public Event craeteEventFromVO(EventVO eventVO) {

		if(eventVO.getPhotoUrl()!=null ){
			event.setPhoto(eventVO.getPhotoUrl());
			File dir = new File(servletContext.getRealPath("/") + File.separator
					+ "Event_Image");
			if (!dir.exists()){
				dir.mkdirs();
			}
			event.setDir(dir.getAbsolutePath());
			Image photo=new Image();


			File serverFile = new File(dir.getAbsolutePath() + File.separator
					+ event.getPhoto().getEventPhoto().getOriginalFilename());

			event.getPhoto().setPhotoDir(serverFile);



			photo.setUrl(eventVO.getPhotoUrl());
			event.setPhoto(photo);
		}
		return event;
	}*/

	public Event insert(Event event) {
		return eventService.insert(event);
	}

	public List<Event> getAll() {
		return eventService.getAll();
	}

	public Event update(Event event) {

		return eventService.update(event);
	}

	public List<Event> getAllByIsDeleted(Boolean isDeleted) {
		return eventService.getAllByIsDeleted(isDeleted);
	}

	public List<EventUser> beforeCreate() {
		List<EventUser> eventUserVOs=new ArrayList<EventUser>();
		List<User> users=userManager.getAllByIsDeleted(false );
		userManager.filterFromRole(users,UserRoleType.ADMIN.name());
		for (User user : users) {
			EventUser eventUser=new EventUser();
			eventUser.setUserId(user.getId());
			eventUser.setRole(user.getRole());
			eventUser.setUserName(user.getFirstName()+" "+user.getLastName());
			eventUserVOs.add(eventUser);
		}
		return eventUserVOs;
	}

	public Map<String, Object> beforeEdit(Long eventID) {
		Map<String,Object> resultMap=new HashMap<String, Object>();
		List<EventUser> availableUsers=beforeCreate();
		List<EventUser> tempAvailableList=new ArrayList<EventUser>();
		List<EventUser> existingUsers=eventUserManager.getByEventId(eventID);
		for (EventUser existingEventUser : existingUsers) {
			for(EventUser availableEventUser : availableUsers){
				if(availableEventUser.getUserId().equals(existingEventUser.getUserId())){
					tempAvailableList.add(availableEventUser);break;
				}
			}
		}
		availableUsers.removeAll(tempAvailableList);
		resultMap.put("availableUsers", availableUsers);
		resultMap.put("existingUsers", existingUsers);
		return resultMap;
	}

	public List<EventUser> InsertEventUserFromEventVO(EventVO eventVO) {
		List<EventUser> eventUserList=eventVO.getEventUsers();
		for (EventUser eventUser : eventUserList) {
			eventUser.setEventId(eventVO.getId());
			eventUser.setEventTitle(eventVO.getTitle());
		}
		return eventUserManager.insertAll(eventUserList);
	}


}
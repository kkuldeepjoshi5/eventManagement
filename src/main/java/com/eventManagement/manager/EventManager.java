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
import com.eventManagement.utility.Message;
import com.eventManagement.vo.UserVO;

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

	public Message delete(Long eventId) {
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

	public Message insert(Event event) {
		return eventService.insert(event);
	}

	public List<Event> getAll() {
		return eventService.getAll();
	}

	public Message update(Event event) {

		return eventService.update(event);
	}

	public List<Event> getAllByIsDeleted(Boolean isDeleted) {
		return eventService.getAllByIsDeleted(isDeleted);
	}

	public List<UserVO> beforeCreate() {
		List<UserVO> userVOs=new ArrayList<UserVO>();
		List<User> users=userManager.getAllByIsDeleted(false );
		userManager.filterFromRole(users,UserRoleType.ADMIN.name());
		for (User user : users) {
			UserVO userVO=new UserVO(user);
			userVOs.add(userVO);
		}
		return userVOs;
	}

	public Map<String, Object> beforeEdit(Long eventID) {
		Map<String,Object> resultMap=new HashMap<String, Object>();
		List<UserVO> availableUsers=beforeCreate();
		List<EventUser> existingUsers=eventUserManager.getByEventId(eventID);
		resultMap.put("availableUsers", availableUsers);
		resultMap.put("existingUsers", existingUsers);
		return resultMap;
	}


}
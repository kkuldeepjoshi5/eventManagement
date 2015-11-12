package com.eventManagement.manager;

import java.util.List;

import com.eventManagement.entity.Event;
import com.eventManagement.service.EventService;
import com.eventManagement.utility.Message;

public class EventManager{

	private EventService eventService;

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


}
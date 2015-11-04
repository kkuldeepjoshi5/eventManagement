package com.eventManagment.Manager;

import java.io.File;
import java.util.List;

import javax.servlet.ServletContext;

import com.eventManagment.Entity.Event;
import com.eventManagment.Entity.Image;
import com.eventManagment.Service.EventService;
import com.eventManagment.Utility.Message;
import com.eventManagment.vo.EventVO;

public class EventManager{
	
	private EventService eventService;

	private ServletContext servletContext;
	
	public ServletContext getServletContext() {
		return servletContext;
	}

	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}

	public EventService getEventService() {
		return eventService;
	}

	public void setEventService(EventService eventService) {
		this.eventService = eventService;
	}

	public Message delete(Long eventId) {
		Event event=eventService.getById(eventId);
		event.setDeleted(true);
		return eventService.update(event);
	}

	public Event craeteEventFromVO(EventVO eventVO) {
		Event event=new Event();
		if(eventVO.getEventDate()!=null){
			event.setEventDate(eventVO.getEventDate());
		}
		if(eventVO.getEventDesc()!=null){
			event.setEventDesc(eventVO.getEventDesc());
		}
		if(eventVO.getEventId()!=null){
			event.setEventId(eventVO.getEventId());
		}
		if(eventVO.getEventTitle()!=null){
			event.setEventTitle(eventVO.getEventTitle());
		}
		if(eventVO.getPhotoUrl()!=null ){
			Image photo=new Image();
			
			File dir = new File(servletContext.getRealPath("/") + File.separator
					+ "Event_Image");
			if (!dir.exists()){
				dir.mkdirs();
			}
			File serverFile = new File(dir.getAbsolutePath() + File.separator
					+ event.getPhoto().getEventPhoto().getOriginalFilename());

			event.getPhoto().setPhotoDir(serverFile);

			
			
			photo.setUrl(eventVO.getPhotoUrl());
			event.setPhoto(photo);
		}
		return event;
	}

	public Message insert(Event event) {
		return eventService.insert(event);
	}

	public List<Event> getAll() {
		return eventService.getAll();
	}

	public EventVO craeteVOFromEvent(Event event) {
		
		EventVO eventVO=new EventVO();
		eventVO.setEventDate(event.getEventDate());
		eventVO.setEventDesc(event.getEventDesc());
		if(event.getEventId()!=null){
			eventVO.setEventId(event.getEventId());
		}
		eventVO.setDeleted(event.getDeleted());
		eventVO.setEventTitle(event.getEventTitle());
		if(event.getPhoto()!=null ){
			eventVO.setPhotoUrl(event.getPhoto().getUrl());
		}
		return eventVO;
	}

	public Message update(Event event) {
		
		return eventService.update(event);
	}
	
	
}
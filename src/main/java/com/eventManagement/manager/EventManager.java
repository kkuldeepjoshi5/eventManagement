package com.eventManagement.manager;

import java.io.File;
import java.util.List;

import javax.servlet.ServletContext;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import com.eventManagement.entity.Event;
import com.eventManagement.entity.Image;
import com.eventManagement.service.EventService;
import com.eventManagement.utility.Message;
import com.eventManagement.vo.EventVO;

public class EventManager{
	
	private EventService eventService;
	
	 private static SessionFactory factory; 

	private ServletContext servletContext;
	
	private Message message=new Message();
	
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
		//event.setDeleted(true);
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
			event.setPhoto(eventVO.getPhotoUrl());
			File dir = new File(servletContext.getRealPath("/") + File.separator
					+ "Event_Image");
			if (!dir.exists()){
				dir.mkdirs();
			}
			event.setDir(dir.getAbsolutePath());
			/*Image photo=new Image();
			
			
			File serverFile = new File(dir.getAbsolutePath() + File.separator
					+ event.getPhoto().getEventPhoto().getOriginalFilename());

			event.getPhoto().setPhotoDir(serverFile);

			
			
			photo.setUrl(eventVO.getPhotoUrl());
			event.setPhoto(photo);*/
		}
		return event;
	}

	public Message insert(Event event) {
		Long eventId=0L;
	  try{
	         factory = new AnnotationConfiguration().configure().addAnnotatedClass(Event.class).buildSessionFactory();
	      }catch (Throwable ex) { 
	         System.err.println("Failed to create sessionFactory object." + ex);
	         throw new ExceptionInInitializerError(ex); 
	      }
		  Session session = factory.openSession();
	      Transaction tx = null;
	      try{
	         tx = session.beginTransaction();
	       
	         eventId = (Long) session.save(event); 
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
	      if(eventId==0L){
	    	  message.setMessageString("error in insert record");
	      }else{
	    	  message.setMessageString("success in insert record");
	      }
	      return message;
		//return eventService.insert(event);
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
		//eventVO.setDeleted(event.getDeleted());
		eventVO.setEventTitle(event.getEventTitle());
		if(event.getPhoto()!=null ){
			eventVO.setPhotoUrl(event.getPhoto());
		}
		return eventVO;
	}

	public Message update(Event event) {
		
		return eventService.update(event);
	}
	
	
}
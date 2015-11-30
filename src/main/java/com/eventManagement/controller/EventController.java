package com.eventManagement.controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.ServletContextAware;

import com.eventManagement.entity.Event;
import com.eventManagement.entity.EventUser;
import com.eventManagement.manager.EventManager;
import com.eventManagement.vo.EventVO;

@Controller
@RequestMapping("/event")
public class EventController implements ServletContextAware {


	private EventManager eventManager;

	public EventManager getEventManager() {
		return eventManager;
	}

	public void setEventManager(EventManager eventManager) {
		this.eventManager = eventManager;
	}

	@Autowired
	private ServletContext servletContext;

	@Override
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;

	}

	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	@ResponseBody
	public  String delete(HttpServletRequest request) {
		try{
			Long eventId =Long.parseLong(request.getParameter("eventId"));
			Event event=eventManager.delete(eventId);
			return "delete.success";
		}catch(Exception e){
			e.printStackTrace();
			return ("Exception:"+e);
		}

	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	@ResponseBody
	public  Map<String,Object> insert( @RequestBody EventVO eventVO,HttpServletRequest request){
		 Map<String,Object> resultMap= new HashMap<String, Object>();
		System.out.println("in insert mode::");
		Event event=new Event(eventVO);
		if(event.getId()!=null){
			event=eventManager.update(event);
			if(eventVO.getCreatableEventUsers()!=null && eventVO.getCreatableEventUsers().size()>0){
				eventManager.InsertEventUserFromEventVO(eventVO);
			}
			if(eventVO.getDeletableEventUsers()!=null && eventVO.getDeletableEventUsers().size()>0){
				eventManager.deleteEventUserFromEventVO(eventVO.getDeletableEventUsers());
			}
		}else{
			event=eventManager.insert(event);
			if(event.getId()!=null){
				eventVO.setId(event.getId());
			}
			if(eventVO.getCreatableEventUsers()!=null && eventVO.getCreatableEventUsers().size()>0){
				eventManager.InsertEventUserFromEventVO(eventVO);
			}
		}
		EventVO resultVO=new EventVO(event);
		resultMap.put("resultVO", resultVO);
		return resultMap;
	}


	@RequestMapping("/getAll")
	@ResponseBody
	public Map<String,Object> getAll(HttpServletRequest request) {
		Map<String,Object> resultMap=new HashMap<String, Object>();
		List<EventVO> eventVOs=new ArrayList<EventVO>();
		Boolean isDeleted=Boolean.FALSE;
		if(request.getParameter("isDeleted")!=null){
			isDeleted=Boolean.parseBoolean(request.getParameter("isDeleted"));
		}

		List<Event> events=eventManager.getAllByIsDeleted(isDeleted );
		for (Event event : events) {
			EventVO eventVO=new EventVO(event);
			eventVOs.add(eventVO);
		}
		resultMap.put("eventVOs", eventVOs);
		return resultMap;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody String update(@RequestBody EventVO eventVO) {

		Event event=new Event(eventVO);
		event=eventManager.update(event);
		return "update.success";
	}

	@RequestMapping(value="/beforeCreate",method=RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> beforeCreate(HttpServletRequest request) {
		Map<String,Object> resultMap=new HashMap<String, Object>();
		List<EventUser> eventUser = eventManager.beforeCreate();
		resultMap.put("availableUsers", eventUser);
		return resultMap;
	}

	@RequestMapping(value="/beforeEdit",method=RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> beforeEdit(HttpServletRequest request) {
		Map<String,Object> resultMap=null;
		if(request.getParameter("id")!=null){
			Long eventID=Long.parseLong(request.getParameter("id"));

			resultMap = eventManager.beforeEdit(eventID);
		}
		return resultMap;
	}


}

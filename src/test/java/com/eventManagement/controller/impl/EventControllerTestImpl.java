package com.eventManagement.controller.impl;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.sql.Date;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;

import com.eventManagement.controller.EventController;
import com.eventManagement.entity.Event;
import com.eventManagement.entity.Image;
import com.eventManagement.manager.EventManager;
import com.eventManagement.utility.Message;
import com.eventManagement.vo.EventVO;
import com.eventManagement.controller.EventControllerTest;


public class EventControllerTestImpl implements EventControllerTest {

	@Autowired
	private EventController eventController;

	private EventManager eventManager;
	
	private Message message;

	private Event event;

//	private MockMvc mockMvc;
	
	
	@Resource
	WebApplicationContext webApplicationContext;

	@Before
	public void setUp() throws Exception {

	//	mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
	//			.build();
		message = new Message();
		event = new Event();
		message.setMessageString("data successfully inserted!!!");
		event.setEventTitle("test event");
		event.setEventDate(Date.valueOf("2011-02-02"));
		event.setEventDesc("this is test event description");
		
		Image photo = new Image();
		/*MockMultipartFile file = new MockMultipartFile("image",
				"FooBar".getBytes());*/
		
		/* FileInputStream test = new FileInputStream("EventManagment/Event_Image/Desert.png");
		 System.out.println("test image:"+test);
		MockMultipartFile file = new MockMultipartFile(
		            "eventPhoto", test);*/
		
	//	multiPartRequest.addFile(new MockMultipartFile("dummyImage", "Desert.jpg","image/jpeg", new byte[20971524] ));


		
	//	System.out.println("test image file:"+file);
	//	photo.setEventPhoto(file);
		//event.setPhoto(photo);

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	@Override
	public void testInsert() {
		String actualMessage = "test fail";
		try {
			EventVO eventVO=eventManager.craeteVOFromEvent(event);
			actualMessage = eventController.insert(eventVO, null).getMessageString();
		} catch (IOException e1) {

			e1.printStackTrace();
		}
		assertEquals(message.getMessageString(), actualMessage);

	}

	@Override
	public void testDelete() {
		// TODO Auto-generated method stub

	}

	@Override
	public void testGetAll() {
		// TODO Auto-generated method stub

	}

	@Override
	public void testUpdate() {
		// TODO Auto-generated method stub

	}

	@Override
	public void testGetById() {
		// TODO Auto-generated method stub

	}

}

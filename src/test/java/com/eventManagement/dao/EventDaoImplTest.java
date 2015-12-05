package com.eventManagement.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.eventManagement.dao.hbImpl.EventDAOImpl;
import com.eventManagement.entity.Event;
import com.eventManagement.manager.EventManager;


@ContextConfiguration(locations="/webmvc-config.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class EventDaoImplTest implements ApplicationContextAware {

	
		@Autowired
		EventDAOImpl eventDaoImpl;

		public EventDAOImpl getEventDaoImpl() {
			return eventDaoImpl;
		}

		public void setEventDaoImpl(EventDAOImpl eventDaoImpl) {
			this.eventDaoImpl = eventDaoImpl;
		}

		@Test
	    @Transactional
	    @Rollback(true)
	    public void testJob() throws Exception {
			eventDaoImpl=new EventDAOImpl();
	 		List<Event> eventList = eventDaoImpl.getAllByIsDeleted(false);
	        Assert.assertEquals(2, eventList.size());
	    }

		@Override
		public void setApplicationContext(ApplicationContext arg0)
				throws BeansException {
			// TODO Auto-generated method stub
			
		}
}
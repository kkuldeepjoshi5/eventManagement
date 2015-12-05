package com.eventManagement.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.util.Collection;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.AsyncContext;
import javax.servlet.DispatcherType;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

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

import com.eventManagement.controller.EventController;
import com.eventManagement.dao.hbImpl.EventDAOImpl;
import com.eventManagement.dao.hbImpl.EventUserDAOImpl;
import com.eventManagement.dao.hbImpl.UserDAOImpl;
import com.eventManagement.entity.Event;
import com.eventManagement.entity.EventUser;
import com.eventManagement.entity.User;
import com.eventManagement.manager.EventManager;
import com.eventManagement.service.impl.EventServiceImpl;
import com.eventManagement.vo.EventVO;


@ContextConfiguration(locations="/webmvc-config.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class EventDaoImplTest2 implements ApplicationContextAware {


		@Autowired
		EventDAOImpl eventDaoImpl;

		@Autowired
		UserDAOImpl userDAOImpl;

		@Autowired
		EventUserDAOImpl eventUserDAOImpl;

		@Autowired
		EventServiceImpl eventServiceImpl;

		@Autowired
		EventController eventController;

		@Test
	    @Transactional
	    @Rollback(true)
	    public void testJob() throws Exception {
			HttpServletRequest request = new HttpServletRequest() {

				@Override
				public AsyncContext startAsync(ServletRequest arg0, ServletResponse arg1)
						throws IllegalStateException {
					// TODO Auto-generated method stub
					return null;
				}

				@Override
				public AsyncContext startAsync() throws IllegalStateException {
					// TODO Auto-generated method stub
					return null;
				}

				@Override
				public void setCharacterEncoding(String arg0)
						throws UnsupportedEncodingException {
					// TODO Auto-generated method stub

				}

				@Override
				public void setAttribute(String arg0, Object arg1) {
					// TODO Auto-generated method stub

				}

				@Override
				public void removeAttribute(String arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public boolean isSecure() {
					// TODO Auto-generated method stub
					return false;
				}

				@Override
				public boolean isAsyncSupported() {
					// TODO Auto-generated method stub
					return false;
				}

				@Override
				public boolean isAsyncStarted() {
					// TODO Auto-generated method stub
					return false;
				}

				@Override
				public ServletContext getServletContext() {
					// TODO Auto-generated method stub
					return null;
				}

				@Override
				public int getServerPort() {
					// TODO Auto-generated method stub
					return 0;
				}

				@Override
				public String getServerName() {
					// TODO Auto-generated method stub
					return null;
				}

				@Override
				public String getScheme() {
					// TODO Auto-generated method stub
					return null;
				}

				@Override
				public RequestDispatcher getRequestDispatcher(String arg0) {
					// TODO Auto-generated method stub
					return null;
				}

				@Override
				public int getRemotePort() {
					// TODO Auto-generated method stub
					return 0;
				}

				@Override
				public String getRemoteHost() {
					// TODO Auto-generated method stub
					return null;
				}

				@Override
				public String getRemoteAddr() {
					// TODO Auto-generated method stub
					return null;
				}

				@Override
				public String getRealPath(String arg0) {
					// TODO Auto-generated method stub
					return null;
				}

				@Override
				public BufferedReader getReader() throws IOException {
					// TODO Auto-generated method stub
					return null;
				}

				@Override
				public String getProtocol() {
					// TODO Auto-generated method stub
					return null;
				}

				@Override
				public String[] getParameterValues(String arg0) {
					// TODO Auto-generated method stub
					return null;
				}

				@Override
				public Enumeration<String> getParameterNames() {
					// TODO Auto-generated method stub
					return null;
				}

				@Override
				public Map<String, String[]> getParameterMap() {
					// TODO Auto-generated method stub
					return null;
				}

				@Override
				public String getParameter(String arg0) {
					// TODO Auto-generated method stub
					return null;
				}

				@Override
				public Enumeration<Locale> getLocales() {
					// TODO Auto-generated method stub
					return null;
				}

				@Override
				public Locale getLocale() {
					// TODO Auto-generated method stub
					return null;
				}

				@Override
				public int getLocalPort() {
					// TODO Auto-generated method stub
					return 0;
				}

				@Override
				public String getLocalName() {
					// TODO Auto-generated method stub
					return null;
				}

				@Override
				public String getLocalAddr() {
					// TODO Auto-generated method stub
					return null;
				}

				@Override
				public ServletInputStream getInputStream() throws IOException {
					// TODO Auto-generated method stub
					return null;
				}

				@Override
				public DispatcherType getDispatcherType() {
					// TODO Auto-generated method stub
					return null;
				}

				@Override
				public String getContentType() {
					// TODO Auto-generated method stub
					return null;
				}

				@Override
				public int getContentLength() {
					// TODO Auto-generated method stub
					return 0;
				}

				@Override
				public String getCharacterEncoding() {
					// TODO Auto-generated method stub
					return null;
				}

				@Override
				public Enumeration<String> getAttributeNames() {
					// TODO Auto-generated method stub
					return null;
				}

				@Override
				public Object getAttribute(String arg0) {
					// TODO Auto-generated method stub
					return null;
				}

				@Override
				public AsyncContext getAsyncContext() {
					// TODO Auto-generated method stub
					return null;
				}

				@Override
				public void logout() throws ServletException {
					// TODO Auto-generated method stub

				}

				@Override
				public void login(String arg0, String arg1) throws ServletException {
					// TODO Auto-generated method stub

				}

				@Override
				public boolean isUserInRole(String arg0) {
					// TODO Auto-generated method stub
					return false;
				}

				@Override
				public boolean isRequestedSessionIdValid() {
					// TODO Auto-generated method stub
					return false;
				}

				@Override
				public boolean isRequestedSessionIdFromUrl() {
					// TODO Auto-generated method stub
					return false;
				}

				@Override
				public boolean isRequestedSessionIdFromURL() {
					// TODO Auto-generated method stub
					return false;
				}

				@Override
				public boolean isRequestedSessionIdFromCookie() {
					// TODO Auto-generated method stub
					return false;
				}

				@Override
				public Principal getUserPrincipal() {
					// TODO Auto-generated method stub
					return null;
				}

				@Override
				public HttpSession getSession(boolean arg0) {
					// TODO Auto-generated method stub
					return null;
				}

				@Override
				public HttpSession getSession() {
					// TODO Auto-generated method stub
					return null;
				}

				@Override
				public String getServletPath() {
					// TODO Auto-generated method stub
					return null;
				}

				@Override
				public String getRequestedSessionId() {
					// TODO Auto-generated method stub
					return null;
				}

				@Override
				public StringBuffer getRequestURL() {
					// TODO Auto-generated method stub
					return null;
				}

				@Override
				public String getRequestURI() {
					// TODO Auto-generated method stub
					return null;
				}

				@Override
				public String getRemoteUser() {
					// TODO Auto-generated method stub
					return null;
				}

				@Override
				public String getQueryString() {
					// TODO Auto-generated method stub
					return null;
				}

				@Override
				public String getPathTranslated() {
					// TODO Auto-generated method stub
					return null;
				}

				@Override
				public String getPathInfo() {
					// TODO Auto-generated method stub
					return null;
				}

				@Override
				public Collection<Part> getParts() throws IOException, ServletException {
					// TODO Auto-generated method stub
					return null;
				}

				@Override
				public Part getPart(String arg0) throws IOException, ServletException {
					// TODO Auto-generated method stub
					return null;
				}

				@Override
				public String getMethod() {
					// TODO Auto-generated method stub
					return null;
				}

				@Override
				public int getIntHeader(String arg0) {
					// TODO Auto-generated method stub
					return 0;
				}

				@Override
				public Enumeration<String> getHeaders(String arg0) {
					// TODO Auto-generated method stub
					return null;
				}

				@Override
				public Enumeration<String> getHeaderNames() {
					// TODO Auto-generated method stub
					return null;
				}

				@Override
				public String getHeader(String arg0) {
					// TODO Auto-generated method stub
					return null;
				}

				@Override
				public long getDateHeader(String arg0) {
					// TODO Auto-generated method stub
					return 0;
				}

				@Override
				public Cookie[] getCookies() {
					// TODO Auto-generated method stub
					return null;
				}

				@Override
				public String getContextPath() {
					// TODO Auto-generated method stub
					return null;
				}

				@Override
				public String getAuthType() {
					// TODO Auto-generated method stub
					return null;
				}

				@Override
				public boolean authenticate(HttpServletResponse arg0) throws IOException,
						ServletException {
					// TODO Auto-generated method stub
					return false;
				}
			};
			request.setAttribute("isDeleted", false);
	 		Map<String, Object> eventList = eventController.getAll(request);
	 		List<User> userList = userDAOImpl.getAllByIsDeleted(false);
	 		List<EventUser> eventUserList = eventUserDAOImpl.getAllByIsDeleted(false);

	 		EventVO eventVO=new EventVO();
	 		eventVO.setTitle("first test");
	 		eventVO.setFromDate(new Date());
	 		eventVO.setToDate(new Date());
	 		Map<String, Object> result= eventController.insert(eventVO, null);
	 		eventVO=(EventVO) result.get("resultVO");
	        Assert.assertEquals(16, eventList.keySet().size()+userList.size()+eventUserList.size()+eventVO.getId());
	    }

		@Override
		public void setApplicationContext(ApplicationContext arg0)
				throws BeansException {
			// TODO Auto-generated method stub

		}
}
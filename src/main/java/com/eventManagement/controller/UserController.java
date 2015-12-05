package com.eventManagement.controller;

import java.io.IOException;
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

import com.eventManagement.entity.User;
import com.eventManagement.manager.UserManager;
import com.eventManagement.utility.Message;
import com.eventManagement.vo.UserVO;

@Controller
@RequestMapping("/user")
public class UserController implements ServletContextAware  {

	private UserManager userManager;

	public UserManager getUserManager() {
		return userManager;
	}

	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}

	private ServletContext servletContext;

	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;

	}

	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	@ResponseBody
	public  String delete(HttpServletRequest request) {
		try{
			Long userId =Long.parseLong(request.getParameter("userId"));
			userManager.delete(userId);
			return "delete.success";
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}

	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	@ResponseBody
	public  Message insert(@RequestBody UserVO userVO,HttpServletRequest request)	throws IOException {

		System.out.println("in insert mode::");
		User user=new User(userVO);

		return userManager.insert(user);
	}


	@RequestMapping("/getAll")
	@ResponseBody
	public Map<String,Object> getAll(HttpServletRequest request) {
		
		Map<String,Object> resultMap=new HashMap<String, Object>();
		List<UserVO> userVOs=new ArrayList<UserVO>();
		Boolean isDeleted=Boolean.FALSE;
		if(request.getParameter("isDeleted")!=null){
			isDeleted=Boolean.parseBoolean(request.getParameter("isDeleted"));
		}
		
		List<User> users=userManager.getAllByIsDeleted(isDeleted );
		for (User user: users) {
			UserVO userVO=new UserVO(user);
			userVOs.add(userVO);
		}
		resultMap.put("userVOs", userVOs);
		return resultMap;
		
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody String update(@RequestBody UserVO userVO) {

		User user=new User(userVO);
		userManager.update(user);
		return "update.success";
	}
	
	@RequestMapping(value = "/loginAction", method = RequestMethod.POST)
	public @ResponseBody Message loginAction(@RequestBody UserVO userVO) {		
		User newUser=new User(userVO);
		List<User> user=userManager.getUserByEmail(newUser.getEmail());
		if(user!=null){
			
		}else{
			
		}
		return null;//userManager.loginAction(user);
	}

}

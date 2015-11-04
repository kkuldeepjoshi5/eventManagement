package com.eventManagment.Controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.ServletContextAware;

import com.eventManagment.Manager.ContactUsManager;
import com.eventManagment.Utility.Mail;

@Controller
@RequestMapping("/contactUs")
public class ContactUsController implements ServletContextAware {

	
	@Autowired
	private ServletContext servletContext;

	@Override
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;

	}

	private ContactUsManager contactUsManager;

	public ContactUsManager getContactUsManager() {
		return contactUsManager;
	}
	public void setContactUsManager(ContactUsManager contactUsManager) {
		this.contactUsManager = contactUsManager;
	}

	@RequestMapping(value="/sendMail",method=RequestMethod.POST)
	@ResponseBody
	public String sendMail(HttpServletRequest request){
		try{
				

		/*	MailVO mailVO=new MailVO();
			mailVO.setHost("gmail.com");
			mailVO.setMessage("hello");
			mailVO.setName("kuldeep");
			mailVO.setPhone(9413640466L);
			mailVO.setReceiverMails("kkuldeepjoshi5@gmail.com");
			mailVO.setSenderEmail("kkuldeepjoshi5@gmail.com");
			mailVO.setSubject("hi");
			mailVO.setTo("kuldeep.joshi@metacube.com");
			System.out.println("in mail con.");
			Mail mail=contactUsManager.createMailFromVO(mailVO);*/
			Mail mail=new Mail();
			mail.sendMail();
			
			return  "send successfully.";
		}catch(Exception e){
			e.printStackTrace();
			return "some error in sending this mail.";
		}
	}

}

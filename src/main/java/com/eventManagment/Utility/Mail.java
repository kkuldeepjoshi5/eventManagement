package com.eventManagment.Utility;

import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

	
public class Mail
{
	  private String to ;//change accordingly  
	  private String from;//change accordingly  
	  private String host ;//or IP address  
	  private String subject;
	  private String text;
  
	  public String getTo() {
			return to;
		}

		public void setTo(String to) {
			this.to = to;
		}

		public String getFrom() {
			return from;
		}

		public void setFrom(String from) {
			this.from = from;
		}

		public String getHost() {
			return host;
		}

		public void setHost(String host) {
			this.host = host;
		}
		
     //Get the session object  
     public String sendMail(){
    	 // Recipient's email ID needs to be mentioned.
         String to = "kuldeep.joshi@metacube.com";

         // Sender's email ID needs to be mentioned
         String from = "kkuldeepjoshi5@gmail.com";

        /* // Assuming you are sending email from localhost
         String host = "localhost";*/

         // Get system properties
         Properties props = new Properties();
         Session session = Session.getDefaultInstance(props, null);
         System.out.print("level 1:: "+session);
         String msgBody = ".kuldeep hello.";

         try {
        	 javax.mail.Message msg = new MimeMessage(session);
        	 System.out.print("level 2:: "+msg);
             msg.setFrom(new InternetAddress(from));
             msg.addRecipient(javax.mail.Message.RecipientType.TO,new InternetAddress(to));;
             msg.setSubject("Your Example.com account has been activated");
             System.out.print("level 3:: "+msg);
             msg.setText(msgBody);
             Transport.send(msg);
             System.out.print("level 4:: "+msg);
         // Setup mail server
        /* properties.setProperty("mail.smtp.host", host);

         // Get the default Session object.
         Session session = Session.getDefaultInstance(properties);

         try{
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(javax.mail.Message.RecipientType.TO,
                                     new InternetAddress(to));

            // Set Subject: header field
            message.setSubject("This is the Subject Line!");

            // Now set the actual message
            message.setText("This is actual message");

            // Send message
            Transport.send(message);*/
 
  
         // Send message  
        
         System.out.println("message sent successfully....");  
         return "mail send successfully.";
      }
      catch (MessagingException mex) {
    	  mex.printStackTrace();
    	  return "error in sending mail"+mex;
    	}  
     }

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	
}	
	
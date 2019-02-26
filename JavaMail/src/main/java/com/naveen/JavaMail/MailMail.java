package com.naveen.JavaMail;

import java.io.File;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;

public class MailMail
{
	/*@Autowired
	private MailSender mailSender;
	
	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	} */
	private JavaMailSender mailSender;  
	   
    public void setMailSender(JavaMailSender mailSender) {  
        this.mailSender = mailSender;  
    }  
	
	/*public void sendMail(String from, String to, String subject, String msg) {

		SimpleMailMessage message = new SimpleMailMessage();
		
		message.setFrom(from);
		message.setTo(to);
		message.setSubject(subject);
		message.setText(msg);
		mailSender.send(message);
		System.out.println("mail sended Succesfully");
	} */
	
	/* public void sendMail(final String from, final String to,final String subject,final String msg) {  
         
	        MimeMessagePreparator messagePreparator = new MimeMessagePreparator() {  
	              
	                public void prepare(MimeMessage mimeMessage) throws Exception {  
	                   mimeMessage.setRecipient(Message.RecipientType.TO,new InternetAddress(to));  
	                   mimeMessage.setFrom(new InternetAddress(from));  
	                   mimeMessage.setSubject(subject);  
	                   mimeMessage.setText(msg);  
	                }

					
	        };  
	        mailSender.send(messagePreparator);  
	        System.out.println("Mail sended succesfully using Mime Message Preparator");
	    } */
	 
	public void sendMail(final String from, final String to,final String subject,final String msg) {  
	        try{  
	        MimeMessage message = mailSender.createMimeMessage();  
	  
	        MimeMessageHelper helper = new MimeMessageHelper(message, true);  
	        helper.setFrom(from);  
	        helper.setTo(to);  
	        helper.setSubject(subject);  
	        helper.setText(msg);  
	  
	        // attach the file  
	        FileSystemResource file = new FileSystemResource(new File("c:/sam.jpg"));  
	        helper.addAttachment("sam.jpg", file);//image will be sent by this name  
	  
	        mailSender.send(message);
	        System.out.println("Mail sended succesfully"+file);
	        }
	        catch(MessagingException e){e.printStackTrace();} 
	
}
}
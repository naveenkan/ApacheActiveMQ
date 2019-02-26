package com.naveen.JavaMail;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext context = 
             new ClassPathXmlApplicationContext("Spring-Mail.xml");
    	 
    	MailMail mm = (MailMail) context.getBean("mailMail");
        mm.sendMail("naveenkumar.ratnam@gmail.com",
        		"shashavali916@gmail.com",
    		   "SpringMailExample@NaveenPolaris", 
    		   "Hai shahsha im naveen sending mail through Spring");
        
    }
}

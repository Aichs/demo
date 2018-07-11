package com.ssm.test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.Properties;
import java.util.UUID;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.MailMessage;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;


public class email {
	 	private final static String FROM_EMAIL = "m17602124793@163.com";
	    private final static String HOST = "smtp.163.com";
	    private final static String PASSWORD = "aa735519898";
	    private final static String SMTP = "smtp";
	    private static Properties properties = new Properties();
	    private static Session session;
	
	@Test
	public void test() throws MessagingException {
		 
				
		        properties.setProperty("mail.transport.protocol", "smtp");//电子邮箱协议
		       
		        properties.setProperty("mail.smtp.host", HOST); //邮箱服务器地址
		        
		        properties.setProperty("mail.smtp.auth", "true"); 

		        session = Session.getInstance(properties);
		        
		        
		        
		        session.setDebug(true);//开启调试模式，可以追踪到邮件发送过程

		        Message mimeMessage = new MimeMessage(session);

		        mimeMessage.setSubject("验证您的邮箱");//标题
		       
		        
		        mimeMessage.setContent("这是一封发自eclipse的邮件，我现在正在测试", "text/html;charset=utf-8");//内容

		        mimeMessage.setFrom(new InternetAddress(FROM_EMAIL));//发送人


		        mimeMessage.setSentDate(new Date());//发送时间


		        Transport transport = session.getTransport(SMTP);

		        transport.connect("smtp.163.com","m17602124793@163.com", "aa735519898");

		        transport.sendMessage(mimeMessage, new Address[] {new InternetAddress("1542549450@qq.com")});

		        transport.close();

		    
	}
	
	@Test
	public void test1() throws MessagingException{
		
		ApplicationContext context =new ClassPathXmlApplicationContext("applicationContext.xml");
		
	}
	
	public static void main(String[] args) {
		ApplicationContext act = new ClassPathXmlApplicationContext("applicationContext.xml");
		SimpleMailMessage message = (SimpleMailMessage)act.getBean("message");
		JavaMailSenderImpl mailSender = (JavaMailSenderImpl)act.getBean("mailSender");
		message.setTo("735519898@qq.com");
		String code = UUID.randomUUID().toString().replaceAll("-", "");
		String content = "<html><head></head><body><h1>这是一封激活邮件,激活请点击以下链接</h1><h3><a href='http://localhost:8080/RegisterDemo/ActiveServlet?code="
				+ code + "'>http://localhost:8080/RegisterDemo/ActiveServlet?code=" + code
				+ "</href></h3></body></html>";
		message.setSubject("nihao");
		message.setText(content);
		mailSender.send(message);
	}

}

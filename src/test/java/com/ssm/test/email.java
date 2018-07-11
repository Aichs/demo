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
		 
				
		        properties.setProperty("mail.transport.protocol", "smtp");//��������Э��
		       
		        properties.setProperty("mail.smtp.host", HOST); //�����������ַ
		        
		        properties.setProperty("mail.smtp.auth", "true"); 

		        session = Session.getInstance(properties);
		        
		        
		        
		        session.setDebug(true);//��������ģʽ������׷�ٵ��ʼ����͹���

		        Message mimeMessage = new MimeMessage(session);

		        mimeMessage.setSubject("��֤��������");//����
		       
		        
		        mimeMessage.setContent("����һ�ⷢ��eclipse���ʼ������������ڲ���", "text/html;charset=utf-8");//����

		        mimeMessage.setFrom(new InternetAddress(FROM_EMAIL));//������


		        mimeMessage.setSentDate(new Date());//����ʱ��


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
		String content = "<html><head></head><body><h1>����һ�⼤���ʼ�,����������������</h1><h3><a href='http://localhost:8080/RegisterDemo/ActiveServlet?code="
				+ code + "'>http://localhost:8080/RegisterDemo/ActiveServlet?code=" + code
				+ "</href></h3></body></html>";
		message.setSubject("nihao");
		message.setText(content);
		mailSender.send(message);
	}

}

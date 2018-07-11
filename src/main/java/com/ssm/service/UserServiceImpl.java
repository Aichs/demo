package com.ssm.service;

import java.util.UUID;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import com.ssm.dao.UserMapper;
import com.ssm.entity.User;
import com.ssm.ip.GetIPAddress;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserMapper um;
	/**
	 * 注册
	 * @param name
	 * @param password
	 * @param email
	 * @return
	 */
	public int createUser(String name, String password,String code, String email) {
		User u=new User();
		u.setName(name);
		u.setPassword(password);
		u.setEmail(email);
//		message.setTo(email);
//		String code = UUID.randomUUID().toString().replaceAll("-", "");
//		String content = "<html><head></head><body><h1>这是一封激活邮件,激活请点击以下链接</h1><h3><a href='http://localhost:8080/RegisterDemo/ActiveServlet?code="
//				+ code + "'>http://localhost:8080/RegisterDemo/ActiveServlet?code=" + code
//				+ "</href></h3></body></html>";
//		message.setText(content);
//		mailSender.send(message);
		ApplicationContext act = new ClassPathXmlApplicationContext("applicationContext.xml");
		SimpleMailMessage message = (SimpleMailMessage)act.getBean("message");
		JavaMailSenderImpl mailSender = (JavaMailSenderImpl)act.getBean("mailSender");
		message.setTo(email);
		 code = UUID.randomUUID().toString().replaceAll("-", "");
		u.setCode(code);
		String ip=GetIPAddress.getHostIp();
		String content = "这是一封激活邮件,激活请点击以下链接http://"+ip+":8080/LGuitar/activation?code=" + code;
		message.setSubject("测试");
		message.setText(content);
		mailSender.send(message);
		return um.createUser(u);
	}
	
	/**
	 * 激活账号
	 */
	public int activation(String code) {
		
		return um.activation(code);
	}
	
	
}

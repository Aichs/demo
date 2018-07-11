package com.ssm.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssm.service.UserService;
import com.ssm.service.UserServiceImpl;

@Controller
public class CreateUserController {
	
	@Autowired
	UserService us;
	
	
	@RequestMapping("create")
	public Object create(String name,String password,String code,String email,HttpSession session,Model mo) {
		
		int count=us.createUser(name, password,code, email);
		
					
		return "jh" ;
	}
	
	@RequestMapping("activation")
	public String activation(String code,Model mo) {
		int count = us.activation(code);
		if(count>0) {
			mo.addAttribute("message", "激活成功!");
			
		}else {
			mo.addAttribute("message", "激活失败!");
		}
		return "hh";
	}
	

}

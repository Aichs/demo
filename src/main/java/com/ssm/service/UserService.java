package com.ssm.service;

import com.ssm.entity.User;

public interface UserService {
	
	/**
	 * ×¢²á
	 * @param name
	 * @param password
	 * @param email
	 * @return
	 */
	int createUser(String name,String password,String code,String email);
	
	
	/**
	 * ¼¤»îÕËºÅ
	 * @param code
	 * @return
	 */
	int activation(String code);
}

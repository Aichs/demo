package com.ssm.service;

import com.ssm.entity.User;

public interface UserService {
	
	/**
	 * ע��
	 * @param name
	 * @param password
	 * @param email
	 * @return
	 */
	int createUser(String name,String password,String code,String email);
	
	
	/**
	 * �����˺�
	 * @param code
	 * @return
	 */
	int activation(String code);
}

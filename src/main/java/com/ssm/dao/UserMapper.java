package com.ssm.dao;

import com.ssm.entity.User;

public interface UserMapper {
	
	/**
	 * ע���û�
	 * @param u
	 * @return
	 */
	int createUser(User u);
	
	/**
	 * �����˺�
	 * @param code
	 * @return
	 */
	int activation(String code);
}

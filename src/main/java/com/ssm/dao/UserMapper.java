package com.ssm.dao;

import com.ssm.entity.User;

public interface UserMapper {
	
	/**
	 * ×¢²áÓÃ»§
	 * @param u
	 * @return
	 */
	int createUser(User u);
	
	/**
	 * ¼¤»îÕËºÅ
	 * @param code
	 * @return
	 */
	int activation(String code);
}

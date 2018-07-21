package com.met.domaci.service;

import com.met.domaci.entities.User;

public interface UserService {
	
	public User findUserByUserName(String userName);
	
	public void saveUser(User user);
	
}

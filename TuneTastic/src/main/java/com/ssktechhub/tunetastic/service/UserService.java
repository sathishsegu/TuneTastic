package com.ssktechhub.tunetastic.service;

import com.ssktechhub.tunetastic.entity.User;

public interface UserService {
	
	public String addUser(User user);

	public boolean validateUser(String email, String password);

	public String getRole(String email);
	
	boolean userExists(String email, String username);

	public User getUser(String email);
	
	public void updateUser(User user);
	
}

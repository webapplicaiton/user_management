package com.sahu.um.service;

import java.util.Optional;

import com.sahu.um.model.User;

public interface UserService {

	public Long registerUser(User user);
	
	public Optional<User> findByEmail(String email);
		
}

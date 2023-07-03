package com.sahu.um.service.impl;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.sahu.um.model.User;
import com.sahu.um.repository.UserRepository;
import com.sahu.um.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Override
	public Long registerUser(User user) {
		user.setUuid(UUID.randomUUID().toString());
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setActive(true);
		user.setStatus("active");
		return userRepo.save(user).getId();
	}

	@Override
	public Optional<User> findByEmail(String email) {
		return userRepo.findByEmail(email);
	}

}

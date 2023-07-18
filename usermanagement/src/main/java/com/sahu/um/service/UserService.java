package com.sahu.um.service;

import java.util.Optional;

import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.data.jpa.domain.Specification;

import com.sahu.um.model.User;

public interface UserService {

	public Long registerUser(User user);
	
	public Optional<User> findByEmail(String email);
		
	public DataTablesOutput<User> findAll(DataTablesInput input);
	
	public DataTablesOutput<User> findAll(DataTablesInput input, Specification<User> additionalSpecification);
}

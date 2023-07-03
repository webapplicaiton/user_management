package com.sahu.um.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sahu.um.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	public Optional<User> findByEmail(String email);
	
}

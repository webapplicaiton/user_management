package com.sahu.um.service.impl;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.sahu.um.model.CustomUserDetails;

public class UserDetailServiceImpl implements UserDetailsService  {

	@Override
	public CustomUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("UserDetailServiceImpl.loadUserByUsername()");
		return null;
	}
}

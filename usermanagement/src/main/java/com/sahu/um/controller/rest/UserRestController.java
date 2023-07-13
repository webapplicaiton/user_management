package com.sahu.um.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sahu.um.service.UserService;

@RestController
@RequestMapping("/api/user/")
public class UserRestController {
	
	@Autowired
	private UserService userservice;
	
	

}

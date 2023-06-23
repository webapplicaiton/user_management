package com.sahu.um.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.sahu.um.constants.LVNConstants;
import com.sahu.um.model.User;

@Controller
public class MainController {

	@GetMapping("/")
	public String showHome() {
		return LVNConstants.INDEX_PAGE;
	}
	
	@GetMapping("/login")
	public String showLoginPage() {
		return LVNConstants.LOGIN_PAGE;
	}
	
	@GetMapping("/register")
	public String showRegistrationPage() {
		return LVNConstants.REGISTRATION_PAGE;
	}
	
	@PostMapping("/register")
	public String registerUser(@ModelAttribute("user") User user) {
		return LVNConstants.LOGIN_PAGE;
	}
}

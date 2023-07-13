package com.sahu.um.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sahu.um.constants.LVNConstants;
import com.sahu.um.model.CustomUserDetails;
import com.sahu.um.model.User;
import com.sahu.um.service.UserService;
import com.sahu.um.util.security.SecurityUtil;

@Controller
public class MainController {

	@Autowired
	private UserService userservice;
	
	@GetMapping("/")
	public String showHome() {
		return LVNConstants.INDEX_PAGE;
	}
	
	@GetMapping("/login")
	public String showLoginPage() {
		return LVNConstants.LOGIN_PAGE;
	}
	
	@GetMapping("/register")
	public String showRegistrationPage(@ModelAttribute("user") User user) {
		System.out.println("MainController.showRegistrationPage()");
		return LVNConstants.REGISTRATION_PAGE;
	}
	
	@PostMapping("/register")
	public String registerUser(@ModelAttribute("user") User user, RedirectAttributes redirectAttribute) {
		System.out.println("MainController.registerUser()");
		Optional<User> isUserExist = userservice.findByEmail(user.getEmail());
		if(isUserExist.isPresent()) {
			redirectAttribute.addFlashAttribute("RegistrationError", "User already Exists");
		    return "redirect:/register";
		}
		else {
			userservice.registerUser(user);
			redirectAttribute.addFlashAttribute("RegistrationSuccess", "User sucessfully registered");
			return "redirect:/login";
		}
	}
	@GetMapping("/dashboard")
	public String showDashboard() {
		CustomUserDetails customUserDetails = SecurityUtil.getCurrentUser();
		System.out.println(customUserDetails.getUsername());
		return LVNConstants.DASHBOARD_PAGE;
	}
	
}

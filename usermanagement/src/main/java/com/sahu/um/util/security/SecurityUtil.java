package com.sahu.um.util.security;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.sahu.um.model.CustomUserDetails;

@Component
public class SecurityUtil {

	public static CustomUserDetails getCurrentUser() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof CustomUserDetails) {
			return ((CustomUserDetails) principal);
		} else {
			return null;
		}
	}
}

package com.sahu.um.model;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomUserDetails extends User {
	
	private static final long serialVersionUID = 1L;
	
	private Long UId;
	
	private List<String> roles;
	
	private List<String> permissions;
	
	
	public CustomUserDetails(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
	}


	public CustomUserDetails(String username, String password, Collection<? extends GrantedAuthority> authorities,
			Long uId, List<String> roles, List<String> permissions) {
		super(username, password, authorities);
		UId = uId;
		this.roles = roles;
		this.permissions = permissions;
	}
	

}

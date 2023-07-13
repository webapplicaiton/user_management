package com.sahu.um.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sahu.um.model.CustomUserDetails;
import com.sahu.um.model.Permission;
import com.sahu.um.model.Role;
import com.sahu.um.model.User;
import com.sahu.um.repository.PermissionRepository;
import com.sahu.um.repository.RoleRepository;
import com.sahu.um.repository.UserRepository;

@Service
public class UserDetailServiceImpl implements UserDetailsService  {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private PermissionRepository permissionRepository;
	
	
	@Override
	public CustomUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("UserDetailServiceImpl.loadUserByUsername()");

		User user = userRepository.findByEmail(username).get();
		if (user == null) {
			throw new UsernameNotFoundException(username);
		} else {
			if (!user.isActive()) {
				throw new UsernameNotFoundException("User is not active, please contact administrator");
			}
		}

		Long loggedInUserId = user.getId();
		List<GrantedAuthority> authorities = List.of(new SimpleGrantedAuthority("EDH_USER"));


		// Here we have to write the logic to collect Roles and permission
		List<Role> roleList = roleRepository.getRolesOfUser(loggedInUserId);
					List<Permission> permissionList = permissionRepository.getAllPermissionsOfUserByUserId(loggedInUserId);

					List<String> userRoles = roleList.stream().map(Role::getName).collect(Collectors.toList());
					List<String> userPermissions = permissionList.stream().map(Permission::getName)
							.collect(Collectors.toList());

		CustomUserDetails customUserDetailsDTO = new CustomUserDetails(user.getEmail(), user.getPassword(),
				authorities, user.getId(), userPermissions, userRoles);
		return customUserDetailsDTO;
	}
	
}

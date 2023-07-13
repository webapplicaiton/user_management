package com.sahu.um.repository;

import java.util.List;

import org.springframework.data.jpa.datatables.repository.DataTablesRepository;
import org.springframework.data.jpa.repository.Query;

import com.sahu.um.model.Permission;

public interface PermissionRepository extends DataTablesRepository<Permission, Long> {
	
	@Query(value = "SELECT p.* FROM permission p INNER JOIN role_permission rp ON rp.permission_id = p.id INNER JOIN role r ON r.id = rp.role_id\r\n"
			+ " INNER JOIN user_role ur\r\n"
			+ " ON ur.role_id = r.id WHERE ur.user_id =:userId AND p.active IS TRUE", nativeQuery = true)
	public List<Permission> getAllPermissionsOfUserByUserId(Long userId);
}

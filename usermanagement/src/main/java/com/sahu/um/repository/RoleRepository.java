package com.sahu.um.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sahu.um.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
	@Query(value = "SELECT r.* from role as r inner join user_role as ur on ur.role_id=r.id\r\n"
			+ "inner join user as u on u.id = ur.user_id where u.id =:id  and r.active is true;", nativeQuery = true)
	public List<Role> getRolesOfUser(Long id);

}

package com.lucasdistasi.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lucasdistasi.login.entity.RoleEntity;

@Repository
public interface RoleEntityRepository extends JpaRepository<RoleEntity, Long> {

	@Query(value = "select r.role from roles r, users u where u.role_id = r.id_role and u.username = ?1", nativeQuery = true)
	@Transactional(readOnly = true)
	String findRoleByUsername(String username);

}

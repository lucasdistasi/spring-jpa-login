package com.lucasdistasi.login.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class RoleEntity {

	@Id
	@Column(name = "id_role")
	private Long idRole;

	@Column(name = "role", unique = true)
	private String role;
	
	@OneToMany(mappedBy = "role")
	List<UserEntity> users;

}

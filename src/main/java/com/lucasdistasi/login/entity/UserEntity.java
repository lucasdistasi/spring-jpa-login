package com.lucasdistasi.login.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "users")
public class UserEntity {

	@Id
	@Column(name = "id_user")
	private Long idUser;

	@Column(name = "username", unique = true)
	@NotBlank
	@Length(min = 5, max = 20)
	private String username;

	@Column(name = "password")
	@NotBlank
	@Length(min = 5, max = 62)
	private String password;
	
	@JoinColumn(name="role_id")
	@ManyToOne
	private RoleEntity role;
	
	

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username.trim(); // trim() removes white spaces
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}

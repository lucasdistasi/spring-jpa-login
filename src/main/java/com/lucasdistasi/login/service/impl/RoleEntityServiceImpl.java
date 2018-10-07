package com.lucasdistasi.login.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucasdistasi.login.repository.RoleEntityRepository;
import com.lucasdistasi.login.service.IRoleEntityService;

@Service
public class RoleEntityServiceImpl implements IRoleEntityService {
	
	@Autowired
	RoleEntityRepository roleRepository;

	@Override
	public String findRoleByUsername(String username) {
		return roleRepository.findRoleByUsername(username);
	}
	
	

}

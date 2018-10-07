package com.lucasdistasi.login.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucasdistasi.login.entity.UserEntity;
import com.lucasdistasi.login.repository.UserEntityRepository;
import com.lucasdistasi.login.service.IUserEntityService;

@Service
public class UserEntityServiceImpl implements IUserEntityService {
	
	@Autowired
	UserEntityRepository userRepository;

	@Override
	public UserEntity findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

}

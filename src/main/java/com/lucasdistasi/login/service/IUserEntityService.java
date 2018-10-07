package com.lucasdistasi.login.service;

import com.lucasdistasi.login.entity.UserEntity;

public interface IUserEntityService {
	
	UserEntity findByUsername(String username);

}

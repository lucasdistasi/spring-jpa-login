package com.lucasdistasi.login.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lucasdistasi.login.entity.UserEntity;
import com.lucasdistasi.login.service.impl.RoleEntityServiceImpl;
import com.lucasdistasi.login.service.impl.UserEntityServiceImpl;

@Service(value = "userDetailsService")
public class JPAUserDetailsService implements UserDetailsService {
	
	@Autowired
	UserEntityServiceImpl userService;
	
	@Autowired
	RoleEntityServiceImpl roleService;

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username)  {
		UserEntity user = userService.findByUsername(username);
		
		if(user == null) {
			System.out.println("USERNAME DOES NOT EXIST");
			throw new UsernameNotFoundException("Username not found");
		}
		
		List<GrantedAuthority> authorities = new ArrayList<>();
		String role = roleService.findRoleByUsername(username);
		authorities.add(new SimpleGrantedAuthority(role));
		
		if(authorities.isEmpty() || role == null) {
			// A logger would be better
			System.out.println("User has no role...");
		}
		
		return new User(user.getUsername(), user.getPassword(), true, true, true, true, authorities);
		
		
	}

}

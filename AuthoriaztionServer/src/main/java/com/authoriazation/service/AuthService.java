package com.authoriazation.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.authoriazation.entity.AppUser;

public interface AuthService extends UserDetailsService{

	
	public String saveUser(AppUser user);
	
	public String generateToken(AppUser usr);
	
	public void validateToken(String token);
}

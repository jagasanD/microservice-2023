package com.example.photoAppUser.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.photoAppUser.dto.CreateUserRequestModel;
import com.example.photoAppUser.entity.AppUser;
import com.example.photoAppUser.utility.ResponsePayLoad;

public interface UserService extends UserDetailsService {

	public ResponsePayLoad createUser(CreateUserRequestModel userDetails);
	public AppUser getUserByEmail(String email);
}

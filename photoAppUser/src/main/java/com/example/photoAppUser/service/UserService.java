package com.example.photoAppUser.service;

import com.example.photoAppUser.dto.CreateUserRequestModel;
import com.example.photoAppUser.dto.UserResponseModel;
import com.example.photoAppUser.entity.AppUser;
import com.example.photoAppUser.utility.ResponsePayLoad;

public interface UserService  {

	public ResponsePayLoad createUser(CreateUserRequestModel userDetails);
	public AppUser getUserByEmail(String email);
	public UserResponseModel getUserByUserId(String id);
	public UserResponseModel getFailedUser();
}

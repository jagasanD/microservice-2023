package com.example.photoAppUser.controller;

import java.util.List;

import org.apache.hc.core5.http.HttpStatus;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.photoAppUser.PropertiesConfig;
import com.example.photoAppUser.dto.CreateUserRequestModel;
import com.example.photoAppUser.dto.UserResponseModel;
import com.example.photoAppUser.entity.AppUser;
import com.example.photoAppUser.service.UserService;
import com.example.photoAppUser.utility.ResponsePayLoad;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private Environment env;
	
	@Autowired
	PropertiesConfig propertiesConfig;
	
	@Autowired
	UserService userService;
	@GetMapping("/status/check")
	public String getStatus() {
		return "users-service port number: "+env.getProperty("local.server.port")+ " message   "+propertiesConfig.getGlobalmessage();
	}
	
	@PostMapping("/save")
	public  ResponseEntity<ResponsePayLoad> createUser(@Valid @RequestBody  CreateUserRequestModel userDetails) {
		ResponsePayLoad payload = userService.createUser(userDetails);
		return new ResponseEntity<ResponsePayLoad>(payload, null, HttpStatus.SC_OK);
	}

	 @GetMapping("/{userId}")
	    public ResponseEntity<UserResponseModel> userAlbums(@PathVariable String userId) {
		 
		 UserResponseModel user = userService.getUserByUserId(userId);
		
		return new ResponseEntity<UserResponseModel>(user, null, HttpStatus.SC_OK); 
		 
	 }
	 
	 @GetMapping("/fail")
	    public ResponseEntity<UserResponseModel> userAlbumsFailed() {
		 UserResponseModel user = userService.getFailedUser();
		return new ResponseEntity<UserResponseModel>(user, null, HttpStatus.SC_OK); 
		 
	 }
	
}

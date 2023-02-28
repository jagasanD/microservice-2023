package com.example.photoAppUser.controller;

import org.apache.hc.core5.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.photoAppUser.dto.CreateUserRequestModel;
import com.example.photoAppUser.service.UserService;
import com.example.photoAppUser.utility.ResponsePayLoad;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private Environment env;
	
	@Autowired
	UserService userService;
	@GetMapping("/status/check")
	public String getStatus() {
		return "users-service port number: "+env.getProperty("local.server.port");
	}
	
	@PostMapping("/save")
	public  ResponseEntity<ResponsePayLoad> createUser(@Valid @RequestBody  CreateUserRequestModel userDetails) {
		ResponsePayLoad payload = userService.createUser(userDetails);
		return new ResponseEntity<ResponsePayLoad>(payload, null, HttpStatus.SC_OK);
	}

	
}

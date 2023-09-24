package com.authoriazation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.authoriazation.entity.AppUser;
import com.authoriazation.service.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	AuthService authService;

	@PostMapping("/save-user")
	public ResponseEntity<String> saveUser(@RequestBody AppUser user) {
		String resp = authService.saveUser(user);
		return new ResponseEntity<String>(resp, HttpStatus.OK);
	}

	@PostMapping("/get-token")
	public ResponseEntity<String> getToken(@RequestBody AppUser user) {
		String resp = authService.generateToken(user);
		return new ResponseEntity<String>(resp, HttpStatus.OK);
	}

	@GetMapping("/validate-token/{token}")
	public ResponseEntity<String> validateToken(@RequestParam String token) {
		try {
			authService.validateToken(token);
			return new ResponseEntity<String>("Valid", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("InValid", HttpStatus.OK);
		}
	}
}

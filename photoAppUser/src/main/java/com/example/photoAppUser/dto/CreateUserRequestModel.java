package com.example.photoAppUser.dto;

import org.springframework.stereotype.Component;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
@Component
public class CreateUserRequestModel {
	
	@NotNull(message="First Name can not be null")
	@Size(min = 2,message="at least 2 character required")
	private String firstName;
	
	@NotNull(message="Last Name can not be null")
	@Size(min = 2,message="atleaset 2 character required")
	private String lastName;
	
	@NotNull(message="Email can not be null")
	@Email(message="need value")
	private String email;
	
	@NotNull(message="password can not be null")
	@Size(min = 8,max=16 ,message="password between 8 to 16 characters")
	private String password;
	
	private String encryptedPassword;
	
	private String userId;
	
	private Long id;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEncryptedPassword() {
		return encryptedPassword;
	}
	public void setEncryptedPassword(String encryptedPassword) {
		this.encryptedPassword = encryptedPassword;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	

}

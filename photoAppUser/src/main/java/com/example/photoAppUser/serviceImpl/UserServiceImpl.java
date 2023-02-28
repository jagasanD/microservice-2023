package com.example.photoAppUser.serviceImpl;

import java.util.ArrayList;
import java.util.UUID;

import org.apache.hc.core5.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.photoAppUser.dto.CreateUserRequestModel;
import com.example.photoAppUser.entity.AppUser;
import com.example.photoAppUser.repository.UserRepository;
import com.example.photoAppUser.service.UserService;
import com.example.photoAppUser.utility.ResponsePayLoad;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;
	BCryptPasswordEncoder bCryptPasswordEncoder;
	@Override
	public ResponsePayLoad createUser(CreateUserRequestModel userDetails) {
		
		ResponsePayLoad payload =saveUser(userDetails);
		return payload;
	}
	private ResponsePayLoad saveUser(CreateUserRequestModel userDetails) {
		AppUser user =null;
		if(userDetails.getId()==null) {
			user = new AppUser();
			userDetails.setUserId(UUID.randomUUID().toString());
		}else {
			user =userRepository.findById(userDetails.getId()).get();
		}
		bCryptPasswordEncoder =new BCryptPasswordEncoder();
		user.setEmail(userDetails.getEmail());
		user.setEncryptedPassword(bCryptPasswordEncoder.encode(userDetails.getPassword()));
		user.setPassword(userDetails.getPassword());
		user.setFirstName(userDetails.getFirstName());
		user.setLastName(userDetails.getLastName());
		user.setUserId(userDetails.getUserId());
		userRepository.save(user);
		return new ResponsePayLoad("Successfully saved User!", HttpStatus.SC_OK+"",user);
		
	}
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		AppUser user = userRepository.findByEmail(email);
		if(user==null) {
			throw new UsernameNotFoundException(email);
		}
		return  new User(user.getEmail(), user.getEncryptedPassword(),true,true,true,true,new ArrayList<>());
	}
	@Override
	public AppUser getUserByEmail(String email) {
		return  userRepository.findByEmail(email);
	}

}

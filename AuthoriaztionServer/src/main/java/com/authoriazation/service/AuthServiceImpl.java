package com.authoriazation.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.authoriazation.config.JwtService;
import com.authoriazation.entity.AppUser;
import com.authoriazation.repository.AppUserRepository;

@Service
public class AuthServiceImpl implements AuthService {

	@Autowired
	private AppUserRepository appUserRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private JwtService jwtService;

	@Override
	public String saveUser(AppUser user) {

		user.setPassword(passwordEncoder.encode(user.getPassword()));
		appUserRepository.save(user);

		return "User Saved Successfully";
	}

	@Override
	public String generateToken(AppUser usr) {

		AppUser user = appUserRepository.findByEmail(usr.getEmail());
		if(user!=null) {
		return jwtService.generateToken(user.getEmail());
		}else {
			return "Invalide User";
		}
	}

	@Override
	public void validateToken(String token) {
		jwtService.validateToken(token);

	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		AppUser user = appUserRepository.findByEmail(email);
		if(user==null) {
			throw new UsernameNotFoundException(email);
		}
		return  new User(user.getEmail(), user.getPassword(),true,true,true,true,new ArrayList<>());
	}
}

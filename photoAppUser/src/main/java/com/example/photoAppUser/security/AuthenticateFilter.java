/*package com.example.photoAppUser.security;

import java.nio.charset.Charset;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.photoAppUser.dto.LoginRequestModel;
import com.example.photoAppUser.entity.AppUser;
import com.example.photoAppUser.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.IOException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AuthenticateFilter extends UsernamePasswordAuthenticationFilter{

	
	private Environment environment;
	private UserService usersService;
	//private AuthenticationManager authenticationManager;

	public AuthenticateFilter(UserService usersService, Environment environment,
			AuthenticationManager authenticationManager) {
		super(authenticationManager);
		this.usersService=usersService;
		this.environment=environment;
		//this.authenticationManager =authenticationManager;
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res)
			throws AuthenticationException {
		System.out.println("*********************calling1**************************");
		try {

			LoginRequestModel creds = new ObjectMapper().readValue(req.getInputStream(), LoginRequestModel.class);

			return getAuthenticationManager().authenticate(
					new UsernamePasswordAuthenticationToken(creds.getEmail(), creds.getPassword(), new ArrayList<>()));

		} catch (IOException | java.io.IOException e) {
			throw new RuntimeException(e);
		} 
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest req, 
			HttpServletResponse res, FilterChain chain,
			Authentication auth) throws IOException, ServletException {
		System.out.println("*********************calling2**************************");
		String email = ((User)auth.getPrincipal()).getUsername();
		AppUser user =usersService.getUserByEmail(email);
		String tockenSec =environment.getProperty("tocken.secret");
		
	Long JWT_TOKEN_VALIDITY =Long.parseLong(environment.getProperty("tocken.expiration_time"));
	System.out.println("Date of Expiration in millisecond    "+JWT_TOKEN_VALIDITY);
		String token =  Jwts.builder().setSubject(user.getUserId()).setIssuedAt(new Date(System.currentTimeMillis()))
        .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
        .signWith(SignatureAlgorithm.HS512, tockenSec.getBytes(Charset.forName("UTF-8"))).compact();

		// add token in header
		res.addHeader("tocken", token);
		res.addHeader("userId", user.getUserId());

	}

	
}*/

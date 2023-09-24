package com.authoriazation.config;

import java.util.ArrayList;

import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.authoriazation.entity.AppUser;
import com.authoriazation.service.AuthServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.io.IOException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AuthenticateFilter extends UsernamePasswordAuthenticationFilter{

	
	private Environment environment;
	private AuthServiceImpl usersService;
	JwtService jwtService;
	

	public AuthenticateFilter(AuthServiceImpl usersService, Environment environment,
			AuthenticationManager authenticationManager,JwtService jwtService) {
		super(authenticationManager);
		this.usersService=usersService;
		this.environment=environment;
		this.jwtService=jwtService;
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res)
			throws AuthenticationException {
		System.out.println("*********************calling1**************************");
		try {

			AppUser creds = new ObjectMapper().readValue(req.getInputStream(), AppUser.class);
			
		Authentication authentication =	getAuthenticationManager().authenticate(
					new UsernamePasswordAuthenticationToken(creds.getEmail(), creds.getPassword(), new ArrayList<>()));
		
		if(!authentication.isAuthenticated()) {
			throw new RuntimeException("Invaid Exception");
		}

			return authentication;

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
		AppUser user =(AppUser)usersService.loadUserByUsername(email);
		String tockenSec =environment.getProperty("tocken.secret");
		
		String token =jwtService.generateToken(email);
		// add token in header
				res.addHeader("tocken", token);
				res.addHeader("userId", user.getId()+"");
		
	/*Long JWT_TOKEN_VALIDITY =Long.parseLong(environment.getProperty("tocken.expiration_time"));
	System.out.println("Date of Expiration in millisecond    "+JWT_TOKEN_VALIDITY);
		String token =  Jwts.builder().setSubject(user.getId()+"").setIssuedAt(new Date(System.currentTimeMillis()))
        .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
        .signWith(SignatureAlgorithm.HS512, tockenSec.getBytes(Charset.forName("UTF-8"))).compact();*/

		

	}

	
}

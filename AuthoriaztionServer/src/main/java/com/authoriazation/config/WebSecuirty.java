package com.authoriazation.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.authoriazation.service.AuthServiceImpl;

@Configuration
@EnableWebSecurity
public class WebSecuirty {

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	AuthServiceImpl authService;

	@Autowired
	Environment environment;
	
	@Autowired
	JwtService jwtService;

	@Bean
	protected SecurityFilterChain configure(HttpSecurity http) throws Exception {
		System.out.println("*********************calling**************************");
		// Configure AuthenticationManagerBuilder
		AuthenticationManagerBuilder authenticationManagerBuilder = http
				.getSharedObject(AuthenticationManagerBuilder.class);

		authenticationManagerBuilder.userDetailsService(authService).passwordEncoder(passwordEncoder);

		AuthenticationManager authenticationManager = authenticationManagerBuilder.build();

		// Create AuthenticationFilter
		AuthenticateFilter authenticationFilter = new AuthenticateFilter(authService, environment,
				authenticationManager,jwtService);
		//authenticationFilter.setFilterProcessesUrl("/auth/get-token");

		http.csrf().disable();
		http.authorizeHttpRequests().requestMatchers("/auth/save-user", "/auth/get-token", "/auth/validate-token/**")
				.permitAll().and().addFilter(authenticationFilter).authenticationManager(authenticationManager)
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.headers().frameOptions().disable();
		return http.build();

	}

}

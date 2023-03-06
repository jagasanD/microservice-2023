package com.example.photoAppUser.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.example.photoAppUser.service.UserService;

@Configuration
@EnableWebSecurity
public class WebSecurityApp {

	private Environment environment;
	private UserService usersService;
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public WebSecurityApp(Environment environment, UserService usersService, BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.environment = environment;
		this.usersService = usersService;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}
    
    @Bean
    protected SecurityFilterChain configure(HttpSecurity http) throws Exception {
    	System.out.println("*********************calling**************************");
    	// Configure AuthenticationManagerBuilder
    	AuthenticationManagerBuilder authenticationManagerBuilder = 
    			http.getSharedObject(AuthenticationManagerBuilder.class);
    	
    	authenticationManagerBuilder.userDetailsService(usersService)
    	.passwordEncoder(bCryptPasswordEncoder);
    	
    	AuthenticationManager authenticationManager = authenticationManagerBuilder.build();
    	
    	// Create AuthenticationFilter
    	AuthenticateFilter authenticationFilter = 
    			new AuthenticateFilter(usersService, environment, authenticationManager);
    	authenticationFilter.setFilterProcessesUrl(environment.getProperty("login.url.path"));
    	
        http.csrf().disable();
  
        http.authorizeHttpRequests()
        .requestMatchers(HttpMethod.POST, "/users/save").permitAll()
        .requestMatchers(HttpMethod.POST, "/users/login").permitAll()
        .requestMatchers(HttpMethod.GET, "/users/status/check").permitAll()
        .requestMatchers(HttpMethod.GET, "/users/**").permitAll()
        .requestMatchers(HttpMethod.POST, "/users/**").permitAll()
       // .requestMatchers(new AntPathRequestMatcher("/h2-console/**")).permitAll()
        .and()
        .addFilter(authenticationFilter)
        .authenticationManager(authenticationManager)
        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
 
         http.headers().frameOptions().disable();
        return http.build();

    }

}

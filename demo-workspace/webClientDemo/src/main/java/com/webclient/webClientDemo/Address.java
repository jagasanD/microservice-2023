package com.webclient.webClientDemo;

import org.springframework.stereotype.Component;

@Component
public class Address {

	public String city;
	
	public String state;
	
	public String country;

	public Address() {
		
	}
	public Address(String city, String state, String country) {
		super();
		this.city = city;
		this.state = state;
		this.country = country;
	}
	
	
}

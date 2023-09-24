package com.webclient.webClientDemo;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Employee {

	public int id;
	
	public String name;
	
	//@Autowired
	public List<Address> address;

	public Employee() {
		
	}
	public Employee(int id, String name, List<Address>  address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
	}
	
	
	
	
}

package com.example.java8.emp;

public class Employee {
	
	private Integer salary;
	private String name;
	
	
	public Employee(Integer salary, String name) {
		super();
		this.salary = salary;
		this.name = name;
	}
	
	
	
	public Integer getSalary() {
		return salary;
	}
	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	

}

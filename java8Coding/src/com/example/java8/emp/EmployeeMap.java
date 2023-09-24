package com.example.java8.emp;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeeMap {

	public static void main(String[] args) {
		
		List<Employee> emps = new ArrayList<>();
		
		emps.add(new Employee(4000,"Raja"));
		emps.add(new Employee(2000,"Mohan"));
		emps.add(new Employee(5000,"Shiva"));
		emps.add(new Employee(8000,"Deva"));
		emps.add(new Employee(9000,"Maya"));
		emps.add(new Employee(3000,"Kaya"));
		
		
		Map<String,Integer> emps1=	emps.stream().filter(emp->emp.getSalary()>=5000)
		.collect(Collectors.toMap(emp->emp.getName(),emp->emp.getSalary()));
		
		System.out.println(emps1);

	}

}

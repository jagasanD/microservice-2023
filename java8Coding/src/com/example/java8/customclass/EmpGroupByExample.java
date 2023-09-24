package com.example.java8.customclass;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class EmpGroupByExample {

	public static void main(String[] args) {
		
		List<Employee> list = new ArrayList<>();
		list.add(new Employee(10l,"MMM","last",20,30.3));
		list.add(new Employee(20l,"BBB","last",20,30.3));
		
		list.add(new Employee(30l,"ZZZ","last",30,50.3));
		list.add(new Employee(40l,"DDD","last",30,50.3));
		
		System.out.println("Names by age:");
	      Map<Integer, List<String>> namesByAge =
	          list.stream().collect( Collectors.groupingBy(
	                		   Employee::getAge,                      
	                       Collectors.mapping(
	                    		   Employee::getFirstName,
	                           Collectors.toList()))
	        		  );
	      System.out.println(namesByAge);
	      
	      Map<Integer, Set<Employee>> groupByAgeSet = 
	                list.stream().collect(Collectors.groupingBy(Employee::getAge,Collectors.toSet()));
	      
	      System.out.println(groupByAgeSet);
	      
	      Map<Integer, Long> countEmpByAge = list.stream().
	                collect(Collectors.groupingBy(Employee::getAge,Collectors.counting()));
	         
	        System.out.println("4. Count employee objects by age: "+countEmpByAge);
	        
	        

	        Map<Integer, Optional<Employee>> empGroupByAgeMaxSal = list.stream().
	                collect(Collectors.groupingBy(Employee::getAge
	                        ,Collectors.maxBy(Comparator.comparing(Employee::getSalary))));      
	        System.out.println("5. Group Emp objects by age and get person with max sal: "+empGroupByAgeMaxSal);
		
	//	list.stream().collect(Collectors.groupingBy(Employee::getAge))
	//	.entrySet().stream().map(val->val.getValue()).sorted(Comparator.comparing(Employee::getFirstName))

	        Map<Integer, List<Employee>> groupbyAge= list.stream().collect(Collectors.groupingBy(Employee::getAge));
	        Map<Integer, List<Employee>> finalMap = new LinkedHashMap<>();
	        finalMap=  groupbyAge.entrySet().stream()
	                .sorted(Map.Entry.<Integer, List<Employee>>comparingByKey().reversed())
	                .collect(Collectors.toMap(val->val.getKey(), val->val.getValue()));
	        System.out.println("FINAL RESULT : " + finalMap);
	        
	      
	}

}

package com.restApi.demoRestAPI;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestControllerApi {
	
	@GetMapping("/emps")
	public ResponseEntity<List<Employee>> getEmp(){
		
		List<Employee> emps = new ArrayList();
		List<Address> address= new ArrayList();
		address.add(new Address("jaipur","MK","IND"));
		address.add(new Address("sariya","CG","IND"));
		
		emps.add(new Employee(10,"jack",address));
		emps.add(new Employee(20,"mohan",address));
		emps.add(new Employee(30,"deva",address));
		emps.add(new Employee(40,"raaz",address));
		emps.add(new Employee(50,"hamid",address));
		emps.add(new Employee(60,"sona",address));
		
		return new ResponseEntity<List<Employee>>(emps,HttpStatusCode.valueOf(200));
		
		
	}

}

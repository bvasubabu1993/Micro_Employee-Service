package com.app.main.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.main.entity.Employee;
import com.app.main.model.EmployeeResponse;
import com.app.main.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
	
	
	@GetMapping("/home")
	public String homePage() {
		String restCall = service. getCallInRestApi();
		return "Welcome To Employee and "+restCall;
	}
	
	@PostMapping("/save")
	public Employee SaveEmployee(@RequestBody Employee employee) {
		return service.saveEmployee(employee);
		
	}
	@GetMapping("/getAll")
	public List<Employee> getAllEmployess(){
		return service.getAllEmployees();
	}
	
	@GetMapping("/get/{id}")
	public EmployeeResponse getById(@PathVariable int id) {
		return service.getById(id);
	}
	
	

}


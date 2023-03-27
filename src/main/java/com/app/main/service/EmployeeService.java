package com.app.main.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.app.main.dao.EmployeeRepository;
import com.app.main.entity.Employee;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository repository;
	
	@Autowired
	private RestTemplate template;
	
	public  Employee saveEmployee(Employee employee) {
		return repository.save(employee);
		
	}
	
	public List<Employee> getAllEmployees(){
		return repository.findAll();
		
	}
	
	public Optional<Employee> getById(int id) {
		return repository.findById(id);
		
	}
	
	
	public String getCallInRestApi() {
		String forObject = template.getForObject("http://localhost:9502/address-app/api/home", String.class);
		return forObject;
		
	}

}

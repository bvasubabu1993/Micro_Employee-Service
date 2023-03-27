package com.app.main.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.app.main.dao.EmployeeRepository;
import com.app.main.entity.Employee;
import com.app.main.model.AddressResponse;
import com.app.main.model.EmployeeResponse;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository repository;
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private RestTemplate template;
	
	public  Employee saveEmployee(Employee employee) {
		return repository.save(employee);
		
	}
	
	public List<Employee> getAllEmployees(){
		return repository.findAll();
		
	}
	
	// this method will return employee and address data using restTemplate
	public EmployeeResponse getById(int id) {
		 Optional<Employee> employee = repository.findById(id);
		 EmployeeResponse employeeResponse = mapper.map(employee, EmployeeResponse.class);
		AddressResponse addressResponse = template.getForObject("http://localhost:9502/address-app/api/get/{id}", AddressResponse.class, id);
		 employeeResponse.setAddressResponse(addressResponse);
		 return employeeResponse;
	}
	
	
	public String getCallInRestApi() {
		String forObject = template.getForObject("http://localhost:9502/address-app/api/home", String.class);
		return forObject;
		
	}

}

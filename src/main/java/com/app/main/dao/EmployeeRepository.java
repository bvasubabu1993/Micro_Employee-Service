package com.app.main.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.main.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}

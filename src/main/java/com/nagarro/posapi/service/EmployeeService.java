package com.nagarro.posapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.posapi.model.Employee;
import com.nagarro.posapi.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	public Employee authLogin(Employee employee) {
		
//		if(employeeRepository.getLoginEmployee(employee.getEmail(), employee.getPassword())!=null) {
//			return emplo 
//		}
		return employeeRepository.getLoginEmployee(employee.getEmail(), employee.getPassword());
	}


	public Employee addEmployee(Employee employee) {
		
		return employeeRepository.save(employee);
	}

}

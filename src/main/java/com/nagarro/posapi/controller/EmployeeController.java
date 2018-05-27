package com.nagarro.posapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.posapi.model.Employee;
import com.nagarro.posapi.service.EmployeeService;

@RestController
@CrossOrigin
@RequestMapping(value="/employee")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping(method=RequestMethod.POST)
	public Employee addEmployee(@RequestBody Employee employee) {
		employeeService.addEmployee(employee);
		return employee;
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public Employee authLogin(@RequestBody Employee employee) {
		return employeeService.authLogin(employee);
	}
	
	

}

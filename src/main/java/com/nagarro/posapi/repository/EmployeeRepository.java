package com.nagarro.posapi.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.nagarro.posapi.model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
	
	@Query("SELECT e FROM Employee e where e.email=?1 and e.password=?2")
	Employee getLoginEmployee(String email,String password);

}

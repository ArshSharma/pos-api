package com.nagarro.posapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.nagarro.posapi.model.Customer;



public interface CustomerRepository extends CrudRepository<Customer, Integer> {
	
	@Query("SELECT c FROM Customer c where CONCAT(c.id, '') like %?1% or c.name like %?2% or c.email like %?3% or c.number like %?4%")
	List<Customer> searchCustomers(String search,String search2,String search3,String search4);

}

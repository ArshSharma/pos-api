package com.nagarro.posapi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.posapi.repository.CustomerRepository;
import com.nagarro.posapi.model.Customer;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepository customerRepository;
	
	public List<Customer> getAllCustomers(){
//		return null;
		List<Customer> customers= new ArrayList<>();
		customerRepository.findAll().forEach(customers::add);
		return customers;
	}
	
	public void addCustomer(Customer customer) {
		customerRepository.save(customer);
	}
	
	public List<Customer> searchCustomers(String search){
		
		return customerRepository.searchCustomers(search,search,search,search);
	}
}

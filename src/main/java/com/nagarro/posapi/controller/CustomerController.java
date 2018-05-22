package com.nagarro.posapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.posapi.model.Customer;
import com.nagarro.posapi.service.CustomerService;

@RestController
@RequestMapping(value="/customers")
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<Customer> getAllCustomers(){
		return customerService.getAllCustomers();
	}
	
	@RequestMapping(value="/{search}", method=RequestMethod.GET)
	public @ResponseBody List<Customer> searchCustomers(@PathVariable String search){
		return customerService.searchCustomers(search);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	private Customer addCustomer(@RequestBody Customer customer) {
		customerService.addCustomer(customer);
		return customer;
	}
	
	

}

package com.nagarro.posapi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.nagarro.posapi.model.Customer;
import com.nagarro.posapi.model.Employee;
import com.nagarro.posapi.model.Order;
import com.nagarro.posapi.model.Product;
import com.nagarro.posapi.repository.CustomerRepository;
import com.nagarro.posapi.repository.EmployeeRepository;
import com.nagarro.posapi.repository.OrderRepository;
import com.nagarro.posapi.repository.ProductRepository;

public class OrderService {
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private CustomerRepository customerRepository;
	public List<Order> getOrders(){
		List<Order> orders= new ArrayList<>();
		orderRepository.findAll().forEach(orders::add);
		return orders;
	}
	
	public void Order(Order order, int employeeId, int customerId) {
		Employee employee = employeeRepository.findOne(employeeId);
		order.setEmployee(employee);
		Customer customer= customerRepository.findOne(customerId);
		order.setCustomer(customer);
		order.setStatus("cancled");
		orderRepository.save(order);
	}

	public List<Orders> searchProducts(int employeeId) {
		Employee employee = employeeRepository.findOne(employeeId);
		
		return Repository.searchProducts(search,search,search);
	}

}

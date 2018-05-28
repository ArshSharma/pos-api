package com.nagarro.posapi.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.posapi.model.Cart;
import com.nagarro.posapi.model.Customer;
import com.nagarro.posapi.model.Employee;
import com.nagarro.posapi.model.Order;
import com.nagarro.posapi.model.Product;
import com.nagarro.posapi.repository.CartRepository;
import com.nagarro.posapi.repository.CustomerRepository;
import com.nagarro.posapi.repository.EmployeeRepository;
import com.nagarro.posapi.repository.OrderRepository;
import com.nagarro.posapi.repository.ProductRepository;

@Service
public class OrderService {
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private CartRepository cartRepository;
	@Autowired
	private ProductRepository productRepository;
	
	public List<Order> getOrders(){
		List<Order> orders= new ArrayList<>();
		orderRepository.findAll().forEach(orders::add);
		return orders;
	}
	
	public void Order(Order order, int employeeId, int customerId) {
		Employee employee = employeeRepository.findOne(employeeId);
		order.setByRefEmployee(employee);
		Customer customer= customerRepository.findOne(customerId);
		order.setByCustomer(customer);
		order.setStatus("cancled");
		Date date = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("dd-MM-yyyy hh:mm");
		order.setTime(ft.format(date));
		orderRepository.save(order);
	}
	
	
	public Order getOrder(int id) {
		return orderRepository.findOne(id);
	}
	
	public void confirmOrder(int orderId) {
		Order order= orderRepository.findOne(orderId);
		order.setStatus("Complete");
		orderRepository.save(order);
		List<Cart> cartsDeleted= cartRepository.getCart(order);
		for(Cart c:cartsDeleted) {
			int minusFactor= c.getQuantity();
			Product product=c.getByProduct();
			Product oldProduct=productRepository.findOne(product.getId());
			oldProduct.setStock(oldProduct.getStock()-c.getQuantity());
			productRepository.save(oldProduct);
		}	
	}

	

}

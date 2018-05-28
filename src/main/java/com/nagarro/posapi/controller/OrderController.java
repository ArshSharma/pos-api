package com.nagarro.posapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.posapi.model.Order;
import com.nagarro.posapi.service.OrderService;

@RestController
@CrossOrigin

public class OrderController {
	@Autowired
	private OrderService orderService;
	@RequestMapping(value="employee/{employeeId}/customer/{customerId}/order", method=RequestMethod.POST)
	public Order newOrder(@PathVariable("employeeId") int employeeId,@PathVariable("customerId") int customerId,@RequestBody Order order) {
		orderService.Order(order, employeeId, customerId);
		return order;
		
	}
	@RequestMapping(value="confirmOrder/{orderId}", method=RequestMethod.PUT)
	public void confirmOrder(@PathVariable("orderId") int orderId) {
		orderService.confirmOrder(orderId);
	}
	
	

}

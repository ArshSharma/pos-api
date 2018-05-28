package com.nagarro.posapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.posapi.model.Cart;
import com.nagarro.posapi.service.CartService;

@RestController
@CrossOrigin
@RequestMapping(value="order/{id}/product/{productId}/cart")
public class CartController {
	@Autowired
	private CartService cartService;
	
	@RequestMapping(method=RequestMethod.POST)
	public List<Cart> addToCart(@PathVariable("id") int orderId,@PathVariable("productId") int productId){
		return cartService.addCart(productId, orderId);
		
	}
	@RequestMapping(method=RequestMethod.PUT)
	public List<Cart> reduceCart(@PathVariable("id") int orderId,@PathVariable("productId") int productId){
		return cartService.reduceQuantity(productId, orderId);
	}

}

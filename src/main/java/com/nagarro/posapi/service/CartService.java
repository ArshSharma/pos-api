package com.nagarro.posapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.posapi.model.Cart;
import com.nagarro.posapi.model.Employee;
import com.nagarro.posapi.model.Order;
import com.nagarro.posapi.model.Product;
import com.nagarro.posapi.repository.CartRepository;
import com.nagarro.posapi.repository.OrderRepository;
import com.nagarro.posapi.repository.ProductRepository;

@Service
public class CartService {
	
	@Autowired
	private CartRepository cartRepository;
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private ProductRepository productRepository;
	
	public List<Cart> getCart(int orderId) {
		Order order = orderRepository.findOne(orderId);
		return cartRepository.getCart(order);
		
	}
	
	public List<Cart> addCart(int productId, int orderId) {
		
		Order order = orderRepository.findOne(orderId);
		Product product =productRepository.findOne(productId);
		Cart oldCart=cartRepository.checkCart(order, product);
		if(oldCart !=null) {
			oldCart.setQuantity(oldCart.quantity+1);
			cartRepository.save(oldCart);
			
		}
		else {
			Cart cart= new Cart();
		cart.setByOrder(order);
		cart.setByProduct(product);
		cart.setQuantity(1);
		cartRepository.save(cart);
		}
		return getCart(orderId);
		
	}
	
	public List<Cart> reduceQuantity(int productId,int orderId){
		Order order = orderRepository.findOne(orderId);
		Product product =productRepository.findOne(productId);
		Cart oldCart=cartRepository.checkCart(order, product);
		if(oldCart.getQuantity()<=1) {
			cartRepository.delete(oldCart.id);
		}
		else {
			oldCart.setQuantity(oldCart.getQuantity()-1);
			cartRepository.save(oldCart);
		}
		return getCart(orderId);

	}
	
	
	

}

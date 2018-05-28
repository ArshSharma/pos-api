package com.nagarro.posapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.nagarro.posapi.model.Cart;
import com.nagarro.posapi.model.Order;
import com.nagarro.posapi.model.Product;

public interface CartRepository extends CrudRepository<Cart, Integer> {
	
	@Query("SELECT c FROM Cart c where c.byOrder=?1")
	List<Cart> getCart(Order order);
	
	@Query("SELECT c FROM Cart c where c.byOrder=?1 and c.byProduct=?2")
	Cart checkCart(Order order, Product product);

}

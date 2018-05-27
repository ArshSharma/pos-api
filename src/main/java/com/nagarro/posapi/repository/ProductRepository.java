package com.nagarro.posapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nagarro.posapi.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	@Query("SELECT p FROM Product p where CONCAT(p.id, '') like %?1% or p.name like %?2% or p.description like %?3%")
	List<Product> searchProducts(String search,String search2,String search3);

}

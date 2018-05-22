package com.nagarro.posapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nagarro.posapi.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}

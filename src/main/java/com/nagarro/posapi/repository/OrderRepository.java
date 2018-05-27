package com.nagarro.posapi.repository;

import org.springframework.data.repository.CrudRepository;

import com.nagarro.posapi.model.Order;

public interface OrderRepository extends CrudRepository<Order, Integer> {

}

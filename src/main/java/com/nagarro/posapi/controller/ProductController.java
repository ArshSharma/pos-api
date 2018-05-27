package com.nagarro.posapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.posapi.model.Product;
import com.nagarro.posapi.service.ProductService;

@RestController
@CrossOrigin
@RequestMapping(value="products")
public class ProductController {
	@Autowired
	private ProductService productService;
	@RequestMapping(method=RequestMethod.GET)
	public List<Product> getAllProducts(){
		return productService.getAllProducts();
	}
	
	@RequestMapping(value="/{search}", method=RequestMethod.GET)
	public @ResponseBody List<Product> searchCustomers(@PathVariable String search){
		return productService.searchProducts(search);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public Product addProduct(@RequestBody Product product) {
		productService.addProduct(product);
		return product;
	}
}

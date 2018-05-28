package com.nagarro.posapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="cart")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Cart {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int id;
	
	@Column(name="quantity")
	public int quantity;
	
	@ManyToOne
//	@JsonBackReference("cart")
	public Product byProduct;
	
	public Product getByProduct() {
		return byProduct;
	}
	public void setByProduct(Product byProduct) {
		this.byProduct = byProduct;
	}
	@JsonBackReference("abcd")
	@ManyToOne
	public Order byOrder;
//	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public Order getByOrder() {
		return byOrder;
	}
	public void setByOrder(Order byOrder) {
		this.byOrder = byOrder;
	}
	
	
	

}

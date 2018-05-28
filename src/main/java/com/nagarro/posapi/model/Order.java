package com.nagarro.posapi.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="orders")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Order {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	private int id ;
	@Column(name="time")
	private String time;
	@Column(name="status")
	private String status;
	@Column(name="total")
	private double total;
	
	@ManyToOne
	@JsonBackReference("efgh")
	private Customer byCustomer;
	
	@ManyToOne
	@JsonBackReference("order")
	private Employee byRefEmployee;

	@OneToMany(mappedBy="byOrder")
//	@JsonManagedReference("abcd")
	private List<Cart> cart;
	
	
	
	
	public Customer getByCustomer() {
		return byCustomer;
	}

	public Employee getByRefEmployee() {
		return byRefEmployee;
	}

	public void setByRefEmployee(Employee byRefEmployee) {
		this.byRefEmployee = byRefEmployee;
	}

	public void setByCustomer(Customer byCustomer) {
		this.byCustomer = byCustomer;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

//	public List<Cart> getCart() {
//		return cart;
//	}

	public void setCart(List<Cart> cart) {
		this.cart = cart;
	}

	

	

}

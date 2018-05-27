package com.nagarro.posapi.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="employee")
public class Employee {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="name")
	private String name;
	@Column(name="email")
	private String email;
	@Column(name="password")
	private String password;
	@Column(name="role")
	private String role;
	@JsonManagedReference
	@OneToMany(mappedBy="byEmployee", fetch=FetchType.EAGER)
	private List<Drawer> drawer = new ArrayList<Drawer>();
	@JsonManagedReference
	@OneToMany(mappedBy="employee", fetch=FetchType.EAGER)
	private List<Order> Order = new ArrayList<Order>();
	
	
	
	public List<Order> getOrder() {
		return Order;
	}
	public void setOrder(List<Order> order) {
		Order = order;
	}
	public List<Drawer> getDrawer() {
		return drawer;
	}
	public void setDrawer(List<Drawer> drawer) {
		this.drawer = drawer;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	

}

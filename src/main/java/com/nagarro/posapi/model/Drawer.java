package com.nagarro.posapi.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="drawer")
public class Drawer {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	private Employee byEmployee;
	
	@Column(name="opening_balance")
	private float openingBalance;
	@Column(name="closing_balance")
	private float closingBalance;
	@Column(name="date")
	private Date date;
	
	public void setByEmployee(Employee byEmployee) {
		this.byEmployee = byEmployee;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public float getOpeningBalance() {
		return openingBalance;
	}
	public void setOpeningBalance(float openingBalance) {
		this.openingBalance = openingBalance;
	}
	public float getClosingBalance() {
		return closingBalance;
	}
	public void setClosingBalance(float closingBalance) {
		this.closingBalance = closingBalance;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
}

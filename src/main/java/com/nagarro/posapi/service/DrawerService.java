package com.nagarro.posapi.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.posapi.model.Drawer;
import com.nagarro.posapi.model.Employee;
import com.nagarro.posapi.repository.DrawerRepository;

@Service
public class DrawerService {
	
	@Autowired
	private DrawerRepository drawerRepository;
	
	public Drawer getTodayDrawer(Employee employee) {
		Date date= new Date();
		SimpleDateFormat ft = new SimpleDateFormat ("dd-MM-yyyy");
		String currentDate=ft.format(date);
		return drawerRepository.getTodayDrawer(currentDate);
		
	}
}

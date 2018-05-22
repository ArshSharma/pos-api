package com.nagarro.posapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.posapi.model.Drawer;
import com.nagarro.posapi.model.Employee;
import com.nagarro.posapi.service.DrawerService;

@RestController
@RequestMapping(value="/drawer")
public class DrawerController {
	
	@Autowired
	private DrawerService drawerService;
	
	@RequestMapping(method=RequestMethod.POST)
	public Drawer getTodayDrawer(@RequestBody Employee employee) {
		return drawerService.getTodayDrawer(employee); 
	}

}

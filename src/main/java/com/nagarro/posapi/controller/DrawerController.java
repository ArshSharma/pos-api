package com.nagarro.posapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.posapi.model.Drawer;
import com.nagarro.posapi.service.DrawerService;

@RestController
@RequestMapping(value="employee/{employeeId}/drawer")
public class DrawerController {
	
	@Autowired
	private DrawerService drawerService;
	
	@RequestMapping(method=RequestMethod.GET)
	public Drawer getTodayDrawer(@PathVariable int employeeId) {
		
		return drawerService.getTodayDrawer(employeeId); 
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public Drawer setOpeningDrawer(@RequestBody Drawer drawer, @PathVariable int employeeId) {
		drawerService.setOpeningDrawer(drawer, employeeId);
		return drawer;
	}
	@RequestMapping(method=RequestMethod.PUT)
	public void setClosingDrawer(@RequestBody Drawer drawer, @PathVariable int employeeId) {
		drawerService.setClosingDrawer(drawer, employeeId);
	}

}

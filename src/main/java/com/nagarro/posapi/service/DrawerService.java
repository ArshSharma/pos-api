package com.nagarro.posapi.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.posapi.model.Drawer;
import com.nagarro.posapi.model.Employee;
import com.nagarro.posapi.repository.DrawerRepository;
import com.nagarro.posapi.repository.EmployeeRepository;

@Service
public class DrawerService {

	@Autowired
	private DrawerRepository drawerRepository;
	@Autowired
	private EmployeeRepository employeeRepository;

	public Drawer getTodayDrawer(int employeeId) {
		Employee employee = employeeRepository.findOne(employeeId);

		Date date = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("dd-MM-yyyy");
		String currentDate = ft.format(date);
		return drawerRepository.getTodayDrawer(employee, currentDate);

	}

	public void setOpeningDrawer(Drawer drawer, int employeeId) {
		Employee employee = employeeRepository.findOne(employeeId);
		Date date = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("dd-MM-yyyy");
		String currentDate = ft.format(date);
		if (drawerRepository.getTodayDrawer(employee, currentDate) == null) {
			drawer.setCurrentDate(currentDate);
			drawer.setByEmployee(employee);
			drawer.setClosingBalance(drawer.getOpeningBalance());
			drawerRepository.save(drawer);
		}

	}
	public void setClosingDrawer(Drawer drawer, int employeeId) {
		Employee employee = employeeRepository.findOne(employeeId);
		Date date = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("dd-MM-yyyy");
		String currentDate = ft.format(date);
		Drawer drawerOld=drawerRepository.getTodayDrawer(employee, currentDate);
		if (drawerOld != null) {
			
			drawerOld.setClosingBalance(drawerOld.getClosingBalance()+drawer.getClosingBalance());
			drawerRepository.save(drawerOld);
		}

	}
}

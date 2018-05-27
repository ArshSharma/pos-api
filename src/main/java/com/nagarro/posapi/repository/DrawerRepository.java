package com.nagarro.posapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.nagarro.posapi.model.Drawer;
import com.nagarro.posapi.model.Employee;

public interface DrawerRepository extends CrudRepository<Drawer, Integer>{
	
	@Query("SELECT d FROM Drawer d where d.byEmployee=?1 and d.currentDate=?2")
	Drawer getTodayDrawer(Employee employee,String date);
	
	@Query("SELECT d FROM Drawer d where d.byEmployee=?1")
	List<Drawer> getDrawerDetails(Employee employee);

}

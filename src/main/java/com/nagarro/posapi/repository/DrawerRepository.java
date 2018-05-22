package com.nagarro.posapi.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.nagarro.posapi.model.Drawer;

public interface DrawerRepository extends CrudRepository<Drawer, Integer>{
	
	@Query("SELECT d FROM Drawer d where d.currentDate=?1")
	Drawer getTodayDrawer(String date);

}

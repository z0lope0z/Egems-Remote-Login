package com.tsl.example.cars.dao;

import java.util.List;

import com.tsl.example.cars.model.Car;

public interface CarDao {

	Car findById(Long id);
	
	List<Car> findAllOrderByName();
	
	void merge(Car car);
	
	void remove(Car car);
}

package com.usk.demo.service;

import java.util.List;

import com.usk.demo.entity.Car;

public interface CarService {

	public List<Car> getAllCars(int pageNumber, int pageSize);
	public Car getCarById(Long id);
	public void saveCar(Car theCar);
	public void deleteCarById(Long id);
	
	List<Car> getCarsByNames(String companyName, String modelName);
	List<Car> getCarsByNamesNative(String companyName, String modelName);
}
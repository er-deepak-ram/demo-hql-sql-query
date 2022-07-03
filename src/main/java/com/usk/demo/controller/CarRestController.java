package com.usk.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.usk.demo.entity.Car;
import com.usk.demo.service.CarService;

@RestController
@RequestMapping("/cars")
public class CarRestController {

	@Autowired
	private CarService carService;
	
	@GetMapping
	public List<Car> getAllCars(@RequestParam int pageNumber, int pageSize) {
		return carService.getAllCars(pageNumber, pageSize);
	}
	
	@GetMapping("/{id}")
	public Car getCar(@PathVariable int id) {
		Car theCar = carService.getCarById(Long.valueOf(id));
		if(theCar == null)
			throw new RuntimeException("Car ID not found: "+id);
		return theCar;
	}
	 
	@PostMapping
	public Car saveCar(@RequestBody Car car) {
		carService.saveCar(car);
		return car;
	}
	
	@PutMapping
	public Car updateCar(@RequestBody Car car) {
		carService.saveCar(car);
		return car;
	}
	
	@DeleteMapping("/{id}")
	public String deleteCar(@PathVariable int id) {
		Car theCar = carService.getCarById(Long.valueOf(id));
		if(theCar == null)
			throw new RuntimeException("Car ID not found - "+id);
		carService.deleteCarById(Long.valueOf(id));
		return "Deleted Car ID - "+id;
	}
	
	@GetMapping("/bynames")
	public List<Car> getCarsByNames(String companyName, String modelName) {
		return carService.getCarsByNames(companyName, modelName);
	}
	
	@GetMapping("/bynamesnative")
	public List<Car> getCarsByNamesNative(String companyName, String modelName) {
		return carService.getCarsByNamesNative(companyName, modelName);
	}
}

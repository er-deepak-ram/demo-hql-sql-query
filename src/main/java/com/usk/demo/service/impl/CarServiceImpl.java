package com.usk.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.usk.demo.entity.Car;
import com.usk.demo.repository.CarRepository;
import com.usk.demo.service.CarService;

@Service
public class CarServiceImpl implements CarService {
	
	@Autowired
	private CarRepository carRepository;

	@Override
	public List<Car> getAllCars(int pageNumber, int pageSize) {
		Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(Direction.ASC, "id"));
		return carRepository.findAll(pageable).getContent();
	}

	@Override
	public Car getCarById(Long id) {
		Optional<Car> result = carRepository.findById(id);
		return result.isPresent() ? result.get() : null;
	}

	@Override
	public void saveCar(Car theCar) {
		carRepository.save(theCar);
	}

	@Override
	public void deleteCarById(Long id) {
		carRepository.deleteById(id);
	}

	@Override
	public List<Car> getCarsByNames(String companyName, String modelName) {
		return carRepository.getCarsByNames(companyName, modelName);
	}

	@Override
	public List<Car> getCarsByNamesNative(String companyName, String modelName) {
		return carRepository.getCarsByNamesNative(companyName, modelName);
	}
}

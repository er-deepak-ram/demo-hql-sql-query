package com.usk.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.usk.demo.entity.Car;

public interface CarRepository extends JpaRepository<Car, Long> {
	
//	HQL
	@Query("from Car where companyName=:companyName and modelName=:modelName")
	List<Car> getCarsByNames(String companyName, String modelName);
	
//	SQL: Last option to pick
	@Query(value = "select c.* from Car c where company_name=:companyName and model_name=:modelName", nativeQuery = true)
	List<Car> getCarsByNamesNative(String companyName, String modelName);
}
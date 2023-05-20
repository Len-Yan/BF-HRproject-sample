package com.example.employeeservice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.employeeservice.domain.Employee;

public interface EmployeeRepository extends MongoRepository<Employee, String>{

	
	Optional<Employee> findById(String id);
	
	Optional<Employee> findByUserID(Integer userId);
	
	Optional<Employee> findByEmail(String email);
	
	//add new
	Employee insert(Employee emp);
	
	//Employee update
	Employee save(Employee emp);
	
	//delete by userId
	Employee deleteEmployeeByUserID(Integer id);
	
	List<Employee> findAll();

	List<Employee> findEmployeeByHouseID(Integer houseId);
}

package com.example.employeeservice.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.employeeservice.domain.Employee;

public interface EmployeePageRepository extends PagingAndSortingRepository<Employee, String>{

	Slice<Employee> findByUserID(Integer userId, Pageable pageable);
	
	Page<Employee> findAll(Pageable pageable);
	
	Page<Employee> findByFirstNameContaining(String firstName, Pageable pageable);
	
	Page<Employee> findByEmailContaining(String email, Pageable pageable);

	
	//Page<Employee> findByFirstNameOrEmail(String firstName, String email, Pageable pageable);
	
}

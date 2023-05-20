package com.example.employeeservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.employeeservice.domain.Employee;
import com.example.employeeservice.repository.EmployeePageRepository;

@Component
@Service
public class EmployeePageService {

	private EmployeePageRepository employeePageRepository;
	
	@Autowired
	public void setEmployePageRepo(EmployeePageRepository employeePageRepository) {
		this.employeePageRepository = employeePageRepository;
	}

	public Slice<Employee> getAllEmployeeWithPage(Integer page, Integer size){
		return employeePageRepository.findAll(PageRequest.of(page, size));
	}
	
	public Slice<Employee> getEmployeeWithPageAndFirstName(String firstName, Integer page, Integer size){
		return employeePageRepository.findByFirstNameContaining(firstName, PageRequest.of(page, size));
	}
	
	public Slice<Employee> getEmployeeWithPageAndEmail(String email, Integer page, Integer size){
		return employeePageRepository.findByEmailContaining(email, PageRequest.of(page, size));
	}
}

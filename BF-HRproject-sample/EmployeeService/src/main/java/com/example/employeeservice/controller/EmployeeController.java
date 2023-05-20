package com.example.employeeservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.employeeservice.domain.Employee;
import com.example.employeeservice.response.AllEmployeeResponse;
import com.example.employeeservice.service.EmployeeService;

@RestController
@RequestMapping("Employee")
public class EmployeeController {

	EmployeeService employeeService;
	
	@Autowired
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@GetMapping
	public List<Employee> getAllEmployee(){
		System.out.println(employeeService.getAllEmployee().get(0).getFirstName());
		return employeeService.getAllEmployee();
	}
	
	@GetMapping("/{id}")
	public Employee findEmployeeById(@PathVariable String id){
		return employeeService.getEmployeeById(id).get();
	}
	
	@GetMapping("/UserId/{id}")
	public Employee findEmployeeByUserId(@PathVariable Integer id) {
		return employeeService.getEmployeeByUserId(id);
	}
	
	@GetMapping("/Email/{eamil}")
	public Employee findEmployeeByEmail(@PathVariable String email) {
		return employeeService.getEmployeeByEmail(email).get();
	}
	
	@PostMapping("/add")
	public Employee addNewEmployee(@RequestBody Employee employee) {
		return employeeService.addEmployee(employee);
	}

	@GetMapping("house/{houseId}")
	public List<Employee> findEmployeeByHouseID(@PathVariable Integer houseId) {
		return employeeService.findEmployeeByHouseID(houseId);
	}
	
	@PostMapping("/update")
	public Employee updateEmployee(@RequestBody Employee employee) {
		return employeeService.updateEmplyee(employee);
	}
	
	@DeleteMapping("/delete/{UserId}")
	public Employee deleteEmployee(@PathVariable Integer UserId) {
		return employeeService.deleteEmployee(UserId);
	}
	
	//--------- basic end point end-------------
	
	
}

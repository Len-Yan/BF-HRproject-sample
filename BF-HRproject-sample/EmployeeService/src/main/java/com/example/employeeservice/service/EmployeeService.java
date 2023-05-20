package com.example.employeeservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.employeeservice.domain.Employee;
import com.example.employeeservice.repository.EmployeeRepository;

@Component
@Service
public class EmployeeService {

	private EmployeeRepository employeeRepository;
	
	@Autowired
	public void setEmployeeRepository(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	
	//should throw exception when null
	public Optional<Employee> getEmployeeById(String id) {
		return employeeRepository.findById(id);
	}
	
	public Employee getEmployeeByUserId(Integer userid) {
		return employeeRepository.findByUserID(userid).get();
	}
	
	public Optional<Employee> getEmployeeByEmail(String email) {
		return employeeRepository.findByEmail(email);
	}
	
	public Employee addEmployee(Employee emp) {
		//if(getEmployeeById(emp.getId()) ){
		//	return new Employee();
		//	}
		return employeeRepository.insert(emp);
	}
	
	//Using UserId to update/ maybe need switch to Id
	public Employee updateEmplyee(Employee emp) {
		Employee currentEmp = employeeRepository.findByUserID(emp.getUserID()).get();
		emp.setId(currentEmp.getId());
		return employeeRepository.save(emp);
	}
	
	public Employee deleteEmployee(Integer UserId) {
		return employeeRepository.deleteEmployeeByUserID(UserId);
	}
	
	public List<Employee> getAllEmployee(){
		return employeeRepository.findAll();
	}

	public List<Employee> findEmployeeByHouseID(Integer houseId) {
		return employeeRepository.findEmployeeByHouseID(houseId);
	}
}

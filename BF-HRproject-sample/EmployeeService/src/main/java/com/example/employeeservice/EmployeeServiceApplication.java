package com.example.employeeservice;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import com.example.employeeservice.domain.Address;
import com.example.employeeservice.domain.Employee;
import com.example.employeeservice.repository.AddressRepository;
import com.example.employeeservice.repository.EmployeeRepository;
import com.example.employeeservice.service.AddressService;
import com.example.employeeservice.service.EmployeeService;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EmployeeServiceApplication implements CommandLineRunner{

	@Autowired
	private EmployeeRepository repository;
	
	@Autowired
	private AddressRepository repository2;
	
    public static void main(String[] args) {
        SpringApplication.run(EmployeeServiceApplication.class, args);
    }

	@Override
	public void run(String... args) throws Exception {

		/*
		repository.deleteAll();
		Date date = new Date();
		Employee s1 = new Employee("someid1", 123, "Dummy", "lastname", 
				"null", "noname", "abc@email.com", "1234567890", "null", 
				"M", "987654321", date, date, date, 
				"null", date, 55);
		
		repository.save(s1);

		repository2.deleteAll();
		Address a1 = new Address("someAddress1-1", "dummy location", "nul",
				"dummy city", "NY", 55556);
		
		repository2.save(a1);
		*/
	}
}

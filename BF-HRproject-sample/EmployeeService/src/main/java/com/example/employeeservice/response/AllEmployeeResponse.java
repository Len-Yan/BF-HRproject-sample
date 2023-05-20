package com.example.employeeservice.response;

import java.util.List;

import com.example.employeeservice.domain.Address;
import com.example.employeeservice.domain.Contact;
import com.example.employeeservice.domain.Employee;
import com.example.employeeservice.domain.PersonalDocument;
import com.example.employeeservice.domain.VisaStatus;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class AllEmployeeResponse {

	Employee employee;
	List<Contact> contact;
	List<Address> addresses;
	List<VisaStatus> visaStatuses;
	PersonalDocument personalDocument;
}

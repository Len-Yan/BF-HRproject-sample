package com.example.employeeservice.response;

import java.util.Date;
import java.util.List;

import com.example.employeeservice.domain.Address;
import com.example.employeeservice.domain.Contact;
import com.example.employeeservice.domain.Employee;
import com.example.employeeservice.domain.PersonalDocument;
import com.example.employeeservice.domain.VisaStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeWithActiveVisa {

	String fullName;
	String workAuthorization;
	Date expirationDate;
	Integer dayLeft;
}

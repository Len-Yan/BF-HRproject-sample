package com.example.employeeservice.domain;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document
public class Employee {

	@Id
	private String id;
	
	private Integer userID;
	private String firstName;
	private String lastName;
	private String middleName;
	private String preferedName;
	private String email;
	private String cellPhone;
	private String alternatePhone;
	private String gender;
	private String SSN;
	private Date DOB;
	private Date startDate;
	private Date endDate;
	private String driverLicense;
	private Date driverLicenseExpiration;
	private Integer houseID;
	
	//private Contact contact;
	//private List<Address> address;
	//private List<VisaStatus> visaStatus;
	//private PersonalDocument personalDocument;
	
}

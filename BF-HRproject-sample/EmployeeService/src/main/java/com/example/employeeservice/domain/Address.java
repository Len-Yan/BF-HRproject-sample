package com.example.employeeservice.domain;

import java.util.Date;

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
public class Address {

	private String id;
	
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String state;
	private String zipCode;
}

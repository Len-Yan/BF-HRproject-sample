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
public class Contact {

	private String id;
	
	private String firstName;
	private String lastName;
	private String cellPhone;
	private String alternatePhone;
	private String email;
	private String relationship;
	private String type;
	
}

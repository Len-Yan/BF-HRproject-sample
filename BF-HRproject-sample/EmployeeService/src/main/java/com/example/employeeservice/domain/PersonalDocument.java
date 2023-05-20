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
public class PersonalDocument {

	private String ID;
	
	
	private String Path;
	private String Title;
	private String Comment;
	private Date EndDate;
	
}

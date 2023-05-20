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
public class VisaStatus {

	private String ID;
	
	private String VisaType;
	private Boolean ActiveFlag;
	private Date StartDate;
	private Date EndDate;
	private Date LastModificationDate;
	
}

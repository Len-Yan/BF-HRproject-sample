package com.example.employeeservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.employeeservice.domain.PersonalDocument;
import com.example.employeeservice.service.PersonalDocumentService;

@RestController
@RequestMapping("PersonalDoc")
public class PersonalDocumentController {

	private PersonalDocumentService personalDocumentService;
		
	@Autowired
	public void setDocumentService(PersonalDocumentService personalDocumentService) {
		this.personalDocumentService = personalDocumentService;
	}
	
	@GetMapping("/{id}")
	public PersonalDocument getDocumentById(@PathVariable String id) {
		return personalDocumentService.getDocmentById(id).get();
	}
	
	@PostMapping("/add")
	public PersonalDocument addDocument(@RequestBody PersonalDocument doc) {
		return personalDocumentService.addDocument(doc);
	}
	
	@PostMapping("/add/{userId}")
	public PersonalDocument addDocumentByUser(@PathVariable Integer userId, @RequestBody PersonalDocument doc) {
		String tempId = userId + " - " + doc.getID();
		doc.setID(tempId);
		return personalDocumentService.addDocument(doc);
	}
	
	@PostMapping("/update")
	public PersonalDocument updateDocument(@RequestBody PersonalDocument doc) {
		return personalDocumentService.updateDocument(doc);
	}
	
	@DeleteMapping("/delete/{id}")
	public PersonalDocument deleteDocument(@PathVariable String id) {
		return personalDocumentService.deleteDocumentById(id);
	}
	
}

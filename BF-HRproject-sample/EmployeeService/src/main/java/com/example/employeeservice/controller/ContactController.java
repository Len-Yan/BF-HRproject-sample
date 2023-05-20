package com.example.employeeservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.employeeservice.domain.Contact;
import com.example.employeeservice.service.ContactService;

@RestController
@RequestMapping("Contact")
public class ContactController {

	ContactService contactService;
	
	@Autowired
	public void setContactService(ContactService contactService) {
		this.contactService = contactService;
	}
	
	// should use getALL(Example ex) method to mattching
	@GetMapping
	public List<Contact> getAllContact(){
		return contactService.getAll();
	}
	
	@GetMapping("/{id}")
	public List<Contact> getAllbyUserId(){
		return null;
	}
	
	//Id should regex with some field of User ID
	@PostMapping("/add")
	public Contact addContact(@RequestBody Contact contact) {
		return contactService.addContact(contact);
	}
	
	@PostMapping("/add/{userId}")
	public Contact addContactByUser(@PathVariable Integer userId, @RequestBody Contact contact) {
		String tempId = userId + " - " + contact.getId();
		contact.setId(tempId);
		return contactService.addContact(contact);
	}
	
	
	
	@PostMapping("/update")
	public Contact updateContact(@RequestBody Contact contact) {
		return contactService.updateContact(contact);
	}
	
	@DeleteMapping("/delete/{id}")
	public Contact deleteContactById(@PathVariable String id) {
		return contactService.deleteContactById(id);
	}
	
}

package com.example.employeeservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.employeeservice.domain.Contact;
import com.example.employeeservice.repository.ContactRepository;

@Component
@Service
public class ContactService {

	private ContactRepository contactRepository;
	
	@Autowired
	public void setContactRepository(ContactRepository contactRepository) {
		this.contactRepository = contactRepository;
	}
	
	public Contact getContactById(String id) {
		return contactRepository.findById(id).get();
	}
	
	//need use imp class
	public Contact addContact(Contact contact) {
		return contactRepository.insert(contact);
	}
	
	//update
	public Contact updateContact(Contact contact){
		return contactRepository.save(contact);
	}
	
	public Contact deleteContactById(String id) {
		return contactRepository.deleteContactById(id);
	}
	
	public List<Contact> getAllByUserId(String userId){
		return contactRepository.findByIdLike(userId);
	}
	
	public List<Contact> getAll(){
		return contactRepository.findAll();
	}
}

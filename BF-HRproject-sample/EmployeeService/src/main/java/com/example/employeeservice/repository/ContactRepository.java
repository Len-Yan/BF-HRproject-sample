package com.example.employeeservice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.employeeservice.domain.Contact;

public interface ContactRepository extends MongoRepository<Contact, Integer>{

	Optional<Contact> findById(String id);
	
	Contact insert(Contact contact);
	
	Contact save(Contact contact);
	
	Contact deleteContactById(String id);
	
	List<Contact> findByIdLike(String userid);
	
	List<Contact> findAll();
}

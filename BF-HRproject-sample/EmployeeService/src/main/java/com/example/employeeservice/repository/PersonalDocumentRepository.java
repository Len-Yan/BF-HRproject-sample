package com.example.employeeservice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.employeeservice.domain.PersonalDocument;

public interface PersonalDocumentRepository extends MongoRepository<PersonalDocument, Integer>{

	Optional<PersonalDocument> findByID(String id);
	
	PersonalDocument insert(PersonalDocument doc);
	
	PersonalDocument save(PersonalDocument doc);
	
	PersonalDocument deletePersonalDocumentByID(String id);
	
	List<PersonalDocument> findByIDLike(String userid);
}

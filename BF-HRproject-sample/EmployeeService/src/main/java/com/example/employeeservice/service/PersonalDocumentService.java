package com.example.employeeservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.employeeservice.domain.PersonalDocument;
import com.example.employeeservice.repository.PersonalDocumentRepository;

@Component
@Service
public class PersonalDocumentService {

	private PersonalDocumentRepository personalDocumentRepository;
	
	@Autowired
	public void SetPersonalDocRepo(PersonalDocumentRepository personalDocumentRepository) {
		this.personalDocumentRepository = personalDocumentRepository;
	}
	
	public Optional<PersonalDocument> getDocmentById(String id){
		return personalDocumentRepository.findByID(id);
	}
	
	public PersonalDocument addDocument(PersonalDocument personalDocument) {
		return personalDocumentRepository.insert(personalDocument);
	}
	
	public PersonalDocument updateDocument(PersonalDocument personalDocument) {
		return personalDocumentRepository.save(personalDocument);
	}
	
	public PersonalDocument deleteDocumentById(String id) {
		return personalDocumentRepository.deletePersonalDocumentByID(id);
	}
	
	public List<PersonalDocument> getAllByUserId(String userId){
		return personalDocumentRepository.findByIDLike(userId);
	}
}

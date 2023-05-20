package com.example.employeeservice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.employeeservice.domain.VisaStatus;

public interface VisaStatusRepository extends MongoRepository<VisaStatus, Integer>{
	
	Optional<VisaStatus> findByID(String id);

	VisaStatus insert(VisaStatus visa);
	
	VisaStatus save(VisaStatus visa);
	
	VisaStatus deleteVisaStatusBy(String id);
	
	List<VisaStatus> findByIDLike(String userid);
}

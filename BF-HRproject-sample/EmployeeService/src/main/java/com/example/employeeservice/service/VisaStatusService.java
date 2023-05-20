package com.example.employeeservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.employeeservice.domain.VisaStatus;
import com.example.employeeservice.repository.VisaStatusRepository;

@Component
@Service
public class VisaStatusService {

	private VisaStatusRepository visaStatusRepository;
	
	@Autowired
	public void setVisaStatusRepository(VisaStatusRepository visaStatusRepository) {
		this.visaStatusRepository = visaStatusRepository;
	}
	
	public Optional<VisaStatus> findVisaStatusById(String id){
		return visaStatusRepository.findByID(id);
	}
	
	public VisaStatus addVisaStatus(VisaStatus visaStatus) {
		return visaStatusRepository.insert(visaStatus);
	}
	
	public VisaStatus updateVisaStatus(VisaStatus visaStatus) {
		return visaStatusRepository.save(visaStatus);
	}
	
	public VisaStatus deleteVisaStatus(String id) {
		return visaStatusRepository.deleteVisaStatusBy(id);
	}
	
	public List<VisaStatus> getAllByUserId(String userId){
		return visaStatusRepository.findByIDLike(userId);
	}
	
}

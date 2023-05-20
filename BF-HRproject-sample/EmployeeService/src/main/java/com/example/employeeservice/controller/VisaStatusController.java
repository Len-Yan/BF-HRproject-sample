package com.example.employeeservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.employeeservice.domain.VisaStatus;
import com.example.employeeservice.service.VisaStatusService;

@RestController
@RequestMapping("VisaStatus")
public class VisaStatusController {

	private VisaStatusService visaStatusService;
	
	@Autowired
	public void setVisaStatusService(VisaStatusService visaStatusService) {
		this.visaStatusService = visaStatusService;
	}
	
	@GetMapping("/{id}")
	public VisaStatus getVisaStatusByid(@PathVariable String id) {
		return visaStatusService.findVisaStatusById(id).get();
	}
	
	@PostMapping("/add")
	public VisaStatus addVisaStatus(@RequestBody VisaStatus visa) {
		return visaStatusService.addVisaStatus(visa);
	}
	
	@PostMapping("/add/{userId}")
	public VisaStatus addVisaStatusByUser(@PathVariable Integer userId, @RequestBody VisaStatus visa) {
		String tempId = userId + " - " + visa.getID();
		visa.setID(tempId);
		return visaStatusService.addVisaStatus(visa);
	}
	
	@PostMapping("/update")
	public VisaStatus updateStatus(@RequestBody VisaStatus visa) {
		return visaStatusService.updateVisaStatus(visa);
	}
	
	@DeleteMapping("/delete/{id}")
	public VisaStatus deleteStatusById(@PathVariable String id) {
		return visaStatusService.deleteVisaStatus(id);
	}
}

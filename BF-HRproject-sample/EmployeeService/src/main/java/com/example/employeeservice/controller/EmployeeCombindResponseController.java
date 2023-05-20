package com.example.employeeservice.controller;

import java.security.KeyStore.PrivateKeyEntry;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.apache.naming.java.javaURLContextFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.employeeservice.domain.Address;
import com.example.employeeservice.domain.Contact;
import com.example.employeeservice.domain.Employee;
import com.example.employeeservice.domain.PersonalDocument;
import com.example.employeeservice.domain.VisaStatus;
import com.example.employeeservice.repository.EmployeePageRepository;
import com.example.employeeservice.response.AllEmployeeResponse;
import com.example.employeeservice.response.EmployeeWithActiveVisa;
import com.example.employeeservice.service.AddressService;
import com.example.employeeservice.service.ContactService;
import com.example.employeeservice.service.EmployeeService;
import com.example.employeeservice.service.PersonalDocumentService;
import com.example.employeeservice.service.VisaStatusService;

@RestController
@RequestMapping("EmployeeSuit")
public class EmployeeCombindResponseController {

	EmployeeService employeeService;
	ContactService contactService;
	AddressService addressService;
	PersonalDocumentService personalDocumentService;
	VisaStatusService visaStatusService;
	EmployeePageRepository employeePageRepository;
	
	@Autowired
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	@Autowired
	public void setContactService(ContactService contactService) {
		this.contactService = contactService;
	}
	@Autowired
	private void setAddressService(AddressService addressService) {
		this.addressService = addressService;
	}
	@Autowired
	public void setDocumentService(PersonalDocumentService personalDocumentService) {
		this.personalDocumentService = personalDocumentService;
	}
	@Autowired
	public void setVisaStatusService(VisaStatusService visaStatusService) {
		this.visaStatusService = visaStatusService;
	}
	@Autowired
	public void setEmployeePageRepo(EmployeePageRepository employeePageRepository) {
		this.employeePageRepository = employeePageRepository;
	}
	
//	private RestTemplate restTemplate;
//	
//	@Autowired
//	public void setRestTemplate(RestTemplate restTemplate) {
//		this.restTemplate = restTemplate;
//	}
	
	/*
	@GetMapping("PersonalInfo/{userid}")
	public List<Contact> getcContacts(@PathVariable Integer userid){
		String idString = userid + "";
		return contactService.getAllByUserId(idString);
	}
	
	/*
	@GetMapping("test")
	public List<Contact> getcContacts1(){
		//String idString = userid + "";
		return contactService.getAllByUserId("someid");
	}
	*/
	
	
	//Must ensure Userid all start with int
	@GetMapping("PersonalInfo/{userid}")
	public AllEmployeeResponse getFullInfo(@PathVariable Integer userid) {
		Employee employee = employeeService.getEmployeeByUserId(userid);
		String idPrefix = userid + "";
		List<Contact> contacts = contactService.getAllByUserId(idPrefix);
		List<Address> addresses = addressService.getAllByUserId(idPrefix);
		List<VisaStatus> visaStatus = visaStatusService.getAllByUserId(idPrefix);
		List<PersonalDocument> documents = personalDocumentService.getAllByUserId(idPrefix);
		PersonalDocument document = new PersonalDocument();
		if(!documents.isEmpty()) document = documents.get(0);
		
		return AllEmployeeResponse.builder()
				.employee(employee).contact(contacts).addresses(addresses)
				.visaStatuses(visaStatus).personalDocument(document).build();
	}
	
	//@GetMapping("HR/allActiveVisa")
	public Slice<EmployeeWithActiveVisa> getEmployeeWithVisa(
				@RequestParam Integer page, @RequestParam Integer size){
		Pageable pageing = PageRequest.of(page, size, Sort.by("id"));
		
		List<Employee> employees= employeeService.getAllEmployee();
		List<EmployeeWithActiveVisa> employeeAndVisas = new ArrayList();
		
		EmployeeWithActiveVisa tempEmpwVisa = new EmployeeWithActiveVisa();
		
		
		for(Employee e : employees) {
			tempEmpwVisa.setFullName(e.getFirstName() + " " + e.getLastName());
			//visaStatusService.findVisaStatusById(e.getUserID());
			tempEmpwVisa.setWorkAuthorization(visaStatusService.getAllByUserId(e.getUserID()+"").get(0).getVisaType());
			tempEmpwVisa.setExpirationDate(visaStatusService.getAllByUserId(e.getUserID()+"").get(0).getEndDate());
			
		    int diffInDays = (int)( (tempEmpwVisa.getExpirationDate().getTime() - new java.util.Date().getTime()) 
	                 / (1000 * 60 * 60 * 24) );
			tempEmpwVisa.setDayLeft(diffInDays);
			
			employeeAndVisas.add(tempEmpwVisa);
		}
		
		//Page<EmployeeWithActiveVisa> pageresult = new Page
		return null;
	}
	
	
	@GetMapping("HR/Viewprofiles")
	public Slice<Employee> viewAllEmployees2(
			@RequestParam(required = false) String firstName,
			@RequestParam(required = false) String email,
			@RequestParam Integer page, @RequestParam Integer size){
		
		List<Employee> employees = new ArrayList<Employee>();
		Pageable pageing = PageRequest.of(page, size, Sort.by("id"));
		
		Page<Employee> pageTemp;
		if(firstName != null) {
			return employeePageRepository.findByFirstNameContaining(firstName, PageRequest.of(page, size, Sort.by("id")));
		}
		else if(email != null) {
			return employeePageRepository.findByEmailContaining(email, PageRequest.of(page, size, Sort.by("id")));
		}
		else {
			return employeePageRepository.findAll(PageRequest.of(page,size, Sort.by("id")));
		}

		//return employeePageRepository.findByUserID(userId, PageRequest.of(page,size, Sort.by("id")));
	}
	
}

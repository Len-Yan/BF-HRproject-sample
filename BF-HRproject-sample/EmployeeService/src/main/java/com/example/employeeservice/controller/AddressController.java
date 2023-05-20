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

import com.example.employeeservice.domain.Address;
import com.example.employeeservice.service.AddressService;

@RestController
@RequestMapping("Address")
public class AddressController {

	AddressService addressService;
	
	@Autowired
	private void setAddressService(AddressService addressService) {
		this.addressService = addressService;
	}
	
	@GetMapping
	public List<Address> getAllAddress(){
		return addressService.getAllAddress();
	}
	
	@PostMapping("/add")
	public Address addAddress(@RequestBody Address address) {
		return addressService.addAddress(address);
	}
	
	//add to a user by mapping userid
	@PostMapping("/add/{userId}")
	public Address addAddressByUser(@PathVariable Integer userId, @RequestBody Address address) {
		String tempId = userId + " - " + address.getId() ;
		
		address.setId(tempId);
		return addressService.addAddress(address);
	}
	
	@PostMapping("/update")
	public Address updateAddress(@RequestBody Address address) {
		return addressService.updateAddress(address);
	}
	
	@DeleteMapping("/delete/{id}")
	public Address deleteAddress(@PathVariable String id) {
		return addressService.deleteAddress(id);
	}
}

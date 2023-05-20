package com.example.employeeservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.employeeservice.domain.Address;
import com.example.employeeservice.repository.AddressRepository;

@Component
@Service
public class AddressService {

	private AddressRepository addressRepository;
	
	@Autowired
	public void setAddressRepo(AddressRepository addressRepository) {
		this.addressRepository = addressRepository;
	}
	
	public Address getAddressById(String id) {
		return addressRepository.findById(id).get();
	}
	
	public Address addAddress(Address address) {
		return addressRepository.insert(address);
	}
	
	public Address updateAddress(Address address) {
		return addressRepository.save(address);
	}
	
	public Address deleteAddress(String id) {
		return addressRepository.deleteAddressById(id);
	}
	
	public List<Address> getAllByUserId(String userId){
		return addressRepository.findByIdLike(userId);
	}
	
	public List<Address> getAllAddress(){
		return addressRepository.findAll();
	}
}

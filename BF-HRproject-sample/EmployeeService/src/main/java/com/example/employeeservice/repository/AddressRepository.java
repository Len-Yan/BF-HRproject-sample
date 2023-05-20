package com.example.employeeservice.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.employeeservice.domain.Address;

public interface AddressRepository extends MongoRepository<Address, String> {

	Optional<Address> findById(String id);
	
	//Optional<Address> addAddress(Address address);
	
	Address save(Address address);
	
	Address insert(Address address);
	
	Address deleteAddressById(String id);
	
	List<Address> findByIdLike(String userid);
	
	List<Address> findAll();
}

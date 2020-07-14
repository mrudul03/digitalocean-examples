package com.microservices.customers.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservices.customers.contract.CustomerResource;
import com.microservices.customers.repository.CustomerEntity;
import com.microservices.customers.repository.CustomersRepository;
import com.microservices.customers.transform.ResourceToEntityTransformer;

@Service
public class CustomerService {
	
	@Autowired
	private CustomersRepository customersRepository;
	
	@Autowired
	private ResourceToEntityTransformer entityTransformer;
	

	public List<CustomerEntity> getAllCustomers(){
		return customersRepository.findAll();
	}
	
	public CustomerEntity createCustomer(CustomerResource customerResource){
		System.out.println("In createCustomer Service");
		CustomerEntity customerEntity = entityTransformer.transformCustomer(customerResource);
		CustomerEntity savedCustomer = customersRepository.save(customerEntity);
		
		
		return savedCustomer;
	}
	
	public CustomerEntity getCustomer(Long customerId){
		return customersRepository.getOne(customerId);
	}
	
	public void deleteCustomer(Long customerId){
		CustomerEntity customerEntity = customersRepository.getOne(customerId);
		customersRepository.delete(customerEntity);
	}

}

package com.microservices.customers.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.customers.contract.CustomerResource;
import com.microservices.customers.domain.CustomerService;
import com.microservices.customers.repository.CustomerEntity;
import com.microservices.customers.transform.EntityToResourceTransformer;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api/customerservice")
@Api(value = "Customer Service", description = "Operations pertaining to customer")
public class CustomerController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private EntityToResourceTransformer resourceTransformer;
	
	@ApiOperation(value = "Get all customers")
	@GetMapping("/customers")
	public ResponseEntity<List<CustomerResource>> getAllCustomers(){
		
		LOGGER.info("in getAllCustomers.........");
		List<CustomerResource> customerResources = null;
		
		List<CustomerEntity> customers = customerService.getAllCustomers();
		if(null != customers){
			LOGGER.info("in getAllCustomers.........:"+customers.size());
			customerResources =resourceTransformer.transformCustomerList(customers);
		}else {
			LOGGER.info("in getAllCustomers.........Null customers");
			customerResources = new ArrayList<>();
		}
		return ResponseEntity.ok(customerResources);
	}
	
//	@RequestMapping(value="/customers", 
//			method = RequestMethod.POST, headers = "Accept=application/json")
	
	@PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE,
	 value="/customers")
	public ResponseEntity<CustomerResource> createCustomer(
			@RequestBody CustomerResource customerResource ){
		
		LOGGER.info("In createCustomer Controller");
		
		CustomerEntity customerEntity = customerService.createCustomer(customerResource);
		return ResponseEntity.ok(resourceTransformer.transformCustomer(customerEntity));
	}
	
	@RequestMapping(value="/customers/{customerId}", 
			method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<CustomerResource> getCustomer(@PathVariable Long customerId ){
		
		LOGGER.info("In getCustomer Controller");
		CustomerEntity customerEntity = customerService.getCustomer(customerId);
		return ResponseEntity.ok(resourceTransformer.transformCustomer(customerEntity));
	}
	
	@RequestMapping(value="/customers/{customerId}", 
			method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity<Void> deleteCustomer(@PathVariable Long customerId ){
		
		LOGGER.info("In deleteCustomer Controller");
		customerService.deleteCustomer(customerId);
		return ResponseEntity.noContent().build();
	}


}

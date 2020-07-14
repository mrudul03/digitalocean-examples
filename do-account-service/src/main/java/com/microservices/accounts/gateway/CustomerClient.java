package com.microservices.accounts.gateway;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.microservices.accounts.contract.CustomerResource;

@FeignClient(name="customer-svc", url="http://customer-svc.customer")
public interface CustomerClient {
	
	@RequestMapping(method = RequestMethod.GET, value = "/api/customerservice/customers/{customerId}")
	CustomerResource getCustomer(@PathVariable("customerId") Long customerId);

}

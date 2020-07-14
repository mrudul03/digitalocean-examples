package com.microservices.customers.contract;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CustomerResource {
	
	private Long customerId;
	private String firstName;
	private String lastName;
	//private Date birthDate;
}

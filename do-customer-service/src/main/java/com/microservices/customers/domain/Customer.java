package com.microservices.customers.domain;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
	
	private Long customerId;
	private String firstName;
	private String lastName;
	private Date birthDate;
	private Date dateCreated;
	private Date dateUodated;
	

}
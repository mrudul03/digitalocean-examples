package com.microservices.accounts.contract;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountResource {
	
	private Long accountId;
	private String accountName;
	private String accountType;
	private Double balance;
	private String customerFirstName;
	private String customerLastName;
	private Date dateCreated;
	private Date dateUodated;

}

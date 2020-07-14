package com.microservices.accounts.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.microservices.accounts.contract.AccountResource;
import com.microservices.accounts.contract.CustomerResource;
import com.microservices.accounts.gateway.CustomerClient;

@Service
public class AccountService {
	
	private final CustomerClient customerClient;
	private static final Logger LOGGER = LoggerFactory.getLogger(AccountService.class);
	
	public AccountService(
			CustomerClient customerClient){
		
		this.customerClient = customerClient;
	}
	
	public List<AccountResource> getAllAccounts(){
		
		List<AccountResource> accounts = new ArrayList<AccountResource>();
		AccountResource account1 = new AccountResource( 123L, "MyAccount", "SAVINGS",
				123.00d, "Customer First Name", "Customer Last Name", 
				new Date(), new Date());
		
		accounts.add(account1);
		
		try {
			LOGGER.info("Calling customer service......");
			CustomerResource customerResource = customerClient.getCustomer(1L);
			LOGGER.info("Got customer resource......."+customerResource);
		}catch(Exception e) {
			LOGGER.error("Exception calling customer service...", e);
		}
		
		return accounts;
	}

}

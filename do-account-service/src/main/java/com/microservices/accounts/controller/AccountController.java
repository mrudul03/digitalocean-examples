package com.microservices.accounts.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.accounts.contract.AccountResource;
import com.microservices.accounts.domain.AccountService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api/accountservice")
@Api(value = "Account Service", description = "Operations pertaining to customer account")
public class AccountController {

	private static final Logger LOGGER = LoggerFactory.getLogger(AccountController.class);
	
	@Autowired
	private AccountService accountService;
	
	@ApiOperation(value = "Get all customers")
	@GetMapping("/accounts")
	public ResponseEntity<List<AccountResource>> getAllAccounts(){
		
		LOGGER.info("in getAllAccounts.........");
		
		List<AccountResource> accountResources = accountService.getAllAccounts();
		return ResponseEntity.ok(accountResources);
	}
}

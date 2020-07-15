package com.app.gpay.controller;

import java.math.BigDecimal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.gpay.clients.BankingClient;
import com.app.gpay.dto.AccountHistoryDto;
import com.app.gpay.dto.AccountHistoryResponseDto;
import com.app.gpay.dto.Customer;
import com.app.gpay.dto.UserRequestDto;
import com.app.gpay.service.RegistrationService;
import com.app.gpay.service.impl.GpayServiceImpl;
@RestController
@RequestMapping("/users")
public class GpayController {

	
	@Autowired
	GpayServiceImpl gpayServiceImpl;
	
	@Autowired
	RegistrationService registrationService;
	
	@Autowired
	BankingClient bankingClient;
	
	Logger logger=LoggerFactory.getLogger(GpayServiceImpl.class);
	
	@PostMapping("/save")
	public ResponseEntity<String> registration(@RequestBody UserRequestDto employeeReqDto) {
		Customer customer=bankingClient.getCustomerId(employeeReqDto.getPhoneNumber());
		if(customer==null) {
			return new ResponseEntity<String>("user does not have bank account ", HttpStatus.CREATED);
		}
		registrationService.saveUser(employeeReqDto);
		return new ResponseEntity<String>("Success", HttpStatus.CREATED);
	}
	
	@PostMapping("/phoneNumberBasedTransfer/{userId}/{toPhoneNumber}/{amount}")
	public ResponseEntity<String> phoneNumberBasedTransfer(@PathVariable Integer userId,@PathVariable Long toPhoneNumber,@PathVariable BigDecimal amount){
		Long fromPhoneNumber=registrationService.getPhoneNumber(userId);
		String message=gpayServiceImpl.transfer(fromPhoneNumber, toPhoneNumber, amount);
		return new ResponseEntity<>(message, HttpStatus.OK);
}
	@GetMapping("LastTransactions/{id}")
	public AccountHistoryResponseDto getLast10Transaction(@PathVariable Integer userId) {
		List<AccountHistoryDto> accountHistoryDtos = gpayServiceImpl.getLast10Transaction(userId);
		AccountHistoryResponseDto accountHistoryResponseDto = new AccountHistoryResponseDto();
		accountHistoryResponseDto.setAccountHistoryDos(accountHistoryDtos);
		accountHistoryResponseDto.setStatusMessage("Last 10 transactions retrived successfully");
		accountHistoryResponseDto.setStatusCode(200);
		return accountHistoryResponseDto;
	}
	
	
}

package com.app.gpay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.gpay.dto.UserRequestDto;
import com.app.gpay.service.RegistrationService;


@RestController
@RequestMapping("/users")
public class GpayController {
	@Autowired
	RegistrationService registrationService;
	
	@PostMapping("/save")
	public ResponseEntity<String> registration(@RequestBody UserRequestDto employeeReqDto) {
		registrationService.saveUser(employeeReqDto);
		return new ResponseEntity<String>("Success", HttpStatus.CREATED);
	}


}

package com.app.gpay.controller;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;


import com.app.gpay.clients.BankingClient;
import com.app.gpay.dto.UserRequestDto;
import com.app.gpay.service.RegistrationService;

@RunWith(MockitoJUnitRunner.class)
public class GpayControllerTest {
	@InjectMocks
	RegistrationController gpayController;
	
	@Mock
	RegistrationService registrationService;
	
	@Mock
	BankingClient bankingClient;
	
	@Test
	public void testRegister() {
		UserRequestDto userRequestDto=new UserRequestDto();
		assertTrue(gpayController.registration(userRequestDto).getBody().contains("user does not have bank account"));
		
	}
	
	@Test
	public void testTransfer() {
		Mockito.when(registrationService.getPhoneNumber(Integer.valueOf(2))).thenReturn(333L);
		
		assertTrue(gpayController.phoneNumberBasedTransfer(Integer.valueOf(2),27667L,new BigDecimal("19")).getStatusCodeValue()==200);
		
	}
}

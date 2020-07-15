package com.app.gpay.service;

import org.springframework.stereotype.Service;

import com.app.gpay.dto.UserRequestDto;
import com.app.gpay.model.Registration;




@Service
public interface RegistrationService {
	public Registration saveUser(UserRequestDto userRequestDto);

}

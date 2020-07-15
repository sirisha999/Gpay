package com.app.gpay.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.gpay.dto.UserRequestDto;
import com.app.gpay.model.Registration;
import com.app.gpay.repository.RegistrationRepository;


@Service
public class RegistrationServiceImpl implements RegistrationService{
	
	@Autowired
	RegistrationRepository registrationRepository;
	
	public Registration saveUser(UserRequestDto userRequestDto) {
			Registration registration = new Registration();
			BeanUtils.copyProperties(userRequestDto, registration);
			return registrationRepository.save(registration);
		}

}

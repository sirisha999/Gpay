package com.app.gpay.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.gpay.model.Registration;

public interface RegistrationRepository  extends JpaRepository<Registration, Integer>{
	

}

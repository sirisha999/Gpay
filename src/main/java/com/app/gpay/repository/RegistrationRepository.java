package com.app.gpay.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.gpay.model.Registration;
@Repository
public interface RegistrationRepository  extends JpaRepository<Registration, Integer>{
	
public Registration findByUserId(Integer id);
}

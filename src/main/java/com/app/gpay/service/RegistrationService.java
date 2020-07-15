package com.app.gpay.service;


import java.math.BigDecimal;
import java.util.List;

import com.app.gpay.dto.AccountHistoryDto;
import com.app.gpay.dto.UserRequestDto;
import com.app.gpay.model.Registration;




public interface RegistrationService {
	
	public Long getPhoneNumber(Integer userId);

	public String transfer(Long toPhoneNumber, Long fromPhoneNumber, BigDecimal amount);

	public List<AccountHistoryDto> getLast10Transaction(Integer userId);

	public Registration saveUser(UserRequestDto userRequestDto);

}

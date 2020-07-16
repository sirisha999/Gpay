package com.app.gpay.service.impl;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.app.gpay.clients.BankingClient;
import com.app.gpay.controller.RegistrationController;
import com.app.gpay.dto.AccountHistoryDto;
import com.app.gpay.dto.UserRequestDto;
import com.app.gpay.model.AccountHistory;
import com.app.gpay.model.Registration;
import com.app.gpay.repository.AccountHistoryRepository;
import com.app.gpay.repository.RegistrationRepository;
import com.app.gpay.service.RegistrationService;


@Service
public class RegistrationServiceImpl implements RegistrationService{
	
	@Autowired
	RegistrationRepository registrationRepository;
	
	@Autowired
	AccountHistoryRepository accountHistoryRepository;
	
	@Autowired
	BankingClient bankingClient;
	
	@Autowired
	RegistrationRepository gpayRepository;
	Logger logger=LoggerFactory.getLogger(RegistrationServiceImpl.class);
	
	public Registration saveUser(UserRequestDto userRequestDto) {
			Registration registration = new Registration();
			BeanUtils.copyProperties(userRequestDto, registration);
			return registrationRepository.save(registration);
		}
	
	public Long getPhoneNumber(Integer id) {
		Registration registration=registrationRepository.findByUserId(id);
		if(registration!=null)
		return registration.getPhoneNumber();
		return 0L;
	}
	
	
	public String transfer(Long fromPhoneNumber,Long toPhoneNumber,BigDecimal amount) {

		ResponseEntity<String> message=bankingClient.phoneNumberBasedTransfer(fromPhoneNumber, toPhoneNumber, amount);
		
		
			AccountHistory fromAccountHistory = new AccountHistory();
			AccountHistory toAccountHistory = new AccountHistory();
			fromAccountHistory.setFromPhoneNumber(fromPhoneNumber);
			fromAccountHistory.setTransferAmount(amount);
			fromAccountHistory.setToPhoneNumber(toPhoneNumber);
			fromAccountHistory.setTransactionTime(new Timestamp(System.currentTimeMillis()));
			accountHistoryRepository.save(fromAccountHistory);
			accountHistoryRepository.save(toAccountHistory);
			return amount+" trasferred from " + fromPhoneNumber + " to "
					+ toPhoneNumber;

		}
	
	public List<AccountHistoryDto> getLast10Transaction(Integer userId) {
		Long number=gpayRepository.findByUserId(userId).getPhoneNumber();
		logger.info("number is"+number);
		List<AccountHistory> list=accountHistoryRepository.findTop10ByFromPhoneNumberOrToPhoneNumberOrderByTransactionTimeDesc(number, number);
	return list.stream().map(RegistrationServiceImpl::getDtoFromEntity).collect(Collectors.toList());
	}
	
	private static AccountHistoryDto getDtoFromEntity(AccountHistory accountHistory) {
		AccountHistoryDto accountHistoryDto = new AccountHistoryDto();
		BeanUtils.copyProperties(accountHistory, accountHistoryDto);
		return accountHistoryDto;
	}

}

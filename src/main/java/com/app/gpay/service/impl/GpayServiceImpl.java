package com.app.gpay.service.impl;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.app.gpay.clients.BankingClient;
import com.app.gpay.dto.AccountHistoryDto;
import com.app.gpay.model.AccountHistory;
import com.app.gpay.repository.AccountHistoryRepository;
import com.app.gpay.repository.RegistrationRepository;

@Service
public class GpayServiceImpl {
	@Autowired
	AccountHistoryRepository accountHistoryRepository;
	
	@Autowired
	BankingClient bankingClient;
	
	@Autowired
	RegistrationRepository gpayRepository;
	
	public String transfer(Long fromPhoneNumber,Long toPhoneNumber,BigDecimal amount) {

		ResponseEntity<String> message=bankingClient.phoneNumberBasedTransfer(fromPhoneNumber, toPhoneNumber, amount);
		if(!message.getBody().contains(amount.toString())){
			return message.getBody();
		}
			AccountHistory fromAccountHistory = new AccountHistory();
			AccountHistory toAccountHistory = new AccountHistory();
			fromAccountHistory.setFromPhoneNumber(fromPhoneNumber);
			fromAccountHistory.setTransferAmount(amount);
			fromAccountHistory.setTransactionTime(new Timestamp(System.currentTimeMillis()));
			accountHistoryRepository.save(fromAccountHistory);
			toAccountHistory.setToPhoneNumber(toPhoneNumber);
			toAccountHistory.setTransactionTime(new Timestamp(System.currentTimeMillis()));
			toAccountHistory.setTransferAmount(amount);
			accountHistoryRepository.save(toAccountHistory);
			return amount+" trasferred from " + fromPhoneNumber + " to "
					+ toPhoneNumber;

		}
	
	public List<AccountHistoryDto> getLast10Transaction(Integer userId) {
		Long number=gpayRepository.findByUserId(userId).getPhoneNumber();
		List<AccountHistory> list=accountHistoryRepository.findTop10ByFromPhoneNumberOrToPhoneNumberOrderByTransactionTimeDesc(number, number);
	return list.stream().map(GpayServiceImpl::getDtoFromEntity).collect(Collectors.toList());
	}
	
	private static AccountHistoryDto getDtoFromEntity(AccountHistory accountHistory) {
		AccountHistoryDto accountHistoryDto = new AccountHistoryDto();
		BeanUtils.copyProperties(accountHistory, accountHistoryDto);
		return accountHistoryDto;
	}
}

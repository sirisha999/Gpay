package com.app.gpay.service;

import java.math.BigDecimal;
import java.util.List;

import com.app.gpay.dto.AccountHistoryDto;

public interface GpayService {
	public String transfer(Long toPhoneNumber,Long fromPhoneNumber,BigDecimal amount);
	public List<AccountHistoryDto> getLast10Transaction(Integer userId);
}

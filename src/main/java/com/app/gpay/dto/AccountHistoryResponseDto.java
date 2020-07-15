package com.app.gpay.dto;

import java.util.ArrayList;
import java.util.List;


public class AccountHistoryResponseDto {
List<AccountHistoryDto> accountHistoryDos = new ArrayList<>();
	
	private int statusCode;
	
	private String statusMessage;

	public List<AccountHistoryDto> getAccountHistoryDos() {
		return accountHistoryDos;
	}

	public void setAccountHistoryDos(List<AccountHistoryDto> accountHistoryDos) {
		this.accountHistoryDos = accountHistoryDos;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getStatusMessage() {
		return statusMessage;
	}

	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}
}

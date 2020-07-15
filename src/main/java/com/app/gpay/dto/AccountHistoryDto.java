package com.app.gpay.dto;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class AccountHistoryDto {
	private Integer transactionId;
	 private Long fromPhoneNumber;
	private BigDecimal transferAmount;
	 private Long toPhoneNumber;
	private Timestamp transactionTime;
	
	public Integer getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
	}
	public Long getFromPhoneNumber() {
		return fromPhoneNumber;
	}
	public void setFromPhoneNumber(Long fromPhoneNumber) {
		this.fromPhoneNumber = fromPhoneNumber;
	}
	public BigDecimal getTransferAmount() {
		return transferAmount;
	}
	public void setTransferAmount(BigDecimal transferAmount) {
		this.transferAmount = transferAmount;
	}
	public Long getToPhoneNumber() {
		return toPhoneNumber;
	}
	public void setToPhoneNumber(Long toPhoneNumber) {
		this.toPhoneNumber = toPhoneNumber;
	}
	public Timestamp getTransactionTime() {
		return transactionTime;
	}
	public void setTransactionTime(Timestamp transactionTime) {
		this.transactionTime = transactionTime;
	}
}


package com.app.gpay.clients;

import java.math.BigDecimal;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.gpay.dto.Customer;

@FeignClient(name="http://BANKING/banking/services")
public interface BankingClient {
	@PostMapping("/phoneNumberBasedTransfer")
	public ResponseEntity<String> phoneNumberBasedTransfer(@PathVariable Long fromPhoneNumber,@PathVariable Long toPhoneNumber,@PathVariable BigDecimal amount);
	@GetMapping("/getCustomer/{}")
	public Customer getCustomerId(@PathVariable Long phone) ;
}

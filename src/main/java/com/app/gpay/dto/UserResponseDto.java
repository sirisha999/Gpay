package com.app.gpay.dto;

import java.util.ArrayList;
import java.util.List;

public class UserResponseDto {
	List<UserDto> userDtos = new ArrayList<>();

	private int statusCode;

	public List<UserDto> getUserDtos() {
		return userDtos;
	}

	public void setUserDtos(List<UserDto> userDtos) {
		this.userDtos = userDtos;
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

	private String statusMessage;
}

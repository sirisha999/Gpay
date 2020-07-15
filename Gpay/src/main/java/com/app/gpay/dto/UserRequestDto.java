package com.app.gpay.dto;

public class UserRequestDto {
	private String user_name;
	private String password;
	private Long phone_number;
	private String email;
	private Long pan_number;

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(Long phone_number) {
		this.phone_number = phone_number;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getPan_number() {
		return pan_number;
	}

	public void setPan_number(Long pan_number) {
		this.pan_number = pan_number;
	}

}

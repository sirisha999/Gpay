package com.app.gpay.dto;

public class UserRequestDto {
	private String userName;
	private String passWord;
	private Long phoneNumber;
	private String email;
	private Long panNumber;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public Long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getPanNumber() {
		return panNumber;
	}
	public void setPanNumber(Long panNumber) {
		this.panNumber = panNumber;
	}


}

package com.entity;

public class UserData {




	private int id;
	private String username;
	private String gender;
	private String userMail;
	private String userPassword;
	private String mobileNumber;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getUserMail() {
		return userMail;
	}
	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public UserData(int id, String username, String gender, String userMail, String userPassword, String mobileNumber
			) {
		this.id = id;
		this.username = username;
		this.gender = gender;
		this.userMail = userMail;
		this.userPassword = userPassword;
		this.mobileNumber = mobileNumber;

	}
	@Override
	public String toString() {
		return "UserData [id=" + id + ", username=" + username + ", gender=" + gender + ", userMail=" + userMail
				+ ", userPassword=" + userPassword + ", mobileNumber=" + mobileNumber 
				+ "]";
	}





}

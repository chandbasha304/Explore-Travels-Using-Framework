package com.data;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.Table;

@Entity
@Table(name="traveller")
public class UserData {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	
	private int userId;
	@Column(name="name")
	private String userName;
	@Column(name="gender")
	private String gender;
	@Column(name="userMail")
	private String userMail;
	@Column(name="userPassword")
	private String userPassword;
	
	
	
	
	public UserData() {
		
	}
	@Column(name="mobileNumber")
	private String mobileNumber;
	@Column(name="userAmount")
	private double userAmount;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	@Override
	public String toString() {
		return "UserData [userId=" + userId + ", userName=" + userName + ", gender=" + gender + ", userMail=" + userMail
				+ ", userPassword=" + userPassword + ", mobileNumber=" + mobileNumber + ", userAmount=" + userAmount
				+ "]";
	}
	public UserData(int userId, String userName, String gender, String userMail, String userPassword,
			String mobileNumber, double userAmount) {
		
		this.userId = userId;
		this.userName = userName;
		this.gender = gender;
		this.userMail = userMail;
		this.userPassword = userPassword;
		this.mobileNumber = mobileNumber;
		this.userAmount = userAmount;
	}
	public void setUserName(String userName) {
		this.userName = userName;
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
	public double getUserAmount() {
		return userAmount;
	}
	public void setUserAmount(double userAmount) {
		this.userAmount = userAmount;
	}
	
	
	
	

}


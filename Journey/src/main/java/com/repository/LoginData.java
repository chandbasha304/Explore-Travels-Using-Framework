package com.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class LoginData  implements RowMapper<LoginData>{
	
	private int id;
	private String userName;
	private String gender;
	private String email;
	private String accountPassword;
private String mobileNumber;

	@Override
public String toString() {
	return "LoginData [id=" + id + ", userName=" + userName + ", gender=" + gender + ", email=" + email
			+ ", accountPassword=" + accountPassword + ", mobileNumber=" + mobileNumber + "]";
}

	public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getUserName() {
	return userName;
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

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getAccountPassword() {
	return accountPassword;
}

public void setAccountPassword(String accountPassword) {
	this.accountPassword = accountPassword;
}

public String getMobileNumber() {
	return mobileNumber;
}

public void setMobileNumber(String mobileNumber) {
	this.mobileNumber = mobileNumber;
}

	public LoginData(int id, String userName, String gender, String email, String accountPassword, String mobileNumber) {
	this.id = id;
	this.userName = userName;
	this.gender = gender;
	this.email = email;
	this.accountPassword = accountPassword;
	this.mobileNumber = mobileNumber;
}
	

	public LoginData() {
	
	}

	@Override
	public LoginData mapRow(ResultSet rs, int rowNum) throws SQLException {
		
LoginData dataDisplay =new LoginData();
dataDisplay.setEmail(rs.getString(4));
dataDisplay.setAccountPassword(rs.getString(5));
		
		
		
		return dataDisplay;
	}

}

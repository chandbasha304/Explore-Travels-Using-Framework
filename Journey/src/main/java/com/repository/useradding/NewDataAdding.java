package com.repository.useradding;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.entity.UserData;
@Component
public class NewDataAdding {

	@Autowired
	JdbcTemplate jdbc;
	public void newDataAdding(String fullname, String number, String email, String password, String gender) {
		UserData newData=new UserData(0, fullname, gender, email, password, number);
		int update = jdbc.update("insert into traveller (username,gender,userMail,userPassword,mobileNumber) values(?,?,?,?,?"
				+ ")",newData.getUsername(),newData.getGender(),newData.getUserMail(),newData.getUserPassword(),newData.getMobileNumber());
		System.out.println(update+" Row Updated");
	}
}

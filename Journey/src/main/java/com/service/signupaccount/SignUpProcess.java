package com.service.signupaccount;

import javax.servlet.http.HttpServletRequest;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.repository.useradding.NewDataAdding;
@Component
public class SignUpProcess implements SignUpAccount{

	@Autowired
	 NewDataAdding dataAdd;
	@Override
	public void login( HttpServletRequest data) {
		String fullname = data.getParameter("fullname");
		String number = data.getParameter("mobilenumber");
		String email = data.getParameter("email");
		String password = data.getParameter("password");
		String gender = data.getParameter("gender");
		dataAdd.newDataAdding(fullname, number, email, password, gender);
	}
	

}

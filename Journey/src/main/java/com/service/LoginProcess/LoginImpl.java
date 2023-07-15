package com.service.LoginProcess;

import javax.servlet.http.HttpServletRequest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.repository.CheckingData;
@Service
public class LoginImpl  implements LoginAccount{
	
	@Autowired
	CheckingData information;

	@Override
	public boolean String(HttpServletRequest loginrequest) {
		String usermail = loginrequest.getParameter("email");
		String password = loginrequest.getParameter("password");
		boolean result = information.dataFromDatabase(usermail, password);
		return result;


	}

}

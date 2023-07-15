package com.controller;

import java.io.IOException;

import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.service.LoginProcess.LoginAccount;
import com.service.booking.PlanningJourney;
import com.service.signupaccount.SignUpAccount;

@Controller
public class ClientRequesting {
	@Autowired
	SignUpAccount refer;
	
	@Autowired
	LoginAccount credentials;
	
	@Autowired
	PlanningJourney booking;

	@RequestMapping("/signup")

	public String signupData(HttpServletRequest request,Model toClient)
	{
		System.out.println("New User Account");

		return "newuser";
	}



	@RequestMapping("/dataSending")

	public String dataReceive(HttpServletRequest request,Model model)
	{

		refer.login(request);
		

		String parameter = request.getParameter("fullname");
		String parameter2 = request.getParameter("password");
		model.addAttribute("fullname",parameter);
		System.out.println(parameter);
		



		return "signupsuccess";
	}
	

	@RequestMapping("/signin")

	public String signinData(HttpServletRequest request,Model toClient)
	{
		System.out.println("New User Account");

		return "account";
	}
	@RequestMapping("/logincredentials")

	public String signintoAccount(HttpServletRequest request,Model toClient) throws ServletException, IOException
	{
		boolean string = credentials.String(request);
		if(string)
		{
			
			String name = request.getParameter("email");
			Model basha = toClient.addAttribute(name);
			Map<String, Object> asMap = toClient.asMap();
			System.out.println(asMap);
			System.out.println(basha);
			toClient.addAttribute("fullname",name);
			toClient.addAttribute("name",asMap);
			return "signupsuccess";
		}
		else
		{
			return "NotFound";
		}
		
		
		

		
	}
	@RequestMapping("/journey")

	public String planJourney(HttpServletRequest request,Model toClient)
	{
		String fromPlace = request.getParameter("from");
		String destination = request.getParameter("to");
	String dateOfJourney = request.getParameter("date");
	booking.String(fromPlace,destination,dateOfJourney);
	return "bookingconfirm";
	}
	
	@RequestMapping("/logout")

	public String logout(HttpServletRequest request,Model toClient)
	{
		
	return "index2";
	
	
	
	
		
		

	}

}

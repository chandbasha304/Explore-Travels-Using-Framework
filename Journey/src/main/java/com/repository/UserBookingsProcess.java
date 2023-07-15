package com.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.entity.UserBookings;

@Repository
public class UserBookingsProcess {
	
	@Autowired
	JdbcTemplate ticket;


	public String ticketBooking(UserBookings newTicket)
	{
		
		
		int update = ticket.update("INSERT INTO bookings VALUES(?,?,?,?,?);",0,newTicket.getFromplace(),newTicket.getToPlace()
				,newTicket.getBookeddate(),newTicket.getJourneydate());
		
		System.out.println(update+"Booked");
		return  "bookingconfirm";
	}
}

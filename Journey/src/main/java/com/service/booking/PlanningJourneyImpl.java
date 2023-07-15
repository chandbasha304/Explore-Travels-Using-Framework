package com.service.booking;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.UserBookings;
import com.repository.UserBookingsProcess;

@Service
public class PlanningJourneyImpl implements PlanningJourney{
	
	@Autowired
	UserBookingsProcess confirming;

	@Override
	public void String(String fromPlace, String destination,String dateOfJourney) {
		
		LocalDate presentdate=LocalDate.now();
		
		UserBookings newTicket=new UserBookings(0, fromPlace, destination, dateOfJourney,presentdate.toString());
		confirming.ticketBooking(newTicket);
		
	}


	

}

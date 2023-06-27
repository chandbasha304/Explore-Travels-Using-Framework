package com.data;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="bookings")
public class UserBookings {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="bookingid")
	private int bookId;
	@Column(name="fromCity")
	private String fromplace;
	@Column(name="destination")
	private String toPlace;
	@Column(name="bookingdate")
	private String bookeddate;
	@Column(name="journeydate")
	private String journeydate;
	@Column(name="seatsBooked")
	private int seats;
	@Column(name="routeid")
	private int routeNumber;
	@Column(name="travelid")
	private int userid;
	
	public UserBookings(int bookId, String fromplace, String toPlace, String bookeddate, String journeydate, int seats,
			int routeNumber, int userid) {
		
		this.bookId = bookId;
		this.fromplace = fromplace;
		this.toPlace = toPlace;
		this.bookeddate = bookeddate;
		this.journeydate = journeydate;
		this.seats = seats;
		this.routeNumber = routeNumber;
		this.userid = userid;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getFromplace() {
		return fromplace;
	}
	public void setFromplace(String fromplace) {
		this.fromplace = fromplace;
	}
	public String getToPlace() {
		return toPlace;
	}
	public void setToPlace(String toPlace) {
		this.toPlace = toPlace;
	}
	public String getBookedData() {
		return bookeddate;
	}
	public void setBookedData(String bookedData) {
		this.bookeddate = bookedData;
	}
	public String getJourneydate() {
		return journeydate;
	}
	public void setJourneydate(String journeydate) {
		this.journeydate = journeydate;
	}
	public int getSeats() {
		return seats;
	}
	public void setSeats(int seats) {
		this.seats = seats;
	}
	public int getRouteNumber() {
		return routeNumber;
	}
	public void setRouteNumber(int routeNumber) {
		this.routeNumber = routeNumber;
	}
	public int getUserId() {
		return userid;
	}
	public void setUserId(int userId) {
		this.userid = userId;
	}
	@Override
	public String toString() {
		return "UserBookings [bookId=" + bookId + ", fromplace=" + fromplace + ", toPlace=" + toPlace + ", bookedData="
				+ bookeddate + ", journeydate=" + journeydate + ", seats=" + seats + ", routeNumber=" + routeNumber
				+ ", userId=" + userid + "]";
	}
	public UserBookings() {
		
	}
	
	
	

}


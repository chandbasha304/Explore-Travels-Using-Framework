package com.entity;


public class UserBookings {
	
	
	private int bookId;
	private String fromplace;
	private String toPlace;
	private String bookeddate;
	private String journeydate;
	
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
	public String getBookeddate() {
		return bookeddate;
	}
	public void setBookeddate(String bookeddate) {
		this.bookeddate = bookeddate;
	}
	public String getJourneydate() {
		return journeydate;
	}
	public void setJourneydate(String journeydate) {
		this.journeydate = journeydate;
	}
	
	public UserBookings(int bookId, String fromplace, String toPlace, String bookeddate, String journeydate) {
		
		this.bookId = bookId;
		this.fromplace = fromplace;
		this.toPlace = toPlace;
		this.bookeddate = bookeddate;
		this.journeydate = journeydate;
	}
	@Override
	public String toString() {
		return "UserBookings [bookId=" + bookId + ", fromplace=" + fromplace + ", toPlace=" + toPlace + ", bookeddate="
				+ bookeddate + ", journeydate=" + journeydate ; }
	public UserBookings() {
		
	}
	
	
	

	

}


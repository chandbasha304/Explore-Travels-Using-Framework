package com.data;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="places")
public class TravelPlaces {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int travelId;
	private String fromPlace;
	@Column(name="destination")
	private String destinationPlace;
	@Column(name="amount")
	private int ticketrate;
	private int seatsAvailable;
	public int getTravelId() {
		return travelId;
	}
	public void setTravelId(int travelId) {
		this.travelId = travelId;
	}
	public String getFromPlace() {
		return fromPlace;
	}
	public void setFromPlace(String fromPlace) {
		this.fromPlace = fromPlace;
	}
	public String getDestinationPlace() {
		return destinationPlace;
	}
	public void setDestinationPlace(String destinationPlace) {
		this.destinationPlace = destinationPlace;
	}
	public int getTicketrate() {
		return ticketrate;
	}
	public void setTicketrate(int ticketrate) {
		this.ticketrate = ticketrate;
	}
	public int getSeatsAvailable() {
		return seatsAvailable;
	}
	public void setSeatsAvailable(int seatsAvailable) {
		this.seatsAvailable = seatsAvailable;
	}
	public TravelPlaces(int travelId, String fromPlace, String destinationPlace, int ticketrate, int seatsAvailable) {
		
		this.travelId = travelId;
		this.fromPlace = fromPlace;
		this.destinationPlace = destinationPlace;
		this.ticketrate = ticketrate;
		this.seatsAvailable = seatsAvailable;
	}
	public TravelPlaces() {
		
	}
	@Override
	public String toString() {
		return "Travel  Places [Route Id=" + travelId + ", From   " + fromPlace + "  To "
				+ destinationPlace + ", Ticketrate=" + ticketrate + ", SeatsAvailable=" + seatsAvailable + "]";
	}

}

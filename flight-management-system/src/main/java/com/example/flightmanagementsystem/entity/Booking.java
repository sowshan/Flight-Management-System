package com.example.flightmanagementsystem.entity;

import java.util.Date;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "booking")
@Data
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer bookingId;
	private Integer noOfPassengers;
	private Date bookingdate;
	@OneToMany(cascade = CascadeType.MERGE)
	private List<Passenger> passengerList;
	private Double ticketCost;
	@OneToOne(cascade = CascadeType.MERGE)
	private Flight flight;
	@ManyToOne(cascade = CascadeType.MERGE)
	private User userId;
	/**
	 * @return the bookingId
	 */
	public Integer getBookingId() {
		return bookingId;
	}
	/**
	 * @param bookingId the bookingId to set
	 */
	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}
	/**
	 * @return the noOfPassengers
	 */
	public Integer getNoOfPassengers() {
		return noOfPassengers;
	}
	/**
	 * @param noOfPassengers the noOfPassengers to set
	 */
	public void setNoOfPassengers(Integer noOfPassengers) {
		this.noOfPassengers = noOfPassengers;
	}
	/**
	 * @return the bookingdate
	 */
	public Date getBookingdate() {
		return bookingdate;
	}
	/**
	 * @param bookingdate the bookingdate to set
	 */
	public void setBookingdate(Date bookingdate) {
		this.bookingdate = bookingdate;
	}
	/**
	 * @return the passengerList
	 */
	public List<Passenger> getPassengerList() {
		return passengerList;
	}
	/**
	 * @param passengerList the passengerList to set
	 */
	public void setPassengerList(List<Passenger> passengerList) {
		this.passengerList = passengerList;
	}
	/**
	 * @return the ticketCost
	 */
	public Double getTicketCost() {
		return ticketCost;
	}
	/**
	 * @param ticketCost the ticketCost to set
	 */
	public void setTicketCost(Double ticketCost) {
		this.ticketCost = ticketCost;
	}
	/**
	 * @return the flight
	 */
	public Flight getFlight() {
		return flight;
	}
	/**
	 * @param flight the flight to set
	 */
	public void setFlight(Flight flight) {
		this.flight = flight;
	}
	/**
	 * @return the userId
	 */
	public User getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(User userId) {
		this.userId = userId;
	}
	
	/*
	 * public Integer getBookingId() { return bookingId; } public void
	 * setBookingId(Integer bookingId) { this.bookingId = bookingId; } public
	 * Integer getNoOfPassengers() { return noOfPassengers; } public void
	 * setNoOfPassengers(Integer noOfPassengers) { this.noOfPassengers =
	 * noOfPassengers; } public Date getBookingdate() { return bookingdate; } public
	 * void setBookingdate(Date bookingdate) { this.bookingdate = bookingdate; }
	 * public List<Passenger> getPassengerList() { return passengerList; } public
	 * void setPassengerList(List<Passenger> passengerList) { this.passengerList =
	 * passengerList; } public Double getTicketCost() { return ticketCost; } public
	 * void setTicketCost(Double ticketCost) { this.ticketCost = ticketCost; }
	 * public Flight getFlight() { return flight; } public void setFlight(Flight
	 * flight) { this.flight = flight; } public User getUserId() { return userId; }
	 * public void setUserId(User userId) { this.userId = userId; }
	 * 
	 * @Override public String toString() { return "Booking [bookingId=" + bookingId
	 * + ", noOfPassengers=" + noOfPassengers + ", bookingdate=" + bookingdate +
	 * ", passengerList=" + passengerList + ", ticketCost=" + ticketCost +
	 * ", flight=" + flight + ", userId=" + userId + "]"; } public Booking(Integer
	 * bookingId, Integer noOfPassengers, Date bookingdate, List<Passenger>
	 * passengerList, Double ticketCost, Flight flight, User userId) { super();
	 * this.bookingId = bookingId; this.noOfPassengers = noOfPassengers;
	 * this.bookingdate = bookingdate; this.passengerList = passengerList;
	 * this.ticketCost = ticketCost; this.flight = flight; this.userId = userId; }
	 * public Booking() { super(); // TODO Auto-generated constructor stub }
	 */
	/*
	 * @OneToMany(mappedBy = "booking", targetEntity = Passenger.class, cascade =
	 * CascadeType.ALL, fetch = FetchType.LAZY) private Passenger passenger;
	 
	
	@OneToOne(mappedBy = "booking",orphanRemoval=true, targetEntity = ScheduledFlight.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private ScheduledFlight scheduledFlight;*/
}

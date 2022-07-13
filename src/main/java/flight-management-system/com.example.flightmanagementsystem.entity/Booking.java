package com.example.flightmanagementsystem.entity;

import javax.persistence.Entity;

@Entity

public class Booking {
	@Id
	@GenerateValue()
	private Integer bookingId;
	private Integer noOfPasseners;
	private Date bookingdate;
	private List<Passenger> passengerList;
	private Double ticketCost;
	private Flight flight;
	private User userId;

}

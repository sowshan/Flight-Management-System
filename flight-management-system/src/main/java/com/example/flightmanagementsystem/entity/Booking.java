package com.example.flightmanagementsystem.entity;

import java.util.Date;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	@OneToOne(cascade = CascadeType.MERGE)
	private Airport sourceAirport;
	@OneToOne(cascade = CascadeType.MERGE)
	private Airport destinationAirport;
	//private Double ticketCost;

	/*
	 * @OneToOne(cascade = CascadeType.MERGE) private Flight flight;
	 * 
	 * @ManyToOne(cascade = CascadeType.MERGE) private User userId;
	 */
     @OneToMany(mappedBy = "booking", targetEntity = Passenger.class, cascade =
	 CascadeType.ALL, fetch = FetchType.LAZY) 
     private Passenger passenger;	
	@OneToOne(mappedBy = "booking",orphanRemoval=true, targetEntity = ScheduledFlight.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private ScheduledFlight scheduledFlight;
}


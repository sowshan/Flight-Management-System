package com.example.flightmanagementsystem.entity;

import javax.persistence.Entity;

@Entity
public class ScheduledFlight {
	private Flight flight;
	private Integer availableSeats;
	private Schedule schedule;
	
}

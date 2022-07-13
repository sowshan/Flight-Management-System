package com.example.flightmanagementsystem.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;

@Entity
public class Schedule {
	private Airport sourceAirport;
	private Airport destinationAirport;
	private LocalDateTime airrivalTime;
	private LocalDateTime departureTime;
}

package com.example.flightmanagementsystem.entity;

import java.time.LocalDateTime;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "schedule")
public class Schedule {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Airport sourceAirport;
	private Airport destinationAirport;
	private LocalDateTime airrivalTime;
	private LocalDateTime departureTime;
	/*
	 * public Schedule() { super(); // TODO Auto-generated constructor stub } public
	 * Schedule(Airport sourceAirport, Airport destinationAirport, LocalDateTime
	 * airrivalTime, LocalDateTime departureTime) { super(); this.sourceAirport =
	 * sourceAirport; this.destinationAirport = destinationAirport;
	 * this.airrivalTime = airrivalTime; this.departureTime = departureTime; }
	 * public Airport getSourceAirport() { return sourceAirport; } public void
	 * setSourceAirport(Airport sourceAirport) { this.sourceAirport = sourceAirport;
	 * } public Airport getDestinationAirport() { return destinationAirport; }
	 * public void setDestinationAirport(Airport destinationAirport) {
	 * this.destinationAirport = destinationAirport; } public LocalDateTime
	 * getAirrivalTime() { return airrivalTime; } public void
	 * setAirrivalTime(LocalDateTime airrivalTime) { this.airrivalTime =
	 * airrivalTime; } public LocalDateTime getDepartureTime() { return
	 * departureTime; } public void setDepartureTime(LocalDateTime departureTime) {
	 * this.departureTime = departureTime; }
	 * 
	 * @Override public String toString() { return "Schedule [sourceAirport=" +
	 * sourceAirport + ", destinationAirport=" + destinationAirport +
	 * ", airrivalTime=" + airrivalTime + ", departureTime=" + departureTime + "]";
	 * }
	 */	
}

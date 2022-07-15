package com.example.flightmanagementsystem.entity;

import javax.persistence.CascadeType;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="scheduledFlight")
public class ScheduledFlight {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer availableSeats;
	//@OneToOne(mappedBy = "scheduledFlight",orphanRemoval=true, targetEntity = Flight.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Flight flight;
	//@OneToOne(mappedBy = "scheduledFlight",orphanRemoval=true, targetEntity = Schedule.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Schedule schedule;
	/*
	 * public ScheduledFlight() { super(); // TODO Auto-generated constructor stub }
	 * public ScheduledFlight(Integer availableSeats, Flight flight, Schedule
	 * schedule) { super(); this.availableSeats = availableSeats; this.flight =
	 * flight; this.schedule = schedule; } public Integer getAvailableSeats() {
	 * return availableSeats; } public void setAvailableSeats(Integer
	 * availableSeats) { this.availableSeats = availableSeats; } public Flight
	 * getFlight() { return flight; } public void setFlight(Flight flight) {
	 * this.flight = flight; } public Schedule getSchedule() { return schedule; }
	 * public void setSchedule(Schedule schedule) { this.schedule = schedule; }
	 * 
	 * @Override public String toString() { return
	 * "ScheduledFlight [availableSeats=" + availableSeats + ", flight=" + flight +
	 * ", schedule=" + schedule + "]"; }
	 */

}

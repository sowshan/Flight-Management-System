package com.example.flightmanagementsystem.entity;

import javax.persistence.*;

@Entity
@Table(name="passenger")
public class Passenger {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer passengerUIN;
	private Integer passengerAge;
	private Integer pnrNumber;
	private String passengerName;
	private Double luggage;
	/*
	 * public Integer getPassengerUIN() { return passengerUIN; } public void
	 * setPassengerUIN(Integer passengerUIN) { this.passengerUIN = passengerUIN; }
	 * public Integer getPassengerAge() { return passengerAge; } public void
	 * setPassengerAge(Integer passengerAge) { this.passengerAge = passengerAge; }
	 * public Integer getPnrNumber() { return pnrNumber; } public void
	 * setPnrNumber(Integer pnrNumber) { this.pnrNumber = pnrNumber; } public String
	 * getPassengerName() { return passengerName; } public void
	 * setPassengerName(String passengerName) { this.passengerName = passengerName;
	 * } public Double getLuggage() { return luggage; } public void
	 * setLuggage(Double luggage) { this.luggage = luggage; }
	 * 
	 * @Override public String toString() { return "Passenger [passengerUIN=" +
	 * passengerUIN + ", passengerAge=" + passengerAge + ", pnrNumber=" + pnrNumber
	 * + ", passengerName=" + passengerName + ", luggage=" + luggage + "]"; }
	 */}

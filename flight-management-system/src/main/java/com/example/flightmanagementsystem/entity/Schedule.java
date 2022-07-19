package com.example.flightmanagementsystem.entity;

import java.math.BigInteger;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity

@Table(name = "schedule")
public class Schedule {
	@Id
	private String scheduleID;
	@OneToOne(cascade = CascadeType.MERGE)
	private Airport sourceAirport;
	@OneToOne(cascade = CascadeType.MERGE)
	private Airport destinationAirport;
	private LocalDateTime airrivalTime;
	private LocalDateTime departureTime;
	/**
	 * @return the scheduleID
	 */
	public String getScheduleID() {
		return scheduleID;
	}
	/**
	 * @param string  the scheduleID to set
	 */
	public void setScheduleID(String string ) {
		this.scheduleID = string ;
	}
	/**
	 * @return the sourceAirport
	 */
	public Airport getSourceAirport() {
		return sourceAirport;
	}
	/**
	 * @param sourceAirport the sourceAirport to set
	 */
	public void setSourceAirport(Airport sourceAirport) {
		this.sourceAirport = sourceAirport;
	}
	/**
	 * @return the destinationAirport
	 */
	public Airport getDestinationAirport() {
		return destinationAirport;
	}
	/**
	 * @param destinationAirport the destinationAirport to set
	 */
	public void setDestinationAirport(Airport destinationAirport) {
		this.destinationAirport = destinationAirport;
	}
	/**
	 * @return the airrivalTime
	 */
	public LocalDateTime getAirrivalTime() {
		return airrivalTime;
	}
	/**
	 * @param airrivalTime the airrivalTime to set
	 */
	public void setAirrivalTime(LocalDateTime airrivalTime) {
		this.airrivalTime = airrivalTime;
	}
	/**
	 * @return the departureTime
	 */
	public LocalDateTime getDepartureTime() {
		return departureTime;
	}
	/**
	 * @param departureTime the departureTime to set
	 */
	public void setDepartureTime(LocalDateTime departureTime) {
		this.departureTime = departureTime;
	}
	
		
}

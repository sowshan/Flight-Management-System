package com.example.flightmanagementsystem.entity;

import javax.persistence.*;

@Entity
@Table(name="airport")
public class Airport {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int airportid;
	private String airportName;
	private String airportLocation;
	public Airport() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Airport(int airportid, String airportName, String airportLocation) {
		super();
		this.airportid = airportid;
		this.airportName = airportName;
		this.airportLocation = airportLocation;
	}
	public int getAirportid() {
		return airportid;
	}
	public void setAirportid(int airportid) {
		this.airportid = airportid;
	}
	public String getAirportName() {
		return airportName;
	}
	public void setAirportName(String airportName) {
		this.airportName = airportName;
	}
	public String getAirportLocation() {
		return airportLocation;
	}
	public void setAirportLocation(String airportLocation) {
		this.airportLocation = airportLocation;
	}
	@Override
	public String toString() {
		return "Airport [airportid=" + airportid + ", airportName=" + airportName + ", airportLocation="
				+ airportLocation + "]";
	}
	
	
}

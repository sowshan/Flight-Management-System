package com.example.flightmanagementsystem.entity;

import javax.persistence.Entity;

@Entity
public class Flight {
	private Integer flightId;
	private String carrierName;
	private String flightModel;
	private int seatCapacity;
}

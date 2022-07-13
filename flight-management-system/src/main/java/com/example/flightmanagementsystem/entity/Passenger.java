package com.example.flightmanagementsystem.entity;

import javax.persistence.*;

@Entity
public class Passenger {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer passengerUIN;
	private Integer passengerAge;
	private Integer pnrNumber;
	private String passengerName;
	private Double luggage;
}

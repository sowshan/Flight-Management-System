package com.example.flightmanagementsystem.entity;

import javax.persistence.*;

@Entity
public class Airport {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int airportid;
	@Column
	private String airportName;
	@Column
	private String airportLocation;
}

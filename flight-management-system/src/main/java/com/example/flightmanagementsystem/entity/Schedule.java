package com.example.flightmanagementsystem.entity;

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
@Getter
@Setter
@NoArgsConstructor
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
		
}

package com.example.flightmanagementsystem.repositories;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.bean.Airport;


public interface Airportrepo extends JpaRepository<Airport,String> {
	List<Airport> findByairportId(String airportID);
   // String deleteByFlightId(String flightId);
//	List<Flight> findByName(String name);
	
}

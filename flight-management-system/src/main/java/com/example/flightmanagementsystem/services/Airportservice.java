package com.example.flightmanagementsystem.services;

import java.util.List;



import com.example.flightmanagementsystem.entity.Airport;
import com.example.flightmanagementsystem.exceptions.AirportNotFoundException;


public interface Airportservice {
	
	Airport addAirport(Airport airport);
	Airport modifyAirport(Airport airport);
	int removeAirport(String airportId) throws AirportNotFoundException;
	public List<Airport> viewAllAirport();
	public Airport viewByAirportId(String airportId);
	
}

package com.flight.project.service;

import java.util.List;


import com.flight.project.entity.Airport;
import com.flight.project.exception.AirportNotFoundException;


public interface AirportService {
	
	Airport addAirport(Airport airport);
	Airport modifyAirport(Airport airport);
	int removeAirport(String airportId) throws AirportNotFoundException;
	public List<Airport> viewAllAirport();
	public Airport viewByAirportId(String airportId)throws AirportNotFoundException;
	
}

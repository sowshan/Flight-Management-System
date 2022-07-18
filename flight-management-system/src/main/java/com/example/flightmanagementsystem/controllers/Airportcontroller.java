package com.flight.project.controller;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.flight.project.entity.Airport;
import com.flight.project.exception.AirportNotFoundException;
import com.flight.project.service.AirportService;

@RestController
public class AirportController {
	
	@Autowired
	private AirportService airportservice;
	
	@PostMapping(value="/flight/addAirport",consumes = "application/json")
	public String addAirport(@RequestBody Airport airport) {
		
		Random rand = new Random();
		int resRandom = rand.nextInt((9999 - 100) + 1) + 10;
		airport.setAirportId(airport.getAirportName().substring(0,2) + Integer.toString(resRandom)); 
		airportservice.addAirport(airport);
		 return "Added Successfully";
		
	}
	
	@GetMapping("/viewAirport")
    public List<Airport> viewAirport() {
		return airportservice.viewAllAirport();
	}
    
	@GetMapping("/viewAirportById/{airportId}")
    public Airport viewAirport(@PathVariable String airportId) throws AirportNotFoundException {
    	if(airportservice.viewByAirportId(airportId)==null) {
    		System.out.println("Invalid Airport code");
    		throw new AirportNotFoundException();
    	}
		return airportservice.viewByAirportId(airportId);
		
    }
	@DeleteMapping(value="/delete/{airportId}")
	public String deleteAirport(@PathVariable String airportId) throws AirportNotFoundException {
		
		airportservice.removeAirport(airportId);	
		return "Deleted Successfully";
		
	}
	@PutMapping(value="/update")
	public Airport updateAirport(@RequestBody Airport airport) {
		return airportservice.modifyAirport(airport);
	}
	

}

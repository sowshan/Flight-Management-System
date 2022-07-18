package com.example.flightmanagementsystem.controllers;

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

import  com.example.flightmanagementsystem.entity.Flight;
import  com.example.flightmanagementsystem.exceptions.FlightNotFoundException;
import com.example.flightmanagementsystem.exceptions.ListEmptyException;
import com.example.flightmanagementsystem.services.Flightservice;
@RestController
public class Flightcontroller {
	
	@Autowired
	Flightservice flightservice;

		@PostMapping(value= "/user/addflight")
	    public String addCustomer(@RequestBody Flight flight)
	    
	  {
		 Random rand = new Random();
		 int resRandom = rand.nextInt((9999 - 100) + 1) + 10;
		 flight.setFlightId(flight.getCarrierName().substring(0,2) + Integer.toString(resRandom));
			
			flightservice.addflight(flight);
			return "Created successfully";
	   }

	 @GetMapping(value="/viewFlights")
    public List<Flight> fetchflightList() throws ListEmptyException 
    {   
	 if(flightservice.fetchFlightList().isEmpty()) throw new ListEmptyException();
  	 	return flightservice.fetchFlightList();
  	 	
     }
		

	
	@GetMapping(value= "/viewFlightById/{flightId}")

public List<Flight> viewFlightByID(@PathVariable("flightId")String flightId)
{ 
	if(flightservice.viewFlightById(flightId).isEmpty()) throw new FlightNotFoundException();
	System.out.println("Fetched Successfully");
	return flightservice.viewFlightById(flightId);
	
}
/*
	 @DeleteMapping(value="/deleteFlight/{flightId}")
	 public String deleteFlight(@PathVariable String flightId) throws FlightNotFoundException {
		 if(flightservice.viewAllFlight().isEmpty()) 
			{
				System.out.println("flightid is not matched");
		   		throw new FlightNotFoundException();
		   	}
		 flightservice.deleteFlight(flightId);
		 return "Deleted Successfully";
	 }*/
//delete by userId
	@DeleteMapping(value="delete/flight/{flightId}")
   public String deleteFlight(@PathVariable("flightId") String flightId)
   
   {
		//if(flightservice.deleteFlight(flightId).isEmpty()) throw new FlightNotFoundException();
		
	  flightservice.deleteFlight(flightId);
       return "Deleted Successfully";
 }

	 @PutMapping(value="/updateFlight")
	 public String modifyflight(@RequestBody Flight flight) {
	  flightservice.modifyFlight(flight);
	return "updated succesfully";
	 }


	





}



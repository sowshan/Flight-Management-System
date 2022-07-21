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
import com.example.flightmanagementsystem.entity.Airport;
import com.example.flightmanagementsystem.exceptions.AirportNotFoundException;
import com.example.flightmanagementsystem.exceptions.ListEmptyException;
import com.example.flightmanagementsystem.services.Airportservice;
@RestController
public class Airportcontroller {
 @Autowired
 private Airportservice airportservice;
 @PostMapping(value="/flight/addAirport",consumes = "application/json")
 public String addAirport(@RequestBody Airport airport) {
 Random rand = new Random();
 int resRandom = rand.nextInt((9999 - 100) + 1) + 10;
 airport.setAirportId(airport.getAirportName().substring(0,2) + Integer.toString(resRandom));
 airportservice.addAirport(airport);
  return "Added Successfully";
 }
 @GetMapping("/viewAirport")
  public List<Airport> viewAirport() throws ListEmptyException {
	 if(airportservice.viewAllAirport().isEmpty()) throw new ListEmptyException();
 return airportservice.viewAllAirport();
 }
	@GetMapping(value= "/viewAirportById/{airportId}")
	public List<Airport> viewAirportByID(@PathVariable("airportId")String airportId) throws AirportNotFoundException
	{ 
		if(airportservice.viewairportById(airportId).isEmpty()) throw new AirportNotFoundException();
		System.out.println("Fetched Successfully");
		return airportservice.viewairportById(airportId);
	}
 @DeleteMapping(value="/delete/{airportName}")
 public String deleteAirport(@PathVariable String airportName)  {
 airportservice.removeAirportName(airportName);
 return "Deleted Successfully";
 }
 @PutMapping(value="/updateAirport")
 public String updateAirport(@RequestBody Airport airport) {
  airportservice.modifyAirport(airport);
  return "updated successfully";
 }

}






























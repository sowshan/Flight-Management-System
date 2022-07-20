package com.example.flightmanagementsystem.services;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.flightmanagementsystem.entity.Airport;
import com.example.flightmanagementsystem.repositories.AirportRepo;
@Service
public class Airportservice {
 @Autowired
 private AirportRepo airportrepo;
 public List<Airport> viewAllAirport() {
 return airportrepo.findAll();
 }
 public List<Airport> viewairportById(String airportId)  {
 return airportrepo.findByairportId(airportId);
 }
 public List<Airport> viewairportByName(String airportName)  {
	 return airportrepo.findByairportName(airportName);
	 }
 public int removeAirportId(String airportId) {
  airportrepo.deleteById(airportId);
  return 1;
  }
 public int removeAirportName(String airportName) {
	  airportrepo.deleteByairportName(airportName);
	  return 1;
	  }
 public Airport addAirport(Airport airport) {
 return airportrepo.save(airport);
 }
 public Airport modifyAirport(Airport airport) {
 return airportrepo.save(airport);
 }
 

	
}

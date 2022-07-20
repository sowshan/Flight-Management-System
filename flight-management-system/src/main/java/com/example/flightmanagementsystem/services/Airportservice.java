package com.example.demo.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Airport;
import com.example.demo.repo.Airportrepo;
@Service
public class Airportservice {
 @Autowired
 private Airportrepo airportrepo;
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

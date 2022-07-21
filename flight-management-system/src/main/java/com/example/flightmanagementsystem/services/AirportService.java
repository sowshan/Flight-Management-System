package com.example.flightmanagementsystem.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.flightmanagementsystem.entity.Airport;
import com.example.flightmanagementsystem.repositories.AirportRepo;

@Service
public class AirportService {
	@Autowired
	 private AirportRepo airportrepo;
	 
	public List<Airport> viewAllAirport() {
	 return  (List<Airport>) airportrepo.findAll();
	 }
	 
	public String viewairportById(String airportId)  {
		if (airportrepo.existsById(airportId)) {
			return "Airport Found";
		}
		else
			return "AirportID Not Found";
	 }
	 
	 public boolean removeAirportId(String airportId) {
		 if (airportrepo.existsById(airportId)) {
				Airport airport = airportrepo.getReferenceById(airportId);
				airportrepo.deleteById(airportId);
				return true;

			} else {
				return false;
				
			}
		}

	 public String addAirport(Airport airport) {
		 if(airport.getAirportId().isEmpty()|| airport.getAirportName().isEmpty()|| airport.getAirportLocation().isEmpty()) {
				return "Please fill all feilds";
			}
			else {
				airportrepo.save(airport);
				return "Airport Added Successfully "+airport.getAirportId();
			}
	 }
	 public boolean modifyAirport(String airportid,Airport airport) {
		 if(airport.getAirportId().isEmpty()|| airport.getAirportName().isEmpty()|| airport.getAirportLocation().isEmpty()) {
				return false;
			}
		 else if (airportrepo.existsById(airportid)) {
					 Optional<Airport> findById = airportrepo.findById(airport.getAirportId());
						if (findById.isPresent()) {
					        airportrepo.save(airport);
					        }
						return true;
			}
		 else {
			 return false;
		 }
	 }
	 }


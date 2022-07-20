package com.example.demo.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Flight;
import com.example.demo.repo.Flightrepo;

@Service
public class Flightservice {

	@Autowired
	private Flightrepo flightrepo;
	
	
		public Flight addflight(Flight flight) {

			return  flightrepo.save(flight);
		}
		 public List<Flight> fetchFlightList() {
		 return flightrepo.findAll();
		 }
		 public List<Flight> viewFlightById(String flightId)  {
			 return flightrepo.findByFlightId(flightId);
			 }
			public Flight modifyFlight(Flight flight) {

				return  flightrepo.save(flight);
			}
public int deleteFlight(String flightId) {
				
				flightrepo.deleteById(flightId);
				return 1;
			}
}
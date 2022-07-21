package com.example.flightmanagementsystem.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.flightmanagementsystem.entity.Flight;
import com.example.flightmanagementsystem.entity.User;
import com.example.flightmanagementsystem.repositories.Flightrepo;

@Service
public class Flightservice {

	@Autowired
	private Flightrepo flightrepo;

	public Flight addflight(Flight flight) {

		return flightrepo.save(flight);
	}

	public List<Flight> viewAllFlights() {
		return flightrepo.findAll();
	}

	public List<Flight> viewFlightById(String flightId) {
		return flightrepo.findByFlightId(flightId);
	}

	/*public boolean modifyFlight(String flightId, Flight flight) {
		if(flightrepo.existsById(flightId)) {
			flightrepo.save(flight);
			return "Updated"+flightrepo.findByFlightId(flightId) != null;
		}
		else
	
		return "Id not found";
	}*/
	public boolean modifyFlight(String flightId,Flight flight) {
		 if(flight.getFlightId().isEmpty()|| flight.getCarrierName().isEmpty()) {
				return false;
			}
		 else if (flightrepo.existsById(flightId)) {
					 Optional<Flight> findById = flightrepo.findById(flight.getFlightId());
						if (findById.isPresent()) {
					        flightrepo.save(flight);
					        }
						return true;
			}
		 else {
			 return false;
		 }
	 }
	
	public int deleteFlight(String flightId) {

		flightrepo.deleteById(flightId);
		return 1;
	}
}
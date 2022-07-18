package com.flight.project.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flight.project.Repository.AirportRepo;
import com.flight.project.entity.Airport;
import com.flight.project.exception.AirportNotFoundException;
import com.flight.project.service.AirportService;


@Service
public class Airportserviceimpl implements AirportService{

	@Autowired
	private AirportRepo airportrepo;

	@Override
	public List<Airport> viewAllAirport() {
		return airportrepo.findAll();
	}

	@Override
	public Airport viewByAirportId(String airportId) throws AirportNotFoundException {
		return airportrepo.findByAirportId(airportId);
	}

	@Override
	public Airport addAirport(Airport airport) {
		return airportrepo.save(airport);
	}

	@Override
	public Airport modifyAirport(Airport airport) {
		return airportrepo.save(airport);
	}

	@Override
	public int removeAirport(String airportId) throws AirportNotFoundException {
		if(airportrepo.existsById(airportId)) {
			airportrepo.deleteById(airportId);
			return 1;
		}
		else {
			throw new AirportNotFoundException();
		}
	}

}

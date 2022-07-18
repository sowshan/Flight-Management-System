package com.flight.project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flight.project.entity.Airport;

@Repository
public interface AirportRepo extends JpaRepository<Airport, String>{

	Airport findByAirportId(String airportid);

}


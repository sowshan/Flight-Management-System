package com.example.flightmanagementsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.example.flightmanagementsystem.entity.Airport;

@Repository
public interface Airportrepo extends JpaRepository<Airport, String>{

	Airport findByAirportId(String airportid);

}


package com.example.flightmanagementsystem.repositories;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.bean.Flight;


public interface Flightrepo extends JpaRepository<Flight,String> {
	List<Flight> findByFlightId(String userId);
   // String deleteByFlightId(String flightId);
//	List<Flight> findByName(String name);
	
}

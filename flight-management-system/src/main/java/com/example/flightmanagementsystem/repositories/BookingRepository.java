package com.example.flightmanagementsystem.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.flightmanagementsystem.entity.Booking;


public interface BookingRepository extends CrudRepository<Booking,Integer> {

	List<Booking> findByBookingID(Integer bid);

	boolean existsById(Integer bid);

	void deleteById(Integer bid);

}
package com.example.flightmanagementsystem.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.flightmanagementsystem.entity.Booking;
import com.example.flightmanagementsystem.repositories.BookingRepository;
import com.example.flightmanagementsystem.services.BookingService;

@RestController
@RequestMapping("/Booking")
public class BookingController {
	@Autowired
	public BookingService bookingService;
	
	@RequestMapping(value = "/Booking/add", method=RequestMethod.POST)
	public String addBooking(@RequestBody Booking booking) {
		
		bookingService.addBooking(booking);
		 return "Booking Added Successfully";
		
	}
	@RequestMapping(value = "/Booking/modify", method = RequestMethod.POST)
	 public void modifyBooking(@RequestBody Booking booking) {
		 bookingService.modifyBooking(booking);
	 }
	@GetMapping(value="/Booking/viewall")
	public List<Booking> viewBooking(){
		if(bookingService.viewBooking().isEmpty()) {
			System.out.println("No Bookings done");
			//throw new FlightNotFoundException();
		}
		return bookingService.viewBooking();
	}

	@GetMapping(value="/Booking/viewById/{bid}")
	public List<Booking> viewBooking(@PathVariable("bid") Integer bid ) {
		if(bookingService.viewBooking(bid)==null) {
			System.out.println("No Booking with this Id");
			//throw new FlightNotFoundException();
		}
		return bookingService.viewBooking(bid);
	}
	

	@RequestMapping(value = "/Booking/delete/{bid}", method = RequestMethod.DELETE)
	 public void deleteStudent(@PathVariable Integer bid) {
		 bookingService.deleteBooking(bid);
		 	 
	 }

	



}

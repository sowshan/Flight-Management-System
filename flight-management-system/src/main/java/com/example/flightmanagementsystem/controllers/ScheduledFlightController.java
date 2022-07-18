package com.flight.project.controller;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.flight.project.entity.Schedule;
import com.flight.project.entity.ScheduledFlight;
import com.flight.project.exception.AirportNotFoundException;
import com.flight.project.exception.RecordNotFoundException;
import com.flight.project.exception.ScheduledFlightNotFoundException;
import com.flight.project.service.AirportService;
import com.flight.project.service.FlightService;
import com.flight.project.service.ScheduledFlightService;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/scheduledFlight")
public class ScheduledFlightController {
	/*
	 * Creating Service object
	 */
	@Autowired
	ScheduledFlightService scheduleFlightService;

	@Autowired
	AirportService airportService;

	@Autowired
	FlightService flightService;

	/*
	 * Controller for adding Scheduled Flights
	 */
	@PostMapping("/add")
	public ResponseEntity<ScheduledFlight> addSF(@ModelAttribute ScheduledFlight scheduledFlight,
			@RequestParam(name = "srcAirport") String source, @RequestParam(name = "dstnAirport") String destination,
			@RequestParam(name = "deptDateTime") String departureTime, @RequestParam(name = "arrDateTime") String arrivalTime) throws AirportNotFoundException {
		Schedule schedule = new Schedule();
		schedule.setScheduleId(scheduledFlight.getScheduleFlightId());
		try {
			schedule.setSrcAirport(airportService.viewByAirportId(source));
		} catch (RecordNotFoundException e) {
			return new ResponseEntity("Airport Not Found", HttpStatus.BAD_REQUEST);
		}
		try {
			schedule.setDstnAirport(airportService.viewByAirportId(destination));
		} catch (RecordNotFoundException e) {
			return new ResponseEntity("Airport Not Found", HttpStatus.BAD_REQUEST);
		}
		schedule.setDeptDateTime(departureTime);
		schedule.setArrDateTime(arrivalTime);
		try {
			scheduledFlight.setFlight(flightService.viewFlight(scheduledFlight.getScheduleFlightId()));
		} catch (RecordNotFoundException e1) {
			return new ResponseEntity("Flight Not Found", HttpStatus.BAD_REQUEST);
		}
		scheduledFlight.setSchedule(schedule);
		scheduledFlight.setAvailableSeats(scheduledFlight.getFlight().getSeatCapacity());
		try {
			return new ResponseEntity<ScheduledFlight>(scheduleFlightService.addScheduledFlight(scheduledFlight),
					HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity("Error adding Flight." + e, HttpStatus.BAD_REQUEST);
		}
	}

	/*
	 * Controller for modifying existing Scheduled Flights
	 */
	@PutMapping("/modify")
	public ResponseEntity<ScheduledFlight> modifyScheduleFlight(@ModelAttribute ScheduledFlight scheduleFlight) {
		ScheduledFlight modifySFlight = scheduleFlightService.modifyScheduledFlight(scheduleFlight);
		if (modifySFlight == null) {
			return new ResponseEntity("Flight not modified", HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			return new ResponseEntity<ScheduledFlight>(modifySFlight, HttpStatus.OK);
		}

	}

	/*
	 * Controller for deleting existing Scheduled Flights
	 */
	@DeleteMapping("/delete")
	public String deleteSF(@RequestParam BigInteger flightId) throws RecordNotFoundException {
		return scheduleFlightService.removeScheduledFlight(flightId);
	}

	/*
	 * Controller for viewing a Scheduled Flight by ID
	 */
	@GetMapping("/search")
	@ExceptionHandler(ScheduledFlightNotFoundException.class)
	public ResponseEntity<ScheduledFlight> viewSF(@RequestParam BigInteger flightId) throws ScheduledFlightNotFoundException {
		ScheduledFlight searchSFlight = scheduleFlightService.viewScheduledFlight(flightId);
		if (searchSFlight == null) {
			return new ResponseEntity("Flight not present", HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<ScheduledFlight>(searchSFlight, HttpStatus.OK);
		}
	}

	/*
	 * Controller for viewing all Scheduled Flights
	 */
	@GetMapping("/viewAll")
	public Iterable<ScheduledFlight> viewAllSF() {
		return scheduleFlightService.viewAllScheduledFlights();
	}
	

}
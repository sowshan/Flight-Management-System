package com.example.flightmanagementsystem.services;

import java.util.List;



import com.example.flightmanagementsystem.entity.Airport;
import com.example.flightmanagementsystem.exceptions.AirportNotFoundException;


public interface Airportservice {
	Airport addAirport(Airport airport);
	Airport modifyAirport(Airport airport);
	int removeAirport(String airportId) throws AirportNotFoundException;
	public List<Airport> viewAllAirport();
	public Airport viewByAirportId(String airportId);
	
        @Autowired(required = true)
	AirportService airportService;

	@GetMapping("/viewAirport/{id}")
	@ExceptionHandler(RecordNotFoundException.class)
	public Airport viewAirport(@PathVariable("id") String airportid) {
		return airportService.viewAirport(airportid);
	}

	@GetMapping("/allAirport")
	public Iterable<Airport> viewAllAirport() {
		return airportService.viewAllAirport();
	}

	@PostMapping("/addAirport")
	@ExceptionHandler(RecordAlreadyPresentException.class)
	public String addAirport(@RequestBody Airport airport) {
		airportService.addAirport(airport);
		return "Added Successfully";
	}

	@PutMapping("/updateAirport")
	@ExceptionHandler(RecordNotFoundException.class)
	public String modifyAirport(@RequestBody Airport airport) {
		airportService.modifyAirport(airport);
		return "Updated Airport id"+airport+" Successfully";
	}

	@DeleteMapping("/deleteAirport/{id}")
	@ExceptionHandler(RecordNotFoundException.class)
	public String removeAirport(@PathVariable("id") String airportid) {
		airportService.removeAirport(airportid);
		return "deleted Successfully";
	}
 public Iterable<Airport> viewAllAirport();

	public Airport viewAirport(String airportid);

	public ResponseEntity<?> addAirport(Airport airport);

	public Airport modifyAirport(Airport airport);

	public String removeAirport(String airportid);
	
}

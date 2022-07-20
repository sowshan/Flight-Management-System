package com.example.flightmanagementsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.example.flightmanagementsystem.entity.Airport;

@Repository
public interface Airportrepo extends JpaRepository<Airport, String>{

	Airport findByAirportId(String airportid);
        @Autowired
	private AirportRepo airportrepo;

	@Override
	public Iterable<Airport> viewAllAirport() {
		return airportrepo.findAll();
	}

	/*
	 * view airport by airportid
	 */
	@Override
	public Airport viewAirport(String airportid) {
		Optional<Airport> findById = airportrepo.findById(airportid);
		if (findById.isPresent()) {
			return findById.get();
		}
			
			//return new ResponseEntity<Airport>(airport, HttpStatus.OK)}
		else
			throw new RecordNotFoundException("Airport with airport code: " + airportid + "not exists");
	    }
		/*catch(RecordNotFoundException e)
		{
			return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
		}
        }*/

	/*
	 * add a airport
	 */
	@Override
	public ResponseEntity<?> addAirport(Airport airport) {
		Optional<Airport> findById = airportrepo.findById(airport.getairportid());
		try {
		if (!findById.isPresent()) {
			airportrepo.save(airport);
			return new ResponseEntity<Airport>(airport,HttpStatus.OK);
		} 
		else
			throw new RecordAlreadyPresentException(
					"Airport with code : " + airport.getairportid() + " already present");
	     }
		catch(RecordAlreadyPresentException e)
		{
			return new ResponseEntity<Airport>(airport,HttpStatus.NOT_FOUND);
		}
	}

	/*
	 * modify an Airport
	 */
	@Override
	public Airport modifyAirport(Airport airport) {
		Optional<Airport> findById = airportrepo.findById(airport.getairportid());
		if (findById.isPresent()) {
			airportrepo.save(airport);
		} 
		else
			throw new RecordNotFoundException("Airport with code: " + airport.getairportid() + " not exists");
		return airport;
	}

	/*
	 * remove an airport
	 */
	@Override
	public String removeAirport(String airportid) {
		Optional<Airport> findById = airportrepo.findById(airportid);
		if (findById.isPresent()) {
			airportrepo.deleteById(airportid);
			return "Airport removed";
		} else
			throw new RecordNotFoundException("Airport with code: " + airportid + " not exists");

	}
        public Iterable<Airport> viewAllAirport();

	public Airport viewAirport(String airportid);

	public ResponseEntity<?> addAirport(Airport airport);

	public Airport modifyAirport(Airport airport);

	public String removeAirport(String airportid);


}


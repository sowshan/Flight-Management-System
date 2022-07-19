package com.flight.project.Repository;
import java.math.BigInteger;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.flight.project.entity.ScheduledFlight;

@Repository
public interface ScheduledFlightRepo extends CrudRepository<ScheduledFlight,BigInteger> {


	
}

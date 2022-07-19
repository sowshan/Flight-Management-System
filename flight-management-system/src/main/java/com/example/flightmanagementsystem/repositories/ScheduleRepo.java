package com.example.flightmanagementsystem.repositories;
import java.math.BigInteger;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.flightmanagementsystem.entity.Schedule;


@Repository
public interface ScheduleRepo extends CrudRepository<Schedule,String> {


	
}


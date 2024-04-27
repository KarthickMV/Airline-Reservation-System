package com.boeing.training.flightticketsystem.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.boeing.training.flightticketsystem.model.Flight;

@Repository
public interface FlightRepository extends JpaRepository<Flight,String> {
	
	Optional<Flight> findByFlightid(String flightno);
}

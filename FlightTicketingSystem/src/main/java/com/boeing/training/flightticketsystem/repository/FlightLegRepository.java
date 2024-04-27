package com.boeing.training.flightticketsystem.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boeing.training.flightticketsystem.model.Airport;
import com.boeing.training.flightticketsystem.model.Flight;
import com.boeing.training.flightticketsystem.model.FlightLeg;

public interface FlightLegRepository extends JpaRepository<FlightLeg,Integer> {
	
	Optional<List<FlightLeg>> findByFlightOrderByLegnoDesc(Flight flight);
	
	Optional<List<FlightLeg>> findByFlight(Flight flight);
	
	Optional<FlightLeg> findByFlightAndDepairportAndArrairport(Flight flight, Airport depairport,Airport arrairport);
	
	List<FlightLeg> findByFlightOrderByDeptime(Flight flight);
	
	List<FlightLeg> findByFlightOrderByDeptimeDesc(Flight flight);
	
	Optional<List<FlightLeg>> findByFlightno(String flightno);
	
	Optional<List<FlightLeg>> findByDepairport(Airport airport);
	
	Optional<List<FlightLeg>> findByArrairport(Airport airport);
	
	Optional<FlightLeg> findByFlightnoAndLegno(String flightno, Long legno);
}

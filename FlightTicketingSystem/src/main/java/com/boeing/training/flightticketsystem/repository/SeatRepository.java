package com.boeing.training.flightticketsystem.repository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.boeing.training.flightticketsystem.model.Passenger;
import com.boeing.training.flightticketsystem.model.Seat;

@Repository
public interface SeatRepository extends JpaRepository<Seat, String> {
	
	Optional<List<Seat>> findByDepdateAndLegnoAndFlightnoOrderBySeatnoDesc(Date depdate,int legno, String flightno);
	 
	Optional<Seat> findByDepdateAndLegnoAndFlightnoAndPassenger(Date depdate,int legno, String flightno,Passenger passenger);
	
}

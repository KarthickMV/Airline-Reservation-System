package com.boeing.training.flightticketsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.boeing.training.flightticketsystem.model.Airport;

@Repository
public interface AirportRepository extends JpaRepository<Airport, String> {
	Airport findByAirportcode(String airportcode);
	
	@Query(value="select [airport_code] from Airport m where m.city=?1",nativeQuery= true)
	 public String Map(String city);
}

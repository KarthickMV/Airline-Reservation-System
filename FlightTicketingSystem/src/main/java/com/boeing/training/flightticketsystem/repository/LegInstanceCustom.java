package com.boeing.training.flightticketsystem.repository;

import java.time.LocalDate;

public interface LegInstanceCustom {

	public boolean addLegInstance(String flightNo, LocalDate startDate, int legNo);
	  
	 public boolean updateAvailableSeats(LocalDate depDate, Integer legNo, String flightNo);
  	
	
}

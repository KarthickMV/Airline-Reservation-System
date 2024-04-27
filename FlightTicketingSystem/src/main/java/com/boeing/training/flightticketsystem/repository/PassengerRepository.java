package com.boeing.training.flightticketsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.boeing.training.flightticketsystem.model.BookingInfo;
import com.boeing.training.flightticketsystem.model.Passenger;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger,Integer>{

	List<Passenger> findByBookingid(BookingInfo bookinfo);
	List<Passenger> findByBookingno(int bookingno);
	
	//Passenger findByPassengerId(int passengerid);
}

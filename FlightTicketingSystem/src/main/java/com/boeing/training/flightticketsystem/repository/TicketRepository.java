package com.boeing.training.flightticketsystem.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.boeing.training.flightticketsystem.model.BookingInfo;
import com.boeing.training.flightticketsystem.model.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket,Integer>{

	//Ticket findByTicketId(int ticketid);
    
   Optional<Ticket> findByBookingid(BookingInfo bookinfo);
   
   Optional<Ticket> findByTicketId(int ticketId);
    
    
   // Ticket findByBookingid(BookingInfo bookinfo);
}

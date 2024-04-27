package com.boeing.training.flightticketsystem.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boeing.training.flightticketsystem.model.Ticket;
import com.boeing.training.flightticketsystem.model.TicketCancellation;
import com.boeing.training.flightticketsystem.model.TicketDTO;
import com.boeing.training.flightticketsystem.repository.TicketCancellationRepository;
import com.boeing.training.flightticketsystem.repository.TicketRepository;

@Service
public class TicketCancellationService {
	@Autowired
	private TicketRepository ticketRepository;
	@Autowired
	private TicketCancellationRepository ticketCancellationRepository;
	@Autowired
	private PassengerService passengerservice;
	
    public Boolean cancelticket(Ticket ticket) {
		int ticketId=ticket.getTicketId();
		Optional<Ticket> proxyticket = ticketRepository.findByTicketId(ticketId);
		if(proxyticket.isPresent()) {
			TicketCancellation ticketcancel = new TicketCancellation();
			ticketcancel.setTicketid(proxyticket.get());
			ticketcancel.setStatus("PENDING");
			ticketcancel=ticketCancellationRepository.save(ticketcancel);
			return true;
		}
		else {
			return false;
		}
	}

	public TicketDTO viewticket(int ticket) {
		Optional<Ticket> proxyticket = ticketRepository.findByTicketId(ticket);
		if(proxyticket.isPresent()) {
			return passengerservice.converttoticketDto(proxyticket.get());
		}else {
			return new TicketDTO();
		}
	}

}

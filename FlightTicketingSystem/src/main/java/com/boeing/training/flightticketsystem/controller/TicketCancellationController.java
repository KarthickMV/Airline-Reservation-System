package com.boeing.training.flightticketsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.boeing.training.flightticketsystem.model.Ticket;
import com.boeing.training.flightticketsystem.model.TicketDTO;
import com.boeing.training.flightticketsystem.service.TicketCancellationService;

@RestController
public class TicketCancellationController {
	@Autowired
	private TicketCancellationService ticketCancellationService;
	
	@PostMapping(path = "/RequestCancellation")
	public Boolean requestforcancellation(@RequestBody Ticket ticketId) {
		Boolean status=ticketCancellationService.cancelticket(ticketId);
		return status;
	}
	
	@PostMapping(path="/viewTicket")
	public TicketDTO viewTicket(@RequestBody Ticket ticket) {
		return ticketCancellationService.viewticket(ticket.getTicketId());
	}

}


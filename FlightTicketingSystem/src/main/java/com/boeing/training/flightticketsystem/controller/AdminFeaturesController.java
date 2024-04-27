package com.boeing.training.flightticketsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.boeing.training.flightticketsystem.model.AddFlightResponseObject;
import com.boeing.training.flightticketsystem.model.FlightDTO;
import com.boeing.training.flightticketsystem.model.FlightLegDTO;
import com.boeing.training.flightticketsystem.model.FlightModelValue;
import com.boeing.training.flightticketsystem.model.FlightRemovalResponseObject;
import com.boeing.training.flightticketsystem.model.TicketCancellationDTO;
import com.boeing.training.flightticketsystem.model.UserBookingDTO;
import com.boeing.training.flightticketsystem.model.UserDetail;
import com.boeing.training.flightticketsystem.service.AdminFeaturesService;

@RestController
public class AdminFeaturesController {
	
	@Autowired
	private AdminFeaturesService adminfeatureservice;
	
	// to add flight to the flight leg table taking the addflight 
	@RequestMapping(method=RequestMethod.POST,value="/addflight")
	public AddFlightResponseObject addFlight(@RequestBody FlightModelValue flightmodelvalue) {
		AddFlightResponseObject res = new AddFlightResponseObject();
		res = adminfeatureservice.addLegInstance(flightmodelvalue, res); 
		return res;
	}
	
	//to remove a flight either by flight id or flight id with source and arrival destination
	@RequestMapping(method=RequestMethod.POST,value="/removeflight")
	public FlightRemovalResponseObject removeFlight(@RequestBody FlightLegDTO flDTO) {
		FlightRemovalResponseObject res = adminfeatureservice.removeFlight(flDTO);
		return res;
	}
	//to list all flights for a given flight number
	@RequestMapping(method=RequestMethod.POST,value="/getallflight")
	public List<FlightLegDTO> getleginstances(@RequestBody FlightLegDTO flDTO){
		return adminfeatureservice.getleginstances(flDTO.getFlightno());
	}
	
	//to check if a given flight number has leg instances
	@RequestMapping(method=RequestMethod.POST,value="/checkflight")
	public FlightDTO isFlightPresent(@RequestBody FlightLegDTO flDTO) {
		return adminfeatureservice.isFlightPresent(flDTO.getFlightno());
	}
	
	//to check if the user exists dynamic validation
	@RequestMapping(method=RequestMethod.POST,value="/checkuser")
	public boolean isUserPresent(@RequestBody UserDetail user) {
		return adminfeatureservice.isUserPresent(user);
	}
	
	//to list all the tickets generated for the given user
	@RequestMapping(method=RequestMethod.POST,value="/getuserbooking")
	public List<UserBookingDTO> getUserTickets(@RequestBody UserDetail user) {
		return adminfeatureservice.getuserbooking(user);
	}
	
	//to return dto objects of the booking made
	@GetMapping("/ticketcancellation")
	public List<TicketCancellationDTO> getticketcancellation(){		
		return adminfeatureservice.getcancellationlist();	
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/altercancellationstatus")
	public boolean changeCancellationStatus(@RequestBody TicketCancellationDTO dto) {
		return adminfeatureservice.changeCancellationStatus(dto);
	}
	
	//for debugging purpose
	@RequestMapping(method=RequestMethod.GET,value="/model")
		public FlightModelValue getModel() {
			return new FlightModelValue();
		}
}


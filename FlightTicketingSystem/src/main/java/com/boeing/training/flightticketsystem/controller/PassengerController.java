package com.boeing.training.flightticketsystem.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.boeing.training.flightticketsystem.model.BookingInfo;
import com.boeing.training.flightticketsystem.model.Passenger;
import com.boeing.training.flightticketsystem.model.Payment;
//import com.boeing.training.flightticketsystem.model.Ticket;
import com.boeing.training.flightticketsystem.model.TicketDTO;
import com.boeing.training.flightticketsystem.service.PassengerService;

@RestController
public class PassengerController {
	@Autowired(required =true)
	private PassengerService passengerService;
	
	@GetMapping("/BookingRequest")
	public BookingInfo viewmodel() {
		return new BookingInfo();
	}
	@PostMapping("/BookingRequest")
    public Boolean passengerDetails(@RequestBody BookingInfo request,HttpSession htsession) {
        boolean id=passengerService.SaveBooking(request,htsession);
        return id;
    }
	
	@GetMapping("/Passenger")
	public Passenger model() {
		return new Passenger();
	}
	@PostMapping(path = "/Passenger")
	public Boolean addInformation(@RequestBody List<Passenger> passinfo,HttpSession htsession) {
		return passengerService.addPassenger(passinfo,htsession);
	}
	
	@GetMapping("/Payment")
	public Payment model1() {
		return new Payment();
	}
	@PostMapping(path = "/Payment")
	public Boolean addpaytype(@RequestBody Payment info,HttpSession htsession) {
		return this.passengerService.addpaytype(info,htsession);
	}
	@RequestMapping(method=RequestMethod.GET,value="/viewlatestbooking")
    public TicketDTO getLatestTicket(HttpSession htsession) {
        return passengerService.getLatestTicket(htsession);
    }

}

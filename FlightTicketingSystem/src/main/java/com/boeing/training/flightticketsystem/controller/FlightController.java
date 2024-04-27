package com.boeing.training.flightticketsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//import com.boeing.training.flightticketsystem.repository.Search_flightsRepository;//
import com.boeing.training.flightticketsystem.model.FlightDisplay;
//import com.boeing.training.flightticketsystem.model.SearchValues;
import com.boeing.training.flightticketsystem.model.UserData;
import com.boeing.training.flightticketsystem.model.connectFlight;
import com.boeing.training.flightticketsystem.model.legInstance;
import com.boeing.training.flightticketsystem.repository.AirportRepository;
import com.boeing.training.flightticketsystem.service.legService;




@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class FlightController {
//	List<LegInstance2> FD;
	@Autowired
	private legService service;
    @Autowired
	private AirportRepository mapr;
 
	List<FlightDisplay> LD;
	List<connectFlight> LC;
	List<FlightDisplay> RLD;
	List<connectFlight> RLC;



	@GetMapping("/Flights")
	
	public List<legInstance> findAlllegInstance(){
		return service.getlegInstances();
	}
	@PostMapping("/Direct")
	public List<FlightDisplay> findlegInstancesByDepAirportAndArrAirportAndDepDate(@RequestBody UserData search /*SearchValues search*/){
		 LD=service.getlegInstancesDepAirportAndArrAirportAndDepDate(mapr.Map(search.getFrom()),mapr.Map(search.getTo()),search.getDepartOn());
		 return LD;
	}
	@GetMapping("/Direct")
	public List<FlightDisplay> getvalue(){
		return LD;
	}
	@PostMapping("/connect")
	public List<connectFlight> findlegInstancesByDepAirportAndArrAirportAndDepDate1(@RequestBody UserData search /*SearchValues search*/){
		return LC=service.getlegInstancesDepAirportAndArrAirportAndDepDate1(mapr.Map(search.getFrom()),mapr.Map(search.getTo()),search.getDepartOn());
	}
	@GetMapping("/connect")
	public List<connectFlight> getvaluec(){
		return LC; 
	}
	@PostMapping("/RDirect")
	public List<FlightDisplay> findreturnlegInstancesByDepAirportAndArrAirportAndDepDate(@RequestBody UserData search /*SearchValues search*/){
		 RLD=service.getlegInstancesDepAirportAndArrAirportAndDepDate(mapr.Map(search.getTo()),mapr.Map(search.getFrom()),search.getReturnOn());
		 return RLD;
	}
	@GetMapping("/RDirect")
	public List<FlightDisplay> getreturnvalue(){
		return RLD;
	}
	@PostMapping("/Rconnect")
	public List<connectFlight> findreturnlegInstancesByDepAirportAndArrAirportAndDepDate1(@RequestBody UserData search /*SearchValues search*/){
		return RLC=service.getlegInstancesDepAirportAndArrAirportAndDepDate1(mapr.Map(search.getTo()),mapr.Map(search.getFrom()),search.getReturnOn());
	}
	@GetMapping("/Rconnect")
	public List<connectFlight> getreturnvaluec(){
		return RLC; 
	}
}

package com.boeing.training.flightticketsystem.service;

import java.sql.Date;
import java.sql.Time;
import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boeing.training.flightticketsystem.model.FlightDisplay;
import com.boeing.training.flightticketsystem.model.FlightLeg;
import com.boeing.training.flightticketsystem.model.connectFlight;
import com.boeing.training.flightticketsystem.model.legInstance;
import com.boeing.training.flightticketsystem.repository.FlightLegRepository;
import com.boeing.training.flightticketsystem.repository.legRepository;

@Service
public class legService {
	
	@Autowired
	private legRepository repository;
	@Autowired
	private FlightLegRepository repo;

	public Date S2D(String dDate) {
		Date date=Date.valueOf(dDate);
		return date;
	}

	public List<legInstance> getlegInstances(){
		return repository.findAll();
	}

//	FlightDisplay D;

	public List<FlightDisplay> getlegInstancesDepAirportAndArrAirportAndDepDate(String depAirport, String arrAirport, String depDate) {
		List<legInstance> flights1 = repository.findAll();

	//    List<legInstance> direct = new ArrayList<legInstance>();
		List<FlightDisplay> direct=new ArrayList<FlightDisplay>();
		for(legInstance fl:flights1){
			if(fl.getDepAirport().equals(depAirport) && fl.getArrAirport().equals(arrAirport) && fl.getLeginstanceprimarykey().getDepDate().equals(S2D(depDate)) && fl.getAvailableSeats()>0 && fl.getFlightStatus().equals("SCHEDULED")) {
				FlightDisplay D= new FlightDisplay();
				D.setLegNo((int)fl.getLeginstanceprimarykey().getLegno());
				D.setDepDate(fl.getLeginstanceprimarykey().getDepDate());
				D.setFlightNo(fl.getLeginstanceprimarykey().getFlight());
				D.setDepAirport(fl.getDepAirport());
				D.setArrAirport(fl.getArrAirport());
				D.setDepTime(fl.getDepTime());
				D.setArrTime(fl.getArrTime());
				D.setFlightStatus(fl.getFlightStatus());
				D.setAvailableSeats(fl.getAvailableSeats());;
				List<FlightLeg> flightl= repo.findAll();
				for(FlightLeg fl1:flightl) {
				if (fl1.getLegno()==fl.getLeginstanceprimarykey().getLegno() && fl1.getFlightno().equals(fl.getLeginstanceprimarykey().getFlight())) {
					 D.setFare(fl1.getBasefare());}}
				Time TA=fl.getArrTime(); LocalTime AR= TA.toLocalTime();
				Time TD=fl.getDepTime(); LocalTime DR= TD.toLocalTime();
				Duration travel= Duration.between(DR, AR);
				D.setDuration(travel.toMinutes());
				direct.add(D);}
			
			
			
		}
	return direct;}
		


	



	public List<connectFlight> getlegInstancesDepAirportAndArrAirportAndDepDate1(String depAirport,String arrAirport,String depDate){
		
		List<connectFlight> connectflight = new ArrayList<connectFlight>();
	List<legInstance> flights = repository.findAll();
	//	List<legInstance> dept = new ArrayList<legInstance>();
	List<FlightDisplay> dept=new ArrayList<FlightDisplay>();
	
		
		
		for(legInstance flight:flights){
			
			
			if(flight.getDepAirport().equals(depAirport) && flight.getLeginstanceprimarykey().getDepDate().equals(S2D(depDate))&& flight.getLeginstanceprimarykey().getDepDate().equals(S2D(depDate)) && flight.getAvailableSeats()>0 && flight.getFlightStatus().equals("SCHEDULED")) {
				FlightDisplay D= new FlightDisplay();
				D.setLegNo((int)flight.getLeginstanceprimarykey().getLegno());
				D.setDepDate(flight.getLeginstanceprimarykey().getDepDate());
				D.setFlightNo(flight.getLeginstanceprimarykey().getFlight());
				D.setDepAirport(flight.getDepAirport());
				D.setArrAirport(flight.getArrAirport());
				D.setDepTime(flight.getDepTime());
				D.setArrTime(flight.getArrTime());
				D.setFlightStatus(flight.getFlightStatus());
				D.setAvailableSeats(flight.getAvailableSeats());;
				List<FlightLeg> flightl= repo.findAll();
				for(FlightLeg fl1:flightl) {
				if (fl1.getLegno()==flight.getLeginstanceprimarykey().getLegno() && fl1.getFlightno().equals(flight.getLeginstanceprimarykey().getFlight())) {
					 D.setFare(fl1.getBasefare());}}
				Time TA=flight.getArrTime(); LocalTime AR= TA.toLocalTime();
				Time TD=flight.getDepTime(); LocalTime DR= TD.toLocalTime();
				Duration travel= Duration.between(DR, AR);
				D.setDuration(travel.toMinutes());
				dept.add(D);}
		}
		
		
	//dept will have all flights departing from mentioned depAirport
		
		int i = 1;
		
		
		for(FlightDisplay flight:dept){
			
			String IntermediateDestination = flight.getArrAirport(); // Getting Intermediate Destination
			java.sql.Time myTime = flight.getArrTime();
			LocalTime localtime =myTime.toLocalTime();
			localtime = localtime.plusMinutes(45);
			
			
			
			for(legInstance f1:flights){ 							//all flights leaving from Intermediate Destination
				
				java.sql.Time time2 = f1.getDepTime();
				LocalTime depTime =time2.toLocalTime();
				
				
				
				
				
				
				
				if(f1.getDepAirport().equals(IntermediateDestination) && f1.getLeginstanceprimarykey().getDepDate().equals(S2D(depDate))  && depTime.isAfter(localtime)) {
					
					
					
					
					
					//all flights departing from intermediate airport will enter this loop
				
					if(f1.getArrAirport().equals(arrAirport)&& f1.getAvailableSeats()>0 && f1.getFlightStatus().equals("SCHEDULED")) {
					//	f1 will be a flight that leaves from intermediate station and reaches to destination
						FlightDisplay D= new FlightDisplay();
						D.setLegNo((int)f1.getLeginstanceprimarykey().getLegno());
						D.setDepDate(f1.getLeginstanceprimarykey().getDepDate());
						D.setFlightNo(f1.getLeginstanceprimarykey().getFlight());
						D.setDepAirport(f1.getDepAirport());
						D.setArrAirport(f1.getArrAirport());
						D.setDepTime(f1.getDepTime());
						D.setArrTime(f1.getArrTime());
						D.setFlightStatus(f1.getFlightStatus());
						D.setAvailableSeats(f1.getAvailableSeats());;
						List<FlightLeg> flightl= repo.findAll();
						for(FlightLeg fl1:flightl) {
						if (fl1.getLegno()==f1.getLeginstanceprimarykey().getLegno() && fl1.getFlightno().equals(f1.getLeginstanceprimarykey().getFlight())) {
							 D.setFare(fl1.getBasefare());}}
						Time TA=f1.getArrTime(); LocalTime AR= TA.toLocalTime();
						Time TD=f1.getDepTime(); LocalTime DR= TD.toLocalTime();
						Duration travel= Duration.between(DR, AR);
						D.setDuration(travel.toMinutes());
						connectFlight c1 = new connectFlight();
						c1.setId(i);
						c1.setDepToarr(flight);
						c1.setArrTodep(D);
						c1.setInterstation(IntermediateDestination);
						Time TDF=flight.getDepTime(); LocalTime DRF= TDF.toLocalTime();
						Duration totaltravel=Duration.between(DRF, AR);
						c1.setTduration(totaltravel.toMinutes());
						connectflight.add(c1);
						i+=1;
						
						
						
				
					} //depAirport->intermediate airport-> ArrAirport
				}
			}
		}
		
	
	
	return connectflight;
}
		
		
		
public List<legInstance> getlegInstancesDepAirportAndArrAirport(String depAirport, String arrAirport){
	List<legInstance> returnFlight = repository.findAll();
	List<legInstance> ret = new ArrayList<legInstance>();
	for(legInstance flight1:returnFlight) {
	
	if(flight1.getDepAirport().equals(arrAirport) && flight1.getArrAirport().equals(depAirport) ) {
		ret.add(flight1);
	}	
		
		
		
	
	
	
}// List out all the return flights
	return ret;
	
}
}

			

	
	
	




package com.boeing.training.flightticketsystem.model;

import java.sql.Date;

public class FlightDTO {
	
	private String flightno;
	private String airline;
	private Date startdate;
	private String occurence;
	private int noOfPassenger;
	public String getFlightno() {
		return flightno;
	}
	public void setFlightno(String flightno) {
		this.flightno = flightno;
	}
	public String getAirline() {
		return airline;
	}
	public void setAirline(String airline) {
		this.airline = airline;
	}
	public Date getStartdate() {
		return startdate;
	}
	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}
	public String getOccurence() {
		return occurence;
	}
	public void setOccurence(String occurence) {
		this.occurence = occurence;
	}
	public int getNoOfPassenger() {
		return noOfPassenger;
	}
	public void setNoOfPassenger(int noOfPassenger) {
		this.noOfPassenger = noOfPassenger;
	}
	public FlightDTO(String flightno, String airline, Date startdate, String occurence, int noOfPassenger) {
		super();
		this.flightno = flightno;
		this.airline = airline;
		this.startdate = startdate;
		this.occurence = occurence;
		this.noOfPassenger = noOfPassenger;
	}
	
	public FlightDTO() {
		
	}
}

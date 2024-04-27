package com.boeing.training.flightticketsystem.model;


public class FlightModelValue {
	private String flightno;
	private String airline;
	private Long maxseats;
	private String occurence;
	private String depairport;//
	private String arrairport;
	private Double basefare;
	private String startdate;
	private String deptime;
	private String arrtime;
	
	
	public FlightModelValue() {
		
	}

	public FlightModelValue(String flightno, String airline, Long maxseats, String occurence, String depairport,
			String arrairport, Double basefare, String startdate, String deptime, String arrtime) {
		super();
		this.flightno = flightno;
		this.airline = airline;
		this.maxseats = maxseats;
		this.occurence = occurence;
		this.depairport = depairport;
		this.arrairport = arrairport;
		this.basefare = basefare;
		this.startdate = startdate;
		this.deptime = deptime;
		this.arrtime = arrtime;
	}

	public String getStartdate() {
		return startdate;
	}

	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}

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
	public Long getMaxseats() {
		return maxseats;
	}
	public void setMaxseats(Long maxseats) {
		this.maxseats = maxseats;
	}
	public String getOccurence() {
		return occurence;
	}
	public void setOccurence(String occurence) {
		this.occurence = occurence;
	}
	public String getDepairport() {
		return depairport;
	}
	public void setDepairport(String depairport) {
		this.depairport = depairport;
	}
	public String getArrairport() {
		return arrairport;
	}
	public void setArrairport(String arrairport) {
		this.arrairport = arrairport;
	}
	public Double getBasefare() {
		return basefare;
	}
	public void setBasefare(Double basefare) {
		this.basefare = basefare;
	}
	public String getDeptime() {
		return deptime;
	}
	public void setDeptime(String deptime) {
		this.deptime = deptime;
	}
	public String getArrtime() {
		return arrtime;
	}
	public void setArrtime(String arrtime) {
		this.arrtime = arrtime;
	}
	
}

package com.boeing.training.flightticketsystem.model;

import java.sql.Time;

public class FlightLegDTO {

	private Long legno;
	private String flightno;
	private String airline;
	private String depairportcode;
	private String arrairportcode;
	private Time deptime;
	private Time arrtime;
	private String occurence;
	private Double basefare;
	
	
	public String getFlightno() {
		return flightno;
	}
	public void setFlightno(String flightno) {
		this.flightno = flightno;
	}
	public Long getLegno() {
		return legno;
	}
	public void setLegno(Long legno) {
		this.legno = legno;
	}
	public String getAirline() {
		return airline;
	}
	public void setAirline(String airline) {
		this.airline = airline;
	}
	public String getDepairportcode() {
		return depairportcode;
	}
	public void setDepairportcode(String depairportcode) {
		this.depairportcode = depairportcode;
	}
	public String getArrairportcode() {
		return arrairportcode;
	}
	public void setArrairportcode(String arrairportcode) {
		this.arrairportcode = arrairportcode;
	}
	public Time getDeptime() {
		return deptime;
	}
	public void setDeptime(Time deptime) {
		this.deptime = deptime;
	}
	public Time getArrtime() {
		return arrtime;
	}
	public void setArrtime(Time arrtime) {
		this.arrtime = arrtime;
	}
	public String getOccurence() {
		return occurence;
	}
	public void setOccurence(String occurence) {
		this.occurence = occurence;
	}
	public Double getBasefare() {
		return basefare;
	}
	public void setBasefare(Double basefare) {
		this.basefare = basefare;
	}
	
	public FlightLegDTO(Long legno, String flightno, String airline, String depairportcode, String arrairportcode,
			Time deptime, Time arrtime, String occurence, Double basefare) {
		super();
		this.legno = legno;
		this.flightno = flightno;
		this.airline = airline;
		this.depairportcode = depairportcode;
		this.arrairportcode = arrairportcode;
		this.deptime = deptime;
		this.arrtime = arrtime;
		this.occurence = occurence;
		this.basefare = basefare;
	}
	public FlightLegDTO() {
		
	}
}

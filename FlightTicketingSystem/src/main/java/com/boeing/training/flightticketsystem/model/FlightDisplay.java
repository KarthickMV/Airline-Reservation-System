package com.boeing.training.flightticketsystem.model;

import java.sql.Date;

import java.sql.Time;




public class FlightDisplay {

	private Date depDate;
	private int legNo;
	private String flightNo;
	private int availableSeats;
	private String depAirport;
	private Time depTime;
	private String arrAirport;
	private Time arrTime;
	private String flightStatus;
	private double fare;
	private long duration;
	public String getFlightStatus() {
		return flightStatus;
	}
	public void setFlightStatus(String flightStatus) {
		this.flightStatus = flightStatus;
	}
	public int getLegNo() {
		return legNo;
	}
	public void setLegNo(int legNo) {
		this.legNo = legNo;
	}
	public String getFlightNo() {
		return flightNo;
	}
	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}
	public int getAvailableSeats() {
		return availableSeats;
	}
	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}
	public String getDepAirport() {
		return depAirport;
	}
	public void setDepAirport(String depAirport) {
		this.depAirport = depAirport;
	}
	public Time getDepTime() {
		return depTime;
	}
	public void setDepTime(Time depTime) {
		this.depTime = depTime;
	}
	public String getArrAirport() {
		return arrAirport;
	}
	public void setArrAirport(String arrAirport) {
		this.arrAirport = arrAirport;
	}
	public Time getArrTime() {
		return arrTime;
	}
	public void setArrTime(Time arrTime) {
		this.arrTime = arrTime;
	}
	public Date getDepDate() {
		return depDate;
	}
	public void setDepDate(Date depDate) {
		this.depDate = depDate;
	}
	@Override
	public String toString() {
		return "LegInstance [depDate=" + depDate + ", legNo=" + legNo + ", flightNo=" + flightNo + ", availableSeats="
				+ availableSeats + ", depAirport=" + depAirport + ", depTime=" + depTime + ", arrAirport=" + arrAirport
				+ ", arrTime=" + arrTime + ", flightStatus=" + flightStatus + "]";
	}
	public FlightDisplay(Date depDate, int legNo, String flightNo, int availableSeats, String depAirport, Time depTime,
			String arrAirport, Time arrTime, String flightStatus) {
		super();
		this.depDate = depDate;
		this.legNo = legNo;
		this.flightNo = flightNo;
		this.availableSeats = availableSeats;
		this.depAirport = depAirport;
		this.depTime = depTime;
		this.arrAirport = arrAirport;
		this.arrTime = arrTime;
		this.flightStatus = flightStatus;
	}

   public FlightDisplay()
   {}
public double getFare() {
	return fare;
}
public void setFare(double fare) {
	this.fare = fare;
}
public long getDuration() {
	return duration;
}
public void setDuration(long duration) {
	this.duration = duration;
}
public FlightDisplay(Date depDate, int legNo, String flightNo, int availableSeats, String depAirport, Time depTime,
		String arrAirport, Time arrTime, String flightStatus, double fare, long duration) {
	super();
	this.depDate = depDate;
	this.legNo = legNo;
	this.flightNo = flightNo;
	this.availableSeats = availableSeats;
	this.depAirport = depAirport;
	this.depTime = depTime;
	this.arrAirport = arrAirport;
	this.arrTime = arrTime;
	this.flightStatus = flightStatus;
	this.fare = fare;
	this.duration = duration;
}



}

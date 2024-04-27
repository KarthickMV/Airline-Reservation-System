package com.boeing.training.flightticketsystem.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="flight")
public class Flight {
	
	@Id
	@Column(name="flight_no")
	private String flightid;
	@Column(name="airline")
	private String airline;
	@Column(name="max_seats")
	private Long maxseats;
	@Column(name="start_date")
	private Date startdate;
	@Column(name="occurrence")
	private String occurence;
	
	public Flight() {
		
	}
	
	public Flight(String flightid, String airline, Long maxseats, Date startdate, String occurence) {
		super();
		this.flightid = flightid;
		this.airline = airline;
		this.maxseats = maxseats;
		this.startdate = startdate;
		this.occurence = occurence;
	}

	public Date getStartdate() {
		return startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public String getFlightid() {
		return flightid;
	}
	public void setFlightid(String flightid) {
		this.flightid = flightid;
	}
	public String getAirline() {
		return airline;
	}
	public void setAirline(String airline) {
		this.airline = airline;
	}
	public long getMaxseats() {
		return maxseats;
	}
	public void setMaxseats(Long long1) {
		this.maxseats = long1;
	}
	public String getOccurence() {
		return occurence;
	}
	public void setOccurence(String occurence) {
		this.occurence = occurence;
	}
}

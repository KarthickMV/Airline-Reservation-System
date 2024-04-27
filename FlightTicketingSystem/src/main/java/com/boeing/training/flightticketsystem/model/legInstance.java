package com.boeing.training.flightticketsystem.model;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="leg_instance")

public class legInstance {
	
	
	@EmbeddedId
	private Leginstanceprimarykey leginstanceprimarykey;
	
	@Column(name = "available_seats")
	private int availableSeats;
	
	@Column(name="leg_no",insertable=false,updatable=false)
	private long legno;
	
	@Column(name="flight_no",insertable=false,updatable=false)
	private String flightno;
	
	@Column(name="dep_date",insertable=false,updatable=false)
	private Date depdate;
	
	@Column(name = "dep_airport")
	private String depAirport;
	@Column(name = "dep_time")
	private Time depTime;
	@Column(name = "arr_airport")
	private String arrAirport;
	@Column(name = "arr_time")
	private Time arrTime;
	@Column(name="flight_status")
	private String flightStatus;
	
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
	public String getFlightStatus() {
		return flightStatus;
	}
	public void setFlightStatus(String flightStatus) {
		this.flightStatus = flightStatus;
	}
	

	@Override
	public String toString() {
		return "legInstance [ availableSeats="
				+ availableSeats + ", depAirport=" + depAirport + ", depTime=" + depTime + ", arrAirport=" + arrAirport
				+ ", arrTime=" + arrTime + ", flightStatus=" + flightStatus + "]";
	}
	public Leginstanceprimarykey getLeginstanceprimarykey() {
		return leginstanceprimarykey;
	}
	public void setLeginstanceprimarykey(Leginstanceprimarykey leginstanceprimarykey) {
		this.leginstanceprimarykey = leginstanceprimarykey;
	}
}

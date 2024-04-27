package com.boeing.training.flightticketsystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="airport")
public class Airport {
	@Id
	@Column(name="airport_code")
	private String airportcode;
	
	@Column(name="city")
	private String city;

	public Airport() {
		
	}
	
	public Airport(String airportcode, String city) {
		super();
		this.airportcode = airportcode;
		this.city = city;
	}

	public String getAirportcode() {
		return airportcode;
	}

	public void setAirportcode(String airportcode) {
		this.airportcode = airportcode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
}

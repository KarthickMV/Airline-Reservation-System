package com.boeing.training.flightticketsystem.model;

import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="flight_leg",uniqueConstraints = @UniqueConstraint(columnNames = {"leg_no", "flight_no"}))
public class FlightLeg {
	@EmbeddedId
    private FlightID id;
	@Column(name="dep_time")
	private Time deptime;
	@Column(name="arr_time")
	private Time arrtime;
	@Column(name="base_fare")
	private Double basefare;
	
	@Column(name="leg_no",insertable = false, updatable = false)
	private Long legno;

	@Column(name="dep_airport",insertable = false, updatable = false)
	private String depairportcode;
	

	@Column(name="arr_airport",insertable = false, updatable = false)
	private String arrairportcode;

	@ManyToOne
    @JoinColumn(name = "flight_no",referencedColumnName="flight_no",insertable = false, updatable = false)
    private Flight flight;
	
	@Column(name="flight_no",unique=false,insertable = false, updatable = false)
	private String flightno;

	
	@OneToOne
	@JoinColumn(name="dep_airport", referencedColumnName="airport_code")
	private Airport depairport;
	
	@OneToOne
	@JoinColumn(name="arr_airport", referencedColumnName="airport_code")
	private Airport arrairport;
	
	
	

	public FlightLeg(FlightID id, Time deptime, Time arrtime, Double basefare, Long legno, String depairportcode,
			String arrairportcode, Flight flight, String flightno, Airport depairport, Airport arrairport) {
		super();
		this.id = id;
		this.deptime = deptime;
		this.arrtime = arrtime;
		this.basefare = basefare;
		this.legno = legno;
		this.depairportcode = depairportcode;
		this.arrairportcode = arrairportcode;
		this.flight = flight;
		this.flightno = flightno;
		this.depairport = depairport;
		this.arrairport = arrairport;
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

	public Long getLegno() {
		return legno;
	}

	public void setLegno(Long legno) {
		this.legno = legno;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public FlightID getId() {
		return id;
	}

	public void setId(FlightID id) {
		this.id = id;
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

	public Airport getDepairport() {
		return depairport;
	}

	public void setDepairport(Airport depairport) {
		this.depairport = depairport;
	}

	public Airport getArrairport() {
		return arrairport;
	}

	public void setArrairport(Airport arrairport) {
		this.arrairport = arrairport;
	}

	public Double getBasefare() {
		return basefare;
	}

	public void setBasefare(Double basefare) {
		this.basefare = basefare;
	}

	public FlightLeg() {
		
	}

	public String getFlightno() {
		return flightno;
	}

	public void setFlightno(String flightno) {
		this.flightno = flightno;
	}
	
}

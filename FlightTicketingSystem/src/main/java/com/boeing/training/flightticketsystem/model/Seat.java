package com.boeing.training.flightticketsystem.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="seat")
public class Seat {
	@EmbeddedId
	private SeatID seatid;
	
	@OneToOne
	@JoinColumn(name="passenger_id",referencedColumnName="passenger_id")
	private Passenger passenger;
	
	@Column(name="seat_no",insertable=false,updatable=false)
	private int seatno;
	
	@Column(name="dep_date",insertable=false,updatable=false)
	private Date depdate;
	
	@Column(name="leg_no",insertable=false,updatable=false)
	private int legno;
	
	@Column(name="flight_no",insertable=false,updatable=false)
	private String flightno;
	
	@ManyToOne
	@JoinColumn(name="dep_date",referencedColumnName="dep_date",insertable=false,updatable=false)
	@JoinColumn(name="leg_no",referencedColumnName="leg_no",insertable=false,updatable=false)
	@JoinColumn(name="flight_no",referencedColumnName="flight_no",insertable=false,updatable=false)
	private legInstance leginstance;

	public SeatID getSeatid() {
		return seatid;
	}

	public void setSeatid(SeatID seatid) {
		this.seatid = seatid;
	}

	public Passenger getPassenger() {
		return passenger;
	}

	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}

	public int getSeatno() {
		return seatno;
	}

	public void setSeatno(int seatno) {
		this.seatno = seatno;
	}

	public Date getDepdate() {
		return depdate;
	}

	public void setDepdate(Date depdate) {
		this.depdate = depdate;
	}

	public int getLegno() {
		return legno;
	}

	public void setLegno(int legno) {
		this.legno = legno;
	}

	public String getFlightno() {
		return flightno;
	}

	public void setFlightno(String flightno) {
		this.flightno = flightno;
	}

	public Seat(SeatID seatid, Passenger passenger, int seatno, Date depdate, int legno, String flightno) {
		super();
		this.seatid = seatid;
		this.passenger = passenger;
		this.seatno = seatno;
		this.depdate = depdate;
		this.legno = legno;
		this.flightno = flightno;
	}
	
	public Seat() {
		
	}
	
	
	
}


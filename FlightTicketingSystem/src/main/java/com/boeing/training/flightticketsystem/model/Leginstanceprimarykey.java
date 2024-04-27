package com.boeing.training.flightticketsystem.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
@Embeddable
public class Leginstanceprimarykey implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Column(name = "dep_date")
	private Date depDate;

	@Column(name="leg_no")
	private long legno;
	
	@Column(name="flight_no")
	private String flight;

	

	public Leginstanceprimarykey(Date depDate, long legno, String flight) {
		super();
		this.depDate = depDate;
		this.legno = legno;
		this.flight = flight;
	}



	public Date getDepDate() {
		return depDate;
	}



	public void setDepDate(Date depDate) {
		this.depDate = depDate;
	}



	public long getLegno() {
		return legno;
	}



	public void setLegno(long legno) {
		this.legno = legno;
	}



	public String getFlight() {
		return flight;
	}



	public void setFlight(String flight) {
		this.flight = flight;
	}



	public 	Leginstanceprimarykey() {
		
	}
}

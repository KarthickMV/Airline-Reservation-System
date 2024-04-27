package com.boeing.training.flightticketsystem.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
public class SeatID implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Column(name="seat_no")
	private int seatno;
	
	@Column(name="dep_date")
	private Date depdate;
	
	@Column(name="leg_no")
	private int legno;
	
	@Column(name="flight_no")
	private String flightno;
	
	public SeatID() {
		
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

	public SeatID(int seatno, Date depdate, int legno, String flightno) {
		super();
		this.seatno = seatno;
		this.depdate = depdate;
		this.legno = legno;
		this.flightno = flightno;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SeatID)) return false;
        SeatID that = (SeatID) o;
        return Objects.equals(getSeatno(), that.getSeatno()) &&
                Objects.equals(getLegno(), that.getLegno())&&
                Objects.equals(getFlightno(), that.getFlightno())&&
                Objects.equals(getDepdate(), that.getDepdate());
    }
 
    @Override
    public int hashCode() {
        return Objects.hash(getSeatno(), getLegno(),getDepdate(),getFlightno());
    }
}


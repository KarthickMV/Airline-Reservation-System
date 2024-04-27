package com.boeing.training.flightticketsystem.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class FlightID implements Serializable {
	
	
	private static final long serialVersionUID = 1L;

	@Column(name="leg_no",unique=false)
	private Long legno;
	
	@Column(name="flight_no")
	private String flightno;

	public FlightID() {
		
	}
	
	public FlightID(Long legno, String flightno) {
		super();
		this.legno = legno;
		this.flightno = flightno;
	}

	public Long getLegno() {
		return legno;
	}

	public void setLegno(Long legno) {
		this.legno = legno;
	}

	public String getFlightno() {
		return flightno;
	}

	public void setFlightno(String flightno) {
		this.flightno = flightno;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FlightID)) return false;
        FlightID that = (FlightID) o;
        return Objects.equals(getLegno(), that.getLegno()) &&
                Objects.equals(getFlightno(), that.getFlightno());
    }
 
    @Override
    public int hashCode() {
        return Objects.hash(getLegno(), getFlightno());
    }
	
}

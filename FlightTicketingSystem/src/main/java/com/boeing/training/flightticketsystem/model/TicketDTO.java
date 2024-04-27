package com.boeing.training.flightticketsystem.model;

import java.sql.Time;
import java.util.Date;
import java.util.List;

public class TicketDTO {
	
	private int ticketId;
	private List<PassengerDTO> passengerlist;
	private String flightno;
	private Date depDate;
	private Date BookingDate;
	private String depairportcode;
	private String arrairportcode;
	private Time deptime;
	private Time arrtime;
	public int getTicketId() {
		return ticketId;
	}
	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}
	public List<PassengerDTO> getPassengerlist() {
		return passengerlist;
	}
	public void setPassengerlist(List<PassengerDTO> passengerlist) {
		this.passengerlist = passengerlist;
	}
	public String getFlightno() {
		return flightno;
	}
	public void setFlightno(String flightno) {
		this.flightno = flightno;
	}
	public Date getDepDate() {
		return depDate;
	}
	public void setDepDate(Date depDate) {
		this.depDate = depDate;
	}
	public Date getBookingDate() {
		return BookingDate;
	}
	public void setBookingDate(Date bookingDate) {
		BookingDate = bookingDate;
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
	public TicketDTO(int ticketId, List<PassengerDTO> passengerlist, String flightno, Date depDate, Date bookingDate,
			String depairportcode, String arrairportcode, Time deptime, Time arrtime) {
		super();
		this.ticketId = ticketId;
		this.passengerlist = passengerlist;
		this.flightno = flightno;
		this.depDate = depDate;
		BookingDate = bookingDate;
		this.depairportcode = depairportcode;
		this.arrairportcode = arrairportcode;
		this.deptime = deptime;
		this.arrtime = arrtime;
	}
	
	public TicketDTO() {
		
	}
	
}


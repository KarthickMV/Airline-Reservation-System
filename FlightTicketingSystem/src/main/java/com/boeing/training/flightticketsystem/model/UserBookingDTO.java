package com.boeing.training.flightticketsystem.model;

import java.sql.Date;


public class UserBookingDTO {

	private String uname;
	private int ticketId;
	private String flightNo;
	private String depairportcode;
	private String arrairportcode;
	private int noOfPassenger;
	private Date bookingDate;
	private Date depDate;
	private float totalPayable;
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public int getTicketId() {
		return ticketId;
	}
	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}
	public String getFlightNo() {
		return flightNo;
	}
	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
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
	public int getNoOfPassenger() {
		return noOfPassenger;
	}
	public void setNoOfPassenger(int noOfPassenger) {
		this.noOfPassenger = noOfPassenger;
	}
	public Date getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}
	public Date getDepDate() {
		return depDate;
	}
	public void setDepDate(Date depDate) {
		this.depDate = depDate;
	}
	public float getTotalPayable() {
		return totalPayable;
	}
	public void setTotalPayable(float totalPayable) {
		this.totalPayable = totalPayable;
	}
	public UserBookingDTO(String uname, int ticketId, String flightNo, String depairportcode, String arrairportcode,
			int noOfPassenger, Date bookingDate, Date depDate, float totalPayable) {
		super();
		this.uname = uname;
		this.ticketId = ticketId;
		this.flightNo = flightNo;
		this.depairportcode = depairportcode;
		this.arrairportcode = arrairportcode;
		this.noOfPassenger = noOfPassenger;
		this.bookingDate = bookingDate;
		this.depDate = depDate;
		this.totalPayable = totalPayable;
	}
	
	
	public UserBookingDTO() {
		
	}
	
}


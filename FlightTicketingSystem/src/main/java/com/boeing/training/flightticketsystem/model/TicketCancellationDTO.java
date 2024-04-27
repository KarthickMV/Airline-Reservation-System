package com.boeing.training.flightticketsystem.model;

import java.sql.Date;

public class TicketCancellationDTO {
	private int cancelId;
	private String flightno;
	private Date bookingDate;
	private Date depDate;
	private int ticketId;
	private String status;
	private String depairportcode;
	private String arrairportcode;
	
	
	public int getCancelid() {
		return cancelId;
	}
	public void setCancelid(int cancelId) {
		this.cancelId = cancelId;
	}
	
	public String getFlightno() {
		return flightno;
	}
	public void setFlightno(String flightno) {
		this.flightno = flightno;
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
	public int getTicketid() {
		return ticketId;
	}
	public void setTicketid(int ticketId) {
		this.ticketId = ticketId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
	public TicketCancellationDTO(int cancelId, String flightno, Date bookingDate, Date depDate,
			int ticketId, String status, String depairportcode, String arrairportcode) {
		super();
		this.cancelId = cancelId;
		this.flightno = flightno;
		this.bookingDate = bookingDate;
		this.depDate = depDate;
		this.ticketId = ticketId;
		this.status = status;
		this.depairportcode = depairportcode;
		this.arrairportcode = arrairportcode;
	}
	public TicketCancellationDTO() {
		
	}
}

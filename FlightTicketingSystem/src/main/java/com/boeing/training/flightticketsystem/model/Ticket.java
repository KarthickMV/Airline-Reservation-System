package com.boeing.training.flightticketsystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ticket")
public class Ticket {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ticket_id")
	private int ticketId;
	
	@OneToOne
	@JoinColumn(name="pay_id",referencedColumnName="pay_id")
	private Payment payid;
	
	
	@OneToOne
	@JoinColumn(name="booking_id",referencedColumnName="booking_id")
	private BookingInfo bookingid;

	public Ticket() {
		super();
	}

	public Ticket(int ticketId, Payment payid, BookingInfo bookingid) {
		super();
		this.ticketId = ticketId;
		this.payid = payid;
		this.bookingid = bookingid;
	}

	public int getTicketId() {
		return ticketId;
	}


	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}


	public Payment getPayid() {
		return payid;
	}


	public void setPayid(Payment payid) {
		this.payid = payid;
	}


	public BookingInfo getBookingid() {
		return bookingid;
	}


	public void setBookingid(BookingInfo bookingid) {
		this.bookingid = bookingid;
	}
	
	

}

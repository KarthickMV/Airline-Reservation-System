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
@Table(name = "ticket_cancellation")
public class TicketCancellation {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="cancel_id")
	private int cancelId;
	
	@Column(name="status")
	private String status;
	
	@OneToOne
	@JoinColumn(name="ticket_id",referencedColumnName="ticket_id")
	private Ticket ticketid;
	
	public TicketCancellation() {
		super();
	}

	public TicketCancellation(int cancelId, String status, Ticket ticketid) {
		super();
		this.cancelId = cancelId;
		this.status = status;
		this.ticketid = ticketid;
	}

	public int getCancelId() {
		return cancelId;
	}

	public void setCancelId(int cancelId) {
		this.cancelId = cancelId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Ticket getTicketid() {
		return ticketid;
	}

	public void setTicketid(Ticket ticketid) {
		this.ticketid = ticketid;
	}
	
	
	

}

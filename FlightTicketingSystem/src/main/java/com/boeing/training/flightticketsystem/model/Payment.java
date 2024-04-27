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
@Table(name = "payment")
public class Payment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="pay_id")
	private int payId;
	
	@Column(name="pay_method")
	private String payMethod;
	
	@Column(name="tax_amount")
	private float taxAmount;
	
	@Column(name="total_payable")
	private float totalPayable;
	
	@Column(name="pay_status")
	private String payStatus="PAID";
	
	@OneToOne
	@JoinColumn(name="booking_id",referencedColumnName="booking_id")
	private BookingInfo bookingid;

	
	
	public Payment() {
		super();
	}

	public Payment(int payId, String payMethod, float taxAmount, float totalPayable, String payStatus,
			BookingInfo bookingid) {
		super();
		this.payId = payId;
		this.payMethod = payMethod;
		this.taxAmount = taxAmount;
		this.totalPayable = totalPayable;
		this.payStatus = payStatus;
		this.bookingid = bookingid;
	}

	public int getPayId() {
		return payId;
	}

	public void setPayId(int payId) {
		this.payId = payId;
	}

	public String getPayMethod() {
		return payMethod;
	}

	public void setPayMethod(String payMethod) {
		this.payMethod = payMethod;
	}

	public float getTaxAmount() {
		return taxAmount;
	}

	public void setTaxAmount(float taxAmount) {
		this.taxAmount = taxAmount;
	}

	public float getTotalPayable() {
		return totalPayable;
	}

	public void setTotalPayable(float totalPayable) {
		this.totalPayable = totalPayable;
	}

	public String getPayStatus() {
		return payStatus;
	}

	public void setPayStatus(String payStatus) {
		this.payStatus = payStatus;
	}

	public BookingInfo getBookingid() {
		return bookingid;
	}

	public void setBookingid(BookingInfo bookingid) {
		this.bookingid = bookingid;
	}
	
	

}

package com.boeing.training.flightticketsystem.model;

import java.sql.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "booking_info")
public class BookingInfo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="booking_id")
	private int bookingId;	
	
	@Column(name="booking_date")
	private Date bookingDate;
	
	@Column(name="user_id",insertable = false, updatable = false)
	private int userId;
	
	public UserDetail getUserdetail() {
		return userdetail;
	}

	public void setUserdetail(UserDetail userdetail) {
		this.userdetail = userdetail;
	}

	@Column(name="no_of_passenger")
	private int noOfPassenger;
	
	@Column(name="net_fare")
	private float netFare;
	
	@Column(name="dep_date")
	private Date depDate;
	
	@Column(name="leg_no")
	private int legNo;
	
	@Column(name="flight_no")
	private String flightNo;
	
	private String bookDate;
	private String departureDate;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private UserDetail userdetail;
	
	public BookingInfo() {
		super();
	}

	public BookingInfo(int bookingId, Date bookingDate, int userId, int noOfPassenger, float netFare, Date depDate,
			int legNo, String flightNo, String bookDate, String departureDate, UserDetail userdetail) {
		super();
		this.bookingId = bookingId;
		this.bookingDate = bookingDate;
		this.userId = userId;
		this.noOfPassenger = noOfPassenger;
		this.netFare = netFare;
		this.depDate = depDate;
		this.legNo = legNo;
		this.flightNo = flightNo;
		this.bookDate = bookDate;
		this.departureDate = departureDate;
		this.userdetail = userdetail;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public Date getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getNoOfPassenger() {
		return noOfPassenger;
	}

	public void setNoOfPassenger(int noOfPassenger) {
		this.noOfPassenger = noOfPassenger;
	}

	public float getNetFare() {
		return netFare;
	}

	public void setNetFare(float netFare) {
		this.netFare = netFare;
	}

	public Date getDepDate() {
		return depDate;
	}

	public void setDepDate(Date depDate) {
		this.depDate = depDate;
	}

	public int getLegNo() {
		return legNo;
	}

	public void setLegNo(int legNo) {
		this.legNo = legNo;
	}

	public String getFlightNo() {
		return flightNo;
	}

	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}

	public String getBookDate() {
		return bookDate;
	}

	public void setBookDate(String bookDate) {
		this.bookDate = bookDate;
	}

	public String getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}
	
	
	
}
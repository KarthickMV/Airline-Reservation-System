package com.boeing.training.flightticketsystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "passenger")
public class Passenger {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="passenger_id")
	private int passengerId;
	
	@Column(name="title")
	private String title;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="email_id")
	private String email;
	
	@Column(name="phone_no")
	private String phone;
	
	@Column(name="seat_no")
	private int seatno=0;
	
	

	@ManyToOne
	@JoinColumn(name="booking_id",referencedColumnName="booking_id")
	private BookingInfo bookingid;
	
	@Column(name="booking_id",insertable=false,updatable=false)
	private int bookingno;
	
	public int getSeatno() {
		return seatno;
	}

	public void setSeatno(int seatno) {
		this.seatno = seatno;
	}

	public int getBookingno() {
		return bookingno;
	}

	public void setBookingno(int bookingno) {
		this.bookingno = bookingno;
	}

	public Passenger() {
		super();
	}

	

	public Passenger(int passengerId, String title, String firstName, String lastName, String email, String phone,
			BookingInfo bookingid, int bookingno) {
		super();
		this.passengerId = passengerId;
		this.title = title;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.bookingid = bookingid;
		this.bookingno = bookingno;
	}

	public int getPassengerId() {
		return passengerId;
	}

	public void setPassengerId(int passengerId) {
		this.passengerId = passengerId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public BookingInfo getBookingid() {
		return bookingid;
	}

	public void setBookingid(BookingInfo bookingid) {
		this.bookingid = bookingid;
	}
	
	

}

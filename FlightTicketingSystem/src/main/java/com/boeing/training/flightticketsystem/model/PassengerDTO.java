package com.boeing.training.flightticketsystem.model;

public class PassengerDTO {

	private String title;
	private String firstName;
	private String lastName;
	private int seatno;
	
	public int getSeatno() {
		return seatno;
	}
	public void setSeatno(int seatno) {
		this.seatno = seatno;
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
	
	
	public PassengerDTO(String title, String firstName, String lastName, int seatno) {
		super();
		this.title = title;
		this.firstName = firstName;
		this.lastName = lastName;
		this.seatno = seatno;
	}
	public PassengerDTO() {
		
	}
}

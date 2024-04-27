package com.boeing.training.flightticketsystem.model;

public class connectFlight {
	
	private int id;
	private FlightDisplay depToarr;
	private FlightDisplay arrTodep;
	private String interstation;
	private long tduration;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public FlightDisplay getDepToarr() {
		return depToarr;
	}
	public void setDepToarr(FlightDisplay  depToarr) {
		this.depToarr = depToarr;
	}
	public FlightDisplay  getArrTodep() {
		return arrTodep;
	}
	public void setArrTodep(FlightDisplay  arrTodep) {
		this.arrTodep = arrTodep;
	}
	public String getInterstation() {
		return interstation;
	}
	public void setInterstation(String interstation) {
		this.interstation = interstation;
	}
	
	
	@Override
	public String toString() {
		return "connectFlight [id=" + id + ", depToarr=" + depToarr + ", arrTodep=" + arrTodep + ", interstation="
				+ interstation + "]";
	}
	public connectFlight(int id, FlightDisplay  depToarr, FlightDisplay  arrTodep, String interstation) {
		super();
		this.id = id;
		this.depToarr = depToarr;
		this.arrTodep = arrTodep;
		this.interstation = interstation;
	}
	public connectFlight() {
		
	}
	public long getTduration() {
		return tduration;
	}
	public void setTduration(long tduration) {
		this.tduration = tduration;
	}
	
	

}

package com.boeing.training.flightticketsystem.model;

public class FlightRemovalResponseObject {

	private boolean leginstance=false;
	private boolean allflights= false;
	public boolean isLeginstance() {
		return leginstance;
	}
	public void setLeginstance(boolean leginstance) {
		this.leginstance = leginstance;
	}
	public boolean isAllflights() {
		return allflights;
	}
	public void setAllflights(boolean allflights) {
		this.allflights = allflights;
	}
	public FlightRemovalResponseObject(boolean leginstance, boolean allflights) {
		super();
		this.leginstance = leginstance;
		this.allflights = allflights;
	}
	public FlightRemovalResponseObject() {
		
	}
			
}
package com.boeing.training.flightticketsystem.model;

public class AddFlightResponseObject {

	private boolean success=false;
	private boolean flight=false;
	private boolean notavailable=false;
	private boolean depairportrunwaynotavailable=false;
	private boolean arrairportrunwaynotavailable=false;
	private FlightLeg addedflight;
	
	
	
	public AddFlightResponseObject(boolean success, boolean flight, boolean notavailable,
			boolean depairportrunwaynotavailable, boolean arrairportrunwaynotavailable) {
		super();
		this.success = success;
		this.flight = flight;
		this.notavailable = notavailable;
		this.depairportrunwaynotavailable = depairportrunwaynotavailable;
		this.arrairportrunwaynotavailable = arrairportrunwaynotavailable;
	}
	
	public FlightLeg getAddedflight() {
		return addedflight;
	}
	public void setAddedflight(FlightLeg addedflight) {
		this.addedflight = addedflight;
	}
	
	public boolean isDepairportrunwaynotavailable() {
		return depairportrunwaynotavailable;
	}
	public void setDepairportrunwaynotavailable(boolean depairportrunwaynotavailable) {
		this.depairportrunwaynotavailable = depairportrunwaynotavailable;
	}
	public boolean isArrairportrunwaynotavailable() {
		return arrairportrunwaynotavailable;
	}
	public void setArrairportrunwaynotavailable(boolean arrairportrunwaynotavailable) {
		this.arrairportrunwaynotavailable = arrairportrunwaynotavailable;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public boolean isFlight() {
		return flight;
	}
	public void setFlight(boolean flight) {
		this.flight = flight;
	}
	public boolean isNotavailable() {
		return notavailable;
	}
	public void setNotavailable(boolean notavailable) {
		this.notavailable = notavailable;
	}
	
	
	public AddFlightResponseObject() {
		
	}
}

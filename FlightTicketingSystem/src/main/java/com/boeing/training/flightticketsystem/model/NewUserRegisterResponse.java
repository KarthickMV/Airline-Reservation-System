package com.boeing.training.flightticketsystem.model;

public class NewUserRegisterResponse {

	
	private boolean success=false;
	
	

	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	

	
	public NewUserRegisterResponse(boolean success) {
		super();
		this.success = success;
	}
	public NewUserRegisterResponse() {
		 
	 }
}

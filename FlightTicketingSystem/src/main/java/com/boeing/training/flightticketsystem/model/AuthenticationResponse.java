package com.boeing.training.flightticketsystem.model;

import java.io.Serializable;

public class AuthenticationResponse implements Serializable {
	private static final long serialVersionUID = 1L;
	private final String jwt;
	private final String fname;
	private final String role;
	
	
	public AuthenticationResponse(String jwt, String fname, String role) {
		super();
		this.jwt = jwt;
		this.fname = fname;
		this.role = role;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public String getFname() {
		return fname;
	}


	public String getRole() {
		return role;
	}


	public String getJwt() {
		return jwt;
	}
}

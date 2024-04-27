package com.boeing.training.flightticketsystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_details")
public class UserDetail {
	
	
	//Table to map the data model in the database
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id")
	private int userid;
	@Column(name="user_name")
	private String uname;
	@Column(name="password")
	private String password;
	@Column(name="gender")
	private String gender;
	@Column (name="first_name")
	private String firstName;
	@Column (name="last_name")
	private String lastName;
	@Column (name="email_id")
	private String email;
	@Column (name="phone_no")
	private String phoneNumber;
	@Column(name="user_role") 
	private String admin="ROLE_USER,ROLE_ADMIN";
	
	
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
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
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	
	  public String getAdmin() { return admin; } 
	    public void setAdmin(String admin)
	  { this.admin = admin; }
	 
	
	public UserDetail(int userid, String uname, String password, String gender, String firstName, String lastName,
				String email, String phoneNumber, String admin) {
			super();
			this.userid = userid;
			this.uname = uname;
			this.password = password;
			this.gender = gender;
			this.firstName = firstName;
			this.lastName = lastName;
			this.email = email;
			this.phoneNumber = phoneNumber;
			this.admin = admin;
		}
	public UserDetail() {
	
	}
	@Override
	public String toString() {
		return "UserDetails [uname=" + uname + ", password=" + password + ", gender=" + gender
				+ ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", phoneNumber="
				+ phoneNumber + "]";
	}
	


}

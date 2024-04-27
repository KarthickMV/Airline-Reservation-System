package com.boeing.training.flightticketsystem.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.boeing.training.flightticketsystem.model.AuthenticationRequest;
import com.boeing.training.flightticketsystem.model.AuthenticationResponse;
import com.boeing.training.flightticketsystem.model.NewUserRegisterResponse;
import com.boeing.training.flightticketsystem.model.UserDetail;
import com.boeing.training.flightticketsystem.repository.UserRepository;
import com.boeing.training.flightticketsystem.util.JwtUtil;

@Service
public class UserService {
	
	@Autowired(required=true)
	public UserRepository userRepository;
	
	@Autowired
	private MyUserDetailsService userDetailsService;
	
	@Autowired
	private JwtUtil jwtTokenUtil;
	
	//Method to obtain a username and password and validate if the user is present in the database or not
	public String isuserValid(String uname,String password) {
		List<UserDetail> users = new ArrayList<UserDetail>();
		userRepository.findAll().forEach(users::add);
		String userType="Not a valid user";
		for(UserDetail user:users) {
			if((user.getUname().equalsIgnoreCase(uname)||user.getEmail().equalsIgnoreCase(uname) )&& user.getPassword().equals(password)) {
				if(user.getAdmin().equalsIgnoreCase("admin")) {
					userType="Welcome Admin: "+ user.getUname();
					break;
				}
				userType="Welcome: "+ user.getUname() ;
				break;
			}
		}
		return userType;
	}
	
	//to find the role of a user
	public String getUserRole(String role) {
		List<String> list = Arrays.stream(role.split(","))
		.collect(Collectors.toList());
		for(String s:list) {
			if(s.equals("ROLE_ADMIN")) {
				return "admin";
			}
			}
		for(String s:list) {
			if(s.equals("ROLE_USER")) {
				return "user";
			}
			}
		return null;
	}
	
	
	//method to retrieve values for the AuthenticationResponse model
	public AuthenticationResponse getResponseObject(AuthenticationRequest authRequest) {
		 System.out.println("Valid/InvalidUser"); 
		 Optional<UserDetail> user = userRepository.findByUname(authRequest.getUsername());
				  if(!user.isPresent()) { 
					  user = userRepository.findByPhoneNumber(authRequest.getUsername()); 
					  }
				  if(!user.isPresent()) {
					  user=userRepository.findByEmail(authRequest.getUsername()); 
					  }
				  
				String fname, role;
				
				fname=user.get().getFirstName();
				role=getUserRole(user.get().getAdmin());
				
				final UserDetails userDetails = userDetailsService
						.loadUserByUsername(authRequest.getUsername());

				final String jwt = jwtTokenUtil.generateToken(userDetails);
				
				return new AuthenticationResponse(jwt,fname,role);
	}
	
	
	// Method to store a userdetails object in the database by taking a userdetails object as input
	public NewUserRegisterResponse registerUser(UserDetail user,NewUserRegisterResponse res) {
		
		/*
		 * List<UserDetail> users = new ArrayList<UserDetail>();
		 * userRepository.findAll().forEach(users::add); boolean Status = true;
		 * for(UserDetail list:users) { if(user.getUname().equals(list.getUname())) {
		 * Status=false; } if(user.getEmail().equals(list.getEmail())) { Status=false; }
		 * if(user.getPhoneNumber().equals(list.getPhoneNumber())) { Status=false; } }
		 * if(Status) { }
		 */
		 
		  user=userRepository.save(user);
		  System.out.println(user.getUserid());
		  res.setSuccess(true);
		  
		return res;
	}
	
	//Dynamic Testing of Username
	public boolean doesUserExist(String username) {
		List<UserDetail> users = new ArrayList<UserDetail>();
		userRepository.findAll().forEach(users::add);
		boolean Status = true;
		  for(UserDetail user:users) {
			  if(username.equalsIgnoreCase(user.getUname())) {
				  Status=false;
			  }
		  }
		  return Status;
	}
	
	//Dynamic Testing of PhoneNumber
	public boolean doesPhoneExist(String phone) {
		List<UserDetail> users = new ArrayList<UserDetail>();
		userRepository.findAll().forEach(users::add);
		boolean Status = true;
		  for(UserDetail user:users) {
			  if(phone.equalsIgnoreCase(user.getPhoneNumber())) {
				  Status=false;
			  }
		  }
		  return Status;
	}
	
	//Dynamic Testing of Email
		public boolean doesEmailExist(String email) {
			List<UserDetail> users = new ArrayList<UserDetail>();
			userRepository.findAll().forEach(users::add);
			boolean Status = true;
			  for(UserDetail user:users) {
				  if(email.equalsIgnoreCase(user.getEmail())){
					  Status=false;
				  }
			  }
			  return Status;
		}
		//To set session values for the userid
		public void getUserId(HttpSession session, String username) {
			Optional<UserDetail> user = userRepository.findByUname(username);
			if(user.isPresent()) {
				int userid = user.get().getUserid();
				session.setAttribute("userid", userid);
			}	
		}
}



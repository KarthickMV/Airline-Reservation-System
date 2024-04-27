package com.boeing.training.flightticketsystem.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.boeing.training.flightticketsystem.model.AuthenticationRequest;
import com.boeing.training.flightticketsystem.model.AuthenticationResponse;
import com.boeing.training.flightticketsystem.model.NewUserRegisterResponse;
import com.boeing.training.flightticketsystem.model.UserDetail;
import com.boeing.training.flightticketsystem.service.UserService;


@RestController
public class UserDetailsController {

	@Autowired(required=true)
	private UserService userService;
	
	@Autowired(required=true)
	private AuthenticationManager authenticationManager;
	
	
	//Just a default page to return a message saying hello
	@RequestMapping("/")
	public String viewHomepage() {
		return "hello";
	}
	
	//To map requests appearing with a /login url and validate if the user exists in the database and return a boolean
	@RequestMapping(method=RequestMethod.POST,value="/login")
	public String isvalidUser(@RequestBody UserDetail user) {
		String Status = userService.isuserValid(user.getUname(), user.getPassword());
		return Status;
	}
	
	//To register users based on a json object sent by the post method
	@RequestMapping(method=RequestMethod.POST,value="/register")
	public NewUserRegisterResponse registerUser(@RequestBody UserDetail user) {
		System.out.println(user);
		NewUserRegisterResponse res = new NewUserRegisterResponse();
		res = userService.registerUser(user,res);
		return res;
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/username")
	public boolean doesUserExist(@RequestBody UserDetail user) {
		boolean status = userService.doesUserExist(user.getUname());
		return status;
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/phonenumber")
	public boolean doesPhoneExist(@RequestBody UserDetail user) {
		boolean status = userService.doesPhoneExist(user.getPhoneNumber());
		return status;
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/email")
	public boolean doesEmailExist(@RequestBody UserDetail user) {
		boolean status = userService.doesEmailExist(user.getEmail());
		return status;
	}
	
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest,HttpSession session) throws Exception {

		try {
			System.out.println("Inside authenticate method");
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
			);
			System.out.println("Validating User");
		}
		catch (BadCredentialsException e) {
			
			  System.out.println("Invalid User"); 
			  AuthenticationResponse ar = new AuthenticationResponse(null,null,null); 
			  return  ResponseEntity.ok(ar);
		} 
		
		userService.getUserId(session,authenticationRequest.getUsername());

		return ResponseEntity.ok(userService.getResponseObject(authenticationRequest));//new AuthenticationResponse(jwt));
	

	}
	
	@RequestMapping(method=RequestMethod.GET,value="/sessionclear")
	public void logOut(HttpSession session) {
		session.invalidate();
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/welcome")
	public String doNothing() {
		return "<h1>Weclome</h1>";
	}
}

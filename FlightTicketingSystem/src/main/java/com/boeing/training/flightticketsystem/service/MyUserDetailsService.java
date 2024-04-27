package com.boeing.training.flightticketsystem.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.boeing.training.flightticketsystem.model.UserDetail;
import com.boeing.training.flightticketsystem.model.UserDetailsAuth;
import com.boeing.training.flightticketsystem.repository.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserDetailsAuth loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("User testing inside service class");
		
		Optional<UserDetail> user = userRepository.findByUname(username);
		if(!user.isPresent()) {
			user = userRepository.findByPhoneNumber(username);
		}
		if(!user.isPresent()) {
			user=userRepository.findByEmail(username);
		}
		
		user.orElseThrow(()->{System.out.println("invalid user"+ username);
			
		return new UsernameNotFoundException("Not Found: "+username);});
		
		System.out.println("User testing inside service class before return");
		
		return user.map(UserDetailsAuth::new).get();
	}
	
	
}

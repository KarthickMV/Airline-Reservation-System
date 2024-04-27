package com.boeing.training.flightticketsystem.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@SuppressWarnings("deprecation")
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailsService myUserDetailsService;
	
	@Autowired
	JwtRequestFilter jwtRequestFilter;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		System.out.println("Inside WebSecurity Configurer");
		auth.userDetailsService(myUserDetailsService);
		System.out.println("Leaving the WebSecurity Configurer");
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.csrf().disable()
					.authorizeRequests()
					.antMatchers("/authenticate").permitAll()
					.antMatchers("/register").permitAll()
					.antMatchers("/model").permitAll()
					.antMatchers("/addflight").permitAll()
					.antMatchers("/removeflight").permitAll()
					.antMatchers("/username").permitAll()
					.antMatchers("/phonenumber").permitAll()
					.antMatchers("/email").permitAll()
					.antMatchers("/getallflight").permitAll()
					.antMatchers("/checkflight").permitAll()
					.antMatchers("/BookingRequest").permitAll()
					.antMatchers("/Passenger").permitAll()
					.antMatchers("/Payment").permitAll()
					.antMatchers("/viewlatestbooking").permitAll()
					.antMatchers("/ticketcancellation").permitAll()
					.antMatchers("/checkuser").permitAll()
					.antMatchers("/getuserbooking").permitAll()
					.antMatchers("/ticketcancellation").permitAll()
					.antMatchers("/altercancellationstatus").permitAll()
					.antMatchers("/viewTicket").permitAll()
					.antMatchers("/Flights").permitAll()
					.antMatchers("/sessionclear").permitAll()
					.antMatchers("/RequestCancellation").permitAll()
					.anyRequest().authenticated().and()
					.exceptionHandling().and().sessionManagement()
					.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
	}	
	

	
}

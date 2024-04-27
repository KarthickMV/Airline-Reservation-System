package com.boeing.training.flightticketsystem.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.boeing.training.flightticketsystem.model.UserDetail;

@Repository
public interface UserRepository extends JpaRepository<UserDetail, String> {
	//Repository to work with the user table
	
	//abstract method to find user by username column
	Optional<UserDetail> findByUname(String userName);
	
	//abstract method to find user by phonenumber column
	Optional<UserDetail> findByPhoneNumber(String number);
	
	//absract method to find user by email id
	Optional<UserDetail> findByEmail(String email);
	
	UserDetail findByUserid(int userid);
}

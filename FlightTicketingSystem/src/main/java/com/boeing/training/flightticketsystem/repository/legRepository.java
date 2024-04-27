package com.boeing.training.flightticketsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.boeing.training.flightticketsystem.model.legInstance;

@Repository
public interface legRepository extends JpaRepository<legInstance,String> {
	
	
	
	
}
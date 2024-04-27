package com.boeing.training.flightticketsystem.repository;

import java.sql.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.boeing.training.flightticketsystem.model.Leginstanceprimarykey;
import com.boeing.training.flightticketsystem.model.legInstance;

@Repository
public interface LegInstanceRepository extends JpaRepository<legInstance, Leginstanceprimarykey>, LegInstanceCustom {
	
	legInstance findByDepdateAndFlightnoAndLegno(Date depdate,String flightno,long legno);
}
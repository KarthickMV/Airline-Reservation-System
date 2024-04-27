package com.boeing.training.flightticketsystem.repository;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class LegInstanceRepositoryImpl implements LegInstanceCustom{

	@PersistenceContext
	private EntityManager em;

	// for adding flights automatically in LegInstance Table 
	
	@Override
	public boolean addLegInstance(String flightNo, LocalDate startDate, int legNo) {
		StoredProcedureQuery storedProcedure = em.createStoredProcedureQuery("InsertLegInstance")
				.registerStoredProcedureParameter(0, String.class, ParameterMode.IN)
				.registerStoredProcedureParameter(1, LocalDate.class, ParameterMode.IN)
				.registerStoredProcedureParameter(2, int.class, ParameterMode.IN);
		storedProcedure.setParameter(0, flightNo).setParameter(1, startDate).setParameter(2, legNo);

		storedProcedure.execute();

		return true;
	}
	
	// for update available seats

		
		  @Override public boolean updateAvailableSeats(LocalDate depDate, Integer
		  legNo, String flightNo) { StoredProcedureQuery storedProcedure2 =
		  em.createStoredProcedureQuery("UpdateAvailableSeats")
		  .registerStoredProcedureParameter(0, LocalDate.class, ParameterMode.IN)
		  .registerStoredProcedureParameter(1, Integer.class, ParameterMode.IN)
		  .registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		  
		  storedProcedure2 .setParameter(0, depDate) .setParameter(1, legNo)
		  .setParameter (2, flightNo);
		  
		  storedProcedure2.execute(); return true; }
		 
	
	
	
}
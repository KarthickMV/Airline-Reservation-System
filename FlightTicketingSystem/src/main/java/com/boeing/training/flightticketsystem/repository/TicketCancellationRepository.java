package com.boeing.training.flightticketsystem.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.boeing.training.flightticketsystem.model.TicketCancellation;

@Repository
public interface TicketCancellationRepository extends JpaRepository<TicketCancellation, Integer>{

	Optional<List<TicketCancellation>> findByStatus(String string);
	
	TicketCancellation findByCancelId(int cancelid);

}

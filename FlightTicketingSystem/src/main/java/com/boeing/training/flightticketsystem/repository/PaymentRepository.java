package com.boeing.training.flightticketsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.boeing.training.flightticketsystem.model.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment,Integer>{

	//Payment findByPayId(int payid);
}

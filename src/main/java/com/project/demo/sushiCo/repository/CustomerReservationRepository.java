package com.project.demo.sushiCo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.project.demo.sushiCo.entity.CustomerReservation;
@Service
public interface CustomerReservationRepository extends JpaRepository<CustomerReservation, Integer>{

}

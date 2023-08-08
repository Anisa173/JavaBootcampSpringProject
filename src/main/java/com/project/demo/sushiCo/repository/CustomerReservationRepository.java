package com.project.demo.sushiCo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.demo.sushiCo.entity.CustomerReservation;
@Repository
public interface CustomerReservationRepository extends JpaRepository<CustomerReservation, Integer>{

}

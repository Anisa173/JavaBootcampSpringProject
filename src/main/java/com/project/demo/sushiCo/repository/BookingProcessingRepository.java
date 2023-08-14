package com.project.demo.sushiCo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.project.demo.sushiCo.entity.BookingProcessing;
@Service
public interface BookingProcessingRepository extends JpaRepository<BookingProcessing, Integer>{

}

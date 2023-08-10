package com.project.demo.sushiCo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.project.demo.sushiCo.entity.AddInBasket;

@Service
public interface AddInBasketRepository extends JpaRepository<AddInBasket, Integer>{

@Query(value = "Select ",nativeQuery = true)
	
	
	
	

}


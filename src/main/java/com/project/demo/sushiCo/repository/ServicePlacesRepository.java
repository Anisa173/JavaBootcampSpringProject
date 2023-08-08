package com.project.demo.sushiCo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.demo.sushiCo.entity.ServicePlaces;

@Repository
public interface ServicePlacesRepository extends JpaRepository<ServicePlaces, Integer>{

}

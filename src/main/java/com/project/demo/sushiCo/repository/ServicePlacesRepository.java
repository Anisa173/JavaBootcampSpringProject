package com.project.demo.sushiCo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.project.demo.sushiCo.domain.dto.ServicePlacesDto;
import com.project.demo.sushiCo.entity.ServicePlaces;

@Service
public interface ServicePlacesRepository extends JpaRepository<ServicePlaces, Integer>{

	ServicePlaces save(ServicePlacesDto serviceP);

}

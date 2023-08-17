package com.project.demo.sushiCo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.project.demo.sushiCo.domain.dto.ServicePlacesDto;
import com.project.demo.sushiCo.entity.ServicePlaces;

@Service
public interface ServicePlacesRepository extends JpaRepository<ServicePlaces, Integer>{

	ServicePlaces save(ServicePlacesDto serviceP);
	@Query(value = "SELECT sp.Id,sp.service_Places ,cust.id "
			+ "FROM Restorant as r INNER JOIN User as cust ON r.idRestorant = restorant_users.idRest AND cust.id = restorant_users.userId "
			+ "INNER JOIN ServicePlaces as sp ON r.idRestorant = sp.service_idR"
			+ "WHERE cust.id = ? and r.idRestorant =: ?", nativeQuery = true)

	ServicePlaces getRestorantPServices(Integer custId, Integer restorantId);

}

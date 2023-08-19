package com.project.demo.sushiCo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import com.project.demo.sushiCo.domain.dto.ServicePlacesDto;
import com.project.demo.sushiCo.entity.ServicePlaces;

@Service
public interface ServicePlacesRepository extends JpaRepository<ServicePlaces, Integer>{

	ServicePlaces save(ServicePlacesDto serviceP);
	
	@Query(value = " SELECT sp.service_Places "
			+ " FROM Restorant as r INNER JOIN ServicePlaces as sp ON r.idRestorant = sp.service_idR "
			+ " WHERE r.idRestorant =: ? ", nativeQuery = true)
	List<ServicePlaces> getRestorantPServices(Integer idRestorant);

	
	@Query("Select sp.Id , r.idRestorant From ServicePlaces sp INNER JOIN Restorant r ON r.sp.service_idR = r.idRestorant")
	ServicePlaces getService_PlacesById(Integer Id, Integer idRestorant);
	
	@Query("Delete From ServicePlaces sp INNER JOIN Restorant r ON r.sp.service_idR = r.idRestorant "
	+ " Where sp.Id =: ?1 And r.idRestorant =: ?2 ")
	void delete(Integer id, Integer idRestorant);
	
	
}

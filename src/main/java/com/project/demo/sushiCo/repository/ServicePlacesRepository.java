package com.project.demo.sushiCo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.project.demo.sushiCo.domain.dto.ServicePlacesDto;
import com.project.demo.sushiCo.entity.ServicePlaces;
import jakarta.validation.Valid;

@Repository
public interface ServicePlacesRepository extends JpaRepository<ServicePlaces, Integer> {

	ServicePlaces save(ServicePlacesDto serviceP);

	@Query(value = " SELECT sp.service_Places , sp.shippingCost  "
			+ " FROM Restorant as r INNER JOIN ServicePlaces as sp ON r.idRestorant = sp.service_idR "
			+ " WHERE r.idRestorant =: ? ", nativeQuery = true)
	List<ServicePlaces> getRestorantPServices(Integer idRestorant);

	@Query(" Select sp.Id , r.idRestorant From ServicePlaces sp INNER JOIN Restorant r ON r.sp.service_idR = r.idRestorant  "
			+ " Where sp.Id =: ?1 And r.idRestorant =: ?2 ")
	ServicePlaces getService_PlacesById(Integer Id, Integer idRestorant);

	@Query(" Delete From ServicePlaces sp INNER JOIN Restorant r ON r.sp.service_idR = r.idRestorant "
			+ " Where sp.Id =: ?1 And r.idRestorant =: ?2 ")
	void delete(Integer id, Integer idRestorant);

	@Modifying
	@Query(" Update ServicePlaces  Set sp.service_Places= :?1 , sp.shippingCost= :?2 Where EXISTS "
			+ " ( Select sp.id , r.idRestorant From Restorant r  "
			+ " Where r.idRestorant =: idRestorant And r.sp.service_idR = r.idRestorant	)"
            + " From ServicePlaces sp Where sp.id=:id")
	ServicePlaces update(Integer idRestorant, Integer id, @Valid ServicePlacesDto placesDto);

}

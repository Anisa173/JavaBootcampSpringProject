package com.project.demo.sushiCo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import com.project.demo.sushiCo.domain.dto.RestorantDto;
import com.project.demo.sushiCo.domain.dto.SelectWhichYouPreferFormDto;
import com.project.demo.sushiCo.entity.Restorant;
import com.project.demo.sushiCo.service.SelectWhichYouPreferForm;

import jakarta.validation.Valid;

public interface RestorantRepository extends JpaRepository<Restorant, Integer> {

	Restorant save(RestorantDto restorant);

	@Query(" Select r From Restorant r INNER JOIN User aw ON aw.r.adminIdWeb = aw.id "
			+ " Where r.idRestorant =: idRestorant And aw.adminIdWeb =: adminIdWeb ")
	Restorant getRestorantsById(Integer idRestorant,Integer adminIdWeb);

	@Modifying
	@Query("Update Restorant  Set deleted = true Where r.idRestorant =: ?1 And aw.adminIdWeb =: ?2 "
	        +" From Restorant r "
			+ " Where aw.id IN "
			+ " (Select aw.adminIdWeb  From Restorant r INNER JOIN User aw ON aw.r.adminIdWeb = aw.id ) ")
	void delete(Integer idRestorant, Integer adminIdWeb);
	
	@Query(" Select r.restName  From  User c INNER JOIN Restorant r ON r.c.id = restorant_users.userId AND r.idRestorant = restorant_users.idRest "
		+ " INNER JOIN  User a ON  a.r.adminRId = a.id " + " Where r.idRestorant = :idRestorant And  c.id =: id ")
	SelectWhichYouPreferForm getCustomerRestorantById(Integer userId, Integer idRestorant);

	SelectWhichYouPreferForm save(SelectWhichYouPreferFormDto restorantSelect);

	@Query(" Select r.restname From Restorant r INNER JOIN User aw ON aw.r.adminIdWeb = aw.id "
			+ "	 Where r.idRestorant = :idRestorant ")
	SelectWhichYouPreferForm getRestorantById1(Integer idRestorant);

	SelectWhichYouPreferForm save(SelectWhichYouPreferForm selectR);

	@Query("Update SelectWhichYouPreferForm sR Set sR.rest =: rest Where idSelect =: idSelect ")
	SelectWhichYouPreferForm updateRprefered(@Valid SelectWhichYouPreferFormDto selectRPreference , Integer idSelect);

	@Query("Select r.phoneNo,r.address,r.activity_field ,pm.payment_Method,sp.service_Places,sp.shippingCost Shipping_Cost"
			+ " From Restorant r INNER JOIN PaymentMethods pm ON r.idRestorant = r.pm.paymentId "
			+ " INNER JOIN ServicePlaces sp ON  r.idRestorant = r.sp.service_idR "
			+ " Where r.idRestorant =: idRestorant ")
	Restorant getRestorantDetails(Integer idRestorant);

}

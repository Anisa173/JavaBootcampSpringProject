package com.project.demo.sushiCo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import com.project.demo.sushiCo.domain.dto.RestorantDto;
import com.project.demo.sushiCo.domain.dto.SelectWhichYouPreferFormDto;
import com.project.demo.sushiCo.entity.Restorant;
import com.project.demo.sushiCo.service.SelectWhichYouPreferForm;

public interface RestorantRepository extends JpaRepository<Restorant, Integer> {

	Restorant save(RestorantDto restorant);

	@Query(" Select r.idRestorant,aw.adminIdWeb " + " From Restorant r INNER JOIN User aw ON aw.r.adminIdWeb = aw.id "
			+ " Where r.idRestorant =: idRestorant And aw.adminIdWeb =: adminIdWeb ")

	Restorant getRestorantsById(Integer id, Integer adminIdWeb);

	@Modifying
	@Query(" Select r.idRestorant, aw.adminIdWeb  From Restorant r INNER JOIN User aw ON aw.r.adminIdWeb = aw.id "
			+ " Where aw.id IN "
			+ " ( Update Restorant r Set deleted = true Where r.idRestorant =: ?1 And aw.adminIdWeb =: ?2 ) ")
	void delete(Integer idRestorant, Integer adminIdWeb);

	@Query("Select c.id , r.idRestorant  From User c INNER JOIN Restorant r ON r.c.id = restorant_users.userId AND r.idRestorant = restorant_users.idRest "
			+ " Where r.idRestorant = : idRestorant And  c.id =: id ")
	SelectWhichYouPreferForm getCustomerRestorantById(Integer id, Integer idRestorant);

	Restorant save(SelectWhichYouPreferFormDto restorantSelect);



}

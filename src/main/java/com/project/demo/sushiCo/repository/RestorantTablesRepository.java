package com.project.demo.sushiCo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import com.project.demo.sushiCo.domain.dto.RestorantTablesDto;
import com.project.demo.sushiCo.entity.RestorantTables;

@Service
public interface RestorantTablesRepository extends JpaRepository<RestorantTables, Integer> {

//Admini i restorantit kerkon te fshije nje rekord qe i perket njerit prej llojeve te tavolinave te restorantit te tij
	@Modifying
	@Query(" Delete From RestorantTables rt INNER JOIN Restorant r ON rt.rtb_id = rt.r.restorant_tbId "
			+ "Where rt.rtb_id =: ?1 and rt.tb_id =: ?2 and rt.r.idRestorant IN  "
			+ "( Select rt.r.idRestorant From r Inner Join User a On a.r.adminRId = a.id Where a.idRestorant =: idRestorant "
			+ " Where a.id =: id )")
	void delete(Integer tableId, Integer rtbId, Integer idRestorant);

	@Query(" Select rt.tb_id , rt.rtb_id , a.id From Restorant r Inner Join RestorantTables rt ON  rt.r.restorant_tbId= rt.rtb_id  "
			+ "INNER JOIN User a ON a.r.adminRId = a.id" + " Where rt.tb_id =: ?1 and rt.rtb_id =: ?2 and a.id =: ?3  ")
	RestorantTables getRestorant_tablesById(Integer tb_id, Integer rtb_id, Integer adminRId);

	RestorantTables save(RestorantTablesDto tables);

	@Query(" Select t.tableName ,t.tableDescription , t.noChairsT , t.noTables From RestorantTables t INNER JOIN Restorant r ON t.r.restorant_tbId = t.rtb_id Where t.rtb_id =: rtb_id  "
			+ " And r.idRestorant IN (Select r.restName From Restorant r INNER JOIN User a ON a.r.adminRId = a.id Where t.rtb_id =: ?1 And a.id =: ?2) ")
	RestorantTables getRestorantTablesDetails(Integer rtb_id, Integer adminRId);

	@Query(" Select t.tableName , t.noTables , t.availableTables , t.lockedTables From RestorantTables t INNER JOIN Restorant r ON t.r.restorant_tbId = t.rtb_id  " 
	+ " INNER JOIN  BookingProcessing bp ON t.rtb_id = t.bp.reservationId  "
	+ "	Where t.rtb_id =: rtb_id And bp.cr_Id =: cr_Id  And r.idRestorant IN  " 
	+ "  ( Select r.idRestorant From Restorant r INNER JOIN User a ON a.r.adminRId = a.id Where t.rtb_id =: ?1 And a.id =: ?2)  ")
	RestorantTables getAlltablesById(Integer rtb_id, Integer cr_Id);

}
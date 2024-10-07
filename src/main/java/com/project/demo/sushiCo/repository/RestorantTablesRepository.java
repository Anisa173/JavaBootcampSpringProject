package com.project.demo.sushiCo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.project.demo.sushiCo.domain.dto.RestorantTablesDto;
import com.project.demo.sushiCo.entity.RestorantTables;

@Repository
public interface RestorantTablesRepository extends JpaRepository<RestorantTables, Integer> {

    //Admini i restorantit kërkon të fshijë një rekord që i përket njërit prej llojeve të tavolinave të restorantit të tij
	@Modifying
	@Query(" Delete From RestorantTables rt INNER JOIN Restorant r ON rt.rtb_id = rt.r.restorant_tbId "
			+ "Where rt.rtb_id =: ?1 and rt.tb_id =: ?2 and rt.r.idRestorant IN  "
			+ "( Select rt.r.idRestorant From Restorant r Inner Join User a On a.r.adminRId = a.id Where a.idRestorant =: idRestorant "
			+ " Where a.id =: id )")
	void delete(Integer tableId, Integer rtbId, Integer idRestorant);

	@Query(" Select rt.tb_id , rt.rtb_id , a.id From RestorantTables rt INNER JOIN Restorant r ON  rt.rtb_id = rt.r.restorant_tbId  "
			+ "INNER JOIN User a ON a.r.adminRId = a.id" + " Where rt.tb_id =: ?1 and rt.rtb_id =: ?2 and a.id =: ?3 ")
	RestorantTables getRestorant_tablesById(Integer tb_id, Integer rtb_id, Integer adminRId);

	RestorantTables save(RestorantTablesDto tables);

	@Query(" Select t From RestorantTables t INNER JOIN Restorant r "
	        + " ON  t.rtb_id = t.r.restorant_tbId Where t.rtb_id =: rtb_id "
			+ " And r.idRestorant IN (Select  r.idRestorant From Restorant r "
	        + " INNER JOIN User a ON a.r.adminRId = a.id Where  a.id =: ?2) ")
	RestorantTables getRestorantTablesDetails(Integer rtb_id, Integer adminRId);

    @Query("Select rtb From RestorantTable rtb inner join BookingProcessing bp ON rtb.bp.restorant_tbId = rtb.rtb_id"
	       +"Inner join User c ON c.bp.customerId = c.id  Where bp.cR_Id =:cR_Id and  rtb.rtb_id=:rtb_id"  )
    RestorantTables getAlltablesById(Integer rtb_id, Integer cR_Id);

	
}
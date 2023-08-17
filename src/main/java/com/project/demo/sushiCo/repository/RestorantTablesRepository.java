package com.project.demo.sushiCo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.project.demo.sushiCo.domain.dto.RestorantTablesDto;
import com.project.demo.sushiCo.entity.RestorantTables;

@Service
public interface RestorantTablesRepository extends JpaRepository<RestorantTables, Integer> {

//Admini i restorantit kerkon te fshije nje rekord qe i perket njerit prej llojeve te tavolinave te restorantit te tij
	@Query("Delete From RestorantTables rt Inner Join Restorant r ON rt.rtb_id = rt.r.restorant_tbId "
			+ "Where rt.rtb_id =: ?1 and rt.tb_id =: ?2 and rt.r.idRestorant IN  "
			+ "(Select rt.r.idRestorant From r Inner Join User a On a.r.adminRId = a.id Where a.idRestorant =: idRestorant "
			+ " Where a.id =: id )")
	void delete(Integer tableId, Integer rtbId, Integer restorantId);

	@Query(" Select rt.rtb_id , a.id From Restorant r rt Inner Join RestorantTables ON  rt.r.restorant_tbId= rt.rtb_id"
			+ "INNER JOIN User a ON a.r.adminRId = a.id" + "Where rt.rtb_id =: ?1 and a.id =: ?2 ")
	RestorantTables getRestorant_tablesById(Integer id, Integer restorantId);

	RestorantTables save(RestorantTablesDto tables);

}

package com.project.demo.sushiCo.service;

import com.project.demo.sushiCo.domain.dto.RestorantTablesDto;
import jakarta.validation.Valid;

public interface RestorantTablesService {

	void delete(Integer tableId, Integer rtbId, Integer idRestorant)throws Exception;

	RestorantTablesDto registerRestorant_tables(@Valid RegisterRestorantTablesForm registerUserForm) throws Exception;

	RestorantTablesDto create(@Valid RestorantTablesDto placesDto) throws Exception;

	RestorantTablesDto getRestorant_tablesById(Integer tb_id, Integer rtb_id, Integer adminRId) throws Exception;

	RestorantTablesDto update(Integer tb_id, Integer rtb_id, Integer adminRId, @Valid RestorantTablesDto placesDto,@Valid RestorantTablesDto restTdto)
			throws Exception;

	//Klienti perpara se te kryej rezervimin duhet te informohet mbi tavolinat e diponueshme,nr e karrigeve , llojet e eventeve qe zhvillohen ne cilin lloj te tavolinave
	RestorantTablesDto getRestorantTablesDetails(Integer rtb_id, Integer adminRId) throws Exception;


	RestorantTablesDto getAlltablesById(Integer rtb_id, Integer adminRId);
}

package com.project.demo.sushiCo.service;

import java.util.List;

import com.project.demo.sushiCo.domain.dto.RestorantTablesDto;

import jakarta.validation.Valid;

public interface RestorantTablesService {

	void delete(Integer tableId, Integer rtbId, Integer restorantId) throws Exception;
	
	RestorantTablesDto getRestorant_tablesById(Integer Id,Integer restorantId) throws Exception;
	
	List<RestorantTablesDto> getAllRestorant_tables() throws Exception;
	
	RestorantTablesDto registerRestorant_tables(@Valid RegisterRestorantTablesForm registerUserForm,Integer restorantId) throws Exception;
	
	RestorantTablesDto create(@Valid RestorantTablesDto placesDto) throws Exception ;

	RestorantTablesDto update(Integer rtb_id, Integer idRestorant, @Valid RestorantTablesDto placesDto) throws Exception;

	
}

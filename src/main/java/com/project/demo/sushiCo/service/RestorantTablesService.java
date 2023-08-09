package com.project.demo.sushiCo.service;

import com.project.demo.sushiCo.domain.dto.RestorantTablesDto;

import jakarta.validation.Valid;

public interface RestorantTablesService {

	void delete(Integer id) throws Exception;
	
	RestorantTablesDto getRestorant_tablesById(Integer Id) throws Exception;
	
	RestorantTablesDto getAllRestorant_tables() throws Exception;
	
	RestorantTablesDto registerRestorant_tables(@Valid RegisterRestorantTablesForm registerUserForm) throws Exception;
	
	RestorantTablesDto create(@Valid RestorantTablesDto placesDto) throws Exception ;
	
	RestorantTablesDto update(Integer Id,@Valid RestorantTablesDto placesDto);
}

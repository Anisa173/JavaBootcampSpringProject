package com.project.demo.sushiCo.service;

import com.project.demo.sushiCo.domain.dto.Restorant_tablesDto;

import jakarta.validation.Valid;

public interface Restorant_tablesService {

	void delete(Integer id) throws Exception;
	
	Restorant_tablesDto getRestorant_tablesById(Integer Id) throws Exception;
	
	Restorant_tablesDto getAllRestorant_tables() throws Exception;
	
	Restorant_tablesDto registerRestorant_tables(@Valid RegisterRestorant_tablesForm registerUserForm) throws Exception;
	
	Restorant_tablesDto create(@Valid Restorant_tablesDto placesDto) throws Exception ;
	
	Restorant_tablesDto update(Integer Id,@Valid Restorant_tablesDto placesDto);
}

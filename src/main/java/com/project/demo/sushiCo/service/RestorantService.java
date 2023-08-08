package com.project.demo.sushiCo.service;

import com.project.demo.sushiCo.domain.dto.RestorantDto;

import jakarta.validation.Valid;

public interface RestorantService {

	RestorantDto registerRestorant(@Valid RegisterRestorantForm registerForm) throws Exception;

	RestorantDto getRestorantsById(Integer Id) throws Exception;

	RestorantDto getAllRestorants() throws Exception;

	RestorantDto create(@Valid RestorantDto restorantDto) throws Exception;

	RestorantDto update(Integer Id, @Valid RestorantDto restorantDto);

	void delete(Integer id) throws Exception;

}

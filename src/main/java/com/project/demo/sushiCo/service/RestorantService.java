package com.project.demo.sushiCo.service;

import java.util.List;

import com.project.demo.sushiCo.domain.dto.RestorantDto;

import jakarta.validation.Valid;

public interface RestorantService {

	RestorantDto registerRestorant(@Valid RegisterRestorantForm registerForm) throws Exception;

	RestorantDto create(@Valid RestorantDto restorantDto) throws Exception;

	RestorantDto getRestorantsById(Integer idRestorant, Integer adminIdWeb) throws Exception;

	RestorantDto update(Integer idRestorant, Integer adminIdWeb, @Valid RestorantDto restorantDto) throws Exception;

	void delete(Integer idRestorant, Integer adminIdWeb) throws Exception;

	List<RestorantDto> getAllRestorants(Integer adminIdWeb) throws Exception;

}

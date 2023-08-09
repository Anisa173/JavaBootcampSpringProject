package com.project.demo.sushiCo.service;

import java.util.List;

import com.project.demo.sushiCo.domain.dto.RestorantDto;

import jakarta.validation.Valid;

public interface RestorantService {

	RestorantDto registerRestorant(@Valid RegisterRestorantForm registerForm) throws Exception;

	RestorantDto getRestorantsById(Integer Id) throws Exception;

	List<RestorantDto> getAllRestorants() throws Exception;

	RestorantDto create(@Valid RestorantDto restorantDto) throws Exception;

	RestorantDto update(Integer IdRestorant, @Valid RestorantDto restorantDto) throws Exception;

	void delete(Integer id) throws Exception;

}

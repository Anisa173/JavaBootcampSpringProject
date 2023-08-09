package com.project.demo.sushiCo.service;

import java.util.List;

import com.project.demo.sushiCo.domain.dto.RestorantDto;
import com.project.demo.sushiCo.domain.dto.ServicePlacesDto;
import com.project.demo.sushiCo.serviceImpl.RegisterUserForm;

import jakarta.validation.Valid;

public interface AppRestorantService {
	void delete(Integer Id) throws Exception;

	RestorantDto getAppRestorantById(Integer Id) throws Exception;

	List<RestorantDto> getAppRestorants() throws Exception;

	RestorantDto registerRestorant(@Valid RegisterUserForm registerUserForm) throws Exception;

	RestorantDto create(@Valid RestorantDto restorantDto) throws Exception;

	RestorantDto update(Integer Id, @Valid ServicePlacesDto placesDto);
}

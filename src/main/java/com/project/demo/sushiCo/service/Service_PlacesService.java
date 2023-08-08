package com.project.demo.sushiCo.service;

import com.project.demo.sushiCo.domain.dto.Service_PlacesDto;

import jakarta.validation.Valid;

public interface Service_PlacesService {

	void delete(Integer id) throws Exception;

	Service_PlacesDto getService_PlacesById(Integer Id) throws Exception;

	Service_PlacesDto getAllService_Places() throws Exception;

	Service_PlacesDto registerPlaces(@Valid RegisterRegisterPlacesForm registerForm) throws Exception;

	Service_PlacesDto create(@Valid Service_PlacesDto placesDto) throws Exception;

	Service_PlacesDto update(Integer Id, @Valid Service_PlacesDto placesDto);

}

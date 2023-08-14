package com.project.demo.sushiCo.service;

import java.util.List;

import com.project.demo.sushiCo.domain.dto.ServicePlacesDto;

import jakarta.validation.Valid;

public interface ServicePlacesService {

	void delete(Integer id) throws Exception;

	List<ServicePlacesDto> getAllService_Places() throws Exception;

	ServicePlacesDto registerPlaces(@Valid RegisterRegisterPlacesForm registerForm) throws Exception;

	ServicePlacesDto create(@Valid ServicePlacesDto placesDto) throws Exception;

	ServicePlacesDto update(Integer Id, @Valid ServicePlacesDto placesDto) throws Exception;

	ServicePlacesDto getService_PlacesById(Integer Id) throws Exception;

	

}

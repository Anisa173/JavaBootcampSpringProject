package com.project.demo.sushiCo.service;

import java.util.List;

import com.project.demo.sushiCo.domain.dto.ServicePlacesDto;

import jakarta.validation.Valid;

public interface ServicePlacesService {

	ServicePlacesDto registerPlaces(@Valid RegisterRegisterPlacesForm registerForm) throws Exception;

	ServicePlacesDto create(@Valid ServicePlacesDto placesDto) throws Exception;

	ServicePlacesDto getService_PlacesById(Integer Id, Integer idRestorant) throws Exception;

	ServicePlacesDto update(Integer Id, Integer idRestorant, @Valid ServicePlacesDto placesDto) throws Exception;

	void delete(Integer Id, Integer idRestorant) throws Exception;

	List<ServicePlacesDto> getRestorantPServices(Integer idRestorant) throws Exception;

}

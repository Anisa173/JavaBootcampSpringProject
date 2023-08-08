package com.project.demo.sushiCo.serviceImpl;

import org.springframework.stereotype.Service;

import com.project.demo.sushiCo.domain.dto.Service_PlacesDto;
import com.project.demo.sushiCo.service.RegisterRegisterPlacesForm;
import com.project.demo.sushiCo.service.Service_PlacesService;

import jakarta.validation.Valid;

@Service
public class Service_PlacesServiceImpl implements Service_PlacesService{


	@Override
	public void delete(Integer id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Service_PlacesDto getService_PlacesById(Integer Id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Service_PlacesDto getAllService_Places() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Service_PlacesDto create(@Valid Service_PlacesDto placesDto) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Service_PlacesDto update(Integer Id, @Valid Service_PlacesDto placesDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Service_PlacesDto registerPlaces(@Valid RegisterRegisterPlacesForm registerForm) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}

package com.project.demo.sushiCo.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.demo.sushiCo.domain.dto.RestorantDto;
import com.project.demo.sushiCo.domain.dto.ServicePlacesDto;
import com.project.demo.sushiCo.service.AppRestorantService;

import jakarta.validation.Valid;

@Service
public class AppRestorantServiceImpl implements AppRestorantService {

	@Override
	public void delete(Integer Id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public RestorantDto getAppRestorantById(Integer Id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RestorantDto> getAppRestorants() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RestorantDto registerRestorant(@Valid RegisterUserForm registerUserForm) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RestorantDto create(@Valid RestorantDto restorantDto) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RestorantDto update(Integer Id, @Valid ServicePlacesDto placesDto) {
		// TODO Auto-generated method stub
		return null;
	}

}

package com.project.demo.sushiCo.serviceImpl;

import org.springframework.stereotype.Service;

import com.project.demo.sushiCo.domain.dto.Restorant_tablesDto;
import com.project.demo.sushiCo.service.RegisterRestorant_tablesForm;
import com.project.demo.sushiCo.service.Restorant_tablesService;

import jakarta.validation.Valid;
@Service
public class Restorant_tableServiceImpl implements Restorant_tablesService{

	@Override
	public void delete(Integer id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Restorant_tablesDto getRestorant_tablesById(Integer Id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Restorant_tablesDto getAllRestorant_tables() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Restorant_tablesDto registerRestorant_tables(@Valid RegisterRestorant_tablesForm registerUserForm)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Restorant_tablesDto create(@Valid Restorant_tablesDto placesDto) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Restorant_tablesDto update(Integer Id, @Valid Restorant_tablesDto placesDto) {
		// TODO Auto-generated method stub
		return null;
	}

	

	
	

}

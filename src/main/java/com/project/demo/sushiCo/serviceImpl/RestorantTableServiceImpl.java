package com.project.demo.sushiCo.serviceImpl;

import org.springframework.stereotype.Service;

import com.project.demo.sushiCo.domain.dto.RestorantTablesDto;
import com.project.demo.sushiCo.service.RegisterRestorantTablesForm;
import com.project.demo.sushiCo.service.RestorantTablesService;

import jakarta.validation.Valid;
@Service
public class RestorantTableServiceImpl implements RestorantTablesService{

	@Override
	public void delete(Integer id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public RestorantTablesDto getRestorant_tablesById(Integer Id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RestorantTablesDto getAllRestorant_tables() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RestorantTablesDto registerRestorant_tables(@Valid RegisterRestorantTablesForm registerUserForm)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RestorantTablesDto create(@Valid RestorantTablesDto placesDto) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RestorantTablesDto update(Integer Id, @Valid RestorantTablesDto placesDto) {
		// TODO Auto-generated method stub
		return null;
	}

	

	
	

}

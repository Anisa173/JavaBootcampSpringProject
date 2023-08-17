package com.project.demo.sushiCo.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.demo.sushiCo.domain.dto.RestorantTablesDto;
import com.project.demo.sushiCo.domain.mappers.RestorantTableMapper;
import com.project.demo.sushiCo.repository.RestorantTablesRepository;
import com.project.demo.sushiCo.service.RegisterRestorantTablesForm;
import com.project.demo.sushiCo.service.RestorantTablesService;

import jakarta.validation.Valid;

@Service
public class RestorantTableServiceImpl implements RestorantTablesService {

	@Autowired
	private final RestorantTablesRepository restorantTbRepository;
	private final RestorantTableMapper restorantTableMapper;

	public RestorantTableServiceImpl(RestorantTablesRepository restorantTbRepository,
			RestorantTableMapper restorantTableMapper) {
		this.restorantTbRepository = restorantTbRepository;
		this.restorantTableMapper = restorantTableMapper;
	}

	@Override
	public void delete(Integer tableId, Integer rtbId, Integer restorantId) throws Exception {

		restorantTbRepository.delete(tableId, rtbId, restorantId);
	}

	@Override
	public List<RestorantTablesDto> getAllRestorant_tables() throws Exception {

		return restorantTbRepository.findAll().stream().map(c -> restorantTableMapper.toDto(c))
				.collect(Collectors.toList());
	}

	@Override
	public RestorantTablesDto getRestorant_tablesById(Integer rtb_id, Integer idRestorant) throws Exception {

		return restorantTableMapper.toDto(restorantTbRepository.getRestorant_tablesById(rtb_id, idRestorant));
	}

	@Override
	public RestorantTablesDto registerRestorant_tables(@Valid RegisterRestorantTablesForm registerUserForm,
			Integer restorantId) throws Exception {
		var tables = getRestorant_tablesById(registerUserForm.getId(), registerUserForm.getIdRestorant());
		tables.setTableName(registerUserForm.getTableName());
		tables.setNoTables(registerUserForm.getNoTables());
		tables.setNoChairsT(registerUserForm.getNoChairsT());
		tables.setTableDescription(registerUserForm.getTableDescription());
		return restorantTableMapper.toDto(restorantTbRepository.save(tables));
	}

	@Override
	public RestorantTablesDto create(@Valid RestorantTablesDto placesDto) throws Exception {
		var result = restorantTableMapper.toEntity(placesDto);
		return restorantTableMapper.toDto(restorantTbRepository.save(result));
	}

	@Override
	public RestorantTablesDto update(Integer rtb_id, Integer idRestorant, @Valid RestorantTablesDto placesDto)
			throws Exception {
		var result = restorantTableMapper.toEntity(getRestorant_tablesById(rtb_id, idRestorant));
		var upToDate = restorantTableMapper.toUpdate(placesDto, result);
		return restorantTableMapper.toDto(restorantTbRepository.save(upToDate));
	}

}

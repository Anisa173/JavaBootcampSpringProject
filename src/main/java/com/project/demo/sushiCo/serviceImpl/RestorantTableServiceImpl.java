package com.project.demo.sushiCo.serviceImpl;

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
	public void delete(Integer tableId, Integer rtbId, Integer idRestorant) throws Exception {

		restorantTbRepository.delete(tableId, rtbId, idRestorant);
	}

	@Override
	public RestorantTablesDto getAlltablesById(Integer rtb_id, Integer adminRId) throws Exception {

		return restorantTableMapper.toDto(restorantTbRepository.getAlltablesById(rtb_id, adminRId));
	}

	@Override
	public RestorantTablesDto getRestorant_tablesById(Integer tb_id, Integer rtb_id, Integer adminRId)
			throws Exception {

		return restorantTableMapper.toDto(restorantTbRepository.getRestorant_tablesById(tb_id, rtb_id, adminRId));
	}

	@Override
	public RestorantTablesDto registerRestorant_tables(@Valid RegisterRestorantTablesForm registerUserForm)
			throws Exception {
		var tables = getRestorant_tablesById(registerUserForm.getRtb_id(), registerUserForm.getTb_id(),
				registerUserForm.getAdminRId());
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
	public RestorantTablesDto update(Integer tb_id, Integer rtb_id, Integer adminRId,
			@Valid RestorantTablesDto placesDto) throws Exception {
		var result = restorantTableMapper.toEntity(getRestorant_tablesById(tb_id, rtb_id, adminRId));
		var upToDate = restorantTableMapper.toUpdate(placesDto, result);
		return restorantTableMapper.toDto(restorantTbRepository.save(upToDate));
	}

}

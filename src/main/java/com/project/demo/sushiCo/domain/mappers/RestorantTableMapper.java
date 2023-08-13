package com.project.demo.sushiCo.domain.mappers;

import org.springframework.stereotype.Component;

import com.project.demo.sushiCo.domain.dto.RestorantTablesDto;
import com.project.demo.sushiCo.entity.RestorantTables;
@Component
public class RestorantTableMapper extends BaseMapper<RestorantTables, RestorantTablesDto> {

	@Override
	public RestorantTables toEntity(RestorantTablesDto dto) {
		RestorantTables tables = new RestorantTables();
		tables.setRtb_id(dto.getRtb_id());
		tables.setTb_id(dto.getTb_id());
		tables.setTableName(dto.getTableName());
		tables.setAvailableTables(dto.getAvailableTables());
		tables.setUnAvailableTables(dto.getUnAvailableTables());
		tables.setTableDescription(dto.getTableDescription());
		return tables;
	}

	@Override
	public RestorantTablesDto toDto(RestorantTables entity) {
		RestorantTablesDto dto = new RestorantTablesDto();
		dto.setRtb_id(entity.getId());
		dto.setTb_id(entity.getTb_id());
		dto.setTableName(entity.getTableName());
		dto.setAvailableTables(entity.getAvailableTables());
		dto.setUnAvailableTables(entity.getUnAvailableTables());
		dto.setTableDescription(entity.getTableDescription());
		dto.setReservationId(entity.getReservation().getId());
		var reservationDescription = entity.getReservation().getReservationDescription();
		dto.setReservationDescription(reservationDescription);
		
		dto.setARest(entity.getARest());
		
		return dto;
	}
	@Override
	public RestorantTables toUpdate(RestorantTablesDto dto, RestorantTables entity) {
		entity.setRtb_id(dto.getRtb_id());
		entity.setTb_id(dto.getTb_id());
		entity.setTableName(dto.getTableName());
		dto.setAvailableTables(entity.getAvailableTables());
		dto.setUnAvailableTables(entity.getUnAvailableTables());
		dto.setTableDescription(entity.getTableDescription());
		return entity;
	}

}




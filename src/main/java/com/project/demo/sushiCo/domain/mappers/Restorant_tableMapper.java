package com.project.demo.sushiCo.domain.mappers;

import com.project.demo.sushiCo.domain.dto.Restorant_tablesDto;
import com.project.demo.sushiCo.entity.Restorant_tables;

public class Restorant_tableMapper extends BaseMapper<Restorant_tables, Restorant_tablesDto> {

	@Override
	public Restorant_tables toEntity(Restorant_tablesDto dto) {
		Restorant_tables tables = new Restorant_tables();
		tables.setRtb_id(dto.getRtb_id());
		tables.setTb_id(dto.getTb_id());
		tables.setTableName(dto.getTableName());
		tables.setNoChairTable(dto.getNoChairTable());
		tables.setDescription(dto.getDescription());
		tables.setStatus(dto.isStatus());
		return tables;
	}

	@Override
	public Restorant_tablesDto toDto(Restorant_tables entity) {
		Restorant_tablesDto dto = new Restorant_tablesDto();
		dto.setRtb_id(entity.getId());
		dto.setTb_id(entity.getTb_id());
		dto.setTableName(entity.getTableName());
		dto.setNoChairTable(entity.getNoChairTable());
		dto.setDescription(entity.getDescription());
		dto.setStatus(entity.isStatus());
		dto.setReservationId(entity.getReservation().getId());
		var reservationDescription = entity.getReservation().getReservationDescription();
		dto.setReservationDescription(reservationDescription);
		
		dto.setARest(entity.getARest());
		
		return dto;
	}
	@Override
	public Restorant_tables toUpdate(Restorant_tablesDto dto, Restorant_tables entity) {
		entity.setRtb_id(dto.getRtb_id());
		entity.setTb_id(dto.getTb_id());
		entity.setTableName(dto.getTableName());
		entity.setNoChairTable(dto.getNoChairTable());
		entity.setDescription(dto.getDescription());
		entity.setStatus(dto.isStatus());
		return entity;
	}

}




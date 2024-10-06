package com.project.demo.sushiCo.domain.mappers;

import com.project.demo.sushiCo.domain.dto.Package_OrderedDto;
import com.project.demo.sushiCo.entity.Package_Ordered;

public class Packaged_OrderedMapper extends BaseMapper<Package_Ordered, Package_OrderedDto> {

	@Override
	public Package_Ordered toEntity(Package_OrderedDto dto) {
		Package_Ordered ordered = new Package_Ordered();
		ordered.setId(dto.getId());
		ordered.setStatusOrderSession(dto.getStatusOrderSession());
		ordered.setSessionPayment(dto.getSessionPayment());
		return ordered;
	}

	@Override
	public Package_OrderedDto toDto(Package_Ordered entity) {
		Package_OrderedDto orderedDto = new Package_OrderedDto();
		orderedDto.setId(entity.getId());
		orderedDto.setStatusOrderSession(entity.getStatusOrderSession());
		orderedDto.setSessionPayment(entity.getSessionPayment());
		orderedDto.setShippersId(entity.getUser().getId());
		var shippersName = entity.getUser().getFirst_name().concat(" ").concat(entity.getUser().getLast_name());
		orderedDto.setShippersName(shippersName);
		var totalOrd = entity.getOrd().stream().count();
		orderedDto.setTotalOrd(totalOrd);
		orderedDto.setServiceId(entity.getServiceP().getId());
		var servicePlaces = entity.getServiceP().getService_Places();
		orderedDto.setServicePlaces(servicePlaces);

		return orderedDto;
	}

	@Override
	public Package_Ordered toUpdate(Package_OrderedDto dto, Package_Ordered entity) {
		entity.setId(dto.getId());
		entity.setStatusOrderSession(dto.getStatusOrderSession());
		entity.setSessionPayment(dto.getSessionPayment());

		return entity;
	}
}

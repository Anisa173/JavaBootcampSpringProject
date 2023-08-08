package com.project.demo.sushiCo.domain.mappers;

import org.springframework.stereotype.Component;

import com.project.demo.sushiCo.domain.dto.Package_OrderedDto;
import com.project.demo.sushiCo.entity.PackageOrdered;
@Component
public class Packaged_OrderedMapper extends BaseMapper<PackageOrdered, Package_OrderedDto> {

	@Override
	public PackageOrdered toEntity(Package_OrderedDto dto) {
		PackageOrdered ordered = new PackageOrdered();
		ordered.setId(dto.getId());
		ordered.setStatusOrderSession(dto.getStatusOrderSession());
		ordered.setSessionPayment(dto.getSessionPayment());
		return ordered;
	}

	@Override
	public Package_OrderedDto toDto(PackageOrdered entity) {
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
	public PackageOrdered toUpdate(Package_OrderedDto dto, PackageOrdered entity) {
		entity.setId(dto.getId());
		entity.setStatusOrderSession(dto.getStatusOrderSession());
		entity.setSessionPayment(dto.getSessionPayment());

		return entity;
	}
}

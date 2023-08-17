package com.project.demo.sushiCo.domain.mappers;

import java.util.List;

import org.springframework.stereotype.Component;

import com.project.demo.sushiCo.domain.dto.PackageOrderedDto;
import com.project.demo.sushiCo.entity.PackageOrdered;
@Component
public class PackagedOrderedMapper extends BaseMapper<PackageOrdered, PackageOrderedDto> {

	@Override
	public PackageOrdered toEntity(PackageOrderedDto dto) {
		PackageOrdered ordered = new PackageOrdered();
		ordered.setId(dto.getId());
		ordered.setStatusOrderSession(dto.getStatusOrderSession());
		ordered.setSessionPayment(dto.getSessionPayment());
		return ordered;
	}

	@Override
	public PackageOrderedDto toDto(PackageOrdered entity) {
		PackageOrderedDto orderedDto = new PackageOrderedDto();
		orderedDto.setId(entity.getId());
		orderedDto.setStatusOrderSession(entity.getStatusOrderSession());
		orderedDto.setSessionPayment(entity.getSessionPayment());
		orderedDto.setShippersId(entity.getUser().getId());
		var shippersName = entity.getUser().getFirst_name().concat(" ").concat(entity.getUser().getLast_name());
		orderedDto.setShippersName(shippersName);
		var totalOrd = entity.getOrd().stream().count();
		orderedDto.setTotalOrd(totalOrd);
		orderedDto.setServiceId(entity.getServicePlaces().getId());
		var servicePlaces = entity.getServicePlaces().getService_Places();
		orderedDto.setServicePlaces(servicePlaces);

		return orderedDto;
	}

	@Override
	public PackageOrdered toUpdate(PackageOrderedDto dto, PackageOrdered entity) {
		entity.setId(dto.getId());
		entity.setStatusOrderSession(dto.getStatusOrderSession());
		entity.setSessionPayment(dto.getSessionPayment());

		return entity;
	}

	@Override
	public List<PackageOrdered> toEntity(List<PackageOrderedDto> dtoList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PackageOrderedDto> toDto(List<PackageOrdered> entityList) {
		// TODO Auto-generated method stub
		return null;
	}
}

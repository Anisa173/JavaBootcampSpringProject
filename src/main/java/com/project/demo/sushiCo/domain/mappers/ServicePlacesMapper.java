package com.project.demo.sushiCo.domain.mappers;

import org.springframework.stereotype.Component;

import com.project.demo.sushiCo.domain.dto.ServicePlacesDto;
import com.project.demo.sushiCo.entity.ServicePlaces;
@Component
public class ServicePlacesMapper extends BaseMapper<ServicePlaces, ServicePlacesDto> {

	@Override
	public ServicePlaces toEntity(ServicePlacesDto dto) {

		ServicePlaces serviceP = new ServicePlaces();
		serviceP.setId(dto.getId());
		serviceP.setService_Places(dto.getService_Places());
		serviceP.setShippingCost(dto.getShippingCost());
		return serviceP;
	}

	@Override
	public ServicePlacesDto toDto(ServicePlaces entity) {
		var servicePdto = new ServicePlacesDto();
		servicePdto.setId(entity.getId());
		servicePdto.setService_Places(entity.getService_Places());
		servicePdto.setShippingCost(entity.getShippingCost());
		var totalPackaged_Ordered = entity.getPckO().stream().count();
		servicePdto.setTotalPackaged_Ordered(totalPackaged_Ordered);
		servicePdto.setService_id(entity.getRestorantService().getId());
		var restName = entity.getRestorantService().getRestName();
		servicePdto.setRestName(restName);

		return servicePdto;
	}

	@Override
	public ServicePlaces toUpdate(ServicePlacesDto dto, ServicePlaces entity) {
		entity.setId(dto.getId());
		entity.setService_Places(dto.getService_Places());
		entity.setShippingCost(dto.getShippingCost());
		return entity;
	}

}




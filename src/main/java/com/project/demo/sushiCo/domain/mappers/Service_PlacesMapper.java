package com.project.demo.sushiCo.domain.mappers;

import org.springframework.stereotype.Component;

import com.project.demo.sushiCo.domain.dto.Service_PlacesDto;
import com.project.demo.sushiCo.entity.ServicePlaces;
@Component
public class Service_PlacesMapper extends BaseMapper<ServicePlaces, Service_PlacesDto> {

	@Override
	public ServicePlaces toEntity(Service_PlacesDto dto) {

		ServicePlaces serviceP = new ServicePlaces();
		serviceP.setId(dto.getId());
		serviceP.setService_Places(dto.getService_Places());
		serviceP.setShippingCost(dto.getShippingCost());
		return serviceP;
	}

	@Override
	public Service_PlacesDto toDto(ServicePlaces entity) {
		var servicePdto = new Service_PlacesDto();
		servicePdto.setId(entity.getId());
		servicePdto.setService_Places(entity.getService_Places());
		servicePdto.setShippingCost(entity.getShippingCost());
		var totalPackaged_Ordered = entity.getPckO().stream().count();
		servicePdto.setTotalPackaged_Ordered(totalPackaged_Ordered);
		servicePdto.setService_idApp(entity.getAppRest().getId());
		var restName = entity.getAppRest().getRestName();
		servicePdto.setRestName(restName);

		return servicePdto;
	}

	@Override
	public ServicePlaces toUpdate(Service_PlacesDto dto, ServicePlaces entity) {
		entity.setId(dto.getId());
		entity.setService_Places(dto.getService_Places());
		entity.setShippingCost(dto.getShippingCost());
		return entity;
	}

}




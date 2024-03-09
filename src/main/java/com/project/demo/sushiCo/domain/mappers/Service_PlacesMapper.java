package com.project.demo.sushiCo.domain.mappers;

import com.project.demo.sushiCo.domain.dto.Service_PlacesDto;
import com.project.demo.sushiCo.entity.Service_Places;

public class Service_PlacesMapper extends BaseMapper<Service_Places, Service_PlacesDto> {

	@Override
	public Service_Places toEntity(Service_PlacesDto dto) {

		Service_Places serviceP = new Service_Places();
		serviceP.setId(dto.getId());
		serviceP.setService_Places(dto.getService_Places());
		serviceP.setShippingCost(dto.getShippingCost());
		return serviceP;
	}

	@Override
	public Service_PlacesDto toDto(Service_Places entity) {
		var servicePdto = new Service_PlacesDto();
		servicePdto.setId(entity.getId());
		servicePdto.setService_Places(entity.getService_Places());
		servicePdto.setShippingCost(entity.getShippingCost());
		var totalPackaged_Ordered = entity.getPckO().stream().count();
		servicePdto.setTotalPackaged_Ordered(totalPackaged_Ordered);
		servicePdto.setService_idApp(entity.getAppRest().getId());
		var appName = entity.getAppRest().getAppName();
		servicePdto.setAppName(appName);

		return servicePdto;
	}

	@Override
	public Service_Places toUpdate(Service_PlacesDto dto, Service_Places entity) {
		entity.setId(dto.getId());
		entity.setService_Places(dto.getService_Places());
		entity.setShippingCost(dto.getShippingCost());
		return entity;
	}

}




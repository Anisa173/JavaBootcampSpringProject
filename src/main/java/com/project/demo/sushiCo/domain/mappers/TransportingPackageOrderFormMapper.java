package com.project.demo.sushiCo.domain.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.project.demo.sushiCo.domain.dto.TransportingPackageOrderFormDto;
import com.project.demo.sushiCo.service.TransportingPackageOrderForm;

@Component
public class TransportingPackageOrderFormMapper extends BaseMapper<TransportingPackageOrderForm, TransportingPackageOrderFormDto> {

	@Override
	public TransportingPackageOrderForm toEntity(TransportingPackageOrderFormDto dto) {
		TransportingPackageOrderForm shpkg = new TransportingPackageOrderForm();
		shpkg.setRegistrationId(dto.getRegistrationId());
		shpkg.setCustomerName_Surname(dto.getCustomerName_Surname());
		shpkg.setCustomerAddress(dto.getCustomerAddress());
		shpkg.setShippersName_Surname(dto.getShippersName_Surname());
		shpkg.setNoPhoneCustomer(dto.getNoPhoneCustomer());
		shpkg.setOrders(dto.getOrders());
		shpkg.setServicePl(dto.getServicePl());
		shpkg.setSessionPayment(dto.getSessionPayment());
		return shpkg;
	}

	@Override
	public TransportingPackageOrderFormDto toDto(TransportingPackageOrderForm entity) {
		TransportingPackageOrderFormDto shpkg = new TransportingPackageOrderFormDto();
		shpkg.setRegistrationId(entity.getId());
		shpkg.setCustomerName_Surname(entity.getCustomerName_Surname());
		shpkg.setCustomerAddress(entity.getCustomerAddress());
		shpkg.setShippersName_Surname(entity.getShippersName_Surname());
		shpkg.setNoPhoneCustomer(entity.getNoPhoneCustomer());
		shpkg.setOrders(entity.getOrders());
		shpkg.setServicePl(entity.getServicePl());
		shpkg.setSessionPayment(entity.getSessionPayment());
		return shpkg;
	}

	@Override
	public TransportingPackageOrderForm toUpdate(TransportingPackageOrderFormDto dto, TransportingPackageOrderForm entity) {
		entity.setCustomerName_Surname(dto.getCustomerName_Surname());
		entity.setShippersName_Surname(dto.getShippersName_Surname());
		entity.setCustomerAddress(dto.getCustomerAddress());
		entity.setOrders(dto.getOrders());
		entity.setServicePl(dto.getServicePl());
		return entity;
	}

	@Override
	public List<TransportingPackageOrderForm> toEntity(List<TransportingPackageOrderFormDto> dtoList) {
		if (dtoList == null) {
			return null;
		}

		List<TransportingPackageOrderForm> list = new ArrayList<TransportingPackageOrderForm>(dtoList.size());
		for (TransportingPackageOrderFormDto shPkgDto : dtoList) {
			list.add(toEntity(shPkgDto));
		}

		return list;

	}

	@Override
	public List<TransportingPackageOrderFormDto> toDto(List<TransportingPackageOrderForm> entityList) {
		if (entityList == null) {
			return null;
		}

		List<TransportingPackageOrderFormDto> list = new ArrayList<TransportingPackageOrderFormDto>(entityList.size());
		for (TransportingPackageOrderForm shPOf : entityList) {
			list.add(toDto(shPOf));
		}

		return list;
	}

}

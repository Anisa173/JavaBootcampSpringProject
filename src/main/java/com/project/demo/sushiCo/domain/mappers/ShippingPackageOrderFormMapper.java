package com.project.demo.sushiCo.domain.mappers;

import java.util.ArrayList;
import java.util.List;
import com.project.demo.sushiCo.domain.dto.ShippingPackageOrderFormDto;
import com.project.demo.sushiCo.service.ShippingPackageOrderForm;

public class ShippingPackageOrderFormMapper extends BaseMapper<ShippingPackageOrderForm, ShippingPackageOrderFormDto> {

	@Override
	public ShippingPackageOrderForm toEntity(ShippingPackageOrderFormDto dto) {
		ShippingPackageOrderForm shpkg = new ShippingPackageOrderForm();
		shpkg.setRegistrationId(dto.getRegistrationId());
		shpkg.setCustomerName(dto.getCustomerName());
		shpkg.setCustomerAddress(dto.getCustomerAddress());
		shpkg.setOrders(dto.getOrders());
		shpkg.setSessionPayment(dto.getSessionPayment());
		return shpkg;
	}

	@Override
	public ShippingPackageOrderFormDto toDto(ShippingPackageOrderForm entity) {
		ShippingPackageOrderFormDto shpkg = new ShippingPackageOrderFormDto();
		shpkg.setRegistrationId(entity.getId());
		shpkg.setCustomerName(entity.getCustomerName());
		shpkg.setCustomerAddress(entity.getCustomerAddress());
		shpkg.setOrders(entity.getOrders());
		shpkg.setSessionPayment(entity.getSessionPayment());
		return shpkg;
	}

	@Override
	public ShippingPackageOrderForm toUpdate(ShippingPackageOrderFormDto dto, ShippingPackageOrderForm entity) {
		entity.setCustomerName(dto.getCustomerName());
		entity.setCustomerAddress(dto.getCustomerAddress());
		entity.setOrders(dto.getOrders());
		return entity;
	}

	@Override
	public List<ShippingPackageOrderForm> toEntity(List<ShippingPackageOrderFormDto> dtoList) {
		if (dtoList == null) {
			return null;
		}

		List<ShippingPackageOrderForm> list = new ArrayList<ShippingPackageOrderForm>(dtoList.size());
		for (ShippingPackageOrderFormDto shPkgDto : dtoList) {
			list.add(toEntity(shPkgDto));
		}

		return list;

	}

	@Override
	public List<ShippingPackageOrderFormDto> toDto(List<ShippingPackageOrderForm> entityList) {
		if (entityList == null) {
			return null;
		}

		List<ShippingPackageOrderFormDto> list = new ArrayList<ShippingPackageOrderFormDto>(entityList.size());
		for (ShippingPackageOrderForm shPOf : entityList) {
			list.add(toDto(shPOf));
		}

		return list;
	}

}

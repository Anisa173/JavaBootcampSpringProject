package com.project.demo.sushiCo.domain.mappers;

import com.project.demo.sushiCo.domain.dto.Payment_MethodsDto;
import com.project.demo.sushiCo.entity.Payment_Methods;

public class Payment_MethodsMapper extends BaseMapper<Payment_Methods, Payment_MethodsDto>{

	@Override
	public Payment_Methods toEntity(Payment_MethodsDto dto) {
	Payment_Methods methods = new Payment_Methods();	
	methods.setId(dto.getId());
	methods.setPayment_Method(dto.getPayment_Methods());
		return methods;
	}

	@Override
	public Payment_MethodsDto toDto(Payment_Methods entity) {
		Payment_MethodsDto methodsDto = new Payment_MethodsDto();
	methodsDto.setId(entity.getId());	
	methodsDto.setPayment_Methods(entity.getPayment_Method());
	var totalOrders = entity.getOrders().stream().count();
	methodsDto.setTotalOrders(totalOrders);
	methodsDto.setPaymentIdApp(entity.getAppRest().getId());
	var appName = entity.getAppRest().getAppName();
	methodsDto.setAppName(appName);

		return methodsDto;
	}

	@Override
	public Payment_Methods toUpdate(Payment_MethodsDto dto, Payment_Methods entity) {
		entity.setId(dto.getId());
		entity.setPayment_Method(dto.getPayment_Methods());
		return entity;
	}

}

package com.project.demo.sushiCo.domain.mappers;

import org.springframework.stereotype.Component;

import com.project.demo.sushiCo.domain.dto.Payment_MethodsDto;
import com.project.demo.sushiCo.entity.PaymentMethods;
@Component
public class Payment_MethodsMapper extends BaseMapper<PaymentMethods, Payment_MethodsDto>{

	@Override
	public PaymentMethods toEntity(Payment_MethodsDto dto) {
	PaymentMethods methods = new PaymentMethods();	
	methods.setId(dto.getId());
	methods.setPayment_Method(dto.getPayment_Methods());
		return methods;
	}

	@Override
	public Payment_MethodsDto toDto(PaymentMethods entity) {
		Payment_MethodsDto methodsDto = new Payment_MethodsDto();
	methodsDto.setId(entity.getId());	
	methodsDto.setPayment_Methods(entity.getPayment_Method());
	var totalOrders = entity.getOrders().stream().count();
	methodsDto.setTotalOrders(totalOrders);
	methodsDto.setPaymentIdApp(entity.getAppRest().getId());
	var appName = entity.getAppRest().getRestName();
	methodsDto.setRestName(appName);

		return methodsDto;
	}

	@Override
	public PaymentMethods toUpdate(Payment_MethodsDto dto, PaymentMethods entity) {
		entity.setId(dto.getId());
		entity.setPayment_Method(dto.getPayment_Methods());
		return entity;
	}

}

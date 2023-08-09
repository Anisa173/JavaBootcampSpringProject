package com.project.demo.sushiCo.domain.mappers;

import org.springframework.stereotype.Component;

import com.project.demo.sushiCo.domain.dto.PaymentMethodsDto;
import com.project.demo.sushiCo.entity.PaymentMethods;
@Component
public class PaymentMethodsMapper extends BaseMapper<PaymentMethods, PaymentMethodsDto>{

	@Override
	public PaymentMethods toEntity(PaymentMethodsDto dto) {
	PaymentMethods methods = new PaymentMethods();	
	methods.setId(dto.getId());
	methods.setPayment_Method(dto.getPayment_Method());
		return methods;
	}

	@Override
	public PaymentMethodsDto toDto(PaymentMethods entity) {
		PaymentMethodsDto methodsDto = new PaymentMethodsDto();
	methodsDto.setId(entity.getId());	
	methodsDto.setPayment_Method(entity.getPayment_Method());
	var totalOrders = entity.getOrders().stream().count();
	methodsDto.setTotalOrders(totalOrders);
	methodsDto.setPaymentIdApp(entity.getAppRest().getId());
	var appName = entity.getAppRest().getRestName();
	methodsDto.setRestName(appName);

		return methodsDto;
	}

	@Override
	public PaymentMethods toUpdate(PaymentMethodsDto dto, PaymentMethods entity) {
		entity.setId(dto.getId());
		entity.setPayment_Method(dto.getPayment_Method());
		return entity;
	}

}

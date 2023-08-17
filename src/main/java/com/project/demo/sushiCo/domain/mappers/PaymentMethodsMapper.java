package com.project.demo.sushiCo.domain.mappers;

import java.util.List;

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
	methodsDto.setOrderMethodId(entity.getOrder().getId());
	methodsDto.setPaymentId(entity.getRestorant().getId());
	var restName = entity.getRestorant().getRestName();
	methodsDto.setRestName(restName);

		return methodsDto;
	}

	@Override
	public PaymentMethods toUpdate(PaymentMethodsDto dto, PaymentMethods entity) {
		entity.setId(dto.getId());
		entity.setPayment_Method(dto.getPayment_Method());
		return entity;
	}

	@Override
	public List<PaymentMethods> toEntity(List<PaymentMethodsDto> dtoList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PaymentMethodsDto> toDto(List<PaymentMethods> entityList) {
		// TODO Auto-generated method stub
		return null;
	}

}

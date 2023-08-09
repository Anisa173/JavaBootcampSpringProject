package com.project.demo.sushiCo.service;

import java.util.List;

import com.project.demo.sushiCo.domain.dto.PaymentMethodsDto;

import jakarta.validation.Valid;

public interface PaymentMethodsService {

	void delete(Integer id) throws Exception;
	
	PaymentMethodsDto getPayment_MethodsById(Integer Id) throws Exception;
	
	List<PaymentMethodsDto> getAllPayment_Methods() throws Exception;
	
	PaymentMethodsDto registerMethod_Payment(@Valid RegisterMethodsPaymentForm form) throws Exception;
	
	PaymentMethodsDto create(@Valid PaymentMethodsDto methodsDto) throws Exception;
	
	PaymentMethodsDto update(Integer Id,@Valid PaymentMethodsDto placesDto) throws Exception;

	
}

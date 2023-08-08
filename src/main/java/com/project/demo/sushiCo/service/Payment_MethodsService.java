package com.project.demo.sushiCo.service;

import com.project.demo.sushiCo.domain.dto.Payment_MethodsDto;
import com.project.demo.sushiCo.serviceImpl.RegisterUserForm;

import jakarta.validation.Valid;

public interface Payment_MethodsService {

	void delete(Integer id) throws Exception;
	
	Payment_MethodsDto getPayment_MethodsById(Integer Id) throws Exception;
	
	Payment_MethodsDto getAllPayment_Methods() throws Exception;
	
	Payment_MethodsDto registerMethod_Payment(@Valid RegisterMethods_PaymentForm form) throws Exception;
	
	Payment_MethodsDto create(@Valid Payment_MethodsDto methodsDto) throws Exception;
	
	Payment_MethodsDto update(Integer Id,@Valid Payment_MethodsDto placesDto);

	
}

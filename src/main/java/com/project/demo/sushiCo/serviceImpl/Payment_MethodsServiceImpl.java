package com.project.demo.sushiCo.serviceImpl;

import org.springframework.stereotype.Service;

import com.project.demo.sushiCo.domain.dto.Payment_MethodsDto;
import com.project.demo.sushiCo.service.Payment_MethodsService;
import com.project.demo.sushiCo.service.RegisterMethods_PaymentForm;

import jakarta.validation.Valid;
@Service
public class Payment_MethodsServiceImpl implements Payment_MethodsService{

	@Override
	public void delete(Integer id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Payment_MethodsDto getPayment_MethodsById(Integer Id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Payment_MethodsDto getAllPayment_Methods() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Payment_MethodsDto registerMethod_Payment(@Valid RegisterMethods_PaymentForm form) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Payment_MethodsDto create(@Valid Payment_MethodsDto methodsDto) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Payment_MethodsDto update(Integer Id, @Valid Payment_MethodsDto placesDto) {
		// TODO Auto-generated method stub
		return null;
	}

	

}

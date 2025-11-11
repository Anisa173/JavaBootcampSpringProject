package com.project.demo.sushiCo.service;

import java.util.List;
import com.project.demo.sushiCo.domain.dto.PaymentMethodsDto;
import jakarta.validation.Valid;

public interface PaymentMethodsService {

	public List<PaymentMethodsDto> getAllPayment_Methods(Integer idRestorant) throws Exception;

	public PaymentMethodsDto registerMethod_Payment(@Valid RegisterMethodsPaymentForm form) throws Exception;

	public PaymentMethodsDto create(@Valid PaymentMethodsDto methodsDto) throws Exception;

	public PaymentMethodsDto getPayment_MethodsById(Integer Id, Integer idRestorant) throws Exception;

	public List<PaymentMethodsDto> getRestorantPMethods(Integer restorantId) throws Exception;

	public void delete(Integer Id, Integer idRestorant) throws Exception;

	public PaymentMethodsDto update(@Valid PaymentMethodsDto paymentDto, Integer Id, Integer idRestorant) throws Exception;

	//PaymentMethodsDto update(Integer Id, Integer idRestorant, @Valid PaymentMethodsDto placesDto) throws Exception;

	

	

	
	
}

package com.project.demo.sushiCo.service;

import java.util.List;
import com.project.demo.sushiCo.domain.dto.PaymentMethodsDto;
import jakarta.validation.Valid;

public interface PaymentMethodsService {

	List<PaymentMethodsDto> getAllPayment_Methods(Integer idRestorant) throws Exception;

	PaymentMethodsDto registerMethod_Payment(@Valid RegisterMethodsPaymentForm form) throws Exception;

	PaymentMethodsDto create(@Valid PaymentMethodsDto methodsDto) throws Exception;

	PaymentMethodsDto getPayment_MethodsById(Integer Id, Integer idRestorant) throws Exception;

	List<PaymentMethodsDto> getRestorantPMethods(Integer restorantId) throws Exception;

	void delete(Integer Id, Integer idRestorant) throws Exception;

	PaymentMethodsDto update(@Valid PaymentMethodsDto pmForm, @Valid PaymentMethodsDto paymentDto, Integer Id,
			Integer idRestoran) throws Exception;


	//PaymentMethodsDto update(Integer Id, Integer idRestorant, @Valid PaymentMethodsDto placesDto) throws Exception;

	

	

	
	
}

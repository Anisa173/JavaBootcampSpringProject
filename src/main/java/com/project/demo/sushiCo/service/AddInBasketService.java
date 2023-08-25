package com.project.demo.sushiCo.service;

import java.util.List;

import com.project.demo.sushiCo.domain.dto.AddInBasketDto;
import com.project.demo.sushiCo.domain.dto.RegisterCardBankDto;
import com.project.demo.sushiCo.domain.dto.OrderByProcessingDto;
import com.project.demo.sushiCo.domain.dto.SelectDishesFormDto;
import jakarta.validation.Valid;

public interface AddInBasketService {

	AddInBasketDto selectDishes(@Valid SelectDishesForm selectForm) throws Exception;

	AddInBasketDto create(@Valid SelectDishesFormDto inBasketDto) throws Exception;

	AddInBasketDto update(@Valid SelectDishesFormDto selectDishesInBasket,
			@Valid SelectDishesFormDto selectDishesFormDto, Integer dId, Integer categoryId, Integer customerId)
			throws Exception;

	SelectDishesFormDto getDishDCategoriesByCustomerId(Integer dId, Integer categoryId, Integer custId)
			throws Exception;

	List<AddInBasketDto> getDishesByCustomerId(Integer dId, Integer categoryId, Integer custId) throws Exception;

	void delete(SelectDishesFormDto selectDishesFormDto, SelectDishesFormDto selectDishesInBasket, Integer custId)
			throws Exception;

	AddInBasketDto displayPaymentServices(@Valid OrderByProcessing byProcessingform) throws Exception;

	OrderByProcessingDto getPaymentServicesCustomById(Integer custId, Integer idRestorant, Integer pmId,
			Integer servPId) throws Exception;

	AddInBasketDto displayCardForm(@Valid RegisterCardform cardBankForm) throws Exception;

	// RegisterCardBankDto getCardsByCustomerId(Integer registrationId, String BankId,
	// Integer userCardId);

	OrderByProcessingDto createByProcessing(@Valid OrderByProcessingDto byProcessingform) throws Exception;

	OrderByProcessingDto updateByProcessing(@Valid OrderByProcessingDto byProcessingform,
			@Valid OrderByProcessingDto orderByProcessForm, Integer custId, Integer idRestorant, Integer pmId,
			Integer servPId) throws Exception;

	RegisterCardBankDto createOrderPaymentDetails(@Valid RegisterCardBankDto regCardForm) throws Exception;

	RegisterCardBankDto getCardsByCustomerId(Integer registrationId, Integer custId, Integer idRestorant, Integer pmId,
			Integer servPId);

	void deleteCardPaymentDetails(RegisterCardBankDto cardsByCustomerId, Integer custId, Integer idRestorant,
			Integer pmId, Integer servPId, Integer registrationId, @Valid RegisterCardBankDto regCardBank)
			throws Exception;



}

package com.project.demo.sushiCo.service;

import java.util.List;

import com.project.demo.sushiCo.domain.dto.AddInBasketDto;
import com.project.demo.sushiCo.domain.dto.CardBankDto;
import com.project.demo.sushiCo.domain.dto.OrderByProcessingDto;
import com.project.demo.sushiCo.domain.dto.SelectDishesFormDto;
import jakarta.validation.Valid;

public interface AddInBasketService {

	AddInBasketDto selectDishes(@Valid SelectDishesForm selectForm,Integer custId) throws Exception;

	AddInBasketDto create(@Valid AddInBasketDto inBasketDto) throws Exception;

	AddInBasketDto update(@Valid AddInBasketDto inBasketDto, Integer id) throws Exception;

	SelectDishesFormDto getDishDCategoriesByCustomerId(Integer dId, Integer categoryId, Integer custId) throws Exception;
	
	List<AddInBasketDto> getDishesByCustomerId(Integer dId, Integer categoryId, Integer custId) throws Exception;
	
	void delete(Integer dId, Integer categoryId,Integer custId) throws Exception;

	AddInBasketDto displayPaymentServices(@Valid OrderByProcessing byProcessingform) throws Exception;

	OrderByProcessingDto getPaymentServicesById(Integer custmId, Integer idRestorant, Integer pmId, Integer servPId)
			throws Exception;

	CardBankDto displayCardForm(@Valid RegisterCardform cardBankForm) throws Exception;
	
	//CardBankDto getCardsByCustomerId(Integer registrationId, String BankId, Integer userCardId);

	CardBankDto getCardsByCustomerId(Integer registrationId, String BankId, Integer userCardId, Integer idRestorant,
			Integer pmId);

	

}

package com.project.demo.sushiCo.service;

import com.project.demo.sushiCo.domain.dto.AddInBasketDto;
import com.project.demo.sushiCo.domain.dto.SelectDishesFormDto;

import jakarta.validation.Valid;

public interface AddInBasketService {

	AddInBasketDto selectDishes(@Valid SelectDishesForm selectForm) throws Exception;

	AddInBasketDto create(@Valid AddInBasketDto inBasketDto) throws Exception;

	AddInBasketDto update(@Valid AddInBasketDto inBasketDto, Integer id) throws Exception;

	SelectDishesFormDto getDishDCategoriesByCustomerId(Integer dId, Integer categoryId, Integer custId) throws Exception;
	
	SelectDishesFormDto getDishesByCustomerId(Integer dId, Integer categoryId, Integer custId) throws Exception;
	
	void delete(Integer dId,Integer id) throws Exception;

}

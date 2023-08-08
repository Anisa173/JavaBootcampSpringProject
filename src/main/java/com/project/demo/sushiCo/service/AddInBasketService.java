package com.project.demo.sushiCo.service;

import com.project.demo.sushiCo.domain.dto.AddInBasketDto;

import jakarta.validation.Valid;

public interface AddInBasketService {

AddInBasketDto selectDishes(@Valid SelectDishesForm selectForm) throws Exception;
AddInBasketDto create(@Valid AddInBasketDto inBasketDto) throws Exception;
AddInBasketDto update(@Valid AddInBasketDto inBasketDto,Integer id) throws Exception;
void delete(Integer dishId) throws Exception;
//getCustomerDish()

}

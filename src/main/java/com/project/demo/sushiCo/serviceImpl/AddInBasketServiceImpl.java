package com.project.demo.sushiCo.serviceImpl;

import org.springframework.stereotype.Service;

import com.project.demo.sushiCo.domain.dto.AddInBasketDto;
import com.project.demo.sushiCo.service.AddInBasketService;
import com.project.demo.sushiCo.service.SelectDishesForm;

import jakarta.validation.Valid;
@Service
public class AddInBasketServiceImpl implements AddInBasketService{

	public AddInBasketServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public AddInBasketDto selectDishes(@Valid SelectDishesForm selectForm) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AddInBasketDto create(@Valid AddInBasketDto inBasketDto) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AddInBasketDto update(@Valid AddInBasketDto inBasketDto, Integer id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Integer dishId) throws Exception {
		// TODO Auto-generated method stub
		
	}

}

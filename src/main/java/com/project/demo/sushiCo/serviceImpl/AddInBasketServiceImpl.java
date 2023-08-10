package com.project.demo.sushiCo.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.demo.sushiCo.domain.dto.AddInBasketDto;
import com.project.demo.sushiCo.domain.mappers.AddInBasketMapper;
import com.project.demo.sushiCo.repository.AddInBasketRepository;
import com.project.demo.sushiCo.service.AddInBasketService;
import com.project.demo.sushiCo.service.SelectDishesForm;

import jakarta.validation.Valid;
@Service
public class AddInBasketServiceImpl implements AddInBasketService{
@Autowired
private final AddInBasketRepository basketRepository;
private final AddInBasketMapper basketMapper;
	public AddInBasketServiceImpl(AddInBasketRepository basketRepository,AddInBasketMapper basketMapper) {
	this.basketRepository = basketRepository;
	this.basketMapper = basketMapper;
	}

	@Override
	public AddInBasketDto selectDishes(@Valid SelectDishesForm selectForm) throws Exception {
	
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

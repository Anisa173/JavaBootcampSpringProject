package com.project.demo.sushiCo.domain.mappers;

import java.util.ArrayList;
import java.util.List;

import com.project.demo.sushiCo.domain.dto.AddInBasketDto;
import com.project.demo.sushiCo.domain.dto.OrderDto;
import com.project.demo.sushiCo.domain.dto.SelectDishesFormDto;
import com.project.demo.sushiCo.entity.AddInBasket;
import com.project.demo.sushiCo.entity.Order;
import com.project.demo.sushiCo.service.SelectDishesForm;

public class SelectDishesFormMapper extends BaseMapper<SelectDishesForm, SelectDishesFormDto> {

	@Override
	public SelectDishesForm toEntity(SelectDishesFormDto dto) {
		var dg = new SelectDishesForm();
		dg.setId(dto.getId());
		dg.setCategoryId(dto.getCategoryId());
		dg.setDish(dto.getDish());
		dg.setCustId(dto.getCustId());
		dg.setCategoryName(dto.getCategoryName());
		return dg;
	}

	@Override
	public SelectDishesFormDto toDto(SelectDishesForm entity) {
		var dg = new SelectDishesFormDto();
		dg.setId(entity.getId());
		dg.setCategoryId(entity.getCategoryId());
		dg.setDish(entity.getDish());
		dg.setCustId(entity.getCustId());
		dg.setCategoryName(entity.getCategoryName());

		return dg;
	}

	@Override
	public SelectDishesForm toUpdate(SelectDishesFormDto dto, SelectDishesForm entity) {
		entity.setDish(dto.getDish());
		entity.setCategoryId(dto.getCategoryId());
		return entity;
	}

	@Override
	public List<SelectDishesForm> toEntity(List<SelectDishesFormDto> dtoList) {
		if (dtoList == null) {
			return null;
		}

		List<SelectDishesForm> list = new ArrayList<SelectDishesForm>(dtoList.size());
		for (SelectDishesFormDto dishInDto : dtoList) {
			list.add(toEntity(dishInDto));
		}
		return list;
	}

	@Override
	public List<SelectDishesFormDto> toDto(List<SelectDishesForm> entityList) {
		
  return null;
}}
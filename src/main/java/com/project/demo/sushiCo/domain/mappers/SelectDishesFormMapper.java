package com.project.demo.sushiCo.domain.mappers;

import java.util.List;

import com.project.demo.sushiCo.domain.dto.SelectDishesFormDto;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SelectDishesFormDto> toDto(List<SelectDishesForm> entityList) {
		// TODO Auto-generated method stub
		return null;
	}

}
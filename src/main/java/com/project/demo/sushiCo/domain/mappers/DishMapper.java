package com.project.demo.sushiCo.domain.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.project.demo.sushiCo.domain.dto.DishDto;
import com.project.demo.sushiCo.entity.Dish;

@Component
public class DishMapper extends BaseMapper<Dish, DishDto> {

	@Override
	public Dish toEntity(DishDto dto) {
		Dish dish = new Dish();
		dish.setDId(dto.getDId());
		dish.setDishName(dto.getDishName());
		dish.setDishPrize(dto.getDishPrize());
		dish.setDishDescription(dto.getDishDescription());
		return dish;
	}

	@Override
	public DishDto toDto(Dish entity) {
		DishDto dishDto = new DishDto();
		dishDto.setDId(entity.getId());
		dishDto.setDishName(entity.getDishName());
		dishDto.setDishPrize(entity.getDishPrize());
		dishDto.setDishDescription(entity.getDishDescription());
		dishDto.setCategoryId(entity.getCategory().getId());
		var dishCategory = entity.getCategory().getCategoryName();		
		dishDto.setDishCategory(dishCategory);
		dishDto.setOrderId(entity.getOrder().getId());
		var orderItems = entity.getOrder().getId();
		dishDto.setOrderItems(orderItems);
		var totalItemsInBasket = entity.getAddInBasket().stream().count();
		dishDto.setTotalItemsInBasket(totalItemsInBasket);
		return dishDto;
	}

	@Override
	public Dish toUpdate(DishDto dto, Dish dishes) {
		dishes.setDishName(dto.getDishName());
		dishes.setDishPrize(dto.getDishPrize());
		dishes.setDishDescription(dto.getDishDescription());
		
		return dishes;
	}

	@Override
	public List<Dish> toEntity(List<DishDto> dtoList) {
		if ( dtoList == null ) {
            return null;
        }

        List<Dish> list = new ArrayList<Dish>( dtoList.size() );
        for ( DishDto dDto : dtoList ) {
            list.add( toEntity( dDto ) );
        }

        return list;
	}

	@Override
	public List<DishDto> toDto(List<Dish> entityList) {
		if ( entityList == null ) {
            return null;
        }

        List<DishDto> list = new ArrayList<DishDto>( entityList.size() );
        for ( Dish dishes : entityList ) {
            list.add( toDto( dishes ) );
        }

        return list;
	}

}

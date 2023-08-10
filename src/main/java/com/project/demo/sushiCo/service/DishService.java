package com.project.demo.sushiCo.service;

import com.project.demo.sushiCo.domain.dto.DishDto;
import com.project.demo.sushiCo.serviceImpl.RegisterDishForm;
import jakarta.validation.Valid;

public interface DishService {

	void deleteDishByCategory(Integer id, Integer categoryId) throws Exception;

	DishDto register(@Valid RegisterDishForm form) throws Exception;

	DishDto create(@Valid DishDto dishDto) throws Exception;

    DishDto update(@Valid DishDto dishDto, Integer dId, Integer categoryId) throws Exception;
	
	DishDto getDishByDishCategory(Integer dId, Integer categoryId) throws Exception;

	


}

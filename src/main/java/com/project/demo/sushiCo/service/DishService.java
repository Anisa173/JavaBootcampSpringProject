package com.project.demo.sushiCo.service;

import java.util.List;

import com.project.demo.sushiCo.domain.dto.DishDto;
import com.project.demo.sushiCo.serviceImpl.RegisterDishForm;
import jakarta.validation.Valid;

public interface DishService {

	void deleteDishByCategory(Integer id, Integer categoryId) throws Exception;

	DishDto register(@Valid RegisterDishForm form) throws Exception;

	DishDto create(@Valid DishDto dishDto) throws Exception;

	DishDto update(@Valid DishDto dishDto, Integer dId, Integer categoryId) throws Exception;

	DishDto getDishByDishCategory(Integer dId, Integer categoryId) throws Exception;

	// Admini i restorantit kerkon te gjeneroje listen me dishes sipas preferences
	// nga konsumatoret per cdo dish ne rendin rrites,pra sa te kerkuara jane secila
	// dish
	List<DishDto> getDishByPreferences() throws Exception;

//Admini i restorantit kerkon te gjeneroje menunë e cila eshte kerkuar me shume nga konsumatoret
	DishDto getMaxPreference(Integer IdDish) throws Exception;

}

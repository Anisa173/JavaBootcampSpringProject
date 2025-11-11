package com.project.demo.sushiCo.service;

import java.util.List;

import com.project.demo.sushiCo.domain.dto.DishDto;
import com.project.demo.sushiCo.domain.dto.RegisterDishFormDto;
import com.project.demo.sushiCo.serviceImpl.RegisterDishForm;
import jakarta.validation.Valid;

public interface DishService {

	void deleteDishByCategory(Integer id, Integer categoryId,Integer admin_Id) throws Exception;

	List<DishDto> getDishesByDishCategory(Integer categoryId, Integer adminId) throws Exception;

	DishDto register(@Valid RegisterDishForm form) throws Exception;

	RegisterDishFormDto getDishByDishCategory(Integer dId, Integer categoryId, Integer adminId) throws Exception;

	// Admini i restorantit kerkon te gjeneroje listen me dishes sipas preferences
	// nga konsumatoret per cdo dish ne rendin rrites,pra sa te kerkuara jane secila
	// dish
	List<DishDto> getDishByPreferences(Integer adminId) throws Exception;

    //Admini i restorantit kerkon te gjeneroje menunë e cila eshte kerkuar me shume nga konsumatoret
	DishDto getMaxPreference(Integer dId,Integer id) throws Exception;

	RegisterDishFormDto create(@Valid RegisterDishFormDto dishDto) throws Exception;

	RegisterDishFormDto update(@Valid RegisterDishFormDto dishDto, Integer dId, Integer categoryId, Integer adminId)
			throws Exception;

	



	
	

}

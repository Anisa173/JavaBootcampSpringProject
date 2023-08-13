package com.project.demo.sushiCo.service;

import java.util.List;

import com.project.demo.sushiCo.domain.dto.DishCategoryDto;
import com.project.demo.sushiCo.domain.dto.DishDto;

import jakarta.validation.Valid;

public interface DishCategoryService {

	void delete(Integer id, Integer AdminId) throws Exception;

	DishCategoryDto register(@Valid RegisterCategoryDishForm dishCategoryform, Integer adminId) throws Exception;

	DishCategoryDto create(@Valid DishCategoryDto dishCategoryDto) throws Exception;

	DishCategoryDto update(@Valid DishCategoryDto dishCategoryDto, Integer id, Integer adminId) throws Exception;

	List<DishCategoryDto> getDishCategory() throws Exception;

	List<DishCategoryDto> getDishCategorybyRestorant(Integer adminId) throws Exception;

	DishCategoryDto getDishCategoryById(Integer id, Integer adminId) throws Exception;

}

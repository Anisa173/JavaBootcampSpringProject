package com.project.demo.sushiCo.service;

import java.util.List;

import com.project.demo.sushiCo.domain.dto.DishCategoryDto;
import jakarta.validation.Valid;

public interface DishCategoryService {
	void delete(Integer id) throws Exception;

	DishCategoryDto register(@Valid RegisterCategoryDishForm dishCategoryform) throws Exception;

	DishCategoryDto create(@Valid DishCategoryDto dishCategoryDto) throws Exception;

	DishCategoryDto update(@Valid DishCategoryDto dishCategoryDto, Integer id) throws Exception;

	List<DishCategoryDto> getDishCategory() throws Exception;

	DishCategoryDto getDishCategoryById(Integer id) throws Exception;
}

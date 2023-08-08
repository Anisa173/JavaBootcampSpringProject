package com.project.demo.sushiCo.service;

import java.util.List;
import com.project.demo.sushiCo.domain.dto.DishDto;
import com.project.demo.sushiCo.serviceImpl.RegisterUserForm;
import jakarta.validation.Valid;

public interface DishService {
	void delete(Integer id) throws Exception;

	DishDto register(@Valid RegisterUserForm form) throws Exception;

	DishDto create(@Valid DishDto dishDto) throws Exception;

	DishDto update(@Valid DishDto dishDto, Integer id) throws Exception;

	List<DishDto> getDishes() throws Exception;

	DishDto getDishById(Integer id) throws Exception;

}

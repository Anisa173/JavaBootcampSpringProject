package com.project.demo.sushiCo.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import com.project.demo.sushiCo.domain.dto.DishCategoryDto;
import com.project.demo.sushiCo.domain.mappers.DishCategoryMapper;
import com.project.demo.sushiCo.repository.DishCategoryRepository;
import com.project.demo.sushiCo.service.DishCategoryService;
import com.project.demo.sushiCo.service.RegisterCategoryDishForm;

import groovy.util.ResourceException;
import jakarta.validation.Valid;

public class DishCategoryServiceImpl implements DishCategoryService {

	@Autowired
	private final DishCategoryRepository dishCategoryRepository;
	private final DishCategoryMapper dishCategoryMapper;

	public DishCategoryServiceImpl(DishCategoryRepository dishCategoryRepository,
			DishCategoryMapper dishCategoryMapper) {
		this.dishCategoryRepository = dishCategoryRepository;
		this.dishCategoryMapper = dishCategoryMapper;
	}

	@Override
	public void delete(Integer id) throws Exception {
		dishCategoryRepository.deleteById(id);
	}

	@Override
	public DishCategoryDto register(@Valid RegisterCategoryDishForm dishCategoryform) throws Exception {
		var result = getDishCategoryById(dishCategoryform.getId());
		result.setCategoryName(dishCategoryform.getCategoryName());
		return dishCategoryMapper.toDto(dishCategoryRepository.save(result));
	}

	@Override
	public DishCategoryDto create(@Valid DishCategoryDto dishCategoryDto) throws Exception {
		var dishCategory = dishCategoryMapper.toEntity(dishCategoryDto);
		return dishCategoryMapper.toDto(dishCategoryRepository.save(dishCategory));
	}

	@Override
	public DishCategoryDto update(@Valid DishCategoryDto dishCategoryDto, Integer id) throws Exception {
		var dishCategory = dishCategoryMapper.toEntity(getDishCategoryById(id));
		var dishResult = dishCategoryMapper.toUpdate(dishCategoryDto, dishCategory);
		return dishCategoryMapper.toDto(dishCategoryRepository.save(dishResult));
	}

	@Override
	public List<DishCategoryDto> getDishCategory() throws Exception {
		return dishCategoryRepository.findAll().stream().map(a -> dishCategoryMapper.toDto(a))
				.collect(Collectors.toList());
	}

	@Override
	public DishCategoryDto getDishCategoryById(Integer id) throws Exception {

		return dishCategoryMapper.toDto(dishCategoryRepository.findById(id)
				.orElseThrow(() -> new ResourceException(String.format("DishCategory not found!", id))));
	}

}

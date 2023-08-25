package com.project.demo.sushiCo.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import com.project.demo.sushiCo.domain.dto.DishCategoryDto;
import com.project.demo.sushiCo.domain.mappers.DishCategoryMapper;
import com.project.demo.sushiCo.entity.DishCategory;
import com.project.demo.sushiCo.repository.DishCategoryRepository;
import com.project.demo.sushiCo.service.DishCategoryService;
import com.project.demo.sushiCo.service.RegisterCategoryDishForm;

import jakarta.validation.Valid;

@Validated
@Service
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
	public void delete(Integer id,Integer adminId) throws Exception {
		dishCategoryRepository.deleteById(id);
	}

	@Override
	public DishCategoryDto register(@Valid RegisterCategoryDishForm dishCategoryform,Integer adminId) throws Exception {
		var result = getDishCategoryById(dishCategoryform.getId(),dishCategoryform.getAdmin_Id());
		((DishCategoryDto) result).setCategoryName(dishCategoryform.getCategoryName());
		return dishCategoryMapper.toDto(dishCategoryRepository.save((DishCategoryDto) result));
	}

	@Override
	public DishCategoryDto create(@Valid DishCategoryDto dishCategoryDto) throws Exception {
		var dishCategory = dishCategoryMapper.toEntity(dishCategoryDto);
		return dishCategoryMapper.toDto(dishCategoryRepository.save(dishCategory));
	}

	@Override
	public DishCategoryDto update(@Valid DishCategoryDto dishCategoryDto,@Valid DishCategoryDto regDishCategForm, Integer id,Integer adminId) throws Exception {
		var dishCategory = dishCategoryMapper.toEntity(getDishCategoryById(id,adminId));
		var dishResult = dishCategoryMapper.toUpdate(dishCategoryDto, (DishCategory) dishCategory);
		return dishCategoryMapper.toDto(dishCategoryRepository.save(dishResult));
	}

	@Override
	public DishCategoryDto getDishCategoryById(Integer id,Integer adminId) throws Exception {
		return dishCategoryMapper.toDto(dishCategoryRepository.getDishCategoryById(id,adminId));
	}

	@Override
	public List<DishCategoryDto> getDishCategorybyRestorant(Integer adminId) throws Exception {
		return dishCategoryRepository.getDishCategorybyRestorant(adminId);
	}


}

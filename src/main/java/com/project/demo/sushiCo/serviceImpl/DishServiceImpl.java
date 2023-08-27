package com.project.demo.sushiCo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.project.demo.sushiCo.domain.dto.DishDto;
import com.project.demo.sushiCo.domain.dto.RegisterDishFormDto;
import com.project.demo.sushiCo.domain.mappers.DishMapper;
import com.project.demo.sushiCo.domain.mappers.RegisterDishFormMapper;
import com.project.demo.sushiCo.entity.Dish;
import com.project.demo.sushiCo.repository.DishRepository;
import com.project.demo.sushiCo.service.DishService;
import jakarta.validation.Valid;

@Validated
@Service
public class DishServiceImpl implements DishService {

	@Autowired
	private final DishRepository dishRepository;
	private final DishMapper dishMapper;
private final RegisterDishFormMapper regDishMapper;

	public DishServiceImpl(DishRepository dishRepository, DishMapper dishMapper,RegisterDishFormMapper regDishMapper) {
		this.dishRepository = dishRepository;
		this.dishMapper = dishMapper;
	this.regDishMapper = regDishMapper;
	}

	@Override
	public void deleteDishByCategory(Integer id, Integer categoryId,Integer admin_Id) throws Exception {
		dishRepository.deleteDishByCategory(id, categoryId,admin_Id);
	}

	@Override
	public DishDto register(@Valid RegisterDishForm form) throws Exception {
		var dishes = getDishByDishCategory(form.getCategoryId(),form.getAdminId(),form.getDId());
		dishes.setDishName(form.getDishName());
		dishes.setDishPrize(form.getDishPrize());
		dishes.setDishDescription(form.getDishDescription());
		dishes.setDishType(form.getDishType());
		return dishMapper.toDto(dishRepository.save(dishes));
	}

	/*regDish.setIdRegistration(entity.getId());
		regDish.setDId(entity.getDId());
		regDish.setDishName(entity.getDishName());
		regDish.setDishPrize(entity.getDishPrize());
		regDish.setDishDescription(entity.getDishDescription());
		regDish.setDishType(entity.getDishType());
		regDish.setAdminId(entity.getAdminId());
		regDish.setCategoryId(entity.getCategoryId());*/

	@Override
	public RegisterDishFormDto create(@Valid RegisterDishFormDto dishDto) throws Exception {
		var dishDto1 = regDishMapper.toEntity(dishDto);
		return regDishMapper.toDto(dishRepository.save(dishDto1));
	}

	@Override
	public RegisterDishFormDto update(@Valid RegisterDishFormDto dishDto,@Valid RegisterDishFormDto regDishForm , Integer dId, Integer categoryId,Integer adminId) throws Exception {
		var dishes = regDishMapper.toEntity(getDishByDishCategory(dId, categoryId,adminId));
		var uptodate = regDishMapper.toUpdate(dishDto, dishes);
		return regDishMapper.toDto(dishRepository.save(uptodate));
	}

	@Override
	public RegisterDishFormDto getDishByDishCategory(Integer dId, Integer categoryId,Integer adminId) throws Exception {

		return regDishMapper.toDto(dishRepository.getDishByDishCategory(dId, categoryId,adminId));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DishDto> getDishByPreferences(Integer adminId) throws Exception {
		
		return ((List<DishDto>) dishMapper.toDto((Dish) dishRepository.getDishByPreferences(adminId)));
	}


	@Override
	public DishDto getMaxPreference(Integer dId,Integer id) throws Exception {
		
		return dishMapper.toDto(dishRepository.getMaxPreference(dId,id));
	}

	@Override
	public List<DishDto> getDishesByDishCategory(Integer categoryId, Integer adminId) throws Exception {
	
		return dishRepository.getDishesByDishCategory(categoryId, adminId);
	}

}

package com.project.demo.sushiCo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.demo.sushiCo.domain.dto.DishDto;
import com.project.demo.sushiCo.domain.mappers.DishMapper;
import com.project.demo.sushiCo.entity.Dish;
import com.project.demo.sushiCo.repository.DishRepository;
import com.project.demo.sushiCo.service.DishService;
import jakarta.validation.Valid;

@Service
public class DishServiceImpl implements DishService {

	@Autowired
	private final DishRepository dishRepository;
	private final DishMapper dishMapper;

	public DishServiceImpl(DishRepository dishRepository, DishMapper dishMapper) {
		this.dishRepository = dishRepository;
		this.dishMapper = dishMapper;
	}

	@Override
	public void deleteDishByCategory(Integer id, Integer categoryId,Integer admin_Id) throws Exception {
		dishRepository.deleteDishByCategory(id, categoryId,admin_Id);
	}

	@Override
	public DishDto register(@Valid RegisterDishForm form) throws Exception {
		var dishes = getDishByDishCategory(form.getId(), form.getCategoryId(),form.getAdminId());
		dishes.setDishName(form.getDishName());
		dishes.setDishPrize(form.getDishPrize());
		dishes.setDishDescription(form.getDishDescription());
		dishes.setCategoryId(form.getCategoryId());
		dishes.setDishType(form.getDishType());//selective
		return dishMapper.toDto(dishRepository.save(dishes));
	}

	@Override
	public DishDto create(@Valid DishDto dishDto) throws Exception {
		var dishDto1 = dishMapper.toEntity(dishDto);
		return dishMapper.toDto(dishRepository.save(dishDto1));
	}

	@Override
	public DishDto update(@Valid DishDto dishDto, Integer dId, Integer categoryId,Integer adminId) throws Exception {
		Dish dishes = dishMapper.toEntity(getDishByDishCategory(dId, categoryId,adminId));
		var uptodate = dishMapper.toUpdate(dishDto, dishes);
		return dishMapper.toDto(dishRepository.save(uptodate));
	}

	@Override
	public DishDto getDishByDishCategory(Integer dId, Integer categoryId,Integer adminId) throws Exception {

		return dishMapper.toDto(dishRepository.getDishByDishCategory(dId, categoryId,adminId));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DishDto> getDishByPreferences() throws Exception {
		
		return ((List<DishDto>) dishMapper.toDto((Dish) dishRepository.getDishByPreferences()));
	}


	@Override
	public DishDto getMaxPreference(Integer IdDish) throws Exception {
		
		return dishMapper.toDto(dishRepository.getMaxPreference(IdDish));
	}

	@Override
	public List<DishDto> getDishesByDishCategory(Integer idCategoria, Integer adminId) throws Exception {
	
		return dishRepository.getDishesByDishCategory(idCategoria, adminId);
	}

}

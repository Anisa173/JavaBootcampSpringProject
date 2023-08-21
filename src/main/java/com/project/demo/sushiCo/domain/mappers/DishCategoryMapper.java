package com.project.demo.sushiCo.domain.mappers;

import java.util.ArrayList;
import java.util.List;
import com.project.demo.sushiCo.domain.dto.DishCategoryDto;
import com.project.demo.sushiCo.entity.DishCategory;

public class DishCategoryMapper extends BaseMapper<DishCategory, DishCategoryDto> {

	@Override
	public DishCategory toEntity(DishCategoryDto dto) {
		var dishCategory = new DishCategory();
		dishCategory.setId(dto.getId());
		dishCategory.setCategoryName(dto.getCategoryName());

		return dishCategory;
	}

	@Override
	public DishCategoryDto toDto(DishCategory entity) {
		var dishCategoryDto = new DishCategoryDto();
		dishCategoryDto.setId(entity.getId());
		dishCategoryDto.setCategoryName(entity.getCategoryName());
		var totalDishes = entity.getDishes().stream().count();
		dishCategoryDto.setTotalDishes(totalDishes);
		var totalAddInBasket = entity.getAddInBasket().stream().count();
		dishCategoryDto.setTotalAddInBasket(totalAddInBasket);
		dishCategoryDto.setAdmin_Id(entity.getUser().getId());
		dishCategoryDto
				.setAdminName(entity.getUser().getFirst_name().concat(" ").concat(entity.getUser().getLast_name()));
		return dishCategoryDto;
	}

	@Override
	public DishCategory toUpdate(DishCategoryDto dto, DishCategory entity) {
		entity.setCategoryName(dto.getCategoryName());
		return entity;
	}

	@Override
	public List<DishCategory> toEntity(List<DishCategoryDto> dtoList) {
		if (dtoList == null) {
			return null;
		}

		List<DishCategory> list = new ArrayList<DishCategory>(dtoList.size());
		for (DishCategoryDto dcDto : dtoList) {
			list.add(toEntity(dcDto));
		}

		return list;
	}

	@Override
	public List<DishCategoryDto> toDto(List<DishCategory> entityList) {
		if (entityList == null) {
			return null;
		}

		List<DishCategoryDto> list = new ArrayList<DishCategoryDto>(entityList.size());
		for (DishCategory dc : entityList) {
			list.add(toDto(dc));
		}

		return list;
	}
}

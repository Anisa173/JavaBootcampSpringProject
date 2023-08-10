package com.project.demo.sushiCo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.demo.sushiCo.domain.dto.DishCategoryDto;
import com.project.demo.sushiCo.domain.dto.DishDto;
import com.project.demo.sushiCo.entity.DishCategory;

public interface DishCategoryRepository extends JpaRepository<DishCategory, Integer>{

	DishCategory save(DishCategoryDto result);

	@Query("Select dc From dishCategory d INNER JOIN dishCategory.dish dc ON d.id = dc.categoryId Where d.id =: id ")
	List<DishDto> getDishesByDishCategory(Integer id);
}




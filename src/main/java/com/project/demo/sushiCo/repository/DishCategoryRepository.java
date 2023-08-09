package com.project.demo.sushiCo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.demo.sushiCo.domain.dto.DishCategoryDto;
import com.project.demo.sushiCo.entity.DishCategory;

public interface DishCategoryRepository extends JpaRepository<DishCategory, Integer>{

	DishCategory save(DishCategoryDto result);

}




package com.project.demo.sushiCo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.project.demo.sushiCo.domain.dto.DishDto;
import com.project.demo.sushiCo.entity.Dish;

@Service
public interface DishRepository extends JpaRepository<Dish, Integer> {

	@Query(" Select d From category.dish cd INNER JOIN category c on cd.categoryId = c.id where cd.dId = ?1 and cd.categoryId = ?2")
	DishDto getDishByDishCategory(Integer dId, Integer categoryId);


	@Query("Delete From category.dish cd inner join category c on cd.categoryId = cd.id where cd.categoryId =: ?1 and cd.dId =: ?2")
	void deleteDishByCategory(Integer id, Integer categoryId);


	Dish save(DishDto dishes);
	
	
}


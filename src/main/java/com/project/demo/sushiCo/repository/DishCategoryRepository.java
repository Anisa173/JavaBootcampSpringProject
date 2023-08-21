package com.project.demo.sushiCo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.project.demo.sushiCo.domain.dto.DishCategoryDto;
import com.project.demo.sushiCo.entity.DishCategory;

public interface DishCategoryRepository extends JpaRepository<DishCategory, Integer> {

	DishCategory save(DishCategoryDto result);
@Modifying
	@Query("Delete From DishCategory dc INNER JOIN User adm ON adm.dc.admin_Id = adm.id Where adm.dc.id =: ?1 and adm.id=: ?2")

	void delete(Integer id, Integer adminId);

	@Query("Select a.dc From User a INNER JOIN DishCategory dc ON a.id = dc.admin_Id Where a.id =: id")
	List<DishCategoryDto> getDishCategorybyRestorant(Integer adminId);

	@Query(value = "Select dc.id,a.id  From DishCategory as dc INNER JOIN User as a ON dc.admin_Id = a.id Where dc.id = ? AND a.id = ? ", nativeQuery = true)
	DishCategory getDishCategoryById(Integer id, Integer adminId);
}

package com.project.demo.sushiCo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.project.demo.sushiCo.domain.dto.DishDto;
import com.project.demo.sushiCo.domain.dto.RegisterDishFormDto;
import com.project.demo.sushiCo.entity.Dish;
import com.project.demo.sushiCo.serviceImpl.RegisterDishForm;

@Repository
public interface DishRepository extends JpaRepository<Dish, Integer> {

	@Query(" Select d.dId From DishCategory dc INNER JOIN Dish d on dc.d.categoryId = dc.id"
         + " INNER JOIN User a ON a.dc.admin_Id = a.id Where d.dId =:?1 And dc.id =: ?2 And a.id =: ?3 "	)
	RegisterDishForm getDishByDishCategory(Integer dId, Integer categoryId,Integer adminId);

	@Modifying
	@Query("Delete From dish d INNER JOIN dishCategory c on c.d.categoryId = c.id "  
	                + "Inner Join User a ON a.c.admin_Id = a.id Where c.id = ?1 And a.id = ?2 AND d.dId = :?1)")
			void deleteDishByCategory(Integer id, Integer categoryId,Integer admin_Id);

	Dish save(DishDto dishes);

	@Query(" Select d , d.totalAddInBasket noCustomer,sum(addB.addItemsDish) TotalNoItems,sum(addB.amountValue)  TotalValue "
			+ " From AddInBasket addB INNER JOIN Dish d ON d.dId = d.addB.IDdish "
			+                       " INNER JOIN DishCategory dc ON dc.d.categoryId = dc.id  "
			+ " Where d.addB.amountValue =: (d.dishPrize * addB.addItemsDish) And dc.id IN "
			+ " (Select dc.id From DishCategory dc Inner join User a ON a.dc.admin_Id = a.id Where a.id = :id)"
			+ " Group By d, d.totalAddInBasket "
			+ " Order By d.totalAddInBasket ASC ")
	List<Dish> getDishByPreferences(Integer adminId);

	   @Query(" Select d , dc.categoryName , max(d.totalAddInBasket)  maxCustomerNo , "
			+ " From Dish d INNER JOIN AddInBasket addB ON d.dId = d.addB.IDdish "
			+ " INNER JOIN DishCategory dc ON dc.d.categoryId = dc.id "
			+ " Where dc.id IN(Select dc.id From DishCategory dc Inner join User a ON a.dc.admin_Id = a.id  "
			+ " Where a.id = :?1 And dc.categoryName = :?2)"
	        + " Group by d , dc.categoryName")
	   Dish getMaxPreference(Integer dId,Integer id);

	/*@Query(value = "Select d.dId , dc.id ,a.id From DishCategory as dc INNER JOIN Dish as d ON dc.id = d.categoryId"
			+ "INNER JOIN User a ON dc.admin_Id = a.id  "
			+ "Where d.dId = ? and a.id = ? and dc.id = ?", nativeQuery = true)
	Dish getDishByDishCategory(Integer dId, Integer categoryId, Integer adminId);*/

	@Query("Select d,dc.categoryName From DishCategory  dc INNER JOIN User a ON a.dc.admin_Id = a.id "
			+ " INNER JOIN Dish  d ON dc.id = dc.d.categoryId  Where dc.id =: ?1 And a.id =: ?2")
	List<DishDto> getDishesByDishCategory(Integer categoryId, Integer adminId);

	Dish save(RegisterDishFormDto dishes);

	RegisterDishForm save(RegisterDishForm uptodate);



}

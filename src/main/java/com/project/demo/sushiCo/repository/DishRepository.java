package com.project.demo.sushiCo.repository;

import java.util.List;

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

	@Query(" Select d , d.totalAddInBasket,sum(d.addB.addItemsDish) TotalNoItems,sum(d.addB.amountValue) TotalValue "
			+ " From Dish d INNER JOIN AddInBasket addB ON d.dId = d.addB.IDdish " + " Order By d.totalAddInBasket ASC "
			+ "Where d.addB.amountValue = d.dishPrize * d.addB.addItemsDish")
	List<DishDto> getDishByPreferences();

	@Query("Select d , max(d.totalAddInBasket)  maxCustomerNo,"
			+ "From Dish d INNER JOIN AddInBasket addB ON d.dId = d.addB.IDdish ")
	DishDto getMaxPreference(Integer idDish);

	@Query(value = "Select d.dId , dc.id ,a.id From DishCategory as dc INNER JOIN Dish as d ON dc.id = d.categoryId"
			+ "INNER JOIN User a ON dc.admin_Id = a.id  "
			+ "Where d.dId = ? and a.id = ? and dc.id = ?", nativeQuery = true)
	DishDto getDishByDishCategory(Integer dId, Integer categoryId, Integer adminId);


	@Query(value = "Select d,dc.categoryName"
+ " From DishCategory as dc INNER JOIN User as a ON dc.admin_Id = d.id "	
+ " INNER JOIN Dish as d ON dc.id = d.categoryId "	
+ " Where dc.id = ? And a.id = ?",nativeQuery = true)

	List<DishDto> getDishesByDishCategory(Integer idCategoria, Integer adminId);

}

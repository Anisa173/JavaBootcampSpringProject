package com.project.demo.sushiCo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.project.demo.sushiCo.domain.dto.DishDto;
import com.project.demo.sushiCo.entity.Dish;

@Repository
public interface DishRepository extends JpaRepository<Dish, Integer> {

	@Query(" Select d From category.dish cd INNER JOIN category c on cd.categoryId = c.id where cd.dId = ?1 and cd.categoryId = ?2")
	DishDto getDishByDishCategory(Integer dId, Integer categoryId);

	@Modifying
	@Query("Delete From dish d inner join dishCategory c on c.d.categoryId = c.id where d.dId =: ?1 And c.id "  
	+"IN(Select c.categoryName,a.id From c Inner Join User a ON a.c.admin_Id = a.id Where c.id = ?1 And a.id = ?2)")
			void deleteDishByCategory(Integer id, Integer categoryId,Integer admin_Id);

	Dish save(DishDto dishes);

	@Query(" Select d , d.totalAddInBasket  noCustomer,sum(d.addB.addItemsDish) TotalNoItems,sum(d.addB.amountValue) TotalValue "
			+ "From Dish d INNER JOIN AddInBasket addB ON d.dId = d.addB.IDdish "
			+ "INNER JOIN DishCategory dc ON dc.d.categoryId = dc.id Order By d.totalAddInBasket ASC "
			+ "Where d.addB.amountValue = (d.dishPrize * d.addB.addItemsDish) And dc.id IN"
			+ "(Select dc.categoryName From DishCategory dc Inner join User a ON a.dc.admin_Id = a.id"
			+ "Where a.id =: id)")
	List<Dish> getDishByPreferences();

	@Query("Select d , max(d.totalAddInBasket)  maxCustomerNo,"
			+ "From Dish d INNER JOIN AddInBasket addB ON d.dId = d.addB.IDdish "
			+ "INNER JOIN DishCategory dc ON dc.d.categoryId = dc.id"
			+ "Where dc.id IN(Select dc.categoryName From DishCategory dc Inner join User a ON a.dc.admin_Id = a.id\"\r\n"
			+ "Where a.id =: ?1 And dc.categoryName =: ?2)")
	Dish getMaxPreference(Integer idDish);

	@Query(value = "Select d.dId , dc.id ,a.id From DishCategory as dc INNER JOIN Dish as d ON dc.id = d.categoryId"
			+ "INNER JOIN User a ON dc.admin_Id = a.id  "
			+ "Where d.dId = ? and a.id = ? and dc.id = ?", nativeQuery = true)
	Dish getDishByDishCategory(Integer dId, Integer categoryId, Integer adminId);

	@Query("Select d,dc.categoryName From DishCategory  dc INNER JOIN User a ON a.dc.admin_Id = a.id "
			+ " INNER JOIN Dish  d ON dc.id = dc.d.categoryId  Where dc.id =: ?1 And a.id =: ?2")
	List<DishDto> getDishesByDishCategory(Integer idCategoria, Integer adminId);

}

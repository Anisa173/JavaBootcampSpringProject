package com.project.demo.sushiCo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import com.project.demo.sushiCo.domain.dto.SelectDishesFormDto;
import com.project.demo.sushiCo.entity.AddInBasket;

@Service
public interface AddInBasketRepository extends JpaRepository<AddInBasket, Integer> {

	@Query(value = "SELECT dc.categoryName,d.dishName,d.dishPrize,d.dishDescription "
			+ "FROM Dish as d INNER JOIN DishCategory as dc ON d.categoryId = dc.id " + "WHERE d.dId IN "
			+ "(SELECT addB.addItemsDish,addB.amountValue as dishCosts,sum(amountValue) as OrderPrize,customer.id,customer.name"
			+ "FROM AddInBasket as addB INNER JOIN d ON addB.IDdish = d.dId "
			+ "INNER JOIN User as customer ON addB.custId = customer.id"
			+ "Where dishCosts = addB.addItemsDish * d.dishPrize)", nativeQuery = true)
	SelectDishesFormDto getDishesByCustomerId(Integer dId, Integer categoryId, Integer custId);

	@Query(value = "SELECT dc.id,d.dId " + "FROM Dish as d INNER JOIN DishCategory as dc ON d.categoryId = dc.id "
			+ "WHERE d.dId IN " + "(customer.id,customer.name"
			+ "FROM AddInBasket as addB INNER JOIN d ON addB.IDdish = d.dId "
			+ "INNER JOIN User as customer ON addB.custId = customer.id)", nativeQuery = true)
	SelectDishesFormDto getDishDCategoriesByCustomerId(Integer dId, Integer categoryId, Integer custId);

	@Query("DELETE FROM AddInBasket  aB INNER JOIN User  customer ON customer.aB.custId = customer.id"
			+ "INNER JOIN Dish d ON d.aB.IDdish = d.dId" + "WHERE  exists "
			+ "(SELECT d.dId,dc.id,d.dishName ,dc.categoryName"
			+ "FROM d INNER JOIN dishCategory dc ON dc.d.categoryId = dc.id" + "WHERE d.dId =: ?1 and dc.id =: ?2)")

	void delete(Integer dId, Integer id);

	AddInBasket save(SelectDishesFormDto basketAdd);

}

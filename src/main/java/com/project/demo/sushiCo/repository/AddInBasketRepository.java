package com.project.demo.sushiCo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.project.demo.sushiCo.domain.dto.RegisterCardBankDto;
import com.project.demo.sushiCo.domain.dto.OrderByProcessingDto;
import com.project.demo.sushiCo.domain.dto.SelectDishesFormDto;
import com.project.demo.sushiCo.entity.AddInBasket;
import com.project.demo.sushiCo.entity.CardBank;
import com.project.demo.sushiCo.service.OrderByProcessing;
import com.project.demo.sushiCo.service.SelectDishesForm;

import jakarta.validation.Valid;

@Repository
public interface AddInBasketRepository extends JpaRepository<AddInBasket, Integer> {

	@Query("  SELECT addB.addItemsDish NoItems , addB.amountValue  Cost,sum(amountValue) as OrderPrize  "
			+ "  FROM AddInBasket addB INNER JOIN Dish d ON addB.IDdish = d.dId  "
			+ "  INNER JOIN  User  cus ON cus.addB.custId = cus.id  "
			+ "  Where dCost = (addB.addItemsDish * d.dishPrize) AND d.dId IN  "
			+ "  (SELECT dc.categoryName, d.dishName,d.dishPrize FROM d INNER JOIN DishCategory dc ON dc.d.categoryId = dc.id "
			+ "  Where dc.id =: id and d.dId =: dId  ")
	List<AddInBasket> getDishesByCustomerId(Integer dId, Integer categoryId, Integer custId);

	@Query(value = "SELECT dc.id,d.dId FROM Dish as d INNER JOIN DishCategory as dc ON d.categoryId = dc.id "
			+ "WHERE dc.id = ? And d.dId IN (Select cus.id"
			+ "FROM AddInBasket as addB INNER JOIN d ON addB.IDdish = d.dId "
			+ "INNER JOIN User as cus ON addB.custId = cus.id" + "Where cus.id = ?)", nativeQuery = true)
	SelectDishesForm getDishDCategoriesByCustomerId(Integer dId, Integer categoryId, Integer custId);

	@Modifying
	@Query(" DELETE FROM AddInBasket  aB INNER JOIN User  c ON c.aB.custId = c.id "
			+ "INNER JOIN Dish d ON d.aB.IDdish = d.dId" + "WHERE c.id =: id And  d.dId IN "
			+ "(SELECT d,dc FROM d INNER JOIN dishCategory dc ON dc.d.categoryId = dc.id "
			+ "WHERE d.dId =: ?1 and dc.id =: ?2)")
	void delete(SelectDishesFormDto selectDishesFormDto, SelectDishesFormDto selectDishesInBasket, Integer custId);

	AddInBasket save(SelectDishesForm addBasket);

	@Query(" Select cus.id,r.idRestorant From User cus INNER JOIN AddInBasket addB ON cus.addB.custId = cus.id "
			+ " Inner Join Restorant r ON r.cus.id = restorant_users.userId  AND r.idRestorant = restorant_users.idRest "
			+ " INNER JOIN CardBank as c ON  cus.id = cus.c.userCardId " + " Where cus.id =: id And r.idRestorant IN "
			+ " ( Select pm.payment_Method,svp.service_Places FROM r INNER JOIN  PaymentMethods pm ON r.idRestorant = r.pm.paymentId"
			+ " INNER JOIN  ServicePlaces svp ON r.idRestorant = r.svp.service_idR "
			+ " WHERE r.idRestorant =: ?1 AND r.pm.Id =: ?2 AND r.svp.Id =: ?3 )")
	OrderByProcessing getPaymentServicesCustomById(Integer custId, Integer idRestorant, Integer pmId, Integer servPId);

	AddInBasket save(OrderByProcessingDto pmSer);

	AddInBasket save(RegisterCardBankDto cardB);

	@Query(" Select cus.id,r.idRestorant From User cus INNER JOIN AddInBasket addB ON cus.addB.custId = cus.id "
			+ " Inner Join Restorant r ON r.cus.id = restorant_users.userId  AND r.idRestorant = restorant_users.idRest "
			+ " INNER JOIN CardBank  c ON  cus.id = cus.c.userCardId " + " Where cus.id =: id And r.idRestorant IN "
			+ " ( Select pm.payment_Method,svp.service_Places FROM r INNER JOIN  PaymentMethods pm ON r.idRestorant = r.pm.paymentId"
			+ " INNER JOIN  ServicePlaces svp ON r.idRestorant = r.svp.service_idR "
			+ " WHERE r.idRestorant =: ?1 AND r.pm.payment_Method =: ' Pay with Card ' AND r.svp.Id =: ?3 )")
	CardBank getCardsByCustomerId(Integer registrationId,Integer custId, Integer idRestorant, Integer pmId,Integer servPId);

	AddInBasket save(SelectDishesFormDto basketAdd);

	OrderByProcessing save(OrderByProcessing processO);

	CardBank save(CardBank paymentCard);

@Modifying
@Query("Update CardBank cb Set deleted = true Where  EXISTS "
+ " (Select cb.registrationId , cus.id , r.idRestorant  From User cus INNER JOIN AddInBasket addB ON cus.addB.custId = cus.id "
+ "	 Inner Join Restorant r ON r.cus.id = restorant_users.userId  AND r.idRestorant = restorant_users.idRest "
+ "	 INNER JOIN cb ON  cus.id = cus.cb.userCardId  Where cus.id =: id And r.idRestorant IN  "
+ "	( Select pm.payment_Method , svp.service_Places FROM r INNER JOIN  PaymentMethods pm ON r.idRestorant = r.pm.paymentId "
+ "	 INNER JOIN  ServicePlaces svp ON r.idRestorant = r.svp.service_idR  "
+ "	 WHERE r.idRestorant =: ?1 AND r.pm.payment_Method =: ' Pay with Card ' AND r.svp.Id =: ?3 ))"
)
	void deleteCardPaymentDetails(@Valid RegisterCardBankDto regCardBank,Integer registrationId, Integer custId, Integer idRestorant, Integer pmId,
			Integer servPId);

}

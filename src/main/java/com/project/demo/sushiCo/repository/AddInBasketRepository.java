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

	@Query("  SELECT dc.categoryName, d.dishName,d.dishPrize ,addB.addItemsDish NoItems , addB.amountValue  Costo,sum(addB.amountValue) as OrderPrize "
			+ "  FROM  DishCategory dc INNER JOIN Dish d ON dc.d.categoryId = dc.id"
			+ "  INNER JOIN AddInBasket addB ON d.addB.IDdish = d.dId"
			+ "  INNER JOIN  User cus ON cus.addB.custId = cus.id  "
			+ "  Where Costo = (addB.addItemsDish * d.dishPrize) AND cus.id =:id"
			+ "  Group By dc.categoryName, d.dishName,d.dishPrize ,addB.addItemsDish, addB.amountValue")
	List<AddInBasket> getDishesByCustomerId(Integer dId, Integer categoryId, Integer custId);

	@Query(value = "SELECT dc.id,d.dId FROM Dish as d INNER JOIN DishCategory as dc ON d.categoryId = dc.id "
			+ "WHERE dc.id = ? And d.dId IN (Select d.dId  "
			+ "FROM d INNER JOIN  AddInBasket as addBON addB.IDdish = d.dId "
			+ "INNER JOIN User as cus ON addB.custId = cus.id" + "Where cus.id = ?)", nativeQuery = true)
	SelectDishesForm getDishDCategoriesByCustomerId(Integer dId, Integer categoryId, Integer custId);

	@Modifying
	@Query(" DELETE FROM User c INNER JOIN AddInBasket aB ON c.aB.custId = c.id "
			+ " INNER JOIN Dish d ON d.aB.IDdish = d.dId" + " WHERE aB.addId = :addId And  c.id=:id")
     void delete(@Valid SelectDishesFormDto selectDishesFormDto, @Valid SelectDishesFormDto selectDishesInBasket,
			Integer custId);
	AddInBasket save(SelectDishesForm addBasket);

	@Query("Select pm.payment_Method,svp.service_Places FROM Restorant r INNER JOIN  PaymentMethods pm ON r.idRestorant = r.pm.paymentId"
			+ " INNER JOIN  ServicePlaces svp ON r.idRestorant = r.svp.service_idR "
			+ "			WHERE  r.pm.Id =: ?1 AND r.svp.Id =:?2 And  r.idRestorant IN  "
			+ "(Select r.idRestorant From User cus INNER JOIN AddInBasket addB ON cus.addB.custId = cus.id"
			+ " Inner Join Restorant r ON r.cus.id = restorant_users.userId  AND r.idRestorant = restorant_users.idRest "
			+ " INNER JOIN CardBank as c ON  cus.id = cus.c.userCardId  Where cus.id =: id )")
	OrderByProcessing getPaymentServicesCustomById(Integer custId, Integer idRestorant, Integer pmId, Integer servPId);

	AddInBasket save(OrderByProcessingDto pmSer);

	AddInBasket save(RegisterCardBankDto cardB);

	@Query("  Select pm.payment_Method ,svp.service_Places FROM PaymentMethods pm INNER JOIN  Restorant r ON r.idRestorant = r.pm.paymentId "
			+ "		INNER JOIN  ServicePlaces svp ON r.idRestorant = r.svp.service_idR "
			+ "		WHERE  r.pm.payment_Method =: 'Pay with Card' AND r.svp.Id =: Id And r.idRestorant IN "
			+ " (Select r.idRestorant From User cus INNER JOIN AddInBasket addB ON cus.addB.custId = cus.id "
			+ " Inner Join Restorant r ON r.cus.id = restorant_users.userId  AND r.idRestorant = restorant_users.idRest "
			+ " INNER JOIN CardBank  c ON  cus.id = cus.c.userCardId  Where cus.id =: id )")
	CardBank getCardsByCustomerId(Integer registrationId, Integer custId, Integer idRestorant, Integer pmId,
			Integer servPId);

	AddInBasket save(SelectDishesFormDto basketAdd);

	OrderByProcessing save(OrderByProcessing processO);

	CardBank save(CardBank paymentCard);

	@Modifying
	@Query("Update CardBank  Set deleted = true  From CardBank cb  Where  cb.id IN "
			+ " ( Select cb.id  From User cus INNER JOIN AddInBasket addB ON cus.addB.custId = cus.id "
			+ "	                              Inner Join Restorant r ON r.cus.id = restorant_users.userId  AND r.idRestorant = restorant_users.idRest "
			+ "	                              INNER JOIN cb ON  cus.id = cus.cb.userCardId  Where cus.id =: id and cb.id=:id And r.idRestorant IN  "
			+ "	(Select r.idRestorant FROM Restorant r INNER JOIN  PaymentMethods pm ON r.idRestorant = r.pm.paymentId "
			+ "	                                       INNER JOIN  ServicePlaces svp ON r.idRestorant = r.svp.service_idR  "
			+ "	 WHERE r.idRestorant =: idRestorant AND pm.payment_Method =: ' Pay with Card ' AND svp.Id =: Id ))")
	void deleteCardPaymentDetails(@Valid RegisterCardBankDto regCardBank, Integer registrationId, Integer custId,
			Integer idRestorant, Integer pmId, Integer servPId);


    void delete(@Valid SelectDishesFormDto selectDishesFormDto, Integer custId);
}

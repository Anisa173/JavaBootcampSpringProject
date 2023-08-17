package com.project.demo.sushiCo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.project.demo.sushiCo.domain.dto.CardBankDto;
import com.project.demo.sushiCo.domain.dto.OrderByProcessingDto;
import com.project.demo.sushiCo.domain.dto.SelectDishesFormDto;
import com.project.demo.sushiCo.domain.dto.UserDto;
import com.project.demo.sushiCo.entity.AddInBasket;
import com.project.demo.sushiCo.entity.CardBank;
import com.project.demo.sushiCo.service.OrderByProcessing;
import com.project.demo.sushiCo.service.SelectDishesForm;

@Service
public interface AddInBasketRepository extends JpaRepository<AddInBasket, Integer> {

	@Query("SELECT addB.addItemsDish,addB.amountValue  dCost,sum(amountValue) as OrderPrize,cus.id,cus.name"
			+ "FROM AddInBasket addB INNER JOIN Dish d ON addB.IDdish = d.dId "
			+ "INNER JOIN User as cus ON addB.custId = cus.id"
			+ "Where dCost = (addB.addItemsDish * d.dishPrize) AND d.dId IN"
			+ "(SELECT dc,d FROM d INNER JOIN DishCategory dc ON dc.d.categoryId = dc.id  Where dc.id =: id and d.dId =: dId")
	List<AddInBasket> getDishesByCustomerId(Integer dId, Integer categoryId, Integer custId);

	@Query(value = "SELECT dc.id,d.dId FROM Dish as d INNER JOIN DishCategory as dc ON d.categoryId = dc.id "
			+ "WHERE dc.id = ? And d.dId IN (Select cus.id"
			+ "FROM AddInBasket as addB INNER JOIN d ON addB.IDdish = d.dId "
			+ "INNER JOIN User as cus ON addB.custId = cus.id" + "Where cus.id = ?)", nativeQuery = true)

	SelectDishesForm getDishDCategoriesByCustomerId(Integer dId, Integer categoryId, Integer custId);

	@Query("DELETE FROM AddInBasket  aB INNER JOIN User  c ON c.aB.custId = c.id"
			+ "INNER JOIN Dish d ON d.aB.IDdish = d.dId" + "WHERE  Exists "
			+ "(SELECT d,dc FROM d INNER JOIN dishCategory dc ON dc.d.categoryId = dc.id"
			+ "WHERE d.dId =: ?1 and dc.id =: ?2)")
	void delete(Integer dId, Integer id);

	AddInBasket save(SelectDishesFormDto basketAdd);

	@Query("Select cus.id,r.idRestorant From User cus INNER JOIN AddInBasket addB ON cus.addB.custId = cus.id"
			+ " Inner Join Restorant r ON r.cus.id = restorant_users.userId  AND r.idRestorant = restorant_users.idRest"
			+ " Where cus.id =: id And r.idRestorant IN"
			+ "(Select pm.paymentId,svp.service_idR FROM r INNER JOIN  PaymentMethods pm ON r.idRestorant = r.pm.paymentId"
			+ "INNER JOIN  ServicePlaces svp ON r.idRestorant = r.svp.service_idR "
			+ "WHERE r.idRestorant =: ?1 AND r.pm.Id =: ?2 AND r.svp.Id =: ?3)")
	OrderByProcessing getPaymentServicesById(Integer id, Integer idRestorant, Integer pmId, Integer servPId);

	@Query("INSERT INTO Cards(BankId,valid_from,expiredTime,cardSecurityCode,userCardId)"
			+ "VALUES(?1,?2,?3,?4,(SELECT cust.c.userCardId,cust.id FROM User cust INNER JOIN CardBank c ON cust.c.userCardId = cust.id WHERE cust.id =: id ))")

	UserDto createPaymentCard();

	AddInBasket save(OrderByProcessingDto pmSer);

	@Query(value = "Select c.id,cu.id FROM User as cu INNER JOIN CardBank as c ON  cu.id = c.userCardId Where c.id =: ?1 and cu.id =: ?2", nativeQuery = true)

	CardBankDto getCardsByCustomerId(Integer cardId, Integer custId);

	CardBank save(CardBankDto cardB);

	@Query("Select c.id,cr.id,r.idRestorant From User c INNER JOIN  CardBank cr ON c.cr.userCardId = c.id"
			+ "INNER JOIN AddInBasket addB ON c.id = c.addB.custId"
			+ "INNER JOIN Restorant r ON r.c.id = restorant_users.userId  AND r.idRestorant = restorant_users.idRest "
			+ "Where c.id =: ?1 And cr.id =: ?2	And r.idRestorant IN"
			+ "(Select pm.Id,pm.payment_Method From r INNER JOIN PaymentMethods pm ON r.pm.paymentId = pm.idRestorant"
			+ "Where pm.Id =: ?1 and r.idRestorant =: ?2 )")

	CardBank getCardsByCustomerId(Integer registrationId, String BankId, Integer userCardId, Integer idRestorant,
			Integer pmId);

}

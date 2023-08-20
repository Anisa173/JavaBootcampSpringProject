package com.project.demo.sushiCo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.project.demo.sushiCo.domain.dto.OrderDto;
import com.project.demo.sushiCo.entity.Order;

import jakarta.validation.Valid;

@Service
public interface OrderRepository extends JpaRepository<Order, Integer> {

	@Query("Insert Into Order(orderPrize,orderItems,orderStatus,oTimeConfirmed,oTimeProccessed,idShporta,idCustomer,adminRestId) Values(?1,?2,?3,?4,?5,"
			+ "(Select o.idShporta From Order o Inner Join PackageOrdered p ON p.o.idShporta = p.id Where p.id =: id),"
			+ "(Select o.idCustomer From Order o Inner Join User c ON c.o.idCustomer = c.id Where c.id IN (Update c Set c.userStatus = 'IN-PROGRESS' Where c.id =: id )),"
			+ "(Select o.adminRestId From Order o Inner Join User a ON a.o.adminRestId = a.id Where a.id =: id))"
			+ "Select cst.o.orderPrize,cst.o.orderItems,cst.o.orderStatus"
			+ "From User cst INNER JOIN AddInBasket ab ON cst.id = cst.ab.userId"
			+ "INNER JOIN Order o ON cst.idCustomer = cst.o.oId"
			+ "INNER JOIN Restorant r ON r.cst.id = restorant_users.userId AND r.idRestorant = restorant_users.idRest"
			+ "WHERE cst.o.orderItems = sum(cst.ab.addItemDish)  AND cst.o.orderStatus = 'Pending' AND cst.o.orderPrize = sum(cst.ab.amountValue)  ")

	Order createOrder(@Valid OrderDto oDto);
	/*
	 * // Admini i webAplication rendit porosite sipas kostos ASC apo DESC dhe i
	 * grupon // sipas Restorantit perkates
	 * 
	 * @Query("Select o , r.idRestorant " +
	 * "From User c INNER JOIN Restorant r ON r.c.id = restorant_users.userId AND r.idRestorant = restorant_users.idRest "
	 * +
	 * "INNER JOIN Order o ON c.o.oId = c.idCustomer  Group By r.c.id  Order By r.c.o.orderPrize"
	 * ) OrderDto getOrderRbyCustId(Integer idRestorant, Integer customerId);
	 */

	// Çdo klient te shohe ne profilin e tij te gjitha porosite qe ka kryer dhe
	// ku?... ne cilin restorant i ka kryer
	@Query("Select r.restName , o  From User uc INNER JOIN Order o ON uc.id = uc.o.idCustomer "
			+ "	INNER JOIN Restorant r ON r.uc.id = restorant_users.userId AND r.idRestorant = restorant_users.idRest "
			+ "Where r.c.id =: id  Group By r.restName")
	List<Order> getOrdersRByCustomerId(Integer customerId);

	// Admini i restorantit kerkon te gjeneroje porosine me koston me te madhe dhe
	// me te vogel si edhe kush e kreu ate
	@Query(value = "Select c.customerName , max(o.orderPrize) as MaxPrize,min(o.orderPrize) as MinPrize,o.orderId"
			+ "From Order as o INNER JOIN User as c ON o.idCustomer = c.id"
			+ "	INNER JOIN User as a ON o.adminRestId = a.id" + " Where a.id =: id  ", nativeQuery = true)
	Order getOrderMaxByCustomerId(Integer idRestorant, Integer custId);

	// Porosia anullohet nga klienti
	@Modifying
	@Query(" UPDATE Order or SET deleted = true  And or.orderStatus = 'Cancel'  WHERE EXISTS "
			+ "( Select or From or INNER JOIN User c  ON c.id = c.or.idCustomer "
			+ "  INNER JOIN User a ON a.or.adminRestId = a.id   Where a.id =: id AND c.id =: id  And o.oId =: oId  ))")
	void cancelUserOrder(Integer adminRestId, Integer idCustomer,Integer oId);

	// Admini i restorantit rendit porosite sipas kostos ASC apo DESC te grupuara
	// per çdo klient
	@Query("Select o  From Order o INNER JOIN User c ON c.o.idCustomer = c.id"
			+ "INNER JOIN User a ON a.o.adminRestId = a.id" + "Order By c.o.orderPrize ASC  Group By c.id"
			+ "Where a.id =: id ")
	List<Order> getOrdersByCost(Integer idCustomer, Integer adminRestId);

//Porosia anullohet nga admini për arsye të pamundësisë për ta dërguar porosinë në destinacionin e kërkuar
	@Modifying
	@Query(" UPDATE Order or SET deleted = true And or.orderStatus = 'Cancel'  WHERE EXISTS  "
			+ " ( Select or From or INNER JOIN User c  ON c.id = c.or.idCustomer "
			+ "	INNER JOIN User a ON a.or.adminRestId = a.id  WHERE  or.oId =: ?1  And  a.id =: id  ) ")
	Order deleteOrder(Integer adminRestId, Integer oId);

}

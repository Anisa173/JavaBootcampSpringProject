package com.project.demo.sushiCo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.project.demo.sushiCo.domain.dto.OrderDto;
import com.project.demo.sushiCo.entity.Order;
import jakarta.validation.Valid;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
@Modifying
	@Query(" Insert Into Order(orderPrize,orderItems,orderStatus,oTimeConfirmed,oTimeProccessed,idShporta,idCustomer,adminRestId)" 
            + "  Values(?1,?2,?3,LocalDateTime.now(),LocalDateTime.now(), "
			+ " (Select o.idShporta From Order o Inner Join PackageOrdered p ON p.o.idShporta = p.id Where p.id =: id), "
            + " (Select o.idCustomer From Order o Inner Join User c ON c.o.idCustomer = c.id Where c.id =: id ), "
			+ " (Select o.adminRestId From Order o Inner Join User a ON a.o.adminRestId = a.id Where a.id =: id)) "
			+ " Select cst.o.orderPrize,cst.o.orderItems,cst.o.orderStatus "
			+ " From User cst INNER JOIN AddInBasket ab ON cst.id = cst.ab.userId "
			+ " INNER JOIN Order o ON cst.idCustomer = cst.o.oId "
			+ " INNER JOIN Restorant r ON r.cst.id = restorant_users.userId AND r.idRestorant = restorant_users.idRest "
			+ " WHERE o.orderItems =: sum(ab.addItemDish)  AND o.orderStatus =: 'Pending' AND cst.o.orderPrize =: sum(ab.amountValue) And r.idRestorant =: idRestorant  ")
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
			+ "	                                INNER JOIN Restorant r ON r.uc.id = restorant_users.userId AND r.idRestorant = restorant_users.idRest "
			+ "Where c.id =: id  Order By r.restName")
	List<Order> getOrdersRByCustomerId(Integer customerId);

	// Admini i restorantit kerkon te gjeneroje porosine me koston me te madhe dhe
	// me te vogel si edhe kush e kreu ate
	@Query(value = " Select CONCAT(c.first_name, ' ' ,c.last_name) as CustomerName , max(o.orderPrize) as MaxPrize, min(o.orderPrize) as MinPrize , o.orderId"
			+ " From Order as o INNER JOIN User as c ON o.idCustomer = c.id"
			+ "	                INNER JOIN User as a ON o.adminRestId = a.id" + " Where a.id =: id  "
            + " Group by CONCAT(c.first_name, ' ' ,c.last_name), o.orderId", nativeQuery = true)
	List<Order> getOrderMaxMinByCustomerId(Integer idRestorant, Integer userId);

	// Porosia anullohet nga klienti
	@Modifying
	@Query("UPDATE or  SET deleted = true , or.orderStatus = 'Cancel' FROM Order or WHERE EXISTS "
			+ "( Select or From User a "
			+ "  Where or.adminRestId = a.id And a.id = :id And or.oId IN " 
            + "(Select o.oId From Order o Inner Join User c ON  c.id = c.or.idCustomer"
            + "  Where c.id = :id and o.oId =:oId )")
	void cancelUserOrder(Integer id,Integer oId);

	// Admini i restorantit rendit porosite sipas kostos ASC apo DESC te grupuara
	// per çdo klient
	@Query("Select o From Order o INNER JOIN User c ON c.o.idCustomer = c.id "
			+                    "INNER JOIN User a ON a.o.adminRestId = a.id" 
            +                    "Order By o.orderPrize ASC  Group By c.id"
			+                    "Where a.id =: id ")
	List<Order> getOrdersByCost(Integer id);

    // Porosia anullohet nga admini për arsye të rradhës së gjatë apo kushte te pamundura per te realizuar transportin ne destinacion
	@Modifying
	@Query(" UPDATE or SET deleted = true , or.orderStatus = 'Cancel' FROM Order or WHERE or.oId IN  "
			+ " ( Select or.oId  From or INNER JOIN User c  ON c.id = c.or.idCustomer "
			+ "	INNER JOIN User a ON a.or.adminRestId = a.id  WHERE  or.oId =: ?1  And  a.id =: id  ) ")
	void deleteOrder(Integer adminRestId, Integer oId);


    @Query(" Select o From Order o INNER JOIN User a ON a.o.adminRestId = a.id "
    + " INNER JOIN User c ON c.o.idCustomer = c.id "
    + " Group By c.id  " 
    + " Where a.id =: id  ")
    List<Order> getOrderById(Integer userId);
  
    // Çdo klient duhet të shohë porositë që ka kryer në çdo restorant në këtë
 	// aplikacion sipas kohës qe jane kryer
	@Query("Select o,r.restName From Order o INNER JOIN User c ON c.o.idCustomer = c.id "
           + "INNER JOIN Restorant r ON r.c.id = restorant_users.userId AND r.idRestorant = restorant_users.idRest"
           + "Where c.id = :id"
           + "Group By r.restName" 
			)
    Order getOrdersByRestorantId(Integer customerId, Integer idRest, String restName) throws Exception;
	
	// Çdo klient te shohe ne profilin e tij te gjitha porosite qe ka kryer ne vetem
	// njerin prej restoranteve
	@Query("Select o , r.restName From Order o INNER JOIN User c ON c.o.idCustomer = c.id "
			+ "           INNER JOIN Restorant r ON r.c.id = restorant_users.userId AND r.idRestorant = restorant_users.idRest"
			+ "           Where c.id = :id and r.idRestorant=:idRestorant")
	Order getOrdByRestorantId(Integer id, Integer idRestorant);

	
}

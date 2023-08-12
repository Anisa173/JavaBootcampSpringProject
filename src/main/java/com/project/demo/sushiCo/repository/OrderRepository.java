package com.project.demo.sushiCo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.project.demo.sushiCo.domain.dto.OrderDto;
import com.project.demo.sushiCo.entity.Order;

@Service
public interface OrderRepository extends JpaRepository<Order, Integer> {

	@Query("Insert Into Order(orderPrize,orderItems,orderStatus,oTimeConfirmed,oTimeProccessed)"
			+ "Select uc.o.orderPrize,uc.o.orderItems,uc.o.orderStatus"
			+ "From User uc INNER JOIN AddInBasket ab ON uc.id =uc.ab.userId"
			+ "INNER JOIN Order o ON uc.idCustomer = uc.o.oId"
			+ "INNER JOIN Restorant r ON r.uc.id = restorant_users.userId AND r.idRestorant = restorant_users.idRest"
			+ "WHERE uc.o.orderItems = sum(uc.ab.addItemDish) AND uc.o.orderPrize = sum(uc.ab.amountValue) AND uc.o.orderStatus = 'Pending' ")
	Order createOrder();

	// Admini i webAplication rendit porosite sipas kostos ASC apo DESC dhe i grupon
	// sipas idRestorant
	@Query("Select r.c.o , r.idRestorant "
			+ "From User c INNER JOIN Restorant r ON r.c.id = restorant_users.userId AND r.idRestorant = restorant_users.idRest "
			+ "INNER JOIN Order o ON c.o.oId = c.idCustomer " + "Group By r.c.id " + "Order By r.c.o.orderPrize ASC ")

	OrderDto getOrderRbyCustId(Integer idRestorant, Integer customerId);

	// Cdo klient te shohe porosite qe ka kryer për çdo restorant ne kete aplikacion
	@Query("Select r.restName ,r.c.o" + "From User uc INNER JOIN Order o ON uc.idCustomer = uc.o.oId "
			+ "	INNER JOIN Restorant r ON r.uc.id = restorant_users.userId AND r.idRestorant = restorant_users.idRest "
			+ "Where r.c.id =: id " + "Group By r.restName ")
	List<OrderDto> getOrdersByRestorantId(Integer customerId, Integer restorantId);

	// Çdo klient te shohe ne profilin e tij te gjitha porosite qe ka kryer dhe
	// ku?... ne cilin restorant i ka kryer
	@Query("Select r.restName ,r.c.o" + "From User uc INNER JOIN Order o ON uc.idCustomer = uc.o.oId "
			+ "	INNER JOIN Restorant r ON r.uc.id = restorant_users.userId AND r.idRestorant = restorant_users.idRest "
			+ "Where r.c.id =: id ")
	List<OrderDto> getOrdersRByCustomerId(Integer customerId);

	// Admini i webAplication rendit porosite sipas kostos ASC apo DESC
	@Query("Select c.o , c.customerName " + "From User c INNER JOIN Order o ON c.o.oId = c.idCustomer"
			+ "Order By c.o.orderPrize ASC ")
	List<OrderDto> getOrdersByCost();

	// Admini i restorantit kerkon te gjeneroje porosine me koston me te madhe dhe
	// me te vogel si edhe kush e kreu ate
	@Query(value = "Select c.customerName , max(o.orderPrize),min(o.orderPrize),o.orderId"
			+ "From User as uc INNER JOIN Order  as o ON uc.idCustomer = o.oId "
			+ "	INNER JOIN Restorant as r ON uc.id = restorant_users.userId AND r.idRestorant = restorant_users.idRest "
			+ " Where r.idRestorant =: idRestorant ", nativeQuery = true)
	OrderDto getOrderMaxByCustomerId(Integer idRestorant, Integer custId);

	// Çdo klient te shohe ne profilin e tij te gjitha porosite qe ka kryer ne
	// njerin prej restoranteve
	@Query("Select r.restName ,r.c.o" + "From User uc INNER JOIN Order o ON uc.idCustomer = uc.o.oId "
			+ "	INNER JOIN Restorant r ON r.uc.id = restorant_users.userId AND r.idRestorant = restorant_users.idRest "
			+ "Where r.c.id =: id AND r.idRestorant =: idRestorant ")
	List<OrderDto> getOrdByRestorantId(Integer customerId, Integer restorantId);

	// Anullon porosine e konfirmuar 'customer'
	@Modifying
	@Query("Update Order or Set deleted = true Where or.idCustomer IN"
			+ "(Select c.or From User c INNER JOIN c.or ON c.id = c.or.idCustomer"
			+ "Where c.or.orderStatus ='Cancel' AND c.id =: id ))")
	void cancelUserOrder(Integer orderId, Integer customerId);

	/*
	 * @Modifying
	 * 
	 * @Query("update Product p set deleted = true where p = :p") void
	 * delete(Product p);
	 */

}

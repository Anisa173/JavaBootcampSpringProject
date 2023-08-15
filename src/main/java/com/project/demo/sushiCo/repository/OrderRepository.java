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

	@Query("Insert Into Order(orderPrize,orderItems,orderStatus,oTimeConfirmed,oTimeProccessed,idShporta,idCustomer,adminRestId) Values(?1,?2,?3,?4,?5,"
			+ "(Select o.idShporta From Order o Inner Join PackageOrdered p ON p.o.idShporta = p.id Where p.id =: id),"
			+ "(Select o.idCustomer From Order o Inner Join User c ON c.o.idCustomer = c.id Where c.id =: id ),"
			+ "(Select o.adminRestId From Order o Inner Join User a ON a.o.adminRestId = a.id Where a.id =: id))"
			+ "Select uc.o.orderPrize,uc.o.orderItems,uc.o.orderStatus"
			+ "From User uc INNER JOIN AddInBasket ab ON uc.id = uc.ab.userId"
			+ "INNER JOIN Order o ON uc.idCustomer = uc.o.oId"
			+ "INNER JOIN Restorant r ON r.uc.id = restorant_users.userId AND r.idRestorant = restorant_users.idRest"
			+ "WHERE uc.o.orderItems = sum(uc.ab.addItemDish) AND uc.o.orderPrize = sum(uc.ab.amountValue) AND uc.o.orderStatus = 'Pending' ")

	Order createOrder();

	// Admini i webAplication rendit porosite sipas kostos ASC apo DESC dhe i grupon
	// sipas Restorantit perkates
	@Query("Select r.c.o , r.idRestorant "
			+ "From User c INNER JOIN Restorant r ON r.c.id = restorant_users.userId AND r.idRestorant = restorant_users.idRest "
			+ "INNER JOIN Order o ON c.o.oId = c.idCustomer " + "Group By r.c.id " + "Order By r.c.o.orderPrize ASC ")

	OrderDto getOrderRbyCustId(Integer idRestorant, Integer customerId);

	// Çdo klient te shohe porosite qe ka kryer për çdo restorant ne kete aplikacion
	@Query("Select r.restName ,r.c.o" + "From User uc INNER JOIN Order o ON uc.id = uc.o.idCustomer "
			+ "	INNER JOIN Restorant r ON r.uc.id = restorant_users.userId AND r.idRestorant = restorant_users.idRest "
			+ "Where r.c.id =: id " + "Group By r.restName ")
	List<OrderDto> getOrdersByRestorantId(Integer customerId, Integer restorantId);

	// Çdo klient te shohe ne profilin e tij te gjitha porosite qe ka kryer dhe
	// ku?... ne cilin restorant i ka kryer
	@Query("Select r.restName ,r.c.o" + "From User uc INNER JOIN Order o ON uc.id = uc.o.idCustomer "
			+ "	INNER JOIN Restorant r ON r.uc.id = restorant_users.userId AND r.idRestorant = restorant_users.idRest "
			+ "Where r.c.id =: id ")
	List<OrderDto> getOrdersRByCustomerId(Integer customerId);

	// Admini i webAplication rendit porosite sipas kostos ASC apo DESC
	@Query("Select c.o , c.customerName " + "From User c INNER JOIN Order o ON c.o.idCustomer = c.id"
			+ "Order By c.o.orderPrize ASC ")
	List<OrderDto> getOrdersByCost();

	// Admini i restorantit kerkon te gjeneroje porosine me koston me te madhe dhe
	// me te vogel si edhe kush e kreu ate
	@Query(value = "Select c.customerName , max(o.orderPrize) as MaxPrize,min(o.orderPrize) as MinPrize,o.orderId"
			+ "From Order as o INNER JOIN User as c ON o.idCustomer = c.id"
			+ "	INNER JOIN User as a ON o.adminRestId = a.id" + " Where a.id =: id  ", nativeQuery = true)
	OrderDto getOrderMaxByCustomerId(Integer idRestorant, Integer custId);

	// Çdo klient te shohe ne profilin e tij te gjitha porosite qe ka kryer ne
	// njerin prej restoranteve
	@Query("Select r.restName ,r.c.o" + "From User uc INNER JOIN Order o ON uc.id = uc.o.idCustomer "
			+ "	INNER JOIN Restorant r ON r.uc.id = restorant_users.userId AND r.idRestorant = restorant_users.idRest "
			+ "Where r.c.id =: id AND r.idRestorant =: idRestorant ")
	List<OrderDto> getOrdByRestorantId(Integer customerId, Integer restorantId);

	// Anullon porosine e konfirmuar 'customer'
	@Modifying
	@Query("UPDATE Order or SET deleted = true WHERE Exists"
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

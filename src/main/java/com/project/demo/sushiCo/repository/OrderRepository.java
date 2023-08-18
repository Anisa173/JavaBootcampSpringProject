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
			+ "WHERE uc.o.orderItems = sum(uc.ab.addItemDish)  AND uc.o.orderStatus = 'Pending' AND uc.o.orderPrize = sum(uc.ab.amountValue) ")

Order createOrder();

/*	// Admini i webAplication rendit porosite sipas kostos ASC apo DESC dhe i grupon
	// sipas Restorantit perkates
	@Query("Select o , r.idRestorant "
			+ "From User c INNER JOIN Restorant r ON r.c.id = restorant_users.userId AND r.idRestorant = restorant_users.idRest "
			+ "INNER JOIN Order o ON c.o.oId = c.idCustomer  Group By r.c.id  Order By r.c.o.orderPrize")
	OrderDto getOrderRbyCustId(Integer idRestorant, Integer customerId);*/

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

	// Anullon porosine e konfirmuar 'customer'
	@Modifying
	@Query("UPDATE Order or SET deleted = true WHERE Exists"
			+ "(Select or From User c INNER JOIN or ON c.id = c.or.idCustomer"
			+ "Where c.or.orderStatus ='Cancel' AND c.id =: id ))")
	void cancelUserOrder(Integer orderId, Integer customerId);

	// Admini i restorantit rendit porosite sipas kostos ASC apo DESC te grupuara
	// per çdo klient
	@Query("Select o  From Order o INNER JOIN User c ON c.o.idCustomer = c.id"
			+ "INNER JOIN User a ON a.o.adminRestId = a.id" + "Order By c.o.orderPrize ASC  Group By c.id"
			+ "Where a.id =: id ")
	List<Order> getOrdersByCost(Integer idCustomer, Integer adminRestId);


}

package com.project.demo.sushiCo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
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

	//Admini i webAplication rendit porosite sipas kostos ASC apo DESC dhe i grupon sipas idRestorant
	@Query("Select r.c.o , r.idRestorant "
+ "From User c INNER JOIN Restorant r ON  "
+ "INNER JOIN Order o ON "	
+ "Group By "	
+ "Order By "	
	)
	OrderDto getOrderRbyCustId(Integer idRestorant, Integer customerId);

	@Query(" ")

	List<OrderDto> getOrdersByRestorantId(Integer customerId, Integer restorantId);

	@Query(" ")
	List<OrderDto> getOrdersRByCustomerId(Integer customerId);

	@Query(" ")
	List<OrderDto> getOrdersByCustId(Integer customerId);

	@Query(" ")
	OrderDto getOrderMaxByCustomerId(Integer idRestorant, Integer custId);

	@Query(" ")
	List<OrderDto> getRestorantOrders(Integer adminIdR);

}

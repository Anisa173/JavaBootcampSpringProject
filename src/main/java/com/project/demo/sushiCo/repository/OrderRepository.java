package com.project.demo.sushiCo.repository;

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

	OrderDto getOrderRbyCustId(Integer idRestorant, Integer customerId);

}

package com.project.demo.sushiCo.service;

import java.util.List;

import com.project.demo.sushiCo.domain.dto.OrderDto;
import com.project.demo.sushiCo.domain.dto.UserDto;

public interface OrderService {

	OrderDto createOrder() throws Exception;

	// Admini i aplikacionit 'sheh' porosite sipas customerId dhe dates se
	// proçesimit
	List<OrderDto> getOrders() throws Exception;

	// Cdo klient te shohe porosite qe ka kryer në çdo restorant ne kete aplikacion
	List<OrderDto> getOrdersByRestorantId(Integer customerId, Integer restorantId) throws Exception;

	// Çdo klient te shohe ne profilin e tij te gjitha porosite qe ka kryer dhe
	// ku?... ne cilin restorant i ka kryer
	List<OrderDto> getOrdersRByCustomerId(Integer customerId) throws Exception;

	// Çdo klient te shohe ne profilin e tij te gjitha porosite qe ka kryer ne cilin restorant 
	List<OrderDto> getOrdByRestorantId(Integer customerId, Integer restorantId) throws Exception;
	
	//Admini i webAplication rendit porosite sipas kostos ASC apo DESC
	List<OrderDto> getOrdersByCost() throws Exception;

     //Admini i restorantit kerkon te gjeneroje Porosine me koston me te madhe dhe me te vogel si edhe kush e kryer ate 
	OrderDto getOrderMaxByCustomerId(Integer idRestorant, Integer custId) throws Exception;
	
	// Anullon porosine e konfirmuar 'customer'
	void cancelUserOrder(Integer orderId,Integer customerId) throws Exception;

}

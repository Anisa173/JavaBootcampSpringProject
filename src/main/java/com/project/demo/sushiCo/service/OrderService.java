package com.project.demo.sushiCo.service;

import java.util.List;

import com.project.demo.sushiCo.domain.dto.OrderDto;

public interface OrderService {

	OrderDto createOrder() throws Exception;

	// Admini i aplikacionit 'sheh' porosite sipas customerId dhe dates se
	// proçesimit
	List<OrderDto> getOrders() throws Exception;

	// Admini i restorantit 'sheh' porosite sipas customerId dhe dates se proçesimit
	List<OrderDto> getRestorantOrders(Integer adminIdR) throws Exception;

	// Cdo klient te shohe porosite qe ka kryer në çdo restorant ne kete aplikacion
	List<OrderDto> getOrdersByRestorantId(Integer customerId, Integer restorantId) throws Exception;

	// Çdo klient te shohe ne profilin e tij te gjitha porosite qe ka kryer dhe
	// ku?... ne cilin restorant i ka kryer
	List<OrderDto> getOrdersRByCustomerId(Integer customerId) throws Exception;

     //Admini i webAplication rendit porosite sipas kostos ASC apo DESC
	List<OrderDto> getOrdersByCustId(Integer customerId) throws Exception;

     //Admini i restorantit kerkon te gjeneroje Porosine me koston me te madhe dhe me te vogel si edhe kush e kryer ate 
	OrderDto getOrderMaxByCustomerId(Integer idRestorant, Integer custId) throws Exception;

}

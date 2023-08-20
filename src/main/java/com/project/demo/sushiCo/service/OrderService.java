package com.project.demo.sushiCo.service;

import java.util.List;
import com.project.demo.sushiCo.domain.dto.OrderDto;

import jakarta.validation.Valid;

public interface OrderService {

	// Admini qe menaxhon porosite e Restorantit kancelon nje porosi per arsye te
	// pamundesise per ta transportuar ate porosi
	OrderDto deleteOrder(Integer adminRestId, Integer oId) throws Exception;

	OrderDto createOrder(@Valid OrderDto oDto) throws Exception;

	// Admini i webAplication rendit porosite sipas kostos ASC apo DESC te grupuara
	// per çdo restorant
	List<OrderDto> getOrdersByCost(Integer idCustomer, Integer adminRestId) throws Exception;

	// Cdo klient te shohe porosite qe ka kryer në çdo restorant ne kete aplikacion
	List<OrderDto> getOrdersByRestorantId(Integer customerId, Integer idRest, String restName) throws Exception;

	// Çdo klient te shohe ne profilin e tij te gjitha porosite qe ka kryer dhe
	// ku?... ne cilin restorant i ka kryer
	List<OrderDto> getOrdersRByCustomerId(Integer customerId) throws Exception;

	// Çdo klient te shohe ne profilin e tij te gjitha porosite qe ka kryer ne cilin
	// restorant
	List<OrderDto> getOrdByRestorantId(Integer customerId, Integer restorantId) throws Exception;

	// Admini i restorantit kerkon te gjeneroje Porosine me koston me te madhe dhe
	// me te vogel si edhe kush e kryer ate
	OrderDto getOrderMaxByCustomerId(Integer idRestorant, Integer custId) throws Exception;

	// Klienti anullon porosine e kryer ne restorantin 'X'
	void cancelUserOrder(Integer adminRestId, Integer idCustomer, Integer oId) throws Exception;

	// Admini i aplikacionit 'sheh' porosite sipas customerId dhe dates se
	// proçesimit
	List<OrderDto> getOrders() throws Exception;

}

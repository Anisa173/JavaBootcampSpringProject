package com.project.demo.sushiCo.service;

import com.project.demo.sushiCo.domain.dto.OrderDto;

public interface OrderService {

	OrderDto getOrderRbyCustId(Integer idRestorant,Integer customerId) throws Exception;

	OrderDto getRestorantOrders(Integer restorantId) throws Exception;

	OrderDto createOrder() throws Exception;
}

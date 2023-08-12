package com.project.demo.sushiCo.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.demo.sushiCo.domain.dto.OrderDto;
import com.project.demo.sushiCo.domain.mappers.OrderMapper;
import com.project.demo.sushiCo.repository.OrderRepository;
import com.project.demo.sushiCo.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private final OrderMapper orderMapper;
	private final OrderRepository orderRepository;

	public OrderServiceImpl(OrderMapper orderMapper, OrderRepository orderRepository) {
		this.orderMapper = orderMapper;
		this.orderRepository = orderRepository;
	}



	@Override
	public OrderDto createOrder() throws Exception {
		
		return orderMapper.toDto(orderRepository.createOrder()) ;
	}

	@Override
	public OrderDto getOrderRbyCustId(Integer idRestorant,Integer customerId) throws Exception {
		return orderRepository.getOrderRbyCustId(idRestorant, customerId);
	}

	@Override
	public OrderDto getRestorantOrders(Integer restorantId) throws Exception {
	
		return null;
	}


}

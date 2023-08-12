package com.project.demo.sushiCo.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

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

	// Admini i aplikacionit 'sheh' porositë sipas customerId dhe datës së
	// proçesimit
	@Override
	public List<OrderDto>  getOrders() throws Exception {
		return orderRepository.findAll().stream().map(m -> orderMapper.toDto(m)).collect(Collectors.toList());
	}


	//Çdo klient duhet të shohë porositë që ka kryer në çdo restorant në këtë aplikacion
	@Override
	public List<OrderDto> getOrdersByRestorantId(Integer customerId, Integer restorantId) throws Exception {
	
		return  orderRepository.getOrdersByRestorantId(customerId, restorantId);
	}


	// Çdo klient të shohë në profilin e tij të gjitha porositë që ka kryer dhe
	// ku?... në cilin restorant i ka kryer
	@Override
	public List<OrderDto> getOrdersRByCustomerId(Integer customerId) throws Exception {
	
		return orderRepository.getOrdersRByCustomerId(customerId);
	}


	//Admini i webAplication rendit porositë sipas kostos ASC apo DESC te grupuara sipas customerId
	@Override
	public List<OrderDto> getOrdersByCustId(Integer customerId) throws Exception {
		
		return orderRepository.getOrdersByCustId(customerId);
	}


	 //Admini i restorantit kërkon të gjenerojë porosinë me koston më të madhe ose më të vogël si edhe kush e kryer atë 
	@Override
	public OrderDto getOrderMaxByCustomerId(Integer idRestorant, Integer custId) throws Exception {
		
		return orderRepository.getOrderMaxByCustomerId(idRestorant, custId);
	}
	
	// Admini i restorantit 'sheh' porositë sipas customerId dhe datës së proçesimit
	@Override
	public List<OrderDto> getRestorantOrders(Integer adminIdR) throws Exception {
		
		return ((OrderRepository) orderRepository).getRestorantOrders(adminIdR);
	}

	


}

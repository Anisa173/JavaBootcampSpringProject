package com.project.demo.sushiCo.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import com.project.demo.sushiCo.domain.dto.OrderDto;
import com.project.demo.sushiCo.domain.mappers.OrderMapper;
import com.project.demo.sushiCo.repository.OrderRepository;
import com.project.demo.sushiCo.service.OrderService;
import jakarta.validation.Valid;

@Validated
@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private final OrderMapper orderMapper;
	@Autowired
	private final OrderRepository orderRepository;

	public OrderServiceImpl(OrderMapper orderMapper, OrderRepository orderRepository) {
		this.orderMapper = orderMapper;
		this.orderRepository = orderRepository;
	}

	@Override
	public OrderDto createOrder(@Valid OrderDto oDto) throws Exception {
		return (orderMapper.toDto(orderRepository.createOrder(oDto)));
	}

	// Admini i aplikacionit 'sheh' porositë sipas customerId dhe datës së
	// proçesimit per arsye analitike
	@Override
	public List<OrderDto> getOrders() throws Exception {
		return orderRepository.findAll().stream().map(a -> orderMapper.toDto(a)).collect(Collectors.toList());
}
	// Çdo klient duhet të shohë porositë që ka kryer në çdo restorant në këtë
	// aplikacion sipas kohës qe jane kryer
	@SuppressWarnings("unchecked")
	@Override
	public List<OrderDto> getOrdersByRestorantId(Integer customerId, Integer idRest, String restName) throws Exception {
		return (List<OrderDto>) orderMapper.toDto((orderRepository).getOrdersByRestorantId(customerId,idRest,restName));
	}

	// Çdo klient të shohë në profilin e tij të gjitha porositë që ka kryer

	@Override
	public List<OrderDto> getOrdersRByCustomerId(Integer customerId) throws Exception {

		return orderMapper.toDto(orderRepository.getOrdersRByCustomerId(customerId));
	}

	// Admini i restorantit rendit porosite sipas kostos ASC apo DESC te grupuara
	// per çdo klient
	@Override
	public List<OrderDto> getOrdersByCost(Integer id) throws Exception {

		return orderMapper.toDto(orderRepository.getOrdersByCost(id));
	}

	// Admini i restorantit kërkon të gjenerojë porosinë me koston më të madhe ose
	// më të vogël si edhe kush e kryer atë
	@Override
	public List<OrderDto> getOrderMaxMinByCustomerId(Integer idRestorant, Integer userId) throws Exception {

		return orderMapper.toDto(orderRepository.getOrderMaxMinByCustomerId(idRestorant, userId));
	}

	// Çdo klient te shohe ne profilin e tij te gjitha porosite qe ka kryer ne vetem
	// njerin prej restoranteve
	@SuppressWarnings("unchecked")
	@Override
	public List<OrderDto> getOrdByRestorantId(Integer id, Integer idRestorant) throws Exception {
		return (List<OrderDto>) orderMapper.toDto(orderRepository.getOrdByRestorantId(id,idRestorant));
	}

	@Override
	public void cancelUserOrder(Integer id, Integer oId) throws Exception {
		orderRepository.cancelUserOrder(id, oId);
	}

	@Override
	public void deleteOrder(Integer adminRestId, Integer oId) throws Exception {
		orderRepository.deleteOrder(adminRestId, oId);
	}

	@Override
	public List<OrderDto> getOrdersById(Integer userId) throws Exception {
		
		return orderMapper.toDto(orderRepository.getOrderById(userId));
	}

	
}

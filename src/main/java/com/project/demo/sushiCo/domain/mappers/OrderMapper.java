package com.project.demo.sushiCo.domain.mappers;

import org.springframework.stereotype.Component;

import com.project.demo.sushiCo.domain.dto.OrderDto;
import com.project.demo.sushiCo.entity.Order;
@Component
public class OrderMapper extends BaseMapper<Order, OrderDto> {

	@Override
	public Order toEntity(OrderDto dto) {
	Order order = new Order();	
	order.setOId(dto.getOId());
	order.setOrderPrize(dto.getOrderPrize());
	order.setOrderItems(dto.getOrderItems());
	order.setOrderStatus(dto.getOrderStatus());
	return order;
	}

	@Override
	public OrderDto toDto(Order entity) {
	OrderDto orderDto = new OrderDto();
	orderDto.setOId(entity.getId());
	orderDto.setOrderPrize(entity.getOrderPrize());
	orderDto.setOrderItems(entity.getOrderItems());
	orderDto.setOrderStatus(entity.getOrderStatus());
	orderDto.setPaymentMethodId(entity.getP_methods().getId());
	var paymentMethodRest = entity.getP_methods().getPayment_Method();
	orderDto.setPaymentMethodRest(paymentMethodRest);
	orderDto.setIdShporta(entity.getPackage_Ordered().getId());
	var totalDish = entity.getDish().stream().count();
	orderDto.setTotalDish(totalDish);
	orderDto.setIdCustomer(entity.getUser().getId());
	var customerName = entity.getUser().getFirst_name().concat(" ").concat(entity.getUser().getLast_name());
	orderDto.setCustomerName(customerName);	
		
		return orderDto;
	}

	@Override
	public Order toUpdate(OrderDto dto, Order entity) {
		entity.setOrderPrize(dto.getOrderPrize());
		entity.setOrderItems(dto.getOrderItems());
		entity.setOrderStatus(dto.getOrderStatus());	
		return entity;
	}

}

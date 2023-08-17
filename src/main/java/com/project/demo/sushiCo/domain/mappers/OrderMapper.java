package com.project.demo.sushiCo.domain.mappers;

import java.util.ArrayList;
import java.util.List;

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
	var totalP_Methods = entity.getP_methods().stream().count();
	orderDto.setTotalP_methods(totalP_Methods);
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

	@Override
	public List<Order> toEntity(List<OrderDto> dtoList) {
		if ( dtoList == null ) {
            return null;
        }

        List<Order> list = new ArrayList<Order>( dtoList.size() );
        for ( OrderDto ordDto : dtoList ) {
            list.add( toEntity( ordDto ) );
        }

        return list;
    }

	@Override
	public List<OrderDto> toDto(List<Order> entityList) {
		if ( entityList == null ) {
            return null;
        }

        List<OrderDto> list = new ArrayList<OrderDto>( entityList.size() );
        for ( Order o : entityList ) {
            list.add( toDto( o ) );
        }

        return list;
    }

	




}

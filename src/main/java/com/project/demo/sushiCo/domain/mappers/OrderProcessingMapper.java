package com.project.demo.sushiCo.domain.mappers;

import java.util.List;

import com.project.demo.sushiCo.domain.dto.OrderByProcessingDto;
import com.project.demo.sushiCo.service.OrderByProcessing;

public class OrderProcessingMapper extends BaseMapper<OrderByProcessing,OrderByProcessingDto> {
	@Override
	public OrderByProcessing toEntity(OrderByProcessingDto dto) {
	var orderP = new OrderByProcessing();
	orderP.setIdcust(dto.getIdcust());
	orderP.setPaymentMId(dto.getPaymentMId());
	orderP.setPayments_methodR(dto.getPayments_methodR());
	orderP.setServicePId(dto.getServicePId());
	orderP.setService_placesR(dto.getService_placesR());
	return orderP;
	}

	@Override
	public OrderByProcessingDto toDto(OrderByProcessing entity) {
		var orderP = new OrderByProcessingDto();
		orderP.setIdcust(entity.getId());
		orderP.setPaymentMId(entity.getPaymentMId());
		orderP.setPayments_methodR(entity.getPayments_methodR());
		orderP.setServicePId(entity.getServicePId());
		orderP.setService_placesR(entity.getService_placesR());
		return orderP;	
		
	}

	@Override
	public OrderByProcessing toUpdate(OrderByProcessingDto dto, OrderByProcessing entity) {
		entity.setPayments_methodR(dto.getPayments_methodR());
		entity.setService_placesR(dto.getService_placesR());
		return entity;
	}

	@Override
	public List<OrderByProcessing> toEntity(List<OrderByProcessingDto> dtoList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderByProcessingDto> toDto(List<OrderByProcessing> entityList) {
		// TODO Auto-generated method stub
		return null;
	}

}

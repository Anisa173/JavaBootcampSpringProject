package com.project.demo.sushiCo.domain.mappers;

import java.util.ArrayList;
import java.util.List;
import com.project.demo.sushiCo.domain.dto.OrderByProcessingDto;
import com.project.demo.sushiCo.service.OrderByProcessing;

public class OrderProcessingMapper extends BaseMapper<OrderByProcessing, OrderByProcessingDto> {
	@Override
	public OrderByProcessing toEntity(OrderByProcessingDto dto) {
		var orderP = new OrderByProcessing();
		orderP.setIdcust(dto.getIdcust());
		orderP.setPayments_methodR(dto.getPayments_methodR());
		orderP.setService_placesR(dto.getService_placesR());
		return orderP;
	}

	@Override
	public OrderByProcessingDto toDto(OrderByProcessing entity) {
		var orderP = new OrderByProcessingDto();
		orderP.setIdcust(entity.getId());
		orderP.setPayments_methodR(entity.getPayments_methodR());
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
		if (dtoList == null) {
			return null;
		}

		List<OrderByProcessing> list = new ArrayList<OrderByProcessing>(dtoList.size());
		for (OrderByProcessingDto ordInDto : dtoList) {
			list.add(toEntity(ordInDto));
		}
		return list;
	}

	@Override
	public List<OrderByProcessingDto> toDto(List<OrderByProcessing> entityList) {
		if (entityList == null) {
			return null;
		}
		List<OrderByProcessingDto> list = new ArrayList<OrderByProcessingDto>(entityList.size());
		for (OrderByProcessing ord : entityList) {
			list.add(toDto(ord));

		}
		return list;
	}

}

package com.project.demo.sushiCo.domain.mappers;

import org.springframework.stereotype.Component;

import com.project.demo.sushiCo.domain.dto.AddInBasketDto;
import com.project.demo.sushiCo.entity.AddInBasket;
@Component
public class AddInBasketMapper extends BaseMapper<AddInBasket, AddInBasketDto> {

	@Override
	public AddInBasket toEntity(AddInBasketDto dto) {
		AddInBasket inBasket = new AddInBasket();
		inBasket.setAddId(dto.getAddId());
		inBasket.setAddItemsDish(dto.getAddItemsDish());
		return inBasket;
	}

	@Override
	public AddInBasketDto toDto(AddInBasket entity) {
		AddInBasketDto basketDto = new AddInBasketDto();
		basketDto.setAddId(entity.getId());
		basketDto.setAddItemsDish(entity.getAddItemsDish());
		basketDto.setCustId(entity.getUser().getId());
		var phoneNo = entity.getUser().getPhoneNo();
		basketDto.setPhoneNo(phoneNo);
		var customerName = entity.getUser().getFirst_name().concat(" ").concat(entity.getUser().getLast_name());
		basketDto.setCustomerName(customerName);
		basketDto.setDishId(entity.getId());
		var dishName = entity.getDish().getDishName();
		basketDto.setDishName(dishName);
		return basketDto;
	}

	@Override
	public AddInBasket toUpdate(AddInBasketDto dto, AddInBasket entity) {
		entity.setAddItemsDish(dto.getAddItemsDish());
		return entity;
	}



}

package com.project.demo.sushiCo.domain.mappers;

import java.util.ArrayList;
import java.util.List;

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
		inBasket.setValueAmount(dto.getValueAmount());
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
		basketDto.setDishes(entity.getDish());
		basketDto.setdCatId(entity.getDishCategory().getId());
		var dishType = entity.getDishCategory().getCategoryName();
		basketDto.setDishType(dishType);
		return basketDto;
	}

	@Override
	public AddInBasket toUpdate(AddInBasketDto dto, AddInBasket entity) {
		entity.setAddItemsDish(dto.getAddItemsDish());
		return entity;
	}

	@Override
	public List<AddInBasket> toEntity(List<AddInBasketDto> dtoList) {
		if ( dtoList == null ) {
            return null;
        }

        List<AddInBasket> list = new ArrayList<AddInBasket>( dtoList.size() );
        for ( AddInBasketDto addInDto : dtoList ) {
            list.add( toEntity( addInDto ) );
        }

        return list;

	}

	@Override
	public List<AddInBasketDto> toDto(List<AddInBasket> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<AddInBasketDto> list = new ArrayList<AddInBasketDto>( entityList.size() );
        for ( AddInBasket addInB : entityList ) {
            list.add( toDto( addInB ) );
        }

        return list;
    }



}

package com.project.demo.sushiCo.domain.mappers;

import java.util.ArrayList;
import java.util.List;
import com.project.demo.sushiCo.domain.dto.RegisterDishFormDto;
import com.project.demo.sushiCo.serviceImpl.RegisterDishForm;

public class RegisterDishFormMapper extends BaseMapper<RegisterDishForm,RegisterDishFormDto>{

	@Override
	public RegisterDishForm toEntity(RegisterDishFormDto dto) {
	var regDish = new RegisterDishForm();	
	regDish.setIdRegistration(dto.getIdRegistration());
	regDish.setDId(dto.getDId());
	regDish.setDishName(dto.getDishName());
	regDish.setDishPrize(dto.getDishPrize());
	regDish.setDishDescription(dto.getDishDescription());
	regDish.setDishType(dto.getDishType());
	regDish.setAdminId(dto.getAdminId());
	regDish.setCategoryId(dto.getCategoryId());
	return regDish;
	}
	@Override
	public RegisterDishFormDto toDto(RegisterDishForm entity) {
		var regDish = new RegisterDishFormDto();	
		regDish.setIdRegistration(entity.getId());
		regDish.setDId(entity.getDId());
		regDish.setDishName(entity.getDishName());
		regDish.setDishPrize(entity.getDishPrize());
		regDish.setDishDescription(entity.getDishDescription());
		regDish.setDishType(entity.getDishType());
		regDish.setAdminId(entity.getAdminId());
		regDish.setCategoryId(entity.getCategoryId());
		return regDish;
	}

	@Override
	public RegisterDishForm toUpdate(RegisterDishFormDto dto, RegisterDishForm entity) {
		entity.setDishName(dto.getDishName());
		entity.setDishPrize(dto.getDishPrize());
		entity.setDishDescription(dto.getDishDescription());
		entity.setDishType(dto.getDishType());
	return entity;
	}

	@Override
	public List<RegisterDishForm> toEntity(List<RegisterDishFormDto> dtoList) {
		if ( dtoList == null ) {
            return null;
        }

        List<RegisterDishForm> list = new ArrayList<RegisterDishForm>( dtoList.size() );
        for ( RegisterDishFormDto regDishDto : dtoList ) {
            list.add( toEntity( regDishDto ) );
        }

        return list;

	}

	@Override
	public List<RegisterDishFormDto> toDto(List<RegisterDishForm> entityList) {
		if ( entityList == null ) {
            return null;
        }

        List<RegisterDishFormDto> list = new ArrayList<RegisterDishFormDto>( entityList.size() );
        for ( RegisterDishForm regDish : entityList ) {
            list.add( toDto( regDish ) );
        }

        return list;
	}

}

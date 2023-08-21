package com.project.demo.sushiCo.domain.mappers;

import java.util.ArrayList;
import java.util.List;
import com.project.demo.sushiCo.domain.dto.SelectWhichYouPreferFormDto;
import com.project.demo.sushiCo.service.SelectWhichYouPreferForm;

public class SelectWhichYouPreferMapper extends BaseMapper<SelectWhichYouPreferForm,SelectWhichYouPreferFormDto> {

	@Override
	public SelectWhichYouPreferForm toEntity(SelectWhichYouPreferFormDto dto) {
		var selectPref = new SelectWhichYouPreferForm();
	selectPref.setIdSelect(dto.getIdSelect());
	selectPref.setRestName(dto.getRestName());	
		return  selectPref;
	}

	@Override
	public SelectWhichYouPreferFormDto toDto(SelectWhichYouPreferForm entity) {
		var selectPref = new SelectWhichYouPreferFormDto();
		selectPref.setIdSelect(entity.getId());
		selectPref.setRestName(entity.getRestName());	
			return  selectPref;
	}

	@Override
	public SelectWhichYouPreferForm toUpdate(SelectWhichYouPreferFormDto dto, SelectWhichYouPreferForm entity) {
	entity.setRestName(dto.getRestName());
		return entity;
	}

	@Override
	public List<SelectWhichYouPreferForm> toEntity(List<SelectWhichYouPreferFormDto> dtoList) {
		if ( dtoList == null ) {
            return null;
        }

        List<SelectWhichYouPreferForm> list = new ArrayList<SelectWhichYouPreferForm>( dtoList.size() );
        for ( SelectWhichYouPreferFormDto selectPrefDto : dtoList ) {
            list.add( toEntity( selectPrefDto ) );
        }

        return list;
	}

	@Override
	public List<SelectWhichYouPreferFormDto> toDto(List<SelectWhichYouPreferForm> entityList) {
		if ( entityList == null ) {
            return null;
        }

        List<SelectWhichYouPreferFormDto> list = new ArrayList<SelectWhichYouPreferFormDto>( entityList.size() );
        for ( SelectWhichYouPreferForm selectPref : entityList ) {
            list.add( toDto( selectPref ) );
        }

        return list;

}}

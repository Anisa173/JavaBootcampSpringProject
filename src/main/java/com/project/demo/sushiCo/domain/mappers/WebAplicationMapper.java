package com.project.demo.sushiCo.domain.mappers;

import java.util.List;

import com.project.demo.sushiCo.domain.dto.WebAplicationDto;
import com.project.demo.sushiCo.entity.WebAplication;

public class WebAplicationMapper extends BaseMapper<WebAplication, WebAplicationDto> {

	@Override
	public WebAplication toEntity(WebAplicationDto dto) {
		var apl = new WebAplication();
		apl.setIdAppl(dto.getIdAppl());
		apl.setAppname(dto.getAppname());
		apl.setSerialNo(dto.getSerialNo());
		return apl;
	}

	@Override
	public WebAplicationDto toDto(WebAplication entity) {
		var aplDto = new WebAplicationDto();
		aplDto.setIdAppl(entity.getId());
		aplDto.setAppname(entity.getAppname());
		aplDto.setSerialNo(entity.getSerialNo());
		var totalUsers = entity.getUsers().stream().count();
		aplDto.setTotalUsers(totalUsers);
		var totalRestorants = entity.getRestorants().stream().count();
		aplDto.setTotalRestorants(totalRestorants);
		
		return aplDto;
	}

	@Override
	public WebAplication toUpdate(WebAplicationDto dto, WebAplication entity) {
		entity.setIdAppl(dto.getIdAppl());
		entity.setAppname(dto.getAppname());
		entity.setSerialNo(dto.getSerialNo());
		return entity;
	}

	@Override
	public List<WebAplication> toEntity(List<WebAplicationDto> dtoList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<WebAplicationDto> toDto(List<WebAplication> entityList) {
		// TODO Auto-generated method stub
		return null;
	}

}

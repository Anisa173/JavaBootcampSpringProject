package com.project.demo.sushiCo.domain.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import com.project.demo.sushiCo.domain.dto.RestorantDto;
import com.project.demo.sushiCo.entity.Restorant;

@Component
public class RestorantMapper extends BaseMapper<Restorant, RestorantDto> {

	@Override
	public Restorant toEntity(RestorantDto dto) {
		Restorant rest = new Restorant();
		rest.setIdRestorant(dto.getIdRestorant());
		rest.setRestNUIS(dto.getRestNUIS());
		rest.setRestName(dto.getRestName());
		rest.setPhoneNo(dto.getPhoneNo());
		rest.setActivity_field(dto.getActivity_field());
		rest.setAddressRest(dto.getAddressRest());
		rest.setStartDay(dto.getStartDay());
		rest.setEndDay(dto.getEndDay());

		return rest;
	}

	@Override
	public RestorantDto toDto(Restorant entity) {
		RestorantDto restDto = new RestorantDto();
		restDto.setIdRestorant(entity.getId());
		restDto.setRestNUIS(entity.getRestNUIS());
		restDto.setRestName(entity.getRestName());
		restDto.setPhoneNo(entity.getPhoneNo());
		restDto.setActivity_field(entity.getActivity_field());
		restDto.setAddressRest(entity.getAddressRest());
		restDto.setStartDay(entity.getStartDay());
		restDto.setEndDay(entity.getEndDay());
		var tableDescription = entity.getRestorantTables().getTableDescription();
		restDto.setTableDescription(tableDescription);
		restDto.setRestorant_tbId(entity.getRestorantTables().getTb_id());
		var totalUser = entity.getUsers().stream().count();
		restDto.setTotalUser(totalUser);
		Long totalPayment_MethodsR = entity.getPayment_MethodsR().stream().count();
		restDto.setTotalPayment_MethodsR(totalPayment_MethodsR);
		var totalService_Places = entity.getPlaces().stream().count();
		restDto.setTotalService_Places(totalService_Places);
		var totalVisitor = entity.getVisitor().stream().count();
		restDto.setTotalVisitor(totalVisitor);
		restDto.setWebAppId(entity.getAplication().getId());
		var applicationName = entity.getAplication().getAppname();
		restDto.setApplicationName(applicationName);
		restDto.setAdminRId(entity.getAdmin().getId());
		var adminName = entity.getAdmin().getFirst_name().concat(" ").concat(entity.getAdmin().getLast_name());
		restDto.setAdminName(adminName);
		restDto.setAdminIdWeb(entity.getAdminWeb().getId());
		return restDto;
	}

	@Override
	public Restorant toUpdate(RestorantDto rest, Restorant dto) {

		rest.setRestNUIS(dto.getRestNUIS());
		rest.setRestName(dto.getRestName());
		rest.setPhoneNo(dto.getPhoneNo());
		rest.setActivity_field(dto.getActivity_field());
		rest.setAddressRest(dto.getAddressRest());
		rest.setStartDay(dto.getStartDay());
		rest.setEndDay(dto.getEndDay());
		return dto;
	}

	@Override
	public List<Restorant> toEntity(List<RestorantDto> dtoList) {
		if (dtoList == null) {
			return null;
		}

		List<Restorant> list = new ArrayList<Restorant>(dtoList.size());
		for (RestorantDto restDto : dtoList) {
			list.add(toEntity(restDto));
		}

		return list;
	}

	@Override
	public List<RestorantDto> toDto(List<Restorant> entityList) {
		if (entityList == null) {
			return null;
		}

		List<RestorantDto> list = new ArrayList<RestorantDto>(entityList.size());
		for (Restorant rest : entityList) {
			list.add(toDto(rest));
		}

		return list;
	}
}

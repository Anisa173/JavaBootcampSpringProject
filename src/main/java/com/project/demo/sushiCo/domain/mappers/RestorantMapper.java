package com.project.demo.sushiCo.domain.mappers;

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
		rest.setService_Places(dto.getService_Places());
		rest.setPayment_Methods(dto.getPayment_Methods());

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
		restDto.setService_Places(entity.getService_Places());
		restDto.setPayment_Methods(entity.getPayment_Methods());
		restDto.setTimeServiceDay(entity.getTimeServiceDay());
		restDto.setTableCapacity(entity.getRestorant_tables().getNoChairTable());
		restDto.setRestorant_tbId(entity.getRestorant_tables().getTb_id());
		var totalUser = entity.getUsers().stream().count();
		restDto.setTotalUser(totalUser);
		Long totalPayment_MethodsR = entity.getPayment_MethodsR().stream().count();
		restDto.setTotalPayment_MethodsR(totalPayment_MethodsR);
		var totalService_Places = entity.getPlaces().stream().count();
		restDto.setTotalService_Places(totalService_Places);
		restDto.setAplicationId(entity.getAplication().getId());
		var applicationName = entity.getAplication().getAppname();
		restDto.setApplicationName(applicationName);
		restDto.setAdminRId(entity.getAdmin().getId());
		var adminName = entity.getAdmin().getFirst_name().concat(" ").concat(entity.getAdmin().getLast_name());
		restDto.setAdminName(adminName);
		return restDto;
	}

	@Override
	public Restorant toUpdate(RestorantDto rest, Restorant dto) {

		rest.setRestNUIS(dto.getRestNUIS());
		rest.setRestName(dto.getRestName());
		rest.setPhoneNo(dto.getPhoneNo());
		rest.setActivity_field(dto.getActivity_field());
		rest.setAddressRest(dto.getAddressRest());
		rest.setService_Places(dto.getService_Places());
		rest.setPayment_Methods(dto.getPayment_Methods());
		return dto;
	}

}

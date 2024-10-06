package com.project.demo.sushiCo.domain.mappers;

import com.project.demo.sushiCo.domain.dto.AppRestDto;
import com.project.demo.sushiCo.entity.AppRestorant;

public class AppRestMapper extends BaseMapper<AppRestorant, AppRestDto> {

	@Override
	public AppRestorant toEntity(AppRestDto dto) {
		AppRestorant rest = new AppRestorant();
		rest.setIdApp(dto.getIdApp());
		rest.setAppName(dto.getAppName());
		rest.setSerialNo(dto.getSerialNo());
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
	public AppRestDto toDto(AppRestorant entity) {
		AppRestDto restDto = new AppRestDto();
		restDto.setIdApp(entity.getId());
		restDto.setAppName(entity.getAppName());
		restDto.setSerialNo(entity.getSerialNo());
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
		return restDto;
	}

	@Override
	public AppRestorant toUpdate(AppRestDto rest, AppRestorant dto) {
		rest.setAppName(dto.getAppName());
		rest.setSerialNo(dto.getSerialNo());
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

package com.project.demo.sushiCo.domain.mappers;

import java.util.ArrayList;
import java.util.List;
import com.project.demo.sushiCo.domain.dto.RegisterUserFormDto;
import com.project.demo.sushiCo.serviceImpl.RegisterUserForm;

public class RegisterUserFormMapper extends BaseMapper<RegisterUserForm, RegisterUserFormDto> {

	@Override
	public RegisterUserForm toEntity(RegisterUserFormDto dto) {
		var rgUser = new RegisterUserForm();
		rgUser.setRegistrationId(dto.getRegistrationId());
		rgUser.setFirst_name(dto.getFirst_name());
		rgUser.setLast_name(dto.getLast_name());
		rgUser.setPassword(dto.getPassword());
		rgUser.setEmail(dto.getEmail());
		rgUser.setAddress(dto.getAddress());
		rgUser.setPhoneNo(dto.getPhoneNo());
		rgUser.setAge(dto.getAge());
		rgUser.setPersonalIdentityNo(dto.getPersonalIdentityNo());
		rgUser.setUserRole(dto.getUserRole());
		rgUser.setRestName(dto.getRestName());
		return rgUser;
	}

	@Override
	public RegisterUserFormDto toDto(RegisterUserForm entity) {
		var rgUser = new RegisterUserFormDto();
		rgUser.setRegistrationId(entity.getId());
		rgUser.setFirst_name(entity.getFirst_name());
		rgUser.setLast_name(entity.getLast_name());
		rgUser.setPassword(entity.getPassword());
		rgUser.setEmail(entity.getEmail());
		rgUser.setAddress(entity.getAddress());
		rgUser.setPhoneNo(entity.getPhoneNo());
		rgUser.setAge(entity.getAge());
		rgUser.setPersonalIdentityNo(entity.getPersonalIdentityNo());
		rgUser.setUserRole(entity.getUserRole());
		rgUser.setRestName(entity.getRestName());
		return rgUser;
	}

	@Override
	public RegisterUserForm toUpdate(RegisterUserFormDto dto, RegisterUserForm rgUser) {
		rgUser.setPassword(dto.getPassword());
		rgUser.setEmail(dto.getEmail());
		rgUser.setAddress(dto.getAddress());
		rgUser.setPhoneNo(dto.getPhoneNo());
		rgUser.setPersonalIdentityNo(dto.getPersonalIdentityNo());
		rgUser.setUserRole(dto.getUserRole());
		rgUser.setRestName(dto.getRestName());

		return rgUser;
	}

	@Override
	public List<RegisterUserForm> toEntity(List<RegisterUserFormDto> dtoList) {
		if (dtoList == null) {
			return null;
		}
		List<RegisterUserForm> list = new ArrayList<RegisterUserForm>(dtoList.size());
		for (RegisterUserFormDto regUDto : dtoList) {
			list.add(toEntity(regUDto));
		}

		return list;
	}

	@Override
	public List<RegisterUserFormDto> toDto(List<RegisterUserForm> entityList) {
		if (entityList == null) {
			return null;
		}

		List<RegisterUserFormDto> list = new ArrayList<RegisterUserFormDto>(entityList.size());
		for (RegisterUserForm regUser : entityList) {
			list.add(toDto(regUser));
		}

		return list;
	}
}
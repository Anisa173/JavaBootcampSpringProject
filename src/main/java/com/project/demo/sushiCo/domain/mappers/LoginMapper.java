package com.project.demo.sushiCo.domain.mappers;

import java.util.ArrayList;
import java.util.List;
import com.project.demo.sushiCo.domain.dto.LoginDto;
import com.project.demo.sushiCo.serviceImpl.Login;

public class LoginMapper extends BaseMapper<Login,LoginDto> {

	@Override
	public Login toEntity(LoginDto dto) {
		var log = new Login();
	log.setRegistrationId(dto.getRegistrationId());
	log.setEmail(dto.getEmail());	
	log.setPassword(dto.getPassword());
	return log;
	}

	@Override
	public LoginDto toDto(Login entity) {
	var log = new LoginDto();
		log.setRegistrationId(entity.getId());
		log.setEmail(entity.getEmail());	
		log.setPassword((String) entity.getPassword());
		return log;
	}

	@Override
	public Login toUpdate(LoginDto dto, Login entity) {
		entity.setEmail(dto.getEmail());
	entity.setPassword(dto.getPassword());
		return entity;
	}

	@Override
	public List<Login> toEntity(List<LoginDto> dtoList) {
		if (dtoList == null) {
			return null;
		}

		List<Login> list = new ArrayList<Login>(dtoList.size());
		for (LoginDto logDto : dtoList) {
			list.add(toEntity(logDto));
		}
		return list;
	}

	@Override
	public List<LoginDto> toDto(List<Login> entityList) {
		if (entityList == null) {
			return null;
		}

		List<LoginDto> list = new ArrayList<LoginDto>(entityList.size());
		for (Login login : entityList) {
			list.add(toDto(login));
		}
		return list;
	}

}

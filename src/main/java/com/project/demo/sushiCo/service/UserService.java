package com.project.demo.sushiCo.service;

import java.util.List;
import org.springframework.core.io.Resource;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.project.demo.sushiCo.domain.dto.RegisterUserFormDto;
import com.project.demo.sushiCo.domain.dto.UserDto;
import com.project.demo.sushiCo.domain.dto.UserWithFileDto;
import com.project.demo.sushiCo.serviceImpl.Login;
import com.project.demo.sushiCo.serviceImpl.RegisterUserForm;
import jakarta.validation.Valid;

public interface UserService {

	UserDto registerUserForm(@Valid RegisterUserForm registerUserForm) throws Exception;

	UserDto registerNewUserAccount(@Valid UserDto userDto) throws UsernameNotFoundException;

	List<UserDto> getAllUser() throws Exception;
	
	RegisterUserFormDto getUserById(Integer idRestorant,Integer adminRId, Integer userId,Integer idAdmin) throws Exception;

	void delete(Integer id) throws Exception;

	UserDto login(@Valid Login form) throws Exception;
	
	RegisterUserFormDto update(Integer id, @Valid RegisterUserFormDto userDto, Integer idRestorant, Integer adminRId,
			Integer userId, Integer idAdmin) throws Exception;

	UserDto addIdentification(Integer idRestorant, Integer adminRId, Integer userId, Integer idAdmin,
			UserWithFileDto reqDto) throws Exception;

	Resource downloadIdentitficationCard(Integer idRestorant, Integer adminRId, Integer userId, Integer idAdmin,
			UserWithFileDto reqDto) throws Exception;

	List<UserDto> getAllShippersByAdminId(Integer id) throws Exception;

	

	

	




}

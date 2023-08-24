package com.project.demo.sushiCo.service;

import java.util.List;
import org.springframework.core.io.Resource;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.project.demo.sushiCo.domain.dto.LoginDto;
import com.project.demo.sushiCo.domain.dto.RegisterUserFormDto;
import com.project.demo.sushiCo.domain.dto.UserDto;
import com.project.demo.sushiCo.domain.dto.UserWithFileDto;
import com.project.demo.sushiCo.serviceImpl.Login;
import com.project.demo.sushiCo.serviceImpl.RegisterUserForm;

import jakarta.validation.Valid;

public interface UserService {

	List<UserDto> getAllUser() throws Exception;

	List<UserDto> getAllShippersByAdminId(Integer id) throws Exception;
	
	List<UserDto> getShippersAdmin(Integer id) throws Exception;
	
	UserDto addIdentification(Integer idRestorant, Integer userId, Integer registrationId, UserWithFileDto reqDto)
			throws Exception;

	Resource downloadIdentitficationCard(Integer idRestorant, Integer userId, Integer registrationId,
			UserWithFileDto reqDto) throws Exception;

	void deleteAdmin(Integer id);

	void deleteShippers(Integer id);

	RegisterUserFormDto getUserById(Integer userId, Integer registrationId, Integer idRestorant) throws Exception;

	UserDto registerUserForm(@Valid RegisterUserForm registerUserForm, Integer userId, Integer registrationId,
			Integer idRestorant) throws Exception;

	UserDto registerNewUserAccount(@Valid RegisterUserFormDto registerUserF, Integer idRestorant, Integer userId,Integer registrationId)
			throws UsernameNotFoundException;

	RegisterUserFormDto update(Integer userId, Integer idRestorant, @Valid RegisterUserFormDto registerUserForm,
			@Valid RegisterUserFormDto registerUserForm2) throws Exception;

	UserDto login(@Valid Login form, Integer userId, Integer registrationId) throws Exception;

	LoginDto getUserLogInById(Integer userId, Integer registrationId) throws Exception;

	LoginDto updateLoginData(Integer userId, @Valid LoginDto loginForm1, @Valid LoginDto loginForm) throws Exception;

	List<UserDto> getAllCustomers(Integer userId) throws Exception;

	
	

}

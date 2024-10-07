package com.project.demo.sushiCo.service;

import java.util.List;
import org.springframework.core.io.Resource;
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

    RegisterUserFormDto registerNewUserAccount(@Valid RegisterUserFormDto regUser,Integer idRestorant, Integer userId,
			Integer registrationId ) throws Exception;
	
	RegisterUserFormDto update(Integer userId, Integer idRestorant, @Valid RegisterUserFormDto regUserForm, @Valid RegisterUserFormDto registerUserForm)
			throws Exception;

	UserDto login(@Valid Login form, Integer userId, Integer registrationId) throws Exception;

	LoginDto getUserLogInById(Integer userId, Integer registrationId) throws Exception;

	LoginDto updateLoginData(Integer userId, @Valid LoginDto loginForm,@Valid LoginDto userLogInById) throws Exception;

	List<UserDto> getAllCustomers(Integer userId) throws Exception;



	

	

	
	
	

}

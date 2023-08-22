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

	UserDto registerNewUserAccount(@Valid RegisterUserFormDto registerUserForm) throws UsernameNotFoundException;

	UserDto registerUserForm(@Valid RegisterUserForm registerUserForm) throws Exception;

	RegisterUserFormDto getUserById(Integer idRestorant, Integer userId, Integer registrationId) throws Exception;

	UserDto update(Integer userId, Integer idRestorant, Integer registrationId,
			@Valid RegisterUserFormDto registerUserForm) throws Exception;

	List<UserDto> getAllUser() throws Exception;

	void delete(Integer id) throws Exception;

	List<UserDto> getAllShippersByAdminId(Integer id) throws Exception;

	UserDto addIdentification(Integer idRestorant, Integer userId, Integer registrationId, UserWithFileDto reqDto)
			throws Exception;

	Resource downloadIdentitficationCard(Integer idRestorant, Integer userId, Integer registrationId,
			UserWithFileDto reqDto) throws Exception;

	UserDto login(@Valid Login form) throws Exception;

	LoginDto getUserLogInById(Integer userId, Integer registrationId) throws Exception;

	UserDto updateLoginData(Integer userId, Integer registrationId, @Valid LoginDto login_form) throws Exception;
UserDto  registerLoginData(@Valid LoginDto form ) throws Exception;
}

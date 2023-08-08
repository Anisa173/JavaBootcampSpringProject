package com.project.demo.sushiCo.service;

import java.util.List;
import org.springframework.core.io.Resource;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import com.project.demo.sushiCo.domain.dto.UserDto;
import com.project.demo.sushiCo.domain.dto.UserWithFileDto;
import com.project.demo.sushiCo.serviceImpl.Login;
import com.project.demo.sushiCo.serviceImpl.RegisterUserForm;
import jakarta.validation.Valid;

public interface UserService {

	UserDto registerUserForm(@Valid RegisterUserForm registerUserForm) throws Exception;

	UserDto registerNewUserAccount(@Valid UserDto userDto) throws UsernameNotFoundException;

	UserDto update(Integer id, @Valid UserDto userDto) throws Exception;

	List<UserDto> getAllUser() throws Exception;

	UserDto getUserById(Integer id) throws Exception;

	void delete(Integer id) throws Exception;

	UserDto login(@Valid Login form) throws Exception;
	
	Resource downloadIdentitficationCard(Integer userId) throws Exception;

	UserDto addIdentification(Integer userId, UserWithFileDto reqDto) throws Exception;

	

}

package com.project.demo.sushiCo.service;

import java.util.List;
import org.springframework.core.io.Resource;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.project.demo.sushiCo.domain.dto.CardBankDto;
import com.project.demo.sushiCo.domain.dto.OrderByProcessingDto;
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

	UserDto getRestorantPMethods(Integer userId, Integer restorantId, Integer paymentId) throws Exception;

	UserDto getRestorantPServices(Integer custId, Integer restorantId, Integer service_PlacesId) throws Exception;

	UserDto displayPaymentServices(@Valid OrderByProcessing byProcessingform) throws Exception;

	OrderByProcessingDto getPaymentServicesById(Integer custmId, Integer idRestorant, Integer pmId, Integer servPId)
			throws Exception;

	CardBankDto getCardsByCustomerId(Integer cardId, Integer custId) throws Exception;

	UserDto displayCardForm(@Valid RegisterCardform cardBankForm) throws Exception;

	UserDto createPaymentCard() throws Exception;

	UserDto cancelUserOrder() throws Exception;

	UserDto getOrdersByCustomerId(Integer IdCustom) throws Exception;

}
